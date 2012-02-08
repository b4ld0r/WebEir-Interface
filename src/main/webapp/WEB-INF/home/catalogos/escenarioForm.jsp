<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@ page import="com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb" %>
<%@ page errorPage="../error.jsp"%>

<!DOCTYPE html>
<html lang="es-GB">
<head>
	<script type="text/javascript">
		var cnt=0;
		
		$(document).ready(function() {
			
			cnt=$("#listaMotivos tr").size()-1 ;
			
			$("#agregarMotivos").click(function() {
				
				if($("#<%=ConstantesWeb.CONST_ATTRIBUTE_ESCENARIO%>").validate().element("#motivoPendiente")){
					
					$("#listaMotivos tr:last").after("<tr>"
											+ "<td>"+ (cnt+1) + "</td>"
											+ "<td>"+ $("#motivoPendiente").attr("value") + "</td>"
											+ "<td>"+ "<input type=\"hidden\"  name=\"motivos["+ cnt +"].descripcion\" value=\""+ $("#motivoPendiente").attr("value")  + "\"/>"+"</td>"
											+ "</tr>");
					$("#motivoPendiente").value("");
					cnt++;
					
				}
			});
			
			
		});
		
		function agregarMotivo(){
			
		}
	</script>
</head>
<body>
	<div class="forms">
	<h2>${tituloPagina}</h2>
		
		<form:form method="POST" modelAttribute="<%=ConstantesWeb.CONST_ATTRIBUTE_ESCENARIO%>">
			<div>
				</br><strong>Nombre de escenario:</strong><form:errors path="nombre" cssClass="error"/>
				</br><form:input path="nombre"/>
				</br></br><strong>Inicial:</strong><form:errors path="inicial" cssClass="error"/>
				</br><form:input path="inicial"/>
				</br></br>
				<fieldset class="fieldsetMenu">
					<legend>Motivos</legend>
					<strong class="break15px">Motivo:</strong>
						<input id="motivoPendiente">
						<input type="button" id="agregarMotivos" class="ui-corner-all"  value="Agregar" />
					<table class="break15px" id="listaMotivos">
						<tr><td></td><td></td><td></td></tr>
						<c:forEach items="${escenario.motivos}" var="motivo" varStatus="status">
						<tr>
							<td align="center">${status.count}</td>
							<td>${motivo.descripcion}</td>
							<td><input type="hidden" name="motivos[${status.index}].descripcion" value="${motivo.descripcion}"/></td>
						</tr>
						</c:forEach>
					</table>
				</fieldset>
				</br>
				<div class="divOptions">
				<input class="ui-corner-all" type="submit" value="Registrar" />
				<input class="ui-corner-all" type="button" value="Cancelar" />
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>