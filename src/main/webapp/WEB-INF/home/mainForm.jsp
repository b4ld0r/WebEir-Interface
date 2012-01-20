<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es-GB">
<head>
	<meta charset="utf-8" />
	<title>Interfaz Web EIR</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui-1.8.17.custom.css"  type="text/css" media="screen" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css" media="screen" />
	<link rel="stylesheet" type="text/css" href="print.css" media="print" />
	
	<script src="${pageContext.request.contextPath}/js/html5.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-1.7.1.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
	  
	<script type="text/javascript">
	$(document).ready(function() {
	  $("#accordion").accordion();
	});
	</script>

</head>
<body>
	<div id="header">
		<div id="logoSystem" >
			<img src="${pageContext.request.contextPath}/img/iweir.png" />
		</div>
		<div>
			<img src="${pageContext.request.contextPath}/img/huawei.png"/>
		</div>
		<div>
			<img src="${pageContext.request.contextPath}/img/telefonica.png"/>
		</div>
	</div>
	
	<div><!-- content and sidebar area -->
		<div id="sidebar">
			<div id="welcome">
				<strong>Bienvenido <span id="user"><core:out value="${loginForm.userName}" />!</span></Strong>
				</br>
				<a href="loginForm.htm"><strong>Cerrar sesi&oacute;n</strong></a>
			</div>
			<div id="accordion"> <!-- #accordion -->
				<h3><a href="#">Solicitudes</a></h3>
					<div>
						<a href="#"><div><Strong>Consulta</Strong></div></a>
						<a href="#"><div><Strong>Alta</Strong></div></a>
					</div>
				<h3><a href="#">IMEI´s</a></h3>
					<div>
						<a href="#"><div><Strong>Consulta</Strong></div></a>
						<a href="#"><div><Strong>Alta</Strong></div></a>
					</div>
				<h3><a href="#">Cat&aacute;logos</a></h3>
					<div>
						<a href="#"><div><Strong>Operadoras</Strong></div></a>
						<a href="#"><div><Strong>Documentos</Strong></div></a>
						<a href="#"><div><Strong>Escenarios</Strong></div></a>
					</div>
				<h3><a href="#">Administraci&oacute;n</a></h3>
					<div>
						<a href="#"><div><Strong>Usuarios</Strong></div></a>
						<a href="#"><div><Strong>Perfiles</Strong></div></a>
						<a href="#"><div><Strong>Permisos</Strong></div></a>
						<a href="#"><div><Strong>Reportes</Strong></div></a>
						<a href="#"><div><Strong>Cambiar contrase&ntilde;a</Strong></div></a>
					</div>
			</div><!-- end of #accordion -->
		</div>
		
		<div id="content">
			<div>
				<h3>Títulos</h3>
				<p>Contenido</p>
			</div>
		</div>
		
	</div><!-- end of content and sidebar-->
	
	<div id="footer">
		<div id="footer-area">
			<p>Powered by <a href="http://www.ciia.com.mx/">CIIA y Asociados. S.A de C.V.</a></p>
		</div><!-- end of footer-area -->
	</div>
	
</body>
</html>