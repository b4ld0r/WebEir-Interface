<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb" %>
<%@ page errorPage="../error.jsp"%>

<!DOCTYPE html>
<html lang="es-GB">
	<head>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ui.jqgrid.css" />
			
		<script src="${pageContext.request.contextPath}/js/i18n/grid.locale-es.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.jqGrid.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.layout.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.tablednd.js" type="text/javascript"></script>
		
		<script type="text/javascript">
			$(document).ready(function() {
				<c:if test="${listaImei != null}">
					jQuery("#listaImei").jqGrid({
						datatype: "local",
						height: "auto",
						width:750,
					   	colNames:["IMEI","Concepto","Fecha Registro","Acta","Lista"],
					   	colModel:[
					   		{name:"imei",index:"imei", width:150},
					   		{name:"concepto",index:"concepto", width:150},
					   		{name:"fechaRegistro",index:"fechaRegistro", width:150},
					   		{name:"operadora",index:"operadora", width:150},
					   		{name:"lista",index:"lista", width:150}
					   	]
					});
					
					jQuery("#listaImei").jqGrid("addRowData",1,{imei:"${listaImei[0].imei}",concepto:"${listaImei[0].concepto}",fechaRegistro:"${listaImei[0].fechaRegistro}",operadora:"${listaImei[0].operadora}",lista:"${listaImei[0].tipoLista.descripcion}"});
				
				</c:if>
				
				$.validator.addMethod("imeiRegExp", function(value, element) {
					return this.optional(element) || /^[0-9]{14}[a-zA-Z0-9]?$/i.test(value);
					}, "El formato es inadecuado");
	
				$(function(){
					$("#<%=ConstantesWeb.CONST_ATTRIBUTE_IMEI%>").validate({
						rules: {
							"imei": "required imeiRegExp"
						},
						messages: {
							"imei": {
								"required":"El campo IMEI es obligatorio"
							}
						}
					});
				});
				
			});
		</script>
	</head>
	<body>
		<h2><c:out value="${beanPermisoSeleccionado.tituloPagina}" default=" "/></h2>
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
						<c:if test="${empty listaImei}">
							<div id="successMsg" class="info ui-corner-all">No se encontraron coincidencias</div>
						</c:if>
						<c:if test="${!empty listaImei}">
							<table id="listaImei"></table>
						</c:if>
					</c:if>
				</div>
			</form:form>
		</div>
	</body>
</html>