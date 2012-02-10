<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb" %>
<!DOCTYPE html>
<html lang="es-GB">
<head></head>
<body>
	<div class="forms">
	<h2>${tituloPagina}</h2>
		
		<form:form method="POST" commandName="<%=ConstantesWeb.CONST_ATTRIBUTE_CONSULTA_IMEI%>">
			<div>
				<p><strong><label for="imei">IMEI:</label></strong><form:errors path="imei" cssClass="error"/></p>
				<p><form:input path="imei"/></p>
				<p>
				<input class="ui-corner-all" type="submit" value="Buscar" />
				</p>
				<table class="break15px tableBlue">
					<tr><td>id IMEI</td><td>IMEI</td></tr>
					<c:forEach items="${consultaIMEI.listaIMEIS}" var="imei" varStatus="status">
					<tr>
						<td <c:if test="${ (status.count % 2) == 0}"> class="alt"</c:if> >${imei.idIMEI}</td>
						<td <c:if test="${ (status.count % 2) == 0}"> class="alt"</c:if> >${imei.ime}</td>
					</tr>
					</c:forEach>
					<c:if test="${empty consultaIMEI.listaIMEIS}">
						<tr><td colspan="2">No se encontraron coincidencias</td></tr>
					</c:if>
				</table>
			</div>
		</form:form>
	</div>
</body>
</html>