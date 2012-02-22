<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es-GB">
<head>
	<meta charset="utf-8"/>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ui.jqgrid.css" />
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
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.1.js"/>

<script src="${pageContext.request.contextPath}/js/jquery.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js" type="text/javascript"></script>

<script src="${pageContext.request.contextPath}/js/i18n/grid.locale-es.js" type="text/javascript"></script>
<script type="text/javascript">
	$.jgrid.no_legacy_api = true;
	$.jgrid.useJSON = true;
</script>
<script src="${pageContext.request.contextPath}/js/jquery.jqGrid.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.layout.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.tablednd.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jquery.contextmenu.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/jqGrid.defaults.js" type="text/javascript"></script>

<script type="text/javascript">
function asignaIdCorrecto(data){
	data.idPerfil=data.id;
}
	
jQuery(document).ready(function(){
	var URL = '${pageContext.request.contextPath}/administracion/obtenPerfiles.htm';
	var URLEdit='${pageContext.request.contextPath}/administracion/editaPerfil.htm';
	var URLDel='${pageContext.request.contextPath}/administracion/eliminaPerfil.htm';
	var options = {
	  url: URL,
	  editurl: URLEdit,
	  edit:{closeAfterEdit:true},
	  colModel:[
		{
		  name:'idPerfil', label: 'IdPerfil',
		  formatter:'integer',
		  width: 40,
		  hidden:true,
		  editable: false,
		  editoptions: {disabled: true, size:5,NullIfEmpty:true}
		},{
		  name:'descripcion',
		  label: 'Nombre de Perfil',
		  width: 750,
		  editable: true,
		  editrules: {required: true}
		},{
		  name:'activo',
		  label: 'Activo',
		  formatter: 'checkbox',
		  width: 40,
		  hidden:true,
		  edittype:"checkbox",
		  editable: false,
		  editoptions:{value:"true:false",defaultValue:"true"},
		  editrules: {edithidden:true}
		}
	  ],
	  caption: "Coleccion de Perfiles",
	  pager : '#perfilesP'
	  
	};
	var procesaRespuesta=function(response, postdata) {
        	var json = eval('(' + response.responseText + ')');
        	return [json.status=="success",json.message];
        }

	var editOptions = {
		mtype: 'POST',
		closeAfterEdit:true,
	    onclickSubmit: function(params, postdata) {
		params.url = URLEdit;
	  },afterSubmit:procesaRespuesta,
	  beforeShowForm: function(form) {
							   $('#activo', form).show();
                           }
	};
	
	var procesaRespuesta=function(response, postdata) {
        	var json = eval('(' + response.responseText + ')');
        	return [json.status=="success",json.message];
        }
	var addOptions = {
		mtype: "POST",
		closeAfterAdd:false,
		clearAfterAdd:true,
		afterSubmit:procesaRespuesta,
		beforeShowForm: function(form) {
							   $('#activo', form).show();
                           }
	};
	var delOptions = {
		afterSubmit:procesaRespuesta,
	  onclickSubmit: function(params, postdata) {
		params.url = URLDel+"?id="+postdata;
	  }
	};
	  
	$("#perfilesT").jqGrid(options);
		jQuery("#perfilesT").jqGrid('navGrid','#perfilesP',{view:true,search:false,del:true,add:true,edit:true},addOptions,editOptions,delOptions,{caption: "Usuario",bClose: "Close"});

});
</script>

</head>
<body>

	<div id="perfiles">
		<h2>${tituloPagina}</h2>
		
		
		<table id="perfilesT"></table> <div id="perfilesP"></div>
	</div>
	
</body>
</html>