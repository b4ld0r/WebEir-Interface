<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb" %>
<!DOCTYPE html>
<html lang="es-GB">
<head></head>
<body>
	<div class="forms">
	<h2>${tituloPagina}</h2>
		
		<form:form method="POST" commandName="<%=ConstantesWeb.CONST_ATTRIBUTE_CONTRASENIA%>">
			<div>
				</br><strong>Contrase&ntilde;a anterior:</strong><form:errors path="actual" cssClass="error"/>
				</br><form:input path="actual"/>
				</br></br><strong>Nueva Contrase&ntilde;a:</strong><form:errors path="nueva" cssClass="error"/>
				</br><form:input path="nueva"/>
				</br></br><strong>Confirmar nueva Contrase&ntilde;a:</strong><form:errors path="confirmacionNueva" cssClass="error"/>
				</br><form:input path="confirmacionNueva"/>
				</br></br>
				<input class="ui-corner-all" type="submit" value="Cambiar" />
				<input class="ui-corner-all" type="button" value="Cancelar" />
			</div>
		</form:form>
	</div>
</body>
</html>