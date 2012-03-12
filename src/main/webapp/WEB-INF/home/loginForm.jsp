<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page import="com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb" %> 
<%@ page errorPage="error.jsp"%>

<!DOCTYPE html>
<html lang="es-GB">
	<head>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css" media="screen" />
		
		<script type="text/javascript">
		
			$(document).ready(function() {
				
				$(function(){
					$("#<%=ConstantesWeb.CONST_ATTRIBUTE_USUARIO%>").validate({
						rules: {
							"nombreUsuario": "required",
							"contrasenia": "required"
						},
						messages: {
							"nombreUsuario": "El campo usuario es obligatorio",
							"contrasenia": "El campo contraseña es obligatorio"
						}
					});
				});
				
			});
		</script>
		
	</head>
	<body>
	
		<div id="loginBG">
			<h2>Acceso al sistema</h2>
			
			<form:form method="POST" commandName="<%=ConstantesWeb.CONST_ATTRIBUTE_USUARIO%>">
				<form:errors path="*" cssClass="errorBlockLogin ui-corner-all" element="div"/>
				<div>
					<img src="${pageContext.request.contextPath}/img/lock.png">
					<strong>Usuario:</strong>
					<br/><form:input path="nombreUsuario"  class="loginText ui-widget-content ui-corner-all"/>
					<p><strong>Contrase&ntilde;a:</strong>
					<br/><form:password path="contrasenia" class="loginText ui-widget-content ui-corner-all"/></p>
					<p><input class="ui-button ui-state-default ui-corner-all ui-state-hover" type="submit" value="Entrar" /></p>
				</div>
			</form:form>
			
		</div>	
	</body>
</html>