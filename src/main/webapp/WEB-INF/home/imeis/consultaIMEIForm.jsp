<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb" %>
<%@ page errorPage="../error.jsp"%>

<!DOCTYPE html>
<html lang="es-GB">
<head>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ui.jqgrid.css" type="text/css" media="screen" />
	
	<script type="text/javascript">
		$(document).ready(function() {//start ready-function
			
			$.validator.addMethod("imeiRegExp", function(value, element) {
				return this.optional(element) || /^[0-9]{14}[a-zA-Z0-9]?$/i.test(value);
				}, "IMEI incorrecto");
			
			$(function(){
				$("#<%=ConstantesWeb.CONST_ATTRIBUTE_IMEI%>").validate({
					rules: {
						"imei": "required imeiRegExp"
					},
					messages: {
						"imei": "El IMEI es incorrecto. Debe tener 15 dígitos"
					}
				});
			});
			
		});	//end ready-function
	</script>
</head>
<body>
	<h2>${tituloPagina}</h2>
	<div class="forms">	
		<form:form method="POST" commandName="<%=ConstantesWeb.CONST_ATTRIBUTE_IMEI%>">
			<div>
				<p>
					<strong><label for="imei">IMEI:</label></strong>
					<form:input path="imei" class="formText ui-widget-content ui-corner-all"/>
					<form:errors path="imei" cssClass="error"/>
				</p>
				<p>
					<input class="ui-button ui-state-default ui-corner-all ui-state-hover" type="submit" value="Buscar" />
				</p>
				<c:if test="${listaImei != null}">
				<div class="ui-jqgrid-view" style="width: 768px; ">
				
					<div style="width: 768px; " class="ui-state-default ui-jqgrid-hdiv">
					<div class="ui-jqgrid-hbox">
						<table class="ui-jqgrid-htable">
							<thead>
								<tr class="ui-jqgrid-labels">
									<th class="ui-state-default ui-th-column ui-th-ltr" style="height:0px;width:150px;">IMEI</th>
									<th class="ui-state-default ui-th-column ui-th-ltr" style="height:0px;width:150px;">Concepto</th>
									<th class="ui-state-default ui-th-column ui-th-ltr" style="height:0px;width:150px;">Fecha Registro</th>
									<th class="ui-state-default ui-th-column ui-th-ltr" style="height:0px;width:150px;">Acta</th>
									<th class="ui-state-default ui-th-column ui-th-ltr" style="height:0px;width:150px;">Lista</th>
								</tr>
							</thead>
						</table>
					</div>
					</div>
						
					<div class="ui-jqgrid-bdiv" style="height: 150px; width: 768px; ">	
					<div style="position:relative;">	
						<table class="ui-jqgrid-btable" id="listaMotivos">
							<tbody>
								<tr class="jqgfirstrow" style="height:auto">
									<td style="height:0px;width:150px;"></td>
									<td style="height:0px;width:150px;"></td>
									<td style="height:0px;width:150px;"></td>
									<td style="height:0px;width:150px;"></td>
									<td style="height:0px;width:150px;"></td>
								</tr>
								<c:forEach items="${listaImei}" var="imei" varStatus="status">
								<tr class="ui-widget-content jqgrow ui-row-ltr">
									<td>${imei.imei}</td>
									<td>Concepto(cliente)</td>
									<td>${imei.fechaRegistro}</td>
									<td>Acta(Operadora)</td>
									<td>${imei.tipoLista.descripcion}</td>
								</tr>
								</c:forEach>
								<c:if test="${empty listaImei}">
									<tr class="ui-widget-content jqgrow ui-row-ltr">
										<td colspan="5" align="center">No se encontraron coincidencias</td>
									</tr>
								</c:if>
							</tbody>
						</table>
					</div>
					</div>
				</div>
				</c:if>
			</div>
		</form:form>
	</div>
</body>
</html>