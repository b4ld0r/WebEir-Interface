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
						"actual": "required",
						"nueva": "required",
						"confirmacionNueva":{
											required:true,
											equalTo:"#nueva"
						},
					},
					messages: {
						"actual": "El campo contraseña es obligatorio",
						"nueva": "El campo de nueva contraseña es obligatorio",
						"confirmacionNueva":{
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
	<div class="forms">
	<h2>${tituloPagina}</h2>
		
		<form:form method="POST" commandName="<%=ConstantesWeb.CONST_ATTRIBUTE_CONTRASENIA%>">
			<div>
				<p><strong><label for="actual">Contrase&ntilde;a anterior:</label></strong></p>
				<p><form:input path="actual"/><form:errors path="actual" cssClass="error"/></p>
				<p><strong><label for="nueva">Nueva Contrase&ntilde;a:</label></strong></p>
				<p><form:input path="nueva"/><form:errors path="nueva" cssClass="error"/></p>
				<p><strong><label for="confirmacionNueva">Confirmar nueva Contrase&ntilde;a:</label></strong></p>
				<p><form:input path="confirmacionNueva"/><form:errors path="confirmacionNueva" cssClass="error"/></p>
				<p>
				<input class="ui-corner-all" type="submit" value="Cambiar" />
				<input class="ui-corner-all" id = "cancelar" type="button" value="Cancelar" />
				</p>
			</div>
		</form:form>
	</div>
</body>
</html>