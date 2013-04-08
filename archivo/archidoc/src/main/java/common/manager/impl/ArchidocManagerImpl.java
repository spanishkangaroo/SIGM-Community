package common.manager.impl;

import fondos.db.ICatalogoTablasTemporalesDBEntity;
import fondos.db.IDivisionFSDbEntity;
import fondos.db.IElementoCuadroClasificacionDbEntity;
import fondos.db.IEntidadProductoraDBEntity;
import fondos.db.IFondoDbEntity;
import fondos.db.INivelCFDBEntity;
import fondos.db.IOrganoProductorDbEntity;
import fondos.db.IProductorSerieDbEntity;
import fondos.db.ISerieDbEntity;
import fondos.db.ISolicitudSerieDbEntity;
import fondos.db.IUDocEnDivisionFSDbEntity;
import fondos.db.IUnidadDocumentalDbEntity;
import fondos.db.IVolumenSerieDBEntity;
import gcontrol.db.IArchivoDbEntity;
import gcontrol.db.ICAOrganoDbEntity;
import gcontrol.db.IGrupoDBEntity;
import gcontrol.db.IGrupoUsuarioDBEntity;
import gcontrol.db.IListaControlAccesoDbEntity;
import gcontrol.db.INivelArchivoDbEntity;
import gcontrol.db.IOrganoUsuarioDBEntity;
import gcontrol.db.IPermisoRolDBEntity;
import gcontrol.db.IPermisosListaDbEntity;
import gcontrol.db.IRolDBEntity;
import gcontrol.db.IRolUsuarioDBEntity;
import gcontrol.db.IUsuarioDBEntity;
import ieci.core.db.DbEngine;

import org.apache.log4j.Logger;

import salas.db.IEdificioDBEntity;
import salas.db.IMesaDBEntity;
import salas.db.IRegistroConsultaSalaDBEntity;
import salas.db.ISalaDBEntity;
import salas.db.IUsuarioArchivoSalasConsultaDBEntity;
import salas.db.IUsuarioSalaConsultaDBEntity;
import se.usuarios.ServiceClient;
import solicitudes.consultas.db.IConsultaDBEntity;
import solicitudes.consultas.db.IMotivoConsultaDBEntity;
import solicitudes.consultas.db.ITemaDBEntity;
import solicitudes.db.IDetalleDBEntity;
import solicitudes.db.IMotivoRechazoDBEntity;
import solicitudes.db.INSecSolicitudesDBEntity;
import solicitudes.db.IRevisionDocumentacionDBEntity;
import solicitudes.prestamos.db.IMotivoPrestamoDBEntity;
import solicitudes.prestamos.db.IPrestamoDBEntity;
import solicitudes.prestamos.db.IProrrogaDBEntity;
import transferencias.db.IDetallePrevisionDBEntity;
import transferencias.db.IMapDescUDocDBEntity;
import transferencias.db.INSecTransferenciasDBEntity;
import transferencias.db.INSecUDocDBEntity;
import transferencias.db.INSecUIDBEntity;
import transferencias.db.IPrevisionDBEntity;
import transferencias.db.IRelacionEntregaDBEntity;
import transferencias.db.IUDocEnUIReeaCRDBEntity;
import transferencias.db.IUDocReeaCRDBEntity;
import transferencias.db.IUDocRelacionDBEntity;
import transferencias.db.IUIReeaCRDBEntity;
import transferencias.db.IUdocElectronicaDBEntity;
import transferencias.db.IUdocEnUIDBEntity;
import transferencias.db.IUnidadInstalacionDBEntity;
import transferencias.db.IUnidadInstalacionReeaDBEntity;
import valoracion.db.IEliminacionSerieDBEntity;
import valoracion.db.IEliminacionUDOCConservadaDBEntity;
import valoracion.db.IEliminacionUDOCEliminadaDBEntity;
import valoracion.db.IHistoricoUDOCDBEntity;
import valoracion.db.INSecValoracionDBEntity;
import valoracion.db.INSecVersionDBEntity;
import valoracion.db.INSecVersionSelDBEntity;
import valoracion.db.IPlazosValoracionDBEntity;
import valoracion.db.IValoracionDBEntity;
import auditoria.db.ICritAccionesDBEntity;
import auditoria.db.ICritUsuariosDBEntity;
import auditoria.db.IDatosTrazaDBEntity;
import auditoria.db.ITrazaDBEntity;

import common.db.DBEntityFactory;
import common.db.DbDataSource;
import common.db.DbDataSourceMultiEntidadImpl;
import common.db.IDBEntityFactory;
import common.lock.db.ILockDBEntity;
import common.session.db.ISessionDBEntity;
import common.util.DBFactoryConstants;

import configuracion.db.IInfoSistemaDBEntity;
import deposito.db.IDepositoDbEntity;
import deposito.db.IDepositoElectronicoDBEntity;
import deposito.db.IElementoAsignableDBEntity;
import deposito.db.IElementoNoAsignableDBEntity;
import deposito.db.IFormatoDbEntity;
import deposito.db.IHistUInstalacionDepositoDBEntity;
import deposito.db.IHuecoDBEntity;
import deposito.db.INsecSigNumHuecoDBEntity;
import deposito.db.INumOrdenDBEntity;
import deposito.db.ITipoElementoDBEntity;
import deposito.db.IUDocEnUiDepositoDbEntity;
import deposito.db.IUInstalacionDepositoDBEntity;
import descripcion.db.IAreaDBEntity;
import descripcion.db.ICampoDatoDBEntity;
import descripcion.db.ICampoTablaDBEntity;
import descripcion.db.ICatalogoListaDescriptoresDBEntity;
import descripcion.db.IDescriptorDBEntity;
import descripcion.db.IFechaDBEntity;
import descripcion.db.IFechaDescrDBEntity;
import descripcion.db.IFichaDBEntity;
import descripcion.db.IFmtFichaDBEntity;
import descripcion.db.IFmtPrefDBEntity;
import descripcion.db.INumeroDBEntity;
import descripcion.db.INumeroDescrDBEntity;
import descripcion.db.IReferenciaDBEntity;
import descripcion.db.IReferenciaDescrDBEntity;
import descripcion.db.ITablaValidacionDBEntity;
import descripcion.db.ITextoCortoDescrDBEntity;
import descripcion.db.ITextoDBEntity;
import descripcion.db.ITextoLargoDescrDBEntity;
import descripcion.db.IUsoObjetoDBEntity;
import descripcion.db.IValidacionDBEntity;
import docelectronicos.db.IDocClasifCFDBEntity;
import docelectronicos.db.IDocClasifDescrDBEntity;
import docelectronicos.db.IDocDocumentoCFDBEntity;
import docelectronicos.db.IDocDocumentoDescrDBEntity;
import docelectronicos.db.IDocFichaDBEntity;
import docelectronicos.db.IDocTCapturaDBEntity;
import docelectronicos.db.IUnidadDocumentalElectronicaDBEntity;
import docvitales.db.IDocumentoVitalDBEntity;
import docvitales.db.ITipoDocVitProcedimientoDBEntity;
import docvitales.db.ITipoDocumentoVitalDBEntity;
import docvitales.db.IUsoDocumentoVitalDBEntity;

/**
 * Gestiona todos los DBEntitys de archidoc
 *
 * @author IECISA
 *
 */
public class ArchidocManagerImpl extends ArchidocManagerBaseImpl {

	protected static Logger logger = Logger
			.getLogger(ArchidocManagerImpl.class);

	private IDBEntityFactory dbEntityFactory;

	private DbDataSource dataSource;

	private String dbFactoryClass;

	/**
	 *
	 * @param dataSourceName
	 *            Nombre del dataSource
	 * @param dbFactoryClass
	 *            Constante de {@link DBFactoryConstants}
	 */
	public ArchidocManagerImpl(String dataSourceName, String dbFactoryClass) {
		DbEngine engine = ServiceClient.getDBEngineWithFactory(dataSourceName,
				dbFactoryClass);
		dataSource = new DbDataSourceMultiEntidadImpl(engine);
		this.dbFactoryClass = dbFactoryClass;
	}

	/**
	 *
	 * @param dataSource
	 *            Datasource
	 * @param dbFactoryClass
	 *            Constante de {@link DBFactoryConstants}
	 */
	public ArchidocManagerImpl(String dataSourceName, String entity,
			String dbFactoryClass) {
		DbEngine engine = ServiceClient.getMultiEntityDbEngineWithFactory(
				dataSourceName, entity, dbFactoryClass);
		dataSource = new DbDataSourceMultiEntidadImpl(engine);
	}

	private IDBEntityFactory getFactory() {
		if (dbEntityFactory == null) {
			dbEntityFactory = DBEntityFactory.getInstance(dbFactoryClass);
			logger.debug("Factory:" + dbFactoryClass);
		}

		return dbEntityFactory;
	}

	/** Entidad: <b>AADATOSTRAZA</b> */
	private IDatosTrazaDBEntity datosTrazaDBEntity;

	/** Entidad: <b>AANAUDITACCION</b> */
	private ICritAccionesDBEntity critAccionesDBEntity;

	/** Entidad: <b>AANAUDITUSR</b> */
	private ICritUsuariosDBEntity critUsuariosDBEntity;

	/** Entidad: <b>AASESION</b> */
	private ISessionDBEntity sessionDBEntity;

	/** Entidad: <b>AATRAZA</b> */
	private ITrazaDBEntity trazaDBEntity;

	/** Entidad: <b>ADAREA</b> */
	private IAreaDBEntity areaDBEntity;

	/** Entidad: <b>ADCAMPODATO</b> */
	private ICampoDatoDBEntity campoDatoDBEntity;

	/** Entidad: <b>ADCAMPOTBL</b> */
	private ICampoTablaDBEntity campoTablaDBEntity;

	/** Entidad: <b>ADCTLGLISTAD</b> */
	private ICatalogoListaDescriptoresDBEntity catalogoListaDescriptoresDBEntity;

	/** Entidad: <b>ADCTLGTBLVLD</b> */
	private ITablaValidacionDBEntity tablaValidacionDBEntity;

	/** Entidad: <b>ADDESCRIPTOR</b> */
	private IDescriptorDBEntity descriptorDBEntity;

	/** Entidad: <b>ADFICHA</b> */
	private IFichaDBEntity fichaDBEntity;

	/** Entidad: <b>ADFMTFICHA</b> */
	private IFmtFichaDBEntity fmtFichaDBEntity;

	/** Entidad: <b>ADFMTPREF</b> */
	private IFmtPrefDBEntity fmtPrefDBEntity;

	/** Entidad: <b>ADOCCLASIFCF</b> */
	private IDocClasifCFDBEntity docClasifCFDBEntity;

	/** Entidad: <b>ADOCCLASIFDESCR</b> */
	private IDocClasifDescrDBEntity docClasifDescrDBEntity;

	/** Entidad: <b>ADOCDOCUMENTOCF</b> */
	private IDocDocumentoCFDBEntity docDocumentoCFDBEntity;

	/** Entidad: <b>ADOCDOCUMENTODESCR</b> */
	private IDocDocumentoDescrDBEntity docDocumentoDescrDBEntity;

	/** Entidad: <b>ADOCFICHACLF</b> */
	private IDocFichaDBEntity docFichaDBEntity;

	/** Entidad: <b>ADOCTCAPTURA</b> */
	private IDocTCapturaDBEntity docTCapturaDBEntity;

	/** Entidad: <b>ADPCDOCUMENTOVIT</b> */
	private IDocumentoVitalDBEntity documentoVitalDBEntity;

	/** Entidad: <b>ADPCTIPODOCPROC</b> */
	private ITipoDocVitProcedimientoDBEntity tipoDocVitProcedimientoDBEntity;

	/** Entidad: <b>ADPCTIPODOCVIT</b> */
	private ITipoDocumentoVitalDBEntity tipoDocumentoVitalDBEntity;

	/** Entidad: <b>ADPCUSODOCVIT</b> */
	private IUsoDocumentoVitalDBEntity usoDocumentoVitalDBEntity;

	/** Entidad: <b>ADTEXTTBLVLD</b> */
	private IValidacionDBEntity validacionDBEntity;

	/** Entidad: <b>ADUSOOBJETO</b> */
	private IUsoObjetoDBEntity usoObjetoDBEntity;

	/** Entidad: <b>ADVCFECHACF</b> */
	private IFechaDBEntity fechaDBEntity;

	/** Entidad: <b>ADVCFECHADESCR</b> */
	private IFechaDescrDBEntity fechaDescrDBEntity;

	/** Entidad: <b>ADVCNUMCF</b> */
	private INumeroDBEntity numeroDBEntity;

	/** Entidad: <b>ADVCNUMDESCR</b> */
	private INumeroDescrDBEntity numeroDescrDBEntity;

	/** Entidad: <b>ADVCREFCF</b> */
	private IReferenciaDBEntity referenciaDBEntity;

	/** Entidad: <b>ADVCREFDESCR</b> */
	private IReferenciaDescrDBEntity referenciaDescrDBEntity;

	/** Entidad: <b>ADVCTEXTCF</b> */
	private ITextoDBEntity textoCortoDBEntity;

	/** Entidad: <b>ADVCTEXTDESCR</b> */
	private ITextoCortoDescrDBEntity textoCortoDescrDBEntity;

	/** Entidad: <b>ADVCTEXTLCF</b> */
	private ITextoDBEntity textoLargoDbEntity;

	/** Entidad: <b>ADVCTEXTLDESCR</b> */
	private ITextoLargoDescrDBEntity textoLargoDescrDBEntity;

	/** Entidad: <b>AGARCHIVO</b> */
	private IArchivoDbEntity archivoDbEntity;

	/** Entidad: <b>AGNIVELARCHIVO</b> */
	private INivelArchivoDbEntity nivelArchivoDbEntity;

	/** Entidad: <b>AGFORMATO</b> */
	private IFormatoDbEntity formatoDbEntity;

	/** Entidad: <b>AGOBJBLOQUEO</b> */
	private ILockDBEntity lockDBEntity;

	/** Entidad: <b>ASCAGRUPO</b> */
	private IGrupoDBEntity grupoDBEntity;

	/** Entidad: <b>ASCALISTCA</b> */
	private IListaControlAccesoDbEntity listaControlAccesoDbEntity;

	/** Entidad: <b>ASCAORGANO</b> */
	private ICAOrganoDbEntity organoDbEntity;

	/** Entidad: <b>ASCAPERMGENROL</b> */
	private IPermisoRolDBEntity permisoRolDBEntity;

	/** Entidad: <b>ASCAPERMLISTCA</b> */
	private IPermisosListaDbEntity permisosListaDbEntity;

	/** Entidad: <b>ASCAROL</b> */
	private IRolDBEntity rolDBEntity;

	/** Entidad: <b>ASCAROLUSR</b> */
	private IRolUsuarioDBEntity rolUsuarioDBEntity;

	/** Entidad: <b>ASCAUSRGRP</b> */
	private IGrupoUsuarioDBEntity grupoUsuarioDBEntity;

	/** Entidad: <b>ASCAUSRORG</b> */
	private IOrganoUsuarioDBEntity organoUsuarioDBEntity;

	/** Entidad: <b>ASCAUSUARIO</b> */
	private IUsuarioDBEntity usuarioDBEntity;

	/** Entidad: <b>ASGDDEPOSITO</b> */
	private IDepositoDbEntity depositoDbEntity;

	/** Entidad: <b>ASGDDEPOSITOELECTRONICO</b> */
	private IDepositoElectronicoDBEntity depositoElectronicoDBEntity;

	/** Entidad: <b>ASGDELEMASIG</b> */
	private IElementoAsignableDBEntity elementoAsignableDBEntity;

	/** Entidad: <b>ASGDELEMNOASIG</b> */
	private IElementoNoAsignableDBEntity elementoNoAsignableDBEntity;

	/** Entidad: <b>ASGDHUECO</b> */
	private IHuecoDBEntity huecoDBEntity;

	/** Entidad: <b>ASGDSIGNUMORDEN</b> */
	private INumOrdenDBEntity numOrdenDBEntity;

	/** Entidad: <b>ASGDTIPOELEMENTO</b> */
	private ITipoElementoDBEntity tipoElementoDBEntity;

	/** Entidad: <b>ASGDUDOCENUI</b> */
	private IUDocEnUiDepositoDbEntity uDocEnUiDepositoDbEntity;

	/** Entidad: <b>ASGDUINSTALACION</b> */
	private IUInstalacionDepositoDBEntity uInstalacionDepositoDBEntity;

	/** Entidad: <b>ASGFELEMENTOCF</b> */
	private IElementoCuadroClasificacionDbEntity elementoCuadroClasificacionDbEntity;

	/** Entidad: <b>ASGFELIMSELUDOC</b> */
	private IEliminacionUDOCEliminadaDBEntity eliminacionUDOCEliminadaDBEntity;

	/** Entidad: <b>ASGFELIMUDOCCONS</b> */
	private IEliminacionUDOCConservadaDBEntity eliminacionUDocConservadaDBEntity;

	/** Entidad: <b>ASGFELIMSERIE</b> */
	private IEliminacionSerieDBEntity eliminacionSerieDBEntity;

	/** Entidad: <b>ASGFENTPRODUCTORA</b> */
	private IEntidadProductoraDBEntity entidadProductoraDBEntity;

	/** Entidad: <b>ASGFESTRUCTJNIVCF</b> */
	// private INivelCFDBEntity estructuraNivelCFDBEntity;

	/** Entidad: <b>ASGFFONDO</b> */
	private IFondoDbEntity fondoDbEntity;

	/** Entidad: <b>ASGFHISTUDOC</b> */
	private IHistoricoUDOCDBEntity historicoUDOCDBEntity;

	/** Entidad: <b>ASGFNIVELCF</b> */
	private INivelCFDBEntity nivelCFDBEntity;

	/** Entidad: <b>ASGFNUMSECSEL</b> */
	private INSecVersionSelDBEntity nSecVersionSelDBEntity;

	/** Entidad: <b>ASGFNUMSECVAL</b> */
	private INSecVersionDBEntity nSecVersionDBEntity;

	/** Entidad: <b>ASGFORGPROD</b> */
	private IOrganoProductorDbEntity organoProductorDbEntity;

	/** Entidad: <b>ASGFPRODSERIE</b> */
	private IProductorSerieDbEntity productorSerieDbEntity;

	/** Entidad: <b>ASGFSERIE</b> */
	private ISerieDbEntity serieDbEntity;

	/** Entidad: <b>ASGFSNSEC</b> */
	private INSecValoracionDBEntity nSecFondosDBEntity;

	/** Entidad: <b>ASGFSOLICITUDSERIE</b> */
	private ISolicitudSerieDbEntity solicitudSerieDbEntity;

	/** Entidad: <b>ASGFUNIDADDOC</b> */
	private IUnidadDocumentalDbEntity unidadDocumentalDbEntity;

	/** Entidad: <b>ASGFVALSERIE</b> */
	private IValoracionDBEntity valoracionDBEntity;

	/** Entidad: <b>ASGFVOLUMENSERIE</b> */
	private IVolumenSerieDBEntity volumenSerieDBEntity;

	/** Entidad: <b>ASGPCONSULTA</b> */
	private IConsultaDBEntity consultaDBEntity;

	/** Entidad: <b>ASGPMTVCONSULTA</b> */
	private IMotivoConsultaDBEntity motivoConsultaDBEntity;

	/** Entidad: <b>ASGPMTVRECHAZO</b> */
	private IMotivoRechazoDBEntity motivoRechazoDBEntity;

	/** Entidad: <b>ASGPPRESTAMO</b> */
	private IPrestamoDBEntity prestamoDBEntity;

	/** Entidad: <b>ASGPPRORROGA</b> */
	private IProrrogaDBEntity prorrogaDBEntity;

	/** Entidad: <b>ASGPSNSEC</b> */
	private INSecSolicitudesDBEntity nSecSolicitudesDBEntity;

	/** Entidad: <b>ASGPSOLICITUDUDOC</b> */
	private IDetalleDBEntity detalleDBEntity;

	/** Entidad: <b>ASGPTEMA</b> */
	private ITemaDBEntity temaDBEntity;

	/** Entidad: <b>ASGTDETALLEPREV</b> */
	private IDetallePrevisionDBEntity detallePrevisionDBEntity;

	/** Entidad: <b>ASGTMAPDESCRUDOC</b> */
	private IMapDescUDocDBEntity mapDescUDocDBEntity;

	/** Entidad: <b>ASGTPREVISION</b> */
	private IPrevisionDBEntity previsionDBEntity;

	/** Entidad: <b>ASGTRENTREGA</b> */
	private IRelacionEntregaDBEntity relacionEntregaDBEntity;

	/** Entidad: <b>ASGTSNSEC</b> */
	private transferencias.db.INSecTransferenciasDBEntity nSecTransferencias;

	/** Entidad: <b>ASGTSNSECUI</b> */
	private INSecUIDBEntity nSecUIDBEntity;

	/** Entidad: <b>ASGTSNSECUDOC</b> */
	private INSecUDocDBEntity nSecUDocDBEntity;

	/** Entidad: <b>ASGTUDOCENUI</b> */
	private IUdocEnUIDBEntity udocEnUIDBEntity;

	/** Entidad: <b>ASGTUDOCSDF</b> */
	private IUdocElectronicaDBEntity udocElectronicaDBEntity;

	/** Entidad: <b>ASGTUINSTALACIONRE</b> */
	private IUnidadInstalacionDBEntity unidadInstalacionDBEntity;

	/** Entidad: <b>ASGTUNIDADDOCRE</b> */
	private IUDocRelacionDBEntity uDocRelacionDBEntity;

	/** Entidad: <b>ITDGUIDGEN</b> */
	//private IGuidGenDBEntity guidGenDBEntity;

	/** Entidad: <b>AGINFOSISTEMA</b> */
	private IInfoSistemaDBEntity infoSistemaDBEntity;

	/** Entidad: <b>ASGTUINSTALACIONREEA</b> */
	private IUnidadInstalacionReeaDBEntity unidadInstalacionReeaDBEntity;

	/** Entidad: <b>ASGFUDOCSDF</b> */
	private IUnidadDocumentalElectronicaDBEntity unidadDocumentalElectronicaDBEntity;

	/** Entidad: <b>ADVCFECHAUDOCRE</b> */
	private IFechaDBEntity fechaUdocReDBEntity;

	/** Entidad: <b>ADVCNUMUDOCRE</b> */
	private INumeroDBEntity numeroUdocReDBEntity;

	/** Entidad: <b>ADVCREFUDOCRE</b> */
	private IReferenciaDBEntity referenciaUdocReDBEntity;

	/** Entidad: <b>ADVCTEXTLUDOCRE</b> */
	private ITextoDBEntity textoLargoUdocReDBEntity;

	/** Entidad: <b>ADVCTEXTUDOCRE</b> */
	private ITextoDBEntity textoCortoUdocReDBEntity;

	/** Entidad: <b>ASGFDIVISIONFS</b> */
	private IDivisionFSDbEntity divisionFSDbEntity;

	/** Entidad: <b>ASGFUDOCENDIVISIONFS</b> */
	private IUDocEnDivisionFSDbEntity uDocEnDivisionFSDbEntity;

	/** Entidad: <b>ASGFPZTRVALSERIE</b> */
	private IPlazosValoracionDBEntity plazosValoracionDBEntity;

	/** Entidad: <b>ASGDSIGNUMHUECO</b> */
	private INsecSigNumHuecoDBEntity nsecSigNumHuecoDBEntity;

	/** Entidad: <b>ASGPREVDOCUDOC</b> */
	private IRevisionDocumentacionDBEntity revisionDocumentacionDBEntity;

	/** Entidad: <b>ASGDHISTUINSTALACION</b> */
	private IHistUInstalacionDepositoDBEntity histUInstalacionDepositoDBEntity;

	/** Entidad: <b>ASGPMTVPRESTAMO</b> */
	private IMotivoPrestamoDBEntity motivoPrestamoDBEntity;

	/** Entidad: <b>ASGSEDIFICIO</b> */
	private IEdificioDBEntity edificioDBEntity;

	/** Entidad: <b>ASGSSALA</b> */
	private ISalaDBEntity salaDBEntity;

	/** Entidad: <b>ASGSMESA</b> */
	private IMesaDBEntity mesaDBEntity;

	/** Entidad: <b>ASGSUSRCSALA</b> */
	private IUsuarioSalaConsultaDBEntity usuarioSalaConsultaDBEntity;

	/** Entidad: <b>ASGSUSRCSARCH</b> */
	private IUsuarioArchivoSalasConsultaDBEntity usuarioArchivoSalasConsultaDBEntity;

	/** Entidad: <b>ASGSREGCSALA</b> */
	private IRegistroConsultaSalaDBEntity registroConsultaSalaDBEntity;

	/** Entidad: <b>ASGTUIREEACR</b> */
	private IUIReeaCRDBEntity uiReeaCRDBEntity;

	/** Entidad: <b>ASGTUDOCENUIREEACR</b> */
	private IUDocEnUIReeaCRDBEntity uDocEnUIReeaCRDBEntity;

	/** Entidad: <b>ASGTUDOCREEACR</b> */
	private IUDocReeaCRDBEntity uDocReeaCRDBEntity;

	/** Entidad: <b>ASGFCTLGTBLTMP</b> */
	private ICatalogoTablasTemporalesDBEntity catalogoTablasTemporalesDBEntity;

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getDatosTrazaDBEntity()
	 */
	public IDatosTrazaDBEntity getDatosTrazaDBEntity() {
		if (datosTrazaDBEntity == null) {
			datosTrazaDBEntity = getFactory().getDatosTrazaDBEntity(dataSource);
		}
		return datosTrazaDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getCritAccionesDBEntity()
	 */
	public ICritAccionesDBEntity getCritAccionesDBEntity() {
		if (critAccionesDBEntity == null) {
			critAccionesDBEntity = getFactory().getCritAccionesDBEntity(
					dataSource);
		}
		return critAccionesDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getCritUsuariosDBEntity()
	 */
	public ICritUsuariosDBEntity getCritUsuariosDBEntity() {
		if (critUsuariosDBEntity == null) {
			critUsuariosDBEntity = getFactory().getCritUsuariosDBEntity(
					dataSource);
		}
		return critUsuariosDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getSessionDBEntity()
	 */
	public ISessionDBEntity getSessionDBEntity() {
		if (sessionDBEntity == null) {
			sessionDBEntity = getFactory().getSessionDBEntity(dataSource);
		}
		return sessionDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getTrazaDBEntity()
	 */
	public ITrazaDBEntity getTrazaDBEntity() {
		if (trazaDBEntity == null) {
			trazaDBEntity = getFactory().getTrazaDBEntity(dataSource);
		}
		return trazaDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getAreaDBEntity()
	 */
	public IAreaDBEntity getAreaDBEntity() {
		if (areaDBEntity == null) {
			areaDBEntity = getFactory().getAreaDBEntity(dataSource);
		}
		return areaDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getCampoDatoDBEntity()
	 */
	public ICampoDatoDBEntity getCampoDatoDBEntity() {
		if (campoDatoDBEntity == null) {
			campoDatoDBEntity = getFactory().getCampoDatoDBEntity(dataSource);
		}
		return campoDatoDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getCampoTablaDBEntity()
	 */
	public ICampoTablaDBEntity getCampoTablaDBEntity() {
		if (campoTablaDBEntity == null) {
			campoTablaDBEntity = getFactory().getCampoTablaDBEntity(dataSource);
		}
		return campoTablaDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * common.db.impl.IArchidocManager#getCatalogoListaDescriptoresDBEntity()
	 */
	public ICatalogoListaDescriptoresDBEntity getCatalogoListaDescriptoresDBEntity() {
		if (catalogoListaDescriptoresDBEntity == null) {
			catalogoListaDescriptoresDBEntity = getFactory()
					.getCatalogoListaDescriptoresDBEntity(dataSource);
		}
		return catalogoListaDescriptoresDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getTablaValidacionDBEntity()
	 */
	public ITablaValidacionDBEntity getTablaValidacionDBEntity() {
		if (tablaValidacionDBEntity == null) {
			tablaValidacionDBEntity = getFactory().getTablaValidacionDBEntity(
					dataSource);
		}
		return tablaValidacionDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getDescriptorDBEntity()
	 */
	public IDescriptorDBEntity getDescriptorDBEntity() {
		if (descriptorDBEntity == null) {
			descriptorDBEntity = getFactory().getDescriptorDBEntity(dataSource);
		}
		return descriptorDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getFichaDBEntity()
	 */
	public IFichaDBEntity getFichaDBEntity() {
		if (fichaDBEntity == null) {
			fichaDBEntity = getFactory().getFichaDBEntity(dataSource);
		}
		return fichaDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getFmtFichaDBEntity()
	 */
	public IFmtFichaDBEntity getFmtFichaDBEntity() {
		if (fmtFichaDBEntity == null) {
			fmtFichaDBEntity = getFactory().getFmtFichaDBEntity(dataSource);
		}
		return fmtFichaDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getFmtPrefDBEntity()
	 */
	public IFmtPrefDBEntity getFmtPrefDBEntity() {
		if (fmtPrefDBEntity == null) {
			fmtPrefDBEntity = getFactory().getFmtPrefDBEntity(dataSource);
		}
		return fmtPrefDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getDocClasifCFDBEntity()
	 */
	public IDocClasifCFDBEntity getDocClasifCFDBEntity() {
		if (docClasifCFDBEntity == null) {
			docClasifCFDBEntity = getFactory().getDocClasifCFDBEntity(
					dataSource);
		}
		return docClasifCFDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getDocClasifDescrDBEntity()
	 */
	public IDocClasifDescrDBEntity getDocClasifDescrDBEntity() {
		if (docClasifDescrDBEntity == null) {
			docClasifDescrDBEntity = getFactory().getDocClasifDescrDBEntity(
					dataSource);
		}
		return docClasifDescrDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getDocDocumentoCFDBEntity()
	 */
	public IDocDocumentoCFDBEntity getDocDocumentoCFDBEntity() {
		if (docDocumentoCFDBEntity == null) {
			docDocumentoCFDBEntity = getFactory().getDocDocumentoCFDBEntity(
					dataSource);
		}
		return docDocumentoCFDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getDocDocumentoDescrDBEntity()
	 */
	public IDocDocumentoDescrDBEntity getDocDocumentoDescrDBEntity() {
		if (docDocumentoDescrDBEntity == null) {
			docDocumentoDescrDBEntity = getFactory()
					.getDocDocumentoDescrDBEntity(dataSource);
		}
		return docDocumentoDescrDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getDocFichaDBEntity()
	 */
	public IDocFichaDBEntity getDocFichaDBEntity() {
		if (docFichaDBEntity == null) {
			docFichaDBEntity = getFactory().getDocFichaDBEntity(dataSource);
		}
		return docFichaDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getDocTCapturaDBEntity()
	 */
	public IDocTCapturaDBEntity getDocTCapturaDBEntity() {
		if (docTCapturaDBEntity == null) {
			docTCapturaDBEntity = getFactory().getDocTCapturaDBEntity(
					dataSource);
		}
		return docTCapturaDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getDocumentoVitalDBEntity()
	 */
	public IDocumentoVitalDBEntity getDocumentoVitalDBEntity() {
		if (documentoVitalDBEntity == null) {
			documentoVitalDBEntity = getFactory().getDocumentoVitalDBEntity(
					dataSource);
		}
		return documentoVitalDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getTipoDocVitProcedimientoDBEntity()
	 */
	public ITipoDocVitProcedimientoDBEntity getTipoDocVitProcedimientoDBEntity() {
		if (tipoDocVitProcedimientoDBEntity == null) {
			tipoDocVitProcedimientoDBEntity = getFactory()
					.getTipoDocVitProcedimientoDBEntity(dataSource);
		}
		return tipoDocVitProcedimientoDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getTipoDocumentoVitalDBEntity()
	 */
	public ITipoDocumentoVitalDBEntity getTipoDocumentoVitalDBEntity() {
		if (tipoDocumentoVitalDBEntity == null) {
			tipoDocumentoVitalDBEntity = getFactory()
					.getTipoDocumentoVitalDBEntity(dataSource);
		}
		return tipoDocumentoVitalDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getUsoDocumentoVitalDBEntity()
	 */
	public IUsoDocumentoVitalDBEntity getUsoDocumentoVitalDBEntity() {
		if (usoDocumentoVitalDBEntity == null) {
			usoDocumentoVitalDBEntity = getFactory()
					.getUsoDocumentoVitalDBEntity(dataSource);
		}
		return usoDocumentoVitalDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getValidacionDBEntity()
	 */
	public IValidacionDBEntity getValidacionDBEntity() {
		if (validacionDBEntity == null) {
			validacionDBEntity = getFactory().getValidacionDBEntity(dataSource);
		}
		return validacionDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getUsoObjetoDBEntity()
	 */
	public IUsoObjetoDBEntity getUsoObjetoDBEntity() {
		if (usoObjetoDBEntity == null) {
			usoObjetoDBEntity = getFactory().getUsoObjetoDBEntity(dataSource);
		}
		return usoObjetoDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getFechaDBEntity()
	 */
	public IFechaDBEntity getFechaDBEntity() {
		if (fechaDBEntity == null) {
			fechaDBEntity = getFactory().getFechaDBEntity(dataSource);
		}
		return fechaDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getFechaDescrDBEntity()
	 */
	public IFechaDescrDBEntity getFechaDescrDBEntity() {
		if (fechaDescrDBEntity == null) {
			fechaDescrDBEntity = getFactory().getFechaDescrDBEntity(dataSource);
		}
		return fechaDescrDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getNumeroDBEntity()
	 */
	public INumeroDBEntity getNumeroDBEntity() {
		if (numeroDBEntity == null) {
			numeroDBEntity = getFactory().getNumeroDBEntity(dataSource);
		}
		return numeroDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getNumeroDescrDBEntity()
	 */
	public INumeroDescrDBEntity getNumeroDescrDBEntity() {
		if (numeroDescrDBEntity == null) {
			numeroDescrDBEntity = getFactory().getNumeroDescrDBEntity(
					dataSource);
		}
		return numeroDescrDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getReferenciaDBEntity()
	 */
	public IReferenciaDBEntity getReferenciaDBEntity() {
		if (referenciaDBEntity == null) {
			referenciaDBEntity = getFactory().getReferenciaDBEntity(dataSource);
		}
		return referenciaDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getReferenciaDescrDBEntity()
	 */
	public IReferenciaDescrDBEntity getReferenciaDescrDBEntity() {
		if (referenciaDescrDBEntity == null) {
			referenciaDescrDBEntity = getFactory().getReferenciaDescrDBEntity(
					dataSource);
		}
		return referenciaDescrDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getTextoDBEntity()
	 */
	public ITextoDBEntity getTextoDBEntity() {
		if (textoCortoDBEntity == null) {
			textoCortoDBEntity = getFactory().getTextoCortoDBEntity(dataSource);
		}
		return textoCortoDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getTextoCortoDescrDBEntity()
	 */
	public ITextoCortoDescrDBEntity getTextoCortoDescrDBEntity() {
		if (textoCortoDescrDBEntity == null) {
			textoCortoDescrDBEntity = getFactory().getTextoCortoDescrDBEntity(
					dataSource);
		}
		return textoCortoDescrDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getTextoLargoDbEntity()
	 */
	public ITextoDBEntity getTextoLargoDbEntity() {
		if (textoLargoDbEntity == null) {
			textoLargoDbEntity = getFactory().getTextoLargoDBEntity(dataSource);
		}
		return textoLargoDbEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getTextoLargoDescrDBEntity()
	 */
	public ITextoLargoDescrDBEntity getTextoLargoDescrDBEntity() {
		if (textoLargoDescrDBEntity == null) {
			textoLargoDescrDBEntity = getFactory().getTextoLargoDescrDBEntity(
					dataSource);
		}
		return textoLargoDescrDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getArchivoDbEntity()
	 */
	public IArchivoDbEntity getArchivoDbEntity() {
		if (archivoDbEntity == null) {
			archivoDbEntity = getFactory().getArchivoDbEntity(dataSource);
		}
		return archivoDbEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getNivelArchivoDbEntity()
	 */
	public INivelArchivoDbEntity getNivelArchivoDbEntity() {
		if (nivelArchivoDbEntity == null) {
			nivelArchivoDbEntity = getFactory().getNivelArchivoDBEntity(
					dataSource);
		}
		return nivelArchivoDbEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getFormatoDbEntity()
	 */
	public IFormatoDbEntity getFormatoDbEntity() {
		if (formatoDbEntity == null) {
			formatoDbEntity = getFactory().getFormatoDBEntity(dataSource);
		}
		return formatoDbEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getLockDBEntity()
	 */
	public ILockDBEntity getLockDBEntity() {
		if (lockDBEntity == null) {
			lockDBEntity = getFactory().getLockDBEntityImplBase(dataSource);
		}
		return lockDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getGrupoDBEntity()
	 */
	public IGrupoDBEntity getGrupoDBEntity() {
		if (grupoDBEntity == null) {
			grupoDBEntity = getFactory().getGrupoDBEntity(dataSource);
		}
		return grupoDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getListaControlAccesoDbEntity()
	 */
	public IListaControlAccesoDbEntity getListaControlAccesoDbEntity() {
		if (listaControlAccesoDbEntity == null) {
			listaControlAccesoDbEntity = getFactory()
					.getListaControlAccesoDbEntity(dataSource);
		}
		return listaControlAccesoDbEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getOrganoDbEntity()
	 */
	public ICAOrganoDbEntity getOrganoDbEntity() {
		if (organoDbEntity == null) {
			organoDbEntity = getFactory().getCAOrganoDbEntity(dataSource);
		}
		return organoDbEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getPermisoRolDBEntity()
	 */
	public IPermisoRolDBEntity getPermisoRolDBEntity() {
		if (permisoRolDBEntity == null) {
			permisoRolDBEntity = getFactory().getPermisoRolDBEntity(dataSource);
		}
		return permisoRolDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getPermisosListaDbEntity()
	 */
	public IPermisosListaDbEntity getPermisosListaDbEntity() {
		if (permisosListaDbEntity == null) {
			permisosListaDbEntity = getFactory().getPermisosListaDbEntity(
					dataSource);
		}
		return permisosListaDbEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getRolDBEntity()
	 */
	public IRolDBEntity getRolDBEntity() {
		if (rolDBEntity == null) {
			rolDBEntity = getFactory().getRolDBEntity(dataSource);
		}
		return rolDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getRolUsuarioDBEntity()
	 */
	public IRolUsuarioDBEntity getRolUsuarioDBEntity() {
		if (rolUsuarioDBEntity == null) {
			rolUsuarioDBEntity = getFactory().getRolUsuarioDBEntity(dataSource);
		}
		return rolUsuarioDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getGrupoUsuarioDBEntity()
	 */
	public IGrupoUsuarioDBEntity getGrupoUsuarioDBEntity() {
		if (grupoUsuarioDBEntity == null) {
			grupoUsuarioDBEntity = getFactory().getGrupoUsuarioDBEntity(
					dataSource);
		}
		return grupoUsuarioDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getOrganoUsuarioDBEntity()
	 */
	public IOrganoUsuarioDBEntity getOrganoUsuarioDBEntity() {
		if (organoUsuarioDBEntity == null) {
			organoUsuarioDBEntity = getFactory().getOrganoUsuarioDBEntity(
					dataSource);
		}
		return organoUsuarioDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getUsuarioDBEntity()
	 */
	public IUsuarioDBEntity getUsuarioDBEntity() {
		if (usuarioDBEntity == null) {
			usuarioDBEntity = getFactory().getUsuarioDBEntity(dataSource);
		}
		return usuarioDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getDepositoDbEntity()
	 */
	public IDepositoDbEntity getDepositoDbEntity() {
		if (depositoDbEntity == null) {
			depositoDbEntity = getFactory().getDepositoDbEntity(dataSource);
		}
		return depositoDbEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getDepositoElectronicoDBEntity()
	 */
	public IDepositoElectronicoDBEntity getDepositoElectronicoDBEntity() {
		if (depositoElectronicoDBEntity == null) {
			depositoElectronicoDBEntity = getFactory()
					.getDepositoElectronicoDBEntity(dataSource);
		}
		return depositoElectronicoDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getElementoAsignableDBEntity()
	 */
	public IElementoAsignableDBEntity getElementoAsignableDBEntity() {
		if (elementoAsignableDBEntity == null) {
			elementoAsignableDBEntity = getFactory()
					.getElementoAsignableDBEntity(dataSource);
		}
		return elementoAsignableDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getElementoNoAsignableDBEntity()
	 */
	public IElementoNoAsignableDBEntity getElementoNoAsignableDBEntity() {
		if (elementoNoAsignableDBEntity == null) {
			elementoNoAsignableDBEntity = getFactory()
					.getElmentoNoAsignableDBEntity(dataSource);
		}
		return elementoNoAsignableDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getHuecoDBEntity()
	 */
	public IHuecoDBEntity getHuecoDBEntity() {
		if (huecoDBEntity == null) {
			huecoDBEntity = getFactory().getHuecoDBEntity(dataSource);
		}
		return huecoDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getNumOrdenDBEntity()
	 */
	public INumOrdenDBEntity getNumOrdenDBEntity() {
		if (numOrdenDBEntity == null) {
			numOrdenDBEntity = getFactory().getOrdenElementoDepositoDBEntity(
					dataSource);
		}
		return numOrdenDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getTipoElementoDBEntity()
	 */
	public ITipoElementoDBEntity getTipoElementoDBEntity() {
		if (tipoElementoDBEntity == null) {
			tipoElementoDBEntity = getFactory().getTipoElementoDBEntity(
					dataSource);
		}
		return tipoElementoDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getuDocEnUiDepositoDbEntity()
	 */
	public IUDocEnUiDepositoDbEntity getuDocEnUiDepositoDbEntity() {
		if (uDocEnUiDepositoDbEntity == null) {
			uDocEnUiDepositoDbEntity = getFactory()
					.getUDocEnUiDepositoDbEntity(dataSource);
		}
		return uDocEnUiDepositoDbEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getuInstalacionDepositoDBEntity()
	 */
	public IUInstalacionDepositoDBEntity getuInstalacionDepositoDBEntity() {
		if (uInstalacionDepositoDBEntity == null) {
			uInstalacionDepositoDBEntity = getFactory()
					.getUnidadInstalacionDepositoDbEntity(dataSource);
		}
		return uInstalacionDepositoDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * common.db.impl.IArchidocManager#getElementoCuadroClasificacionDbEntity()
	 */
	public IElementoCuadroClasificacionDbEntity getElementoCuadroClasificacionDbEntity() {
		if (elementoCuadroClasificacionDbEntity == null) {
			elementoCuadroClasificacionDbEntity = getFactory()
					.getElementoCuadroClasificacionDBEntity(dataSource);
		}
		return elementoCuadroClasificacionDbEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * common.db.impl.IArchidocManager#getEliminacionUDOCEliminadaDBEntity()
	 */
	public IEliminacionUDOCEliminadaDBEntity getEliminacionUDOCEliminadaDBEntity() {
		if (eliminacionUDOCEliminadaDBEntity == null) {
			eliminacionUDOCEliminadaDBEntity = getFactory()
					.getEliminacionUDocEliminadaDBEntity(dataSource);
		}
		return eliminacionUDOCEliminadaDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * common.db.impl.IArchidocManager#getEliminacionUDocConservadaDBEntity()
	 */
	public IEliminacionUDOCConservadaDBEntity getEliminacionUDocConservadaDBEntity() {
		if (eliminacionUDocConservadaDBEntity == null) {
			eliminacionUDocConservadaDBEntity = getFactory()
					.getEliminacionUDocConservadaDBEntity(dataSource);
		}
		return eliminacionUDocConservadaDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getEliminacionSerieDBEntity()
	 */
	public IEliminacionSerieDBEntity getEliminacionSerieDBEntity() {
		if (eliminacionSerieDBEntity == null) {
			eliminacionSerieDBEntity = getFactory().getEliminacionDBEntity(
					dataSource);
		}
		return eliminacionSerieDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getEntidadProductoraDBEntity()
	 */
	public IEntidadProductoraDBEntity getEntidadProductoraDBEntity() {
		if (entidadProductoraDBEntity == null) {
			entidadProductoraDBEntity = getFactory()
					.getEntidadProductoraDBEntity(dataSource);
		}
		return entidadProductoraDBEntity;
	}

	/**
	 * @return Entity que gestiona la tabla <b>ASGFESTRUCTJNIVCF</b>
	 */
	// public INivelCFDBEntity getEstructuraNivelCFDBEntity() {
	// return estructuraNivelCFDBEntity;
	// }

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getFondoDbEntity()
	 */
	public IFondoDbEntity getFondoDbEntity() {
		if (fondoDbEntity == null) {
			fondoDbEntity = getFactory().getFondoDBEntity(dataSource);
		}
		return fondoDbEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getHistoricoUDOCDBEntity()
	 */
	public IHistoricoUDOCDBEntity getHistoricoUDOCDBEntity() {
		if (historicoUDOCDBEntity == null) {
			historicoUDOCDBEntity = getFactory().getHistoricoDBEntity(
					dataSource);
		}
		return historicoUDOCDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getNivelCFDBEntity()
	 */
	public INivelCFDBEntity getNivelCFDBEntity() {
		if (nivelCFDBEntity == null) {
			nivelCFDBEntity = getFactory().getNivelCFDBEntity(dataSource);
		}
		return nivelCFDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getnSecVersionSelDBEntity()
	 */
	public INSecVersionSelDBEntity getnSecVersionSelDBEntity() {
		if (nSecVersionSelDBEntity == null) {
			nSecVersionSelDBEntity = getFactory().getNVersionSeleccionDBEntity(
					dataSource);
		}
		return nSecVersionSelDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getnSecVersionDBEntity()
	 */
	public INSecVersionDBEntity getnSecVersionDBEntity() {
		if (nSecVersionDBEntity == null) {
			nSecVersionDBEntity = getFactory().getNVersionValoracionDBEntity(
					dataSource);
		}
		return nSecVersionDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getOrganoProductorDbEntity()
	 */
	public IOrganoProductorDbEntity getOrganoProductorDbEntity() {
		if (organoProductorDbEntity == null) {
			organoProductorDbEntity = getFactory().getOrganoProductorDBEntity(
					dataSource);
		}
		return organoProductorDbEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getProductorSerieDbEntity()
	 */
	public IProductorSerieDbEntity getProductorSerieDbEntity() {
		if (productorSerieDbEntity == null) {
			productorSerieDbEntity = getFactory().getProductorSerieDBEntity(
					dataSource);
		}
		return productorSerieDbEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getSerieDbEntity()
	 */
	public ISerieDbEntity getSerieDbEntity() {
		if (serieDbEntity == null) {
			serieDbEntity = getFactory().getSerieDBEntity(dataSource);
		}
		return serieDbEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getnSecFondosDBEntity()
	 */
	public valoracion.db.INSecValoracionDBEntity getnSecFondosDBEntity() {
		if (nSecFondosDBEntity == null) {
			nSecFondosDBEntity = getFactory().getNSecValoracionDBEntity(
					dataSource);
		}
		return nSecFondosDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getSolicitudSerieDbEntity()
	 */
	public ISolicitudSerieDbEntity getSolicitudSerieDbEntity() {
		if (solicitudSerieDbEntity == null) {
			solicitudSerieDbEntity = getFactory().getSolicitudSerieDBEntity(
					dataSource);
		}
		return solicitudSerieDbEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getUnidadDocumentalDbEntity()
	 */
	public IUnidadDocumentalDbEntity getUnidadDocumentalDbEntity() {
		if (unidadDocumentalDbEntity == null) {
			unidadDocumentalDbEntity = getFactory()
					.getFondosUnidadDocumentalDBEntity(dataSource);
		}
		return unidadDocumentalDbEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getValoracionDBEntity()
	 */
	public IValoracionDBEntity getValoracionDBEntity() {
		if (valoracionDBEntity == null) {
			valoracionDBEntity = getFactory().getValoracionDBEntity(dataSource);
		}
		return valoracionDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getVolumenSerieDBEntity()
	 */
	public IVolumenSerieDBEntity getVolumenSerieDBEntity() {
		if (volumenSerieDBEntity == null) {
			volumenSerieDBEntity = getFactory().getVolumenSerieDBEntity(
					dataSource);
		}
		return volumenSerieDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getConsultaDBEntity()
	 */
	public IConsultaDBEntity getConsultaDBEntity() {
		if (consultaDBEntity == null) {
			consultaDBEntity = getFactory().getConsultaDBEntity(dataSource);
		}
		return consultaDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getMotivoConsultaDBEntity()
	 */
	public IMotivoConsultaDBEntity getMotivoConsultaDBEntity() {
		if (motivoConsultaDBEntity == null) {
			motivoConsultaDBEntity = getFactory().getMotivoConsultaDBEntity(
					dataSource);
		}
		return motivoConsultaDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getMotivoRechazoDBEntity()
	 */
	public IMotivoRechazoDBEntity getMotivoRechazoDBEntity() {
		if (motivoRechazoDBEntity == null) {
			motivoRechazoDBEntity = getFactory().getMotivoRechazoDBEntity(
					dataSource);
		}
		return motivoRechazoDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getPrestamoDBEntity()
	 */
	public IPrestamoDBEntity getPrestamoDBEntity() {
		if (prestamoDBEntity == null) {
			prestamoDBEntity = getFactory().getPrestamoDBEntity(dataSource);
		}
		return prestamoDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getProrrogaDBEntity()
	 */
	public IProrrogaDBEntity getProrrogaDBEntity() {
		if (prorrogaDBEntity == null) {
			prorrogaDBEntity = getFactory().getProrrogaDBEntity(dataSource);
		}
		return prorrogaDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getnSecSolicitudesDBEntity()
	 */
	public INSecSolicitudesDBEntity getnSecSolicitudesDBEntity() {
		if (nSecSolicitudesDBEntity == null) {
			nSecSolicitudesDBEntity = getFactory()
					.getNSecDBEntityForSolicitudes(dataSource);
		}
		return nSecSolicitudesDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getDetalleDBEntity()
	 */
	public IDetalleDBEntity getDetalleDBEntity() {
		if (detalleDBEntity == null) {
			detalleDBEntity = getFactory().getDetalleDBEntity(dataSource);
		}
		return detalleDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getTemaDBEntity()
	 */
	public ITemaDBEntity getTemaDBEntity() {
		if (temaDBEntity == null) {
			temaDBEntity = getFactory().getTemaDBEntity(dataSource);
		}
		return temaDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getDetallePrevisionDBEntity()
	 */
	public IDetallePrevisionDBEntity getDetallePrevisionDBEntity() {
		if (detallePrevisionDBEntity == null) {
			detallePrevisionDBEntity = getFactory()
					.getDetallePrevisionDBEntity(dataSource);
		}
		return detallePrevisionDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getMapDescUDocDBEntity()
	 */
	public IMapDescUDocDBEntity getMapDescUDocDBEntity() {
		if (mapDescUDocDBEntity == null) {
			mapDescUDocDBEntity = getFactory().getMapDescUDocDBEntity(
					dataSource);
		}
		return mapDescUDocDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getPrevisionDBEntity()
	 */
	public IPrevisionDBEntity getPrevisionDBEntity() {
		if (previsionDBEntity == null) {
			previsionDBEntity = getFactory().getPrevisionDBEntity(dataSource);
		}
		return previsionDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getRelacionEntregaDBEntity()
	 */
	public IRelacionEntregaDBEntity getRelacionEntregaDBEntity() {
		if (relacionEntregaDBEntity == null) {
			relacionEntregaDBEntity = getFactory().getRelacionDBEntity(
					dataSource);
		}
		return relacionEntregaDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getnSecTransferencias()
	 */
	public INSecTransferenciasDBEntity getnSecTransferencias() {
		if (nSecTransferencias == null) {
			nSecTransferencias = getFactory().getNSecDBEntity(dataSource);
		}
		return nSecTransferencias;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getnSecUIDBEntity()
	 */
	public INSecUIDBEntity getnSecUIDBEntity() {
		if (nSecUIDBEntity == null) {
			nSecUIDBEntity = getFactory().getNSecUIDBEntity(dataSource);
		}
		return nSecUIDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getnSecUDocDBEntity()
	 */
	public INSecUDocDBEntity getnSecUDocDBEntity() {
		if (nSecUDocDBEntity == null) {
			nSecUDocDBEntity = getFactory().getNSecUDocDBEntity(dataSource);
		}
		return nSecUDocDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getUdocEnUIDBEntity()
	 */
	public IUdocEnUIDBEntity getUdocEnUIDBEntity() {
		if (udocEnUIDBEntity == null) {
			udocEnUIDBEntity = getFactory().getUdocEnUIDBEntity(dataSource);
		}
		return udocEnUIDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getUdocElectronicaDBEntity()
	 */
	public IUdocElectronicaDBEntity getUdocElectronicaDBEntity() {
		if (udocElectronicaDBEntity == null) {
			udocElectronicaDBEntity = getFactory().getUDocElectronicaDBEntity(
					dataSource);
		}
		return udocElectronicaDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getUnidadInstalacionDBEntity()
	 */
	public IUnidadInstalacionDBEntity getUnidadInstalacionDBEntity() {
		if (unidadInstalacionDBEntity == null) {
			unidadInstalacionDBEntity = getFactory()
					.getUnidadInstalacionDBEntity(dataSource);
		}
		return unidadInstalacionDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getuDocRelacionDBEntity()
	 */
	public IUDocRelacionDBEntity getuDocRelacionDBEntity() {
		if (uDocRelacionDBEntity == null) {
			uDocRelacionDBEntity = getFactory()
					.getTransferenciasUnidadDocumentalDBEntity(dataSource);
		}
		return uDocRelacionDBEntity;
	}

	// /*
	// * (non-Javadoc)
	// *
	// * @see common.db.impl.IArchidocManager#getGuidGenDBEntity()
	// */
	// public IGuidGenDBEntity getGuidGenDBEntity() {
	// if (guidGenDBEntity == null) {
	// guidGenDBEntity = getFactory().getGuidGenDBEntity(dataSource);
	// }
	// return guidGenDBEntity;
	// }

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getInfoSistemaDBEntity()
	 */
	public IInfoSistemaDBEntity getInfoSistemaDBEntity() {
		if (infoSistemaDBEntity == null) {
			infoSistemaDBEntity = getFactory().getInfoSistemaDBEntity(
					dataSource);
		}
		return infoSistemaDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getUnidadInstalacionReeaDBEntity()
	 */
	public IUnidadInstalacionReeaDBEntity getUnidadInstalacionReeaDBEntity() {
		if (unidadInstalacionReeaDBEntity == null) {
			unidadInstalacionReeaDBEntity = getFactory()
					.getUnidadInstalacionReeaDBEntity(dataSource);
		}
		return unidadInstalacionReeaDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * common.db.impl.IArchidocManager#getUnidadDocumentalElectronicaDBEntity()
	 */
	public IUnidadDocumentalElectronicaDBEntity getUnidadDocumentalElectronicaDBEntity() {
		if (unidadDocumentalElectronicaDBEntity == null) {
			unidadDocumentalElectronicaDBEntity = getFactory()
					.getUnidadDocumentalElectronicaDBEntity(dataSource);
		}
		return unidadDocumentalElectronicaDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getFechaUdocReDBEntity()
	 */
	public IFechaDBEntity getFechaUdocReDBEntity() {
		if (fechaUdocReDBEntity == null) {
			fechaUdocReDBEntity = getFactory().getFechaUDocREDBEntity(
					dataSource);
		}
		return fechaUdocReDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getNumeroUdocReDBEntity()
	 */
	public INumeroDBEntity getNumeroUdocReDBEntity() {
		if (numeroUdocReDBEntity == null) {
			numeroUdocReDBEntity = getFactory().getNumeroUDocREDBEntity(
					dataSource);
		}
		return numeroUdocReDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getReferenciaUdocReDBEntity()
	 */
	public IReferenciaDBEntity getReferenciaUdocReDBEntity() {
		if (referenciaUdocReDBEntity == null) {
			referenciaUdocReDBEntity = getFactory()
					.getReferenciaUDocREDBEntity(dataSource);
		}
		return referenciaUdocReDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getTextoLargoUdocReDBEntity()
	 */
	public ITextoDBEntity getTextoLargoUdocReDBEntity() {
		if (textoLargoUdocReDBEntity == null) {
			textoLargoUdocReDBEntity = getFactory()
					.getTextoLargoUDocREDBEntity(dataSource);
		}
		return textoLargoUdocReDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getTextoCortoUdocReDBEntity()
	 */
	public ITextoDBEntity getTextoCortoUdocReDBEntity() {
		if (textoCortoUdocReDBEntity == null) {
			textoCortoUdocReDBEntity = getFactory()
					.getTextoCortoUDocREDBEntity(dataSource);
		}
		return textoCortoUdocReDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getDivisionFSDbEntity()
	 */
	public IDivisionFSDbEntity getDivisionFSDbEntity() {
		if (divisionFSDbEntity == null) {
			divisionFSDbEntity = getFactory().getDivisionFSDBEntity(dataSource);
		}
		return divisionFSDbEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getuDocEnDivisionFSDbEntity()
	 */
	public IUDocEnDivisionFSDbEntity getuDocEnDivisionFSDbEntity() {
		if (uDocEnDivisionFSDbEntity == null) {
			uDocEnDivisionFSDbEntity = getFactory()
					.getUDocEnDivisionFSDBEntity(dataSource);
		}
		return uDocEnDivisionFSDbEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getPlazosValoracionDBEntity()
	 */
	public IPlazosValoracionDBEntity getPlazosValoracionDBEntity() {
		if (plazosValoracionDBEntity == null) {
			plazosValoracionDBEntity = getFactory()
					.getPlazosValoracionDBEntity(dataSource);
		}
		return plazosValoracionDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getNsecSigNumHuecoDBEntity()
	 */
	public INsecSigNumHuecoDBEntity getNsecSigNumHuecoDBEntity() {
		if (nsecSigNumHuecoDBEntity == null) {
			nsecSigNumHuecoDBEntity = getFactory().getNsecSigNumHuecoDBEntity(
					dataSource);
		}
		return nsecSigNumHuecoDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getRevisionDocumentacionDBEntity()
	 */
	public IRevisionDocumentacionDBEntity getRevisionDocumentacionDBEntity() {
		if (revisionDocumentacionDBEntity == null) {
			revisionDocumentacionDBEntity = getFactory()
					.getRevisionDocumentacionDBEntity(dataSource);
		}
		return revisionDocumentacionDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * common.db.impl.IArchidocManager#getHistUInstalacionDepositoDBEntity()
	 */
	public IHistUInstalacionDepositoDBEntity getHistUInstalacionDepositoDBEntity() {
		if (histUInstalacionDepositoDBEntity == null) {
			histUInstalacionDepositoDBEntity = getFactory()
					.getHistUInstalacionDepositoDBEntity(dataSource);
		}
		return histUInstalacionDepositoDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getMotivoPrestamoDBEntity()
	 */
	public IMotivoPrestamoDBEntity getMotivoPrestamoDBEntity() {
		if (motivoPrestamoDBEntity == null) {
			motivoPrestamoDBEntity = getFactory().getMotivoPrestamoDBEntity(
					dataSource);
		}
		return motivoPrestamoDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getEdificioDBEntity()
	 */
	public IEdificioDBEntity getEdificioDBEntity() {
		if (edificioDBEntity == null) {
			edificioDBEntity = getFactory().getEdificioDBEntity(dataSource);
		}
		return edificioDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getSalaDBEntity()
	 */
	public ISalaDBEntity getSalaDBEntity() {
		if (salaDBEntity == null) {
			salaDBEntity = getFactory().getSalaDBEntity(dataSource);
		}
		return salaDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getMesaDBEntity()
	 */
	public IMesaDBEntity getMesaDBEntity() {
		if (mesaDBEntity == null) {
			mesaDBEntity = getFactory().getMesaDBEntity(dataSource);
		}
		return mesaDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getUsuarioSalaConsultaDBEntity()
	 */
	public IUsuarioSalaConsultaDBEntity getUsuarioSalaConsultaDBEntity() {
		if (usuarioSalaConsultaDBEntity == null) {
			usuarioSalaConsultaDBEntity = getFactory()
					.getUsuarioSalaConsultaDBEntity(dataSource);
		}
		return usuarioSalaConsultaDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * common.db.impl.IArchidocManager#getUsuarioArchivoSalasConsultaDBEntity()
	 */
	public IUsuarioArchivoSalasConsultaDBEntity getUsuarioArchivoSalasConsultaDBEntity() {
		if (usuarioArchivoSalasConsultaDBEntity == null) {
			usuarioArchivoSalasConsultaDBEntity = getFactory()
					.getUsuarioArchivoSalasConsultaDBEntity(dataSource);
		}

		return usuarioArchivoSalasConsultaDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getRegistroConsultaSalaDBEntity()
	 */
	public IRegistroConsultaSalaDBEntity getRegistroConsultaSalaDBEntity() {
		if (registroConsultaSalaDBEntity == null) {
			registroConsultaSalaDBEntity = getFactory()
					.getRegistroConsultaSalaDBEntity(dataSource);
		}

		return registroConsultaSalaDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getUiReeaCRDBEntity()
	 */
	public IUIReeaCRDBEntity getUiReeaCRDBEntity() {
		if (uiReeaCRDBEntity == null) {
			uiReeaCRDBEntity = getFactory().getUiReeaCRDBEntity(dataSource);
		}
		return uiReeaCRDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getuDocEnUIReeaCRDBEntity()
	 */
	public IUDocEnUIReeaCRDBEntity getuDocEnUIReeaCRDBEntity() {
		if (uDocEnUIReeaCRDBEntity == null) {
			uDocEnUIReeaCRDBEntity = getFactory().getUDocEnUIReeaCRDBEntity(
					dataSource);
		}
		return uDocEnUIReeaCRDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see common.db.impl.IArchidocManager#getuDocReeaCRDBEntity()
	 */
	public IUDocReeaCRDBEntity getuDocReeaCRDBEntity() {
		if (uDocReeaCRDBEntity == null) {
			uDocReeaCRDBEntity = getFactory().getUDocReeaCRDBEntity(dataSource);
		}
		return uDocReeaCRDBEntity;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * common.db.impl.IArchidocManager#getCatalogoTablasTemporalesDBEntity()
	 */
	public ICatalogoTablasTemporalesDBEntity getCatalogoTablasTemporalesDBEntity() {
		if (catalogoTablasTemporalesDBEntity == null) {
			catalogoTablasTemporalesDBEntity = getFactory()
					.getCatalogoTablasTemporalesDBEntity(dataSource);
		}
		return catalogoTablasTemporalesDBEntity;
	}

	public String getDbFactoryClass() {
		return dbFactoryClass;
	}
}
