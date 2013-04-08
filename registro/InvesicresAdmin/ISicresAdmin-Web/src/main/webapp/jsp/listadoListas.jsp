<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="es" xml:lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta name="author" content="IECISA" />
<title><bean:message key="ieci.tecdoc.sgm.pgadmin.title.aplication"/> - <bean:message key="ieci.tecdoc.sgm.rpadmin.libros.seleccionar.repositorio"/></title>
<link href='<html:rewrite page="/css/estilos.css"/>' rel="stylesheet" type="text/css" />
<link href="css/adminApp.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/common.js"></script>
<script><!--
	var skipcycle = false;

	function guardar() {
		var idLista = -1;
		var descripcion = "";

		if(document.forms[0].idList.length > 0){
			for(var i = 0; i < document.forms[0].idList.length; i++) {
				if( document.forms[0].idList[i].checked) {
					idLista = document.forms[0].idList[i].value;
					break;
				}
			}
		}
		else{
			if(document.forms[0].idList.checked){
				idLista = document.forms[0].idList.value;
			}
		}

		if(idLista != -1){
			descripcion = document.getElementById("txt" + idLista).innerHTML;

			if(window && window.opener && window.opener.asignarRepositorio){
				window.opener.asignarRepositorio(idLista, descripcion);
			}
			window.close();
		}
		else{
			alert("<bean:message key="ieci.tecdoc.sgm.rpadmin.error.mensaje.required.select.lista" />");
			return;
		}
	}

	function init() {
		mytimer = setTimeout('fcsOnMe()', 50);
	}

	function fcsOnMe(){

		if (!skipcycle){
			window.focus();
		}
		mytimer = setTimeout('fcsOnMe()', 50);
	}

	function detectKey() {
		if(window.event && window.event.keyCode == 116){
			window.event.keyCode = 0;
			return false;
		}
		return true;
	}


	function clickIE4(){
		if (event.button==2){
			return false;
		}
		return true;
	}

	function clickNS4(e){
		if (document.layers||document.getElementById&&!document.all){
			if (e.which==2||e.which==3){
				return false;
			}
		}
		return true;
	}

	if (document.layers){
		document.captureEvents(Event.MOUSEDOWN);
		document.onmousedown=clickNS4;
	}
	else if (document.all && !document.getElementById){
		document.onmousedown=clickIE4;
	}

	document.oncontextmenu=new Function("return false");
	document.onkeydown = detectKey;
--></script>
</head>
<body onload="init()">
<form action="/listadoListas.do">
<table cellpadding="0" cellspacing="0" border="0" width="100%">
	<tr>
		<td valign="top">
			<table cellspacing="2" cellpadding="2" border="0" width="100%">
				<tr>
					<td width="100%" align="left">
						<jsp:include page="includes/errores.jsp"/>
					</td>
					<logic:notEqual name="estado" value="1">
						<td align="right" class="col_nuevo" onclick="guardar()"><bean:message key="ieci.tecdoc.sgm.rpadmin.botones.aceptar"/></td>
					</logic:notEqual>
					<td align="right" class="col_eliminar" onclick="window.close()"><bean:message key="ieci.tecdoc.sgm.rpadmin.botones.cancelar"/></td>
				</tr>
			</table>
			<table cellpadding="0" cellspacing="0" border="0" width="100%">
				<tr><td height="5"></td></tr>
				<tr>
					<td>
						<div id="tablaListas" style="overflow:auto; width:320px; height:210px; ">
						<c:set var="idLista"><bean:write name="idLista"/></c:set>

						<display:table name="listas.lista" uid="fila" requestURI="/listadoListas.do" class="tablaListado" sort="page">

						 	<display:column style="width:5%px" titleKey="ieci.tecdoc.sgm.rpadmin.libros.asociacion.select">
						 		<table cellpadding="0" cellspacing="0" border="0" align="center">
						 			<tr>
						 				<td align="center">
						 					<input type="radio" name="idList" value='<bean:write name="fila" property="codigo" />'
						 					<c:if test="${idLista == fila.codigo}">
						 						checked
						 					</c:if>
						 					<logic:equal name="estado" value="1">disabled</logic:equal> />
						 				</td>
						 			</tr>
						 		</table>
						 	</display:column>

							<display:column titleKey="ieci.tecdoc.sgm.rpadmin.libros.nombre"
								 sortable="false" style="width:90%;">
								 <span id='txt<c:out value="${fila.codigo}"/>'>
								 	<c:out value="${fila.descripcion}"/>
								 </span>
						    </display:column>

						</display:table>
						</div>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>