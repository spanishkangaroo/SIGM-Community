package es.ieci.plusvalias.domain;

// Generated 30-jun-2010 12:15:53 by Hibernate Tools 3.2.4.CR1

import java.util.Date;

/**
 * IntedemoraDTO generated by hbm2java
 */
public class IntedemoraDTO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer orden;
	private Integer anyoejercicio;
	private Date desde;
	private Date hasta;
	private Double porcentaje;

	public IntedemoraDTO() {
	}

	public IntedemoraDTO(Integer orden) {
		this.orden = orden;
	}

	public IntedemoraDTO(Integer orden, Integer anyoejercicio, Date desde,
			Date hasta, Double porcentaje) {
		this.orden = orden;
		this.anyoejercicio = anyoejercicio;
		this.desde = desde;
		this.hasta = hasta;
		this.porcentaje = porcentaje;
	}

	public Integer getOrden() {
		return this.orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public Integer getAnyoejercicio() {
		return this.anyoejercicio;
	}

	public void setAnyoejercicio(Integer anyoejercicio) {
		this.anyoejercicio = anyoejercicio;
	}

	public Date getDesde() {
		return this.desde;
	}

	public void setDesde(Date desde) {
		this.desde = desde;
	}

	public Date getHasta() {
		return this.hasta;
	}

	public void setHasta(Date hasta) {
		this.hasta = hasta;
	}

	public Double getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}
}
