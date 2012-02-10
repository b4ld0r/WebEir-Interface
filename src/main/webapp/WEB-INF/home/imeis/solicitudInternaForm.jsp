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
		
		<form:form method="POST" commandName="<%=ConstantesWeb.CONST_ATTRIBUTE_SOLICITUD_INTERNA%>">
			<div>
				</br><strong>Solicitud:</strong><form:errors path="solicitud" cssClass="error"/>
				</br><form:input path="solicitud"/>
				</br></br><strong>Inicial:</strong><form:errors path="imei" cssClass="error"/>
				</br><form:input path="imei"/>
				</br></br>
				<input class="ui-corner-all" type="submit" value="Guardar" />
				<input class="ui-corner-all" type="button" value="Cancelar" />
			</div>
		</form:form>
	</div>
</body>
</html>