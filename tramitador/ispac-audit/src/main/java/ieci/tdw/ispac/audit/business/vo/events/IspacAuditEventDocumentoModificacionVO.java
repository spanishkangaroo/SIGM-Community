/**
 * 
 */
package ieci.tdw.ispac.audit.business.vo.events;

/**
 * @author IECISA
 * @version $Revision$
 *
 */
public class IspacAuditEventDocumentoModificacionVO extends IspacAuditAbstractBasicUserEventVO{
	
	String numExpediente;
	String idDocumento;
	String idTramite;
	String newValue;

	/**
	 * @return el numExpediente
	 */
	public String getNumExpediente() {
		return numExpediente;
	}

	/**
	 * @param numExpediente el numExpediente a fijar
	 */
	public void setNumExpediente(String numExpediente) {
		this.numExpediente = numExpediente;
	}

	/**
	 * @return el idDocumento
	 */
	public String getIdDocumento() {
		return idDocumento;
	}

	/**
	 * @param idDocumento el idDocumento a fijar
	 */
	public void setIdDocumento(String idDocumento) {
		this.idDocumento = idDocumento;
	}


	/**
	 * @return el idTramite
	 */
	public String getIdTramite() {
		return idTramite;
	}

	/**
	 * @param idTramite el idTramite a fijar
	 */
	public void setIdTramite(String idTramite) {
		this.idTramite = idTramite;
	}

	/**
	 * @return el newValue
	 */
	public String getNewValue() {
		return newValue;
	}

	/**
	 * @param newValue el newValue a fijar
	 */
	public void setNewValue(String newValue) {
		this.newValue = newValue;
	}
	
	

}
