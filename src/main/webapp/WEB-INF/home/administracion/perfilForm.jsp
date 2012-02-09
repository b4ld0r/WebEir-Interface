<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb" %>
<!DOCTYPE html>
<html lang="es-GB">
<head>
	<script type="text/javascript">
		$(document).ready(function() {//start ready-function
			
			$("#cancelar").click(function() {
				document.location.href = document.location.href;
			});
			
			$(function(){
				$("#<%=ConstantesWeb.CONST_ATTRIBUTE_PERFIL%>").validate({
					rules: {
						"descripcion": "required"
					},
					messages: {
						"descripcion": "Debe ingresar la descripcion"
					},
					debug: true,
					submitHandler: function(form){
						alert("paso validacion");
					}
				});
			});
			
		});	//end ready-function
	</script>
</head>
<body>
	<div class="forms">
	<h2>${tituloPagina}</h2>
		
		<form:form method="POST" commandName="<%=ConstantesWeb.CONST_ATTRIBUTE_PERFIL%>">
			<div>
				<p><strong><label for="descripcion">Nombre de Perfil:</label></strong><form:errors path="descripcion" cssClass="error"/></p>
				<p><form:input path="descripcion"/></p>
				<p>
				<input class="ui-corner-all" type="submit" value="Guardar" />
				<input class="ui-corner-all" type="button" value="Cancelar" id="cancelar"/>
				</p>
			</div>
		</form:form>
	</div>
</body>
</html>