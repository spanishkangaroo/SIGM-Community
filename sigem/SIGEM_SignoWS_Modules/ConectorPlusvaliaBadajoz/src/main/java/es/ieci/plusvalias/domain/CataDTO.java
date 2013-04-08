package es.ieci.plusvalias.domain;

// Generated 30-jun-2010 12:15:53 by Hibernate Tools 3.2.4.CR1

/**
 * CataDTO generated by hbm2java
 */
public class CataDTO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String tabla;
	private Integer anyoliquidacion;
	private Double coeficiente;
	private String moneda;
	private String operador;

	public CataDTO() {
	}

	public CataDTO(String tabla) {
		this.tabla = tabla;
	}

	public CataDTO(String tabla, Integer anyoliquidacion, Double coeficiente,
			String moneda, String operador) {
		this.tabla = tabla;
		this.anyoliquidacion = anyoliquidacion;
		this.coeficiente = coeficiente;
		this.moneda = moneda;
		this.operador = operador;
	}

	public String getTabla() {
		return this.tabla;
	}

	public void setTabla(String tabla) {
		this.tabla = tabla;
	}

	public Integer getAnyoliquidacion() {
		return this.anyoliquidacion;
	}

	public void setAnyoliquidacion(Integer anyoliquidacion) {
		this.anyoliquidacion = anyoliquidacion;
	}

	public Double getCoeficiente() {
		return this.coeficiente;
	}

	public void setCoeficiente(Double coeficiente) {
		this.coeficiente = coeficiente;
	}

	public String getMoneda() {
		return this.moneda;
	}

	public void setMoneda(String moneda) {
		this.moneda = moneda;
	}

	public String getOperador() {
		return this.operador;
	}

	public void setOperador(String operador) {
		this.operador = operador;
	}
}
