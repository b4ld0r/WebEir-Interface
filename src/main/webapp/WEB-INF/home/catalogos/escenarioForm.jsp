<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb" %>
<%@ page errorPage="../error.jsp"%>

<!DOCTYPE html>
<html lang="es-GB">
<head>
	<script type="text/javascript">
		var cnt=0;
		
		$(document).ready(function() {//start ready-function
			
			cnt=$("#listaMotivos tr").size()-1 ;
			
			$("#agregarMotivos").click(function() {
				var regExp = /^[a-zA-Z áéíóúAÉÍÓÚÑñ]+$/;
				 
				if($("#motivo").val() != '' && regExp.test($("#motivo").val())){
					
					$("#listaMotivos tr:last").after("<tr>"
											+ "<td"+ (((cnt+1)%2)==0?" class=\"alt\"":"") +">"+ (cnt+1) + "</td>"
											+ "<td"+ (((cnt+1)%2)==0?" class=\"alt\"":"") +">"+ $("#motivo").attr("value")
											+ "<input type=\"hidden\"  name=\"motivos["+ cnt +"].descripcion\" value=\""+ $("#motivo").attr("value")  + "\"/>"+"</td>"
											+ "</tr>");
					$("#motivo").attr("value","");
					cnt++;
					
				}
			});
			
			$("#cancelar").click(function() {
				document.location.href = document.location.href;
			});
			
			$(function(){
				$("#<%=ConstantesWeb.CONST_ATTRIBUTE_ESCENARIO%>").validate({
					rules: {
						"nombre": "required",
						"inicial": "required"
					},
					messages: {
						"nombre": "Debe ingresar el nombre de escenario",
						"inicial": "Debe ingresar la inicial"
					},
					debug: true,
					submitHandler: function(form){
						
					}
				});
			});
			
		});	//end ready-function
	</script>
</head>
<body>
	<div class="forms">
	<h2>${tituloPagina}</h2>
		
		<form:form method="POST" modelAttribute="<%=ConstantesWeb.CONST_ATTRIBUTE_ESCENARIO%>">
			<div>
				<div id="errores" class="errorblock"></div>
				<p><strong><label for="nombre">Nombre de escenario:</label></strong><form:errors path="nombre" cssClass="error"/></p>
				<p><form:input path="nombre"/></p>
				<p><strong><label for="inicial">Inicial:</label></strong><form:errors path="inicial" cssClass="error"/></p>
				<p><form:input path="inicial"/></p>
				<fieldset class="fieldsetMenu">
					<legend>Motivos Asociados</legend>
					<strong class="break15px"><label>Motivo:</label></strong>
						<input type="text" id="motivo"/>
						<input type="button" id="agregarMotivos" class="ui-corner-all"  value="Agregar" />
					<table class="break15px tableBlue" id="listaMotivos">
						<tr><td>#</td><td>Motivo</td></tr>
						<c:forEach items="${escenario.motivos}" var="motivo" varStatus="status">
						<tr>
							<td <c:if test="${ (status.count % 2) == 0}"> class="alt"</c:if> align="center" >${status.count}</td>
							<td <c:if test="${ (status.count % 2) == 0}"> class="alt"</c:if> >${motivo.descripcion}
								<input type="hidden" name="motivos[${status.index}].descripcion" value="${motivo.descripcion}"/></td>
						</tr>
						</c:forEach>
					</table>
				</fieldset>
				<div class="divOptions">
				<input class="ui-corner-all" type="submit" value="Registrar" />
				<input class="ui-corner-all" type="button" value="Cancelar" id="cancelar"/>
				</div>				
			</div>
		</form:form>
	</div>
</body>
</html>