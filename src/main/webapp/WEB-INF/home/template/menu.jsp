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
						<c:forEach var="modulo" items="${menu}">
							<h3><a href="#">${modulo.nombre}</a></h3>
							<div>
								<c:forEach var="opcion" items="${modulo.submenu}">								
									<a href="${opcion.url}"><div id="option${opcion.idTag}"><Strong>${opcion.nombre}</Strong></div></a>
								</c:forEach>
							</div>
							
						</c:forEach>
					</div><!-- end of #accordion -->
				</c:if>
			</div>