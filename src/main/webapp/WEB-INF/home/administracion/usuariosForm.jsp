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
					  width: 250,
					  editable: true,
					  editrules: {required: true}
					},{
					  name:"apellidoPaterno",
					  label: "Apellido Paterno",
					  width: 250,
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
					  width: 250,
					  editable: true,
					  editrules: {required: true}
					},{
					  name:"idPerfilSistema",
					  label: "Perfil",
					  width: 200,
					  hidden:true,
					  editable: true,
					  edittype:'select',
					  editoptions: { value: "<c:forEach var="perfiles" items="${perfiles}" varStatus="perfil">${perfiles.idPerfilSistema}:${perfiles.descripcion}<c:if test="${not perfil.last}">;</c:if></c:forEach>" },
					  editrules: {edithidden:true,required: true}
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
					  width: 40,
					  hidden:true,
					  edittype:"checkbox",
					  editable: false,
					  editoptions:{value:"true:false",defaultValue:"true"},
					  editrules: {edithidden:true}
					}
				  ],
				  caption: "",
				  pager : "#usuariosP"
				};
					
				var serializaData=function(data) {
											if(data.oper=='edit')
												asignaIdCorrecto(data);
											data.perfilSistema=new Object();
											data.perfilSistema.idPerfilSistema=data.idPerfilSistema;
											delete data.oper;
											delete data.id;
											delete data.idPerfilSistema;
											return JSON.stringify(data);
										}
		
				var editOptions = {
					onclickSubmit: function(params, postdata) {
						params.url = URLEdit;
				  	},
				  beforeShowForm: function(form) {
										   $("#nombreUsuario",form).attr("readonly","readonly");
										   $("#activo", form).show();
									   },serializeEditData:serializaData 
				};
				var addOptions = {
					beforeShowForm: function(form) {
										   $("#nombreUsuario",form).removeAttr("readonly");
										   $("#activo", form).hide();
									   },serializeEditData:serializaData 
				};
				var delOptions = {
				  onclickSubmit: function(params, postdata) {
					params.url = URLDel+"?id="+postdata;
				  }
				};

				$("#usuariosT").jqGrid(options);
					jQuery("#usuariosT").jqGrid("navGrid","#usuariosP",{view:true,search:false,del:true,add:true,edit:true},editOptions,addOptions,delOptions,{},{width:350});
		
			});
		</script>

	</head>
	<body>
		<h2>${tituloPagina}</h2>
		<div class="gridCenter">
			<div class="messages">
				<div id="successMsg" class="noDisplay success ui-corner-all"></div>
			</div>
			<table id="usuariosT"></table> <div id="usuariosP"></div>
		</div>
	</body>
</html>