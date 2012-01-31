<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="es-GB">
<head>
	<meta charset="utf-8"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css" media="screen" />
	
	<script src="${pageContext.request.contextPath}/js/jquery-1.7.1.js"></script>
	
<style>
.error {
	color: #ff0000;
}
.errorblock{
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding:8px;
	margin:16px;
}

</style>


</head>
<body>

	<div id="loginBG">
		<h2>Acceso al sistema</h2>
		
		<form:form method="POST" commandName="login">
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