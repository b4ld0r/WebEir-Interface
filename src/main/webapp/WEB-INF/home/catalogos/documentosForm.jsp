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
				data.idDocumento = data.id;
			}
			
			$(document).ready(function(){
				var URL = "${pageContext.request.contextPath}/catalogos/obtenDocumentos.htm";
				var URLEdit="${pageContext.request.contextPath}/catalogos/editaDocumento.htm";
				var URLDel="${pageContext.request.contextPath}/catalogos/eliminaDocumento.htm";
				var options = {
				  url: URL,
				  editurl: URLEdit,
				  edit:{closeAfterEdit:"true"},
				  colModel:[
					{
					  name:"idDocumento", 
					  label: "idDocumento",
					  formatter:"integer",
					  width: 40,
					  hidden:true,
					  editable: false,
					  editoptions: {
									  disabled: true,
									  size:5,
									  NullIfEmpty:true
					  }
					},{
					  name:"descripcion",
					  label: "Nombre de documento",
					  index:"descripcion",
					  width: 600,
					  editable: true,
					  editrules: {
						  required: true,
						  custom:true,
						  custom_func:Validaciones.esAlfabetico
					  },
					  editoptions:{
									  maxlength: 45
					  }
					},{
					  name:"obligatorio",
					  label: "Obligatorio",
					  index:"descripcion",
					  formatter: "checkbox",
					  width: 150,
					  edittype:"checkbox",
					  align:"center",
					  editable: true,
					  editoptions:{
						  			value:"true:false",
						  			defaultValue:"true"
						  		  }
					}
				  ],
				  caption: "",
				  pager : "#documentosP",
				  modal : "true"
				};

				var editOptions = {
				    onclickSubmit: function(params, postdata) {
						params.url = URLEdit;
					}
				};
				
				var delOptions = {
					onclickSubmit: function(params, postdata) {
						params.url = URLDel+"?id="+postdata;
					}
				};
				
				$("#documentosT").jqGrid(options);
				$("#documentosT").jqGrid(
					"navGrid",
					"#documentosP",{
									view:true,
									search:false,
									del:true,
									add:true,
									edit:true},
					editOptions,
					{},
					delOptions);
			});
		</script>
	
	</head>
	<body>
		<h2><c:out value="${beanPermisoSeleccionado.tituloPagina}" default=" "/></h2>
		<div class="gridCenter">
			<div class="messages">
				<div id="successMsg" class="noDisplay success ui-corner-all"></div>
			</div>
			<table id="documentosT"></table>
			<div id="documentosP"></div>
		</div>
	</body>
</html>