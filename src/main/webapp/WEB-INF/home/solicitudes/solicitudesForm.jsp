<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es-GB">
	<head>
		<meta charset="utf-8"/>
		<title>Login IWEIR</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ui.jqgrid.css" />
		<script src="${pageContext.request.contextPath}/js/i18n/grid.locale-es.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.jqGrid.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.layout.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.tablednd.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/jqGrid.defaults.js" type="text/javascript"></script>


		<script type="text/javascript">
			function asignaIdCorrecto(data){
				data.idUsuario=data.id;
			}
			jQuery(document).ready(function(){
				jQuery("#solicitudesT").jqGrid({ 
					url:'server.php?q=2', 
					datatype: "json", 
					colModel:[
						{
							name:"idSolicitud", label: "idSolicitud",
							formatter:"integer",
							width: 40,
							hidden:true,
							editable: false,
							editoptions: {disabled: true, size:5,NullIfEmpty:true}
						},{
							name:"operadora",
							label: "Operadora",
							width: 250,
							editable: true,
							editrules: {required: true}
						},{
							name:"estatus",
							label: "Estatus",
							width: 250,
							editable: true,
							editrules: {required: true}
						},
						{
							name:"escenario",
							label: "Escenario",
							width: 200,
							hidden:true,
							editable: true,
							editrules: {edithidden:true,required: true}
						},{
							name:"Motivo",
							label: "escenario.motivo",
							width: 250,
							editable: true,
							editrules: {required: true}
						}
					], 
					rowNum: 10, 
					rowList:[10,20,30], 
					pager: '#solicitudesP', 
					sortname: 'invdate', 
					viewrecords: true, 
					sortorder: "desc", 
					caption:"", 
					grouping: true, 
					groupingView : { 
						groupField : ['name'], 
						groupColumnShow : [false], 
						groupText : ['<b>{0}</b>'], 
						groupCollapse : false, 
						groupOrder: ['asc'], 
						groupSummary : [true], 
						showSummaryOnHide: true, 
						groupDataSorted : true 
					}, 
					footerrow: true, 
					userDataOnFooter: true 
				}); 
				jQuery("#solicitudesT").jqGrid('navGrid','#solicitudesP',{add:false,edit:false,del:false});
			});
		</script>

	</head>
	<body>

		<div class="gridCenter">
			<h2>Solicitudes</h2>


			<table id="solicitudesT"></table> <div id="solicitudesP"></div>
		</div>

	</body>
</html>