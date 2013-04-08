<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt"%>

<%@ taglib uri="/WEB-INF/displaytag.tld" prefix="display" %>

<%@ taglib uri="/WEB-INF/taglibs/displaydepositotags.tld" prefix="archivo"%>
<%@ taglib uri="/WEB-INF/taglibs/securityTag.tld" prefix="security"%>

<bean:struts id="actionMapping" mapping="/asignacionCajas" />
<c:set var="FORMATO_FECHA" value="${appConstants.common.FORMATO_FECHA}"/>
<c:set var="vRelacion" value="${sessionScope[appConstants.transferencias.RELACION_KEY]}"/>

<c:set var="unidadDocumental" value="${sessionScope[appConstants.transferencias.PARTE_UDOC_SELECCIONADA]}"/>

<SCRIPT>
function aceptar(){
	var form = document.forms['<c:out value="${actionMapping.name}" />'];
	form.method.value = "guardarEditarDescripcionContenidoParte";
	form.submit();
}
</SCRIPT>

<tiles:insert template="/pages/tiles/PABoxLayout.jsp">
	<tiles:put name="boxTitle" direct="true">
		<bean:message key="archigest.archivo.transferencias.descContenidoUDoc"/>
	</tiles:put>
	<tiles:put name="buttonBar" direct="true">
		<TABLE cellpadding=0 cellspacing=0>
		<TR>
			<TD>
				<a class="etiquetaAzul12Bold" href="javascript:aceptar();" >
					<html:img page="/pages/images/Ok_Si.gif" altKey="archigest.archivo.aceptar" titleKey="archigest.archivo.aceptar" styleClass="imgTextBottom" />
					&nbsp;<bean:message key="archigest.archivo.aceptar"/>
				</a>
			</TD>
			<TD width="10">&nbsp;</TD>
			<TD>
				<tiles:insert definition="button.closeButton" flush="true">
					<tiles:put name="labelKey" direct="true">archigest.archivo.cancelar</tiles:put>
					<tiles:put name="imgIcon" direct="true">/pages/images/Ok_No.gif</tiles:put>
				</tiles:insert>
			</TD>
		</TR>
		</TABLE>
	</tiles:put>
	<tiles:put name="boxContent" direct="true">
		<html:form action="/asignacionCajas">
		<input type="hidden" name="method" value="" />

		<tiles:insert page="/pages/tiles/PABlockLayout.jsp">
			<tiles:put name="blockContent" direct="true">
				<TABLE class="formulario" cellpadding=0 cellspacing=0>
					<TR>
						<TD class="tdTitulo" width="220px">
							<bean:message key="archigest.archivo.transferencias.numExp"/>:&nbsp;
						</TD>
						<TD class="tdDatos">
							<c:out value="${unidadDocumental.expediente}" />
						</TD>
					</TR>
					<c:if test="${totalPartes>0}">
						<TR>
							<TD class="tdTitulo">
								<bean:message key="archigest.archivo.transferencias.parte"/>:&nbsp;
							</TD>
							<TD class="tdDatos">
								<c:out value="${unidadDocumental.asunto}"/>&nbsp;<bean:message key="archigest.archivo.de"/>&nbsp;<c:out value="${unidadDocumental.totalPartes}" />.
							</TD>
						</TR>
					</c:if>
					<TR>
						<TD class="tdTitulo">
							<bean:message key="archigest.archivo.transferencias.asunto"/>:&nbsp;
						</TD>
						<TD class="tdDatos">
							<c:out value="${unidadDocumental.asunto}" />
						</TD>
					</TR>
					<c:if test="${unidadDocumental.signaturaUdoc!=null}">
						<TR>
							<TD class="tdTitulo">
								<bean:message key="archigest.archivo.transferencias.signatura"/>:&nbsp;
							</TD>
							<TD class="tdDatos">
								<c:out value="${unidadDocumental.signaturaUdoc}" />
							</TD>
						</TR>
					</c:if>
					<TR>
						<TD class="tdTitulo">
							<bean:message key="archigest.archivo.descripcion"/>:&nbsp;
						</TD>
						<TD class="tdDatos">
						<c:choose>
							<c:when test="${unidadDocumental.descContenido!=null}">
								<c:set var="descripcionContenidoValue" value="${unidadDocumental.descContenido}" />
								<jsp:useBean id="descripcionContenidoValue" type="java.lang.String"/>
								<html:textarea property="descripcionContenido" value="<%=descripcionContenidoValue%>" onkeypress="maxlength(this,254,false)" onchange="maxlength(this,254,true)"/>
							</c:when>
							<c:otherwise>
								<html:textarea property="descripcionContenido" onkeypress="maxlength(this,254,false)" onchange="maxlength(this,254,true)"/>
							</c:otherwise>
						</c:choose>
						</TD>
					</TR>

				</TABLE>
			</tiles:put>
		</tiles:insert>
		</html:form>
	</tiles:put>
</tiles:insert>

