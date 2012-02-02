<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb" %>
<!DOCTYPE html>
<html lang="es-GB">
<head></head>
<body>
	<div class="forms">
	<h1>${tituloPagina}</h1>
		
		<form:form method="POST" commandName="<%=ConstantesWeb.CONST_ATTRIBUTE_ESCENARIO%>">
			<div>
				</br><strong>Nombre de escenario:</strong><form:errors path="nombre" cssClass="error"/>
				</br><form:input path="nombre"/>
				</br></br><strong>Inicial:</strong><form:errors path="inicial" cssClass="error"/>
				</br><form:input path="inicial"/>
				</br>
				<fieldset>
					<legend>Motivos</legend>
					</br><strong>Motivo:</strong><form:errors path="motivos." cssClass="error"/>
					</br><form:input path="motivos"/>
				</fieldset>
				</br></br>
				<input class="ui-corner-all" type="submit" value="Entrar" />
				<input class="ui-corner-all" type="button" value="Cancelar" />
			</div>
		</form:form>
	</div>
</body>
</html>