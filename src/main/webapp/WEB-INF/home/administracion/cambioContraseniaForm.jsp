<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb" %>
<%@ page errorPage="../error.jsp"%>

<!DOCTYPE html>
<html lang="es-GB">
<head>
	<script type="text/javascript">
		
		$(document).ready(function() {//start ready-function

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
											equalTo:"#nueva"
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
			
		});	//end ready-function
	</script>
</head>
<body>
	<h2>${tituloPagina}</h2>
	<div class="forms">	
		<form:form method="POST" commandName="<%=ConstantesWeb.CONST_ATTRIBUTE_CONTRASENIA%>">
			<div>
				<p><strong><label for="contraseniaActual">Contrase&ntilde;a anterior:</label></strong></p>
				<p><form:input path="contraseniaActual" class="formText ui-widget-content ui-corner-all"/><form:errors path="contraseniaActual" cssClass="error"/></p>
				<p><strong><label for="contraseniaNueva">Nueva Contrase&ntilde;a:</label></strong></p>
				<p><form:input path="contraseniaNueva" class="formText ui-widget-content ui-corner-all"/><form:errors path="contraseniaNueva" cssClass="error"/></p>
				<p><strong><label for="confirmaContraseniaNueva">Confirmar nueva Contrase&ntilde;a:</label></strong></p>
				<p><form:input path="confirmaContraseniaNueva" class="formText ui-widget-content ui-corner-all"/><form:errors path="confirmaContraseniaNueva" cssClass="error"/></p>
				<p>
				<input class="ui-button ui-state-default ui-corner-all ui-state-hover" type="submit" value="Cambiar" />
				<input class="ui-button ui-state-default ui-corner-all ui-state-hover" id = "cancelar" type="button" value="Cancelar" />
				</p>
			</div>
		</form:form>
	</div>
</body>
</html>