package ieci.tecdoc.sgm.tram.secretaria.rules.sesiones;

import ieci.tecdoc.sgm.tram.secretaria.helper.SecretariaConstants;


public class GetPropuestasOrdinariasRule extends GetPropuestasToSesionRule{

	public String getTipoPropuesta() {
		return SecretariaConstants.VALUE_TIPO_PROPUESTA_ORDINARIA;
	}



}
