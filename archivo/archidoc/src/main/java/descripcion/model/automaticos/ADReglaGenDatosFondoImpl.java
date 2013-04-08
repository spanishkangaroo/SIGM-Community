package descripcion.model.automaticos;

import java.util.Date;
import java.util.List;
import java.util.Map;

import util.CollectionUtils;
import xml.config.ConfiguracionSistemaArchivoFactory;

import common.bi.GestionDescripcionBI;
import common.bi.ServiceRepository;
import common.bi.ServiceSession;
import common.util.CustomDateRange;
import common.util.StringUtils;

import descripcion.model.xml.card.TipoFicha;
import descripcion.vos.CampoFechaVO;
import descripcion.vos.CampoNumericoVO;
import descripcion.vos.CampoReferenciaVO;
import descripcion.vos.CampoTextoVO;
import descripcion.vos.ValorCampoGenericoVO;
import descripcion.vos.ValorCampoGenericoVOBase;
import fondos.vos.FondoVO;
import fondos.vos.VolumenSerieVO;

/**
 * Clase que realiza el c�lculo de los valores autom�ticos de un fondo.
 */
public class ADReglaGenDatosFondoImpl implements IADReglaGenDatos {

	/** Sesi�n de base de datos. */
	protected ServiceSession session = null;

	/** Repositorio de servicios. */
	private ServiceRepository service = null;

	/** Identificador de la serie. */
	private String id = null;

	/** Si hay que actualizar el volumen y soporte. */
	private boolean isActVolSop = false;

	/** Si hay que actualizar las fechas extremas. */
	private boolean isActFechas = false;

	/** Si hay que actualizar los productores. */
	private boolean isActProds = false;

	/** Lista de vol�menes y soportes. */
	private List listaVolumenesYSoportes = null;

	/** Fecha extrema inicial. */
	private Date fechaInicial = null;

	/** Fecha extrema final. */
	private Date fechaFinal = null;

	/** Identificador del productor de la serie. */
	private String productor = null;

	private static final String ID_CAMPO_CANTIDAD = ConfiguracionSistemaArchivoFactory
			.getConfiguracionSistemaArchivo().getConfiguracionDescripcion()
			.getCantidadVolumenSoporteDocumental();
	private static final String ID_CAMPO_SOPORTE_DOCUMENTAL = ConfiguracionSistemaArchivoFactory
			.getConfiguracionSistemaArchivo().getConfiguracionDescripcion()
			.getSoporteDocumental();
	private static final String ID_CAMPO_FECHA_INICIAL = ConfiguracionSistemaArchivoFactory
			.getConfiguracionSistemaArchivo().getConfiguracionDescripcion()
			.getFechaExtremaInicial();
	private static final String ID_CAMPO_FECHA_FINAL = ConfiguracionSistemaArchivoFactory
			.getConfiguracionSistemaArchivo().getConfiguracionDescripcion()
			.getFechaExtremaFinal();
	private static final String ID_CAMPO_PRODUCTOR = ConfiguracionSistemaArchivoFactory
			.getConfiguracionSistemaArchivo().getConfiguracionDescripcion()
			.getProductor();

	/**
	 * Inicializa la clase con unos par�metros.
	 * 
	 * @param parametros
	 *            Par�metros de la clase.
	 */
	public void inicializa(Map parametros) {
		if (parametros != null) {
			// Accion
			int[] acciones = (int[]) parametros
					.get(ADReglaGenDatosContants.ACCIONES);
			if ((acciones == null) || (acciones.length == 0)) {
				isActVolSop = true;
				isActFechas = true;
				isActProds = true;
			} else {
				for (int i = 0; i < acciones.length; i++) {
					switch (acciones[i]) {
					case ADReglaGenDatosContants.ACTUALIZAR_TODO:
						isActVolSop = true;
						isActFechas = true;
						isActProds = true;
						break;

					case ADReglaGenDatosContants.ACTUALIZAR_VOLUMENES_SOPORTES:
						isActVolSop = true;
						break;

					case ADReglaGenDatosContants.ACTUALIZAR_FECHAS_EXTREMAS:
						isActFechas = true;
						break;

					case ADReglaGenDatosContants.ACTUALIZAR_PRODUCTORES:
						isActProds = true;
						break;
					}
				}
			}

			// Lista de vol�menes y soportes
			if (isActVolSop)
				listaVolumenesYSoportes = (List) parametros
						.get(ADReglaGenDatosContants.LISTA_VOL_SOP);

			// Fechas extremas
			if (isActFechas) {
				fechaInicial = (Date) parametros
						.get(ADReglaGenDatosContants.FECHA_INICIAL);
				fechaFinal = (Date) parametros
						.get(ADReglaGenDatosContants.FECHA_FINAL);
			}

			// Productor
			if (isActProds)
				productor = (String) parametros
						.get(ADReglaGenDatosContants.PRODUCTOR);
		} else {
			isActVolSop = true;
			isActFechas = true;
			isActProds = true;
		}
	}

	/**
	 * Genera los datos autom�ticos.
	 * 
	 * @param session
	 *            Sesi�n de base de datos.
	 * @param id
	 *            Identificador del objeto descrito.
	 * @throws ADReglaGenDatosException
	 *             si ocurre alg�n error.
	 */
	public void generacionDatosAutomaticos(ServiceSession session, String id)
			throws ADReglaGenDatosException {
		this.id = id;
		this.session = session;
		this.service = ServiceRepository.getInstance(session);

		if (isActVolSop)
			actualizarVolumenYSoporte();

		if (isActFechas)
			actualizarFechasExtremas();

		if (isActProds)
			actualizarProductor();
	}

	/**
	 * Actualiza el vol�men y soporte del fondo.
	 */
	protected void actualizarVolumenYSoporte() {
		if (CollectionUtils.isEmpty(listaVolumenesYSoportes))
			listaVolumenesYSoportes = service.lookupGestionFondosBI()
					.getRepositoriosEcmSeriesFondo(id);

		// Servicio de gesti�n de descripci�n
		GestionDescripcionBI descripcionBI = service
				.lookupGestionDescripcionBI();

		// Elimina informaci�n anterior
		eliminaInformacionAnteriorVolumen(descripcionBI);

		// Inserta volumen y soporte
		if (!CollectionUtils.isEmpty(listaVolumenesYSoportes)) {
			VolumenSerieVO volumenSerie;

			for (int i = 0; i < listaVolumenesYSoportes.size(); i++) {
				volumenSerie = (VolumenSerieVO) listaVolumenesYSoportes.get(i);

				descripcionBI
						.actualizaCampo(
								TipoFicha.FICHA_ELEMENTO_CF,
								new CampoNumericoVO(
										id,
										ID_CAMPO_CANTIDAD,
										(i + 1),
										volumenSerie.getCantidad(),
										ValorCampoGenericoVOBase.TIPO_ELEMENTO_INDEFINIDO));

				descripcionBI
						.actualizaCampo(
								TipoFicha.FICHA_ELEMENTO_CF,
								new CampoTextoVO(
										id,
										ID_CAMPO_SOPORTE_DOCUMENTAL,
										(i + 1),
										volumenSerie.getTipoDocumental(),
										ValorCampoGenericoVOBase.TIPO_ELEMENTO_INDEFINIDO));
			}
		}
	}

	/**
	 * Actualiza las fechas extremas del fondo.
	 */
	protected void actualizarFechasExtremas() {
		if (fechaInicial == null || fechaFinal == null) {
			CustomDateRange range = service.lookupGestionFondosBI()
					.getFechasExtremas(id);

			fechaInicial = range.getInitialDate();
			fechaFinal = range.getFinalDate();
		}

		// Servicio de gesti�n de descripci�n
		GestionDescripcionBI descripcionBI = service
				.lookupGestionDescripcionBI();

		// Fecha inicial
		if (fechaInicial != null)
			descripcionBI.actualizaCampo(TipoFicha.FICHA_ELEMENTO_CF,
					new CampoFechaVO(id, ID_CAMPO_FECHA_INICIAL, 1,
							fechaInicial,
							ValorCampoGenericoVOBase.TIPO_ELEMENTO_INDEFINIDO));
		else
			descripcionBI
					.vaciaCampo(TipoFicha.FICHA_ELEMENTO_CF,
							ValorCampoGenericoVO.TIPO_FECHA, id,
							ID_CAMPO_FECHA_INICIAL);

		// Fecha final
		if (fechaFinal != null)
			descripcionBI.actualizaCampo(TipoFicha.FICHA_ELEMENTO_CF,
					new CampoFechaVO(id, ID_CAMPO_FECHA_FINAL, 1, fechaFinal,
							ValorCampoGenericoVOBase.TIPO_ELEMENTO_INDEFINIDO));
		else
			descripcionBI.vaciaCampo(TipoFicha.FICHA_ELEMENTO_CF,
					ValorCampoGenericoVO.TIPO_FECHA, id, ID_CAMPO_FECHA_FINAL);
	}

	/**
	 * Actualiza el productor del fondo.
	 */
	protected void actualizarProductor() {
		if (StringUtils.isBlank(productor)) {
			FondoVO fondo = service.lookupGestionFondosBI().getFondoXId(id);
			if (fondo != null)
				productor = fondo.getIdEntProductora();
		}

		// Servicio de gesti�n de descripci�n
		GestionDescripcionBI descripcionBI = service
				.lookupGestionDescripcionBI();

		// Actualizar el productor
		if (productor != null)
			descripcionBI.actualizaCampo(TipoFicha.FICHA_ELEMENTO_CF,
					new CampoReferenciaVO(id, ID_CAMPO_PRODUCTOR, 1,
							CampoReferenciaVO.REFERENCIA_A_ELEMENTO_DESCRIPTOR,
							productor,
							ValorCampoGenericoVOBase.TIPO_ELEMENTO_INDEFINIDO));
		else
			descripcionBI.vaciaCampo(TipoFicha.FICHA_ELEMENTO_CF,
					ValorCampoGenericoVO.TIPO_REFERENCIA, id,
					ID_CAMPO_PRODUCTOR);

	}

	/**
	 * Elimina la informaci�n anterior del volumen de las series del fondo.
	 * 
	 * @param descripcionBI
	 *            Servicio de gesti�n de la descripci�n.
	 */
	protected void eliminaInformacionAnteriorVolumen(
			GestionDescripcionBI descripcionBI) {
		// Cantidad
		descripcionBI.vaciaCampo(TipoFicha.FICHA_ELEMENTO_CF,
				ValorCampoGenericoVO.TIPO_NUMERICO, id, ID_CAMPO_CANTIDAD);

		// Soporte documental
		descripcionBI.vaciaCampo(TipoFicha.FICHA_ELEMENTO_CF,
				ValorCampoGenericoVO.TIPO_TEXTO_CORTO, id,
				ID_CAMPO_SOPORTE_DOCUMENTAL);
	}

}
