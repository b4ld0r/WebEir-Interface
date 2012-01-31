<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es-GB">
<head>
	<meta charset="utf-8"/>
	<script src="${pageContext.request.contextPath}/js/jquery-1.7.1.js"></script>
</head>
<body>
	<h1>$tituloPagina</h1>
		
		<form:form method="POST" commandName="login">
			<div>
				</br><strong>Nombre de escenario:</strong><form:errors path="nombre" cssClass="error"/>
				</br><form:input path="nombre"/>
				</br></br><strong>Inicial:</strong><form:errors path="inicial" cssClass="error"/>
				</br><form:input path="inicial"/>
				</br>
				<fieldset>
					<legend>Motivos</legend>
					</br><strong>Motivo:</strong><form:errors path="motivo" cssClass="error"/>
					</br><form:input path="motivo"/>
				</fieldset>
				</br></br>
				<input class="ui-corner-all" type="submit" value="Entrar" />
				<input class="ui-corner-all" type="button" value="Cancelar" />
			</div>
		</form:form>
</body>
</html>