<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb" %> 

<!DOCTYPE html>
<html lang="es-GB">
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css" media="screen" />
	<script src="${pageContext.request.contextPath}/js/jquery-1.7.1.js"></script>
</head>
<body>

	<div id="loginBG">
		<h2>Acceso al sistema</h2>
		
		<form:form method="POST" commandName="<%=ConstantesWeb.CONST_ATTRIBUTE_LOGIN%>">
			<div>
				<img src="${pageContext.request.contextPath}/img/lock.png">
				</br><strong>Usuario:</strong><form:errors path="usuario" cssClass="error"/>
				</br><form:input path="usuario"/>
				</br></br><strong>Contrase&ntilde;a:</strong><form:errors path="contrasenia" cssClass="error"/>
				</br><form:password path="contrasenia"/>
				</br></br><input class="ui-corner-all" type="submit" value="Entrar" />
			</div>
		</form:form>
		
	</div>

</body>
</html>