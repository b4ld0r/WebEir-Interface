<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
				  edit:{closeAfterEdit:true},
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
					  width: 600,
					  editable: true,
					  editrules: {required: true}
					}
					,{
					  name:'obligatorio',
					  label: 'Obligatorio',
					  formatter: 'checkbox',
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
				  pager : "#documentosP"
				};
			
				var procesaRespuesta=function(response, postdata) {
			        	var success = true;
			        	var message = ""
			        	var json = eval("(" + response.responseText + ")");
						alert(response.responseText+"\n"+json.status+" "+json.message);
			        	return [json.status=="success",json.message];
			        }
			
				var editOptions = {
					mtype: "POST",
					closeAfterEdit:true,
				    onclickSubmit: function(params, postdata) {
					params.url = URLEdit;
				  },afterSubmit:procesaRespuesta
				};
				var addOptions = {
					mtype: "POST",
					closeAfterAdd:true,
					clearAfterAdd:true,
					afterSubmit:procesaRespuesta
				};
				var delOptions = {
				  onclickSubmit: function(params, postdata) {
					params.url = URLDel+"?id="+postdata;
				  },
				  afterSubmit:procesaRespuesta
				};
				
				$("#documentosT")
				.jqGrid(options);
				$("#documentosT").jqGrid(
					"navGrid",
					"#documentosP",{
									view:true,
									search:false,
									del:true,
									add:true,
									edit:true
									},
					editOptions,
					addOptions,
					delOptions,
					{},
					{});

			});
		</script>
	
	</head>
	<body>
		<h2>${tituloPagina}</h2>
		
		<div class="gridCenter">
			<table id="documentosT"></table>
			<div id="documentosP"></div>
		</div>
		
	</body>
</html>