<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			<div id="sidebar">
				<div id="welcome">
					<strong>Bienvenido <span id="user"><!-- c:out value="${loginForm.userName}" / -->!</span></Strong>
					</br>
					<a href="cierreSesion.htm"><strong>Cerrar sesi&oacute;n</strong></a>
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