<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb" %> 

<!DOCTYPE html>
<html lang="es-GB">
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css" media="screen" />
	
</head>
<body>

	<div id="loginBG">
		<h2>Acceso al sistema</h2>
		
		<form:form method="POST" commandName="<%=ConstantesWeb.CONST_ATTRIBUTE_LOGIN%>">
			<div>
				<img src="${pageContext.request.contextPath}/img/lock.png">
				<p><strong>Usuario:</strong><form:errors path="usuario" cssClass="error"/></p>
				<p><form:input path="usuario"/></p>
				<p><strong>Contrase&ntilde;a:</strong><form:errors path="contrasenia" cssClass="error"/></p>
				<p><form:password path="contrasenia"/></p>
				<p><input class="ui-corner-all" type="submit" value="Entrar" /></p>
			</div>
		</form:form>
		
	</div>

</body>
</html>