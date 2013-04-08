package es.ieci.scsp.verifdata.model.mapping.scsp;

// Generated 06-mar-2012 7:54:31 by Hibernate Tools 3.3.0.GA

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CorePeticionRespuesta generated by hbm2java
 */
@Entity
@Table(name = "core_peticion_respuesta")
public class CorePeticionRespuesta implements java.io.Serializable {

	private String idpeticion;
	private CoreServicio coreServicio;
	private String estado;
	private Date fechapeticion;
	private Date fecharespuesta;
	private Date ter;
	private String error;
	private int numeroenvios;
	private int numerotransmisiones;
	private Date fechaultimosondeo;
	private Integer transmisionsincrona;
	private String descompuesta;
	private Set<CoreTransmision> coreTransmisions = new HashSet<CoreTransmision>(
			0);
	private Set<CoreTokenData> coreTokenDatas = new HashSet<CoreTokenData>(0);

	public CorePeticionRespuesta() {
	}

	public CorePeticionRespuesta(String idpeticion, CoreServicio coreServicio,
			String estado, Date fechapeticion, int numeroenvios,
			int numerotransmisiones) {
		this.idpeticion = idpeticion;
		this.coreServicio = coreServicio;
		this.estado = estado;
		this.fechapeticion = fechapeticion;
		this.numeroenvios = numeroenvios;
		this.numerotransmisiones = numerotransmisiones;
	}

	public CorePeticionRespuesta(String idpeticion, CoreServicio coreServicio,
			String estado, Date fechapeticion, Date fecharespuesta, Date ter,
			String error, int numeroenvios, int numerotransmisiones,
			Date fechaultimosondeo, Integer transmisionsincrona,
			String descompuesta, Set<CoreTransmision> coreTransmisions,
			Set<CoreTokenData> coreTokenDatas) {
		this.idpeticion = idpeticion;
		this.coreServicio = coreServicio;
		this.estado = estado;
		this.fechapeticion = fechapeticion;
		this.fecharespuesta = fecharespuesta;
		this.ter = ter;
		this.error = error;
		this.numeroenvios = numeroenvios;
		this.numerotransmisiones = numerotransmisiones;
		this.fechaultimosondeo = fechaultimosondeo;
		this.transmisionsincrona = transmisionsincrona;
		this.descompuesta = descompuesta;
		this.coreTransmisions = coreTransmisions;
		this.coreTokenDatas = coreTokenDatas;
	}

	@Id
	@Column(name = "idpeticion", unique = true, nullable = false, length = 26)
	public String getIdpeticion() {
		return this.idpeticion;
	}

	public void setIdpeticion(String idpeticion) {
		this.idpeticion = idpeticion;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "certificado", nullable = false)
	public CoreServicio getCoreServicio() {
		return this.coreServicio;
	}

	public void setCoreServicio(CoreServicio coreServicio) {
		this.coreServicio = coreServicio;
	}

	@Column(name = "estado", nullable = false, length = 4)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechapeticion", nullable = false, length = 19)
	public Date getFechapeticion() {
		return this.fechapeticion;
	}

	public void setFechapeticion(Date fechapeticion) {
		this.fechapeticion = fechapeticion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecharespuesta", length = 19)
	public Date getFecharespuesta() {
		return this.fecharespuesta;
	}

	public void setFecharespuesta(Date fecharespuesta) {
		this.fecharespuesta = fecharespuesta;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ter", length = 19)
	public Date getTer() {
		return this.ter;
	}

	public void setTer(Date ter) {
		this.ter = ter;
	}

	@Column(name = "error")
	public String getError() {
		return this.error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Column(name = "numeroenvios", nullable = false)
	public int getNumeroenvios() {
		return this.numeroenvios;
	}

	public void setNumeroenvios(int numeroenvios) {
		this.numeroenvios = numeroenvios;
	}

	@Column(name = "numerotransmisiones", nullable = false)
	public int getNumerotransmisiones() {
		return this.numerotransmisiones;
	}

	public void setNumerotransmisiones(int numerotransmisiones) {
		this.numerotransmisiones = numerotransmisiones;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechaultimosondeo", length = 19)
	public Date getFechaultimosondeo() {
		return this.fechaultimosondeo;
	}

	public void setFechaultimosondeo(Date fechaultimosondeo) {
		this.fechaultimosondeo = fechaultimosondeo;
	}

	@Column(name = "transmisionsincrona")
	public Integer getTransmisionsincrona() {
		return this.transmisionsincrona;
	}

	public void setTransmisionsincrona(Integer transmisionsincrona) {
		this.transmisionsincrona = transmisionsincrona;
	}

	@Column(name = "descompuesta", length = 1)
	public String getDescompuesta() {
		return this.descompuesta;
	}

	public void setDescompuesta(String descompuesta) {
		this.descompuesta = descompuesta;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "corePeticionRespuesta")
	public Set<CoreTransmision> getCoreTransmisions() {
		return this.coreTransmisions;
	}

	public void setCoreTransmisions(Set<CoreTransmision> coreTransmisions) {
		this.coreTransmisions = coreTransmisions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "corePeticionRespuesta")
	public Set<CoreTokenData> getCoreTokenDatas() {
		return this.coreTokenDatas;
	}

	public void setCoreTokenDatas(Set<CoreTokenData> coreTokenDatas) {
		this.coreTokenDatas = coreTokenDatas;
	}

}
