<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es-GB">
<head>
	<meta charset="utf-8"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui-1.8.17.custom.css"  type="text/css" media="screen" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css" media="screen" />
	<title>Login IWEIR</title>
</head>
<body>

	<div id="loginBG">
		<h2>Acceso al sistema</h2>
		<form:form action="loginForm.htm"  commandName="loginForm">
			<div>
				<img src="${pageContext.request.contextPath}/img/lock.png">
				</br><strong>Usuario:</strong><form:errors path="userName" />
				</br><form:input path="userName"/> 
				</br></br></br><strong>Contrase&ntilde;a:</strong><form:errors path="password" />
				</br><form:password path="password" />
				</br></br><input class="ui-corner-all" type="submit" value="Entrar" />
			</div>
			
		</form:form>
		
	</div>

</body>
</html>