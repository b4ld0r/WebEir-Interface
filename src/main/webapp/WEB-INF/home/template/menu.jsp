<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
			<div id="sidebar">
				<c:if test="${(!empty login.perfilSistema) && (empty usuario)}">
					<div id="welcome">
						<strong>Bienvenido <span id="user"><c:out value="${login.nombre}" />!</span></Strong>
						</br>
						<a href="${pageContext.request.contextPath}/inicio/cierreSesion.htm"><strong>Cerrar sesi&oacute;n</strong></a>
					</div>
					
					<div id="accordion" class="hidden"> <!-- #accordion -->
						<c:forEach var="modulo" items="${login.perfilSistema.moduloSistema}">
							<h3><a href="#">${modulo.descripcion}</a></h3>
							<div>
								<c:forEach var="opcion" items="${modulo.permisoSistema}">								
									<a href="${pageContext.request.contextPath}${opcion.url}"><div id="option${opcion.idPermisoSistema}"><Strong>${opcion.descripcion}</Strong></div></a>
								</c:forEach>
							</div>
							
						</c:forEach>
					</div><!-- end of #accordion -->
				</c:if>
			</div>