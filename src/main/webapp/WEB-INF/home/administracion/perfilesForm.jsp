<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es-GB">
<head>
	<meta charset="utf-8"/>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui-1.8.17.custom.css"  type="text/css" media="screen" />
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ui.jqgrid.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css" type="text/css" media="screen" />
	<title>Login IWEIR</title>
	
<style>
.error {
	color: #ff0000;
}
.errorblock{
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding:8px;
	margin:16px;
}

</style>

<script src="${pageContext.request.contextPath}/js/jquery.layout.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/i18n/grid.locale-es.js" type="text/javascript"></script>
<script type="text/javascript">
	$.jgrid.no_legacy_api = true;
	$.jgrid.useJSON = true;
</script>
<script src="${pageContext.request.contextPath}/js/jquery.jqGrid.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.tablednd.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.contextmenu.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/ui.multiselect.js" type="text/javascript"></script>


<script type="text/javascript">
jQuery(document).ready(function(){
	jQuery("#crud").jqGrid({ 
		url:'${pageContext.request.contextPath}/js/peticion.jsp', 
		datatype: "json", 
		colNames:['Inv No','Date', 'Client', 'Amount','Tax','Total','Notes'], 
		colModel:[ {name:'id',index:'id', width:55, editable:true, editoptions:{readonly:true}, sorttype:'int'}, 
			{name:'invdate',index:'invdate', width:90, sorttype:'date', editable:true, editrules:{date:true},formatter:'date', datefmt:'d/m/Y'}, 
			{name:'name',index:'name asc, invdate', width:100,editable:true}, 
			{name:'amount',index:'amount', width:80, align:"right",editable:true,editrules:{number:true},sorttype:'number',formatter:'number'}, 
			{name:'tax',index:'tax', width:80, align:"right",editable:true,editrules:{number:true},sorttype:'number',formatter:'number'}, 
			{name:'total',index:'total', width:80,align:"right",editable:true,editrules:{number:true},sorttype:'number',formatter:'number'}, 
			{name:'note',index:'note', width:150, sortable:false,editable:true} ],
		rowNum:10, 
		rowTotal: 50, 
		rowList:[10,20,30], 
		pager: '#pcrud', 
		sortname: 'id', 
		loadonce: true, 
		viewrecords: true, 
		sortorder: "desc", 
		editurl: 'server.php', // this is dummy existing url 
		caption:"CRUD on Local Data" }); 
	jQuery("#crud").jqGrid('navGrid','#pcrud',{});
});
</script>

</head>
<body>

	<div id="usuarios">
		<h2>Perfiles</h2>
		
		
		<table id="crud"><tr><td>&nbsp;</td></tr></table><div id="pcrud"></div>
	</div>
	
</body>
</html>