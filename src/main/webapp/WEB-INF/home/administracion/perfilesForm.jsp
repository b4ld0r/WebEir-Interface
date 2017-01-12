<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
				data.idPerfilSistema=data.id;
			}
	
			jQuery(document).ready(function(){
				var URL = '${pageContext.request.contextPath}/administracion/obtenPerfiles.htm';
				var URLEdit='${pageContext.request.contextPath}/administracion/editaPerfil.htm';
				var URLDel='${pageContext.request.contextPath}/administracion/eliminaPerfil.htm';
				var URLPermisos='${pageContext.request.contextPath}/administracion/obtenPermisosPerfil.htm';
	
				$( "#edita-permisos" ).dialog({
					autoOpen: false,
					resizable: false,
					height:300,
					width:500,
					modal: true,
					buttons: {
						"Asigna perfil": function() {
							jQuery("#permisos").multiselect("destroy");
						},
						Cancel: function() {
							jQuery("#permisos").multiselect("destroy");
						}
					}
				});
				$("#edita-permisos").removeClass("hidden");
				var options = {
					url: URL,
					editurl: URLEdit,
					edit:{closeAfterEdit:true},
					colModel:[
						{
							name:'idPerfilSistema', label: 'IdPerfil',
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
					caption: "",
					pager : '#perfilesP'
	  
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
	  
				$("#perfilesT").jqGrid(options);
				jQuery("#perfilesT").jqGrid('navGrid','#perfilesP',{view:true,search:false,del:true,add:true,edit:true},{},editOptions,delOptions,{caption: "Usuario",bClose: "Close"})
				.jqGrid("navButtonAdd","#perfilesP",{
					caption:"", 
					buttonicon:"ui-icon-key", 
					onClickButton: function(){
						var id = jQuery("#perfilesT").jqGrid('getGridParam','selrow');
						if(id){
							var ret = jQuery("#perfilesT").jqGrid('getRowData',id);
							location.href="${pageContext.request.contextPath}/administracion/asignaPerfil.htm?id="+ret.idPerfilSistema;
						}else{
							alert("Seleccione algo ò_ó");
						}
					
					
					}, 
					position:"last"
				});

			});
		</script>

	</head>
	<body>
		<h2><c:out value="${beanPermisoSeleccionado.tituloPagina}" default=" "/></h2>
		<div class="gridCenter">
			<div class="messages">
				<div id="successMsg" class="noDisplay success ui-corner-all"></div>
			</div>
			<table id="perfilesT"></table> <div id="perfilesP"></div>
		</div>

	</body>
</html>