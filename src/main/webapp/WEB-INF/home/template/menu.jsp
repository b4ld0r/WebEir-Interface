<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			<div id="sidebar">
				<c:if test="${!empty login.permisos}">	
					<div id="welcome">
						<strong>Bienvenido <span id="user"><c:out value="${login.usuario}" />!</span></Strong>
						</br>
						<a href="cierreSesion.htm"><strong>Cerrar sesi&oacute;n</strong></a>
					</div>
					
					<div id="accordion"> <!-- #accordion -->
						<c:forEach var="modulo" items="${menu}">
							<h3><a href="${modulo.url}">${modulo.nombre}</a></h3>
							<div>
								<c:forEach var="opcion" items="${modulo.submenu}">								
									<a href="${opcion.url}"><div><Strong>${opcion.nombre}</Strong></div></a>
								</c:forEach>
							</div>
							
						</c:forEach>
					</div><!-- end of #accordion -->
				</c:if>
			</div>