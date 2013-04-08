package es.ieci.tecdoc.fwktd.csv.web.vo;

import java.util.Date;

import es.ieci.tecdoc.fwktd.core.model.Entity;

/**
 * Informaci�n de un documento con su CSV generado.
 *
 * @author Iecisa
 * @version $Revision$
 *
 */
public class InfoDocumentoVO extends Entity {

	private static final long serialVersionUID = 2035244382996088869L;

	/**
	 * Nombre del documento.
	 */
	private String nombre = null;

	/**
	 * Descripci�n del documento.
	 */
	private String descripcion = null;

	/**
	 * Tipo MIME del documento.
	 */
	private String tipoMime = null;

	/**
	 * Fecha de creaci�n del documento.
	 */
	private Date fechaCreacion = null;

	/**
	 * Fecha de caducidad del documento.
	 */
	private Date fechaCaducidad = null;

	/**
	 * C�digo de la aplicaci�n que almacena el documento.
	 */
	private String codigoAplicacion = null;

	/**
	 * Indica la disponibilidad del documento en la aplicaci�n externa.
	 */
	private boolean disponible = true;

	/**
	 * C�digo Seguro de Verificaci�n del documento.
	 */
	private String csv = null;

	/**
	 * Fecha de generaci�n del CSV.
	 */
	private Date fechaCSV = null;

	/**
	 * Nombre de la aplicaci�n que almacena el documento.
	 */
	private String nombreAplicacion = null;

	/**
	 * Constructor.
	 */
	public InfoDocumentoVO() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoMime() {
		return tipoMime;
	}

	public void setTipoMime(String tipoMime) {
		this.tipoMime = tipoMime;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public String getCodigoAplicacion() {
		return codigoAplicacion;
	}

	public void setCodigoAplicacion(String codigoAplicacion) {
		this.codigoAplicacion = codigoAplicacion;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public String getCsv() {
		return csv;
	}

	public void setCsv(String csv) {
		this.csv = csv;
	}

	public Date getFechaCSV() {
		return fechaCSV;
	}

	public void setFechaCSV(Date fechaCSV) {
		this.fechaCSV = fechaCSV;
	}

	public String getNombreAplicacion() {
		return nombreAplicacion;
	}

	public void setNombreAplicacion(String nombreAplicacion) {
		this.nombreAplicacion = nombreAplicacion;
	}
}
