<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb" %>
<%@ page errorPage="../error.jsp"%>

<!DOCTYPE html>
<html lang="es-GB">
	<head>
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
	
		<script type="text/javascript">
			
			$(document).ready(function() {
				
				$("#cancelar").click(function() {
					document.location.href = document.location.href;
				});
				
				$(function(){
					$("#<%=ConstantesWeb.CONST_ATTRIBUTE_CONTRASENIA%>").validate({
						rules: {
							"contraseniaActual": "required",
							"contraseniaNueva": "required",
							"confirmaContraseniaNueva":{
												required:true,
												equalTo:"#contraseniaNueva"
							},
						},
						messages: {
							"contraseniaActual": "El campo contraseña es obligatorio",
							"contraseniaNueva": "El campo de nueva contraseña es obligatorio",
							"confirmaContraseniaNueva":{
												required:"El campo de confirmación de contraseña es obligatorio",
												equalTo:"Las contraseñas no coinciden, verifique y vuelva a intentarlo"
							}
						}
					});
				});
				
			});
		</script>
	</head>
	<body>
		<h2>${tituloPagina}</h2>
		<div class="forms">	
			<form:form method="POST" commandName="<%=ConstantesWeb.CONST_ATTRIBUTE_CONTRASENIA%>">
				<div>
					<c:if test="${!empty mensajeExito}">
						<div class="success ui-corner-all">${mensajeExito}</div>
					</c:if>
					<form:errors path="*" cssClass="alert ui-corner-all" element="div"/>
					<p><strong><label for="contraseniaActual">Contrase&ntilde;a anterior:</label></strong></p>
					<p><form:password path="contraseniaActual" class="formText ui-widget-content ui-corner-all"/></p>
					<p><strong><label for="contraseniaNueva">Nueva Contrase&ntilde;a:</label></strong></p>
					<p><form:password path="contraseniaNueva" class="formText ui-widget-content ui-corner-all"/></p>
					<p><strong><label for="confirmaContraseniaNueva">Confirmar nueva Contrase&ntilde;a:</label></strong></p>
					<p><form:password path="confirmaContraseniaNueva" class="formText ui-widget-content ui-corner-all"/></p>
					<p>
					<input class="ui-button ui-state-default ui-corner-all ui-state-hover" type="submit" value="Cambiar" />
					<input class="ui-button ui-state-default ui-corner-all ui-state-hover" id = "cancelar" type="button" value="Cancelar" />
					</p>
				</div>
			</form:form>
		</div>
	</body>
</html>