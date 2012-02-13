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


<script type="text/javascript">
jQuery(document).ready(function(){
	var URL = '${pageContext.request.contextPath}/usuario/obtenUsuarios.htm';
	var URLEdit='${pageContext.request.contextPath}/usuario/editaUsuario.htm';
	var URLDel='${pageContext.request.contextPath}/usuario/eliminaUsuario.htm';
	var options = {
	  url: URL,
	  editurl: URLEdit,
	  edit:{closeAfterEdit:true},
	  colModel:[
		{
		  name:'idUsuario', label: 'IdUsuario',
		  formatter:'integer',
		  width: 40,
		  hidden:true,
		  editable: false,
		  editoptions: {disabled: true, size:5,NullIfEmpty:true}
		},
		{
		  name:'nombre',
		  label: 'Nombre',
		  width: 200,
		  editable: true,
		  editrules: {required: true}
		},
		{
		  name:'apellidoPaterno',
		  label: 'Apellido Paterno',
		  width: 200,
		  editable: true,
		  editrules: {required: true}
		},
		{
		  name:'apellidoMaterno',
		  label: 'Apellido Materno',
		  width: 200,
		  hidden:true,
		  editable: true,
		  editrules: {edithidden:true,required: true}
		},
		{
		  name:'nombreUsuario',
		  label: 'Nombre Usuario',
		  width: 200,
		  editable: true,
		  editrules: {required: true}
		},{
		  name:'correoElectronico',
		  label: 'Crreo Electronico',
		  width: 300,
		  hidden:true,
		  editable: true,
		  editrules: {edithidden:true,required: true,email:true}
		},{
		  name:'area',
		  label: 'Area',
		  width: 200,
		  hidden:true,
		  editable: true,
		  editrules: {edithidden:true,required: true}
		}
	  ],
	  caption: "Coleccion de Usuarios",
	  pager : '#usuariosP',
	  height: '220'
	};
	
	$.extend($.jgrid.defaults, {
	  datatype: 'json',
	  jsonReader : {
		repeatitems:false,
		total: function(result) {
		  //Total number of pages
		  return Math.ceil(result.total / result.max);
		},
		records: function(result) {
		  //Total number of records
		  return result.total;
		}
	  },
	  prmNames: {rows: 'max', search: null},
	  height: '220',
	  viewrecords: true,
	  rowList: [10, 20, 50, 100],
	  altRows: true,
	  loadError: function(xhr, status, error) {
		alert(error);
	  }
	  });
	  
	  
	  //////////////
	  $.extend($.jgrid.edit, {
		  ajaxEditOptions: { contentType: "application/json" },
		  mtype: 'POST',
		  serializeEditData: function(data) {
			if(data.oper=='edit')
				data.idUsuario=data.id;
			delete data.oper;
			delete data.id;
			return JSON.stringify(data);
		  }
		});
	$.extend($.jgrid.del, {
		  mtype: 'POST',
		  serializeDelData: function() {
			return "";
		  }
		});

	var editOptions = {
		mtype: 'PUT',
		closeAfterEdit:true,
	  onclickSubmit: function(params, postdata) {
		params.url = URLEdit;
	  }
	};
	var addOptions = {mtype: "POST",closeAfterEdit:true};
	var delOptions = {
	  onclickSubmit: function(params, postdata) {
		params.url = URLDel+"?id="+postdata;
	  }
	};
	  ///////7
	  
	$("#usuariosT")
		.jqGrid(options);
		jQuery("#usuariosT").jqGrid('navGrid','#usuariosP',{view:true,search:false,del:true,add:true,edit:true},addOptions,editOptions,delOptions,{caption: "Usuario",bClose: "Close"});

});
</script>

</head>
<body>

	<div id="usuarios">
		<h2>Usuarios</h2>
		
		
		<table id="usuariosT"></table> <div id="usuariosP"></div>
	</div>
	
</body>
</html>