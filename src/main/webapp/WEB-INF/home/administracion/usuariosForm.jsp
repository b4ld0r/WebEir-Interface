<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="es-GB">
<head>
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
		var URL = "${pageContext.request.contextPath}/administracion/obtenUsuarios.htm";
		var URLEdit="${pageContext.request.contextPath}/administracion/editaUsuario.htm";
		var URLDel="${pageContext.request.contextPath}/administracion/eliminaUsuario.htm";
		var options = {
		  url: URL,
		  editurl: URLEdit,
		  edit:{closeAfterEdit:true},
		  colModel:[
			{
			  name:"idUsuario", label: "IdUsuario",
			  formatter:"integer",
			  width: 40,
			  hidden:true,
			  editable: false,
			  editoptions: {disabled: true, size:5,NullIfEmpty:true}
			},{
			  name:"nombre",
			  label: "Nombre",
			  width: 200,
			  editable: true,
			  editrules: {required: true}
			},{
			  name:"apellidoPaterno",
			  label: "Apellido Paterno",
			  width: 200,
			  editable: true,
			  editrules: {required: true}
			},
			{
			  name:"apellidoMaterno",
			  label: "Apellido Materno",
			  width: 200,
			  hidden:true,
			  editable: true,
			  editrules: {edithidden:true,required: true}
			},{
			  name:"nombreUsuario",
			  label: "Nombre Usuario",
			  width: 200,
			  editable: true,
			  editrules: {required: true}
			},{
			  name:"correoElectronico",
			  label: "Correo Electronico",
			  width: 300,
			  hidden:true,
			  editable: true,
			  editrules: {edithidden:true,required: true,email:true}
			},{
			  name:"area",
			  label: "Area",
			  width: 200,
			  hidden:true,
			  editable: true,
			  editrules: {edithidden:true,required: true}
			},{
			  name:"activo",
			  label: "Activo",
			  formatter: "checkbox",
			  align:'center',
			  width: 40,
			  hidden:true,
			  edittype:"checkbox",
			  editable: true,
			  editoptions:{value:"true:false",defaultValue:"true"},
			  editrules: {edithidden:true}
			}
		  ],
		  caption: "Coleccion de Usuarios",
		  pager : "#usuariosP",
		  height: "220"
		};

		var procesaRespuesta=function(response, postdata) {
				var json = eval("(" + response.responseText + ")");
				return [json.status=="success",json.message];
			}

		var editOptions = {
			mtype: "POST",
			closeAfterEdit:true,
			onclickSubmit: function(params, postdata) {
			params.url = URLEdit;
		  },afterSubmit:procesaRespuesta,
		  beforeShowForm: function(form) {
								   $("#nombreUsuario",form).attr("readonly","readonly");
								   $("#activo", form).show();
							   }
		};
		var addOptions = {
			mtype: "POST",
			closeAfterAdd:false,
			clearAfterAdd:true,
			afterSubmit:procesaRespuesta,
			beforeShowForm: function(form) {
								   $("#nombreUsuario",form).removeAttr("readonly");
								   $("#activo", form).hide();
							   }
		};
		var delOptions = {
		  onclickSubmit: function(params, postdata) {
			params.url = URLDel+"?id="+postdata;
		  }
		};
		  ///////7

		$("#usuariosT")
			.jqGrid(options);
			jQuery("#usuariosT").jqGrid("navGrid","#usuariosP",{view:true,search:false,del:true,add:true,edit:true},editOptions,addOptions,delOptions,{},{width:350})
			.jqGrid("navButtonAdd","#usuariosP",{
			   caption:"", 
			   buttonicon:"ui-icon-person", 
			   onClickButton: function(){ 
				 alert("Adding Row");
			   }, 
			   position:"last"
			});

	});
	</script>

</head>
<body>
	<h2>Usuarios</h2>
	<div id="usuarios">

		<table id="usuariosT"></table> <div id="usuariosP"></div>
	</div>
</body>
</html>