<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page import="com.ciia.webeirinterface.controllers.applicationConstants.ConstantesWeb" %>

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
				data.idEscenario = data.id;
			}
			
			var cntMotivos=0;
			
			$(document).ready(function(){
				var URL = "${pageContext.request.contextPath}/catalogos/obtenEscenarios.htm";
				var URLEdit="${pageContext.request.contextPath}/catalogos/editaEscenario.htm";
				var URLDel="${pageContext.request.contextPath}/catalogos/eliminaEscenario.htm";
				cntMotivos=$("#listaMotivos tr").size()-1 ;
				var options = {
				  url: URL,
				  editurl: URLEdit,
				  edit:{closeAfterEdit:"true"},
				  colModel:[
					{
					  name:"idEscenario", 
					  label: "idEscenario",
					  formatter:"integer",
					  width: 40,
					  hidden:true,
					  editable: false
					},{
					  name:"descripcion",
					  label: "Nombre de escenario",
					  index:"descripcion",
					  width: 500,
					  editable: true
					},{
					  name:"inicial",
					  label: "Inicial",
					  index:"inicial",
					  width: 250,
					  editable: true
					}
				  ],
				  caption: "",
				  pager : "#escenariosP",
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
				
				$("#escenariosT").jqGrid(options);
				$("#escenariosT").jqGrid(
					"navGrid",
					"#escenariosP",{
									view:true,
									search:false,
									del:true,
									add:false,
									edit:false},
					{},
					{},
					delOptions)
				.jqGrid("navButtonAdd","#escenariosP",{
					caption:"",
					title:"Modificar fila seleccionada", 
					buttonicon:"ui-icon-pencil", 
					onClickButton: function(){
						var id = jQuery("#escenariosT").jqGrid('getGridParam','selrow');
						if(id){
							var ret = jQuery("#escenariosT").jqGrid('getRowData',id);
							$( "#escenario-form" ).dialog( "open" );
						}else{
							alert("Seleccione un registro");
						}
					}, 
					position:"first"
				})
				.jqGrid("navButtonAdd","#escenariosP",{
					caption:"",
					title:"Agregar nueva fila", 
					buttonicon:"ui-icon-plus", 
					onClickButton: function(){
						$( "#escenario-form" ).dialog( "open" );
					}, 
					position:"first"
				});
				
				var allFields = $( [] ).add( $( "#descripcion" ) ).add( $( "#inicial" ) ).add( $( "#motivo" ) );
				$( "#escenario-form" ).dialog({
					autoOpen: false,
					width: 670,
					modal: true,
					dialogClass:"ui-jqdialog",
					resizable: false,
					draggable: false,
					buttons: {
						"Guardar": function() {
							$("#<%=ConstantesWeb.CONST_ATTRIBUTE_ESCENARIO%>").submit();
							var id = jQuery("#escenariosT").jqGrid('getGridParam','selrow');
							allFields.val("");
							$( this ).dialog( "close" );
						},
						"Cancelar": function() {
							alert("Cancelar");
							allFields.val("");
							$( this ).dialog( "close" );
						}
					},
					Close: function() {
						allFields.val("");
					}
				});
				
				
				$("#agregarMotivos").click(function() {
					
					if(Validaciones.esAlfabetico($("#motivo").val())){
						
						$("#listaMotivos tr:last").after("<tr class=\"ui-widget-content jqgrow ui-row-ltr\">"
												+ "<td>"+ (cntMotivos+1) + "</td>"
												+ "<td>"+ $("#motivo").attr("value")
												+ "<input type=\"hidden\"  name=\"motivos["+ cntMotivos +"].descripcion\" value=\""+ $("#motivo").attr("value")  + "\"/>"+"</td>"
												+ "</tr>");
						$("#motivo").attr("value","");
						cnt++;
					}
				});
				
				$("#<%=ConstantesWeb.CONST_ATTRIBUTE_ESCENARIO%>").validate({
					rules: {
						"descripcion": "required",
						"inicial": "required"
					},
					messages: {
						"descripcion": "Debe ingresar el nombre de escenario",
						"inicial": "Debe ingresar la inicial"
					}
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
			<table id="escenariosT"></table>
			<div id="escenariosP"></div>
		</div>
		
		<div id="escenario-form" class="ui-jqdialog" title="Agregar registro">
			<form:form method="POST" modelAttribute="<%=ConstantesWeb.CONST_ATTRIBUTE_ESCENARIO%>">
				<div>
					<div class="messages">
						<div id="errores" class="noDisplay ui-state-error"></div>
					</div>
					<p><strong><label for="descripcion">Nombre de escenario:</label></strong><form:errors path="descripcion" cssClass="error"/>
					<form:input path="descripcion" class="formText ui-widget-content ui-corner-all"/></p>
					<p><strong><label for="inicial">Inicial:</label></strong><form:errors path="inicial" cssClass="error"/>
					<form:input path="inicial" class="formText ui-widget-content ui-corner-all"/></p>
					<fieldset class="fieldsetMenu">
						<legend>Motivos Asociados</legend>
						<strong class="break15px"><label>Motivo:</label></strong>
							<input type="text" id="motivo" class="formText ui-widget-content ui-corner-all"/>
							<input type="button" id="agregarMotivos" class="ui-button ui-state-default ui-corner-all ui-state-hover"  value="Agregar" />
						<table id="listaMotivos" class="ui-widget ui-widget-content">
							<thead>
								<tr class="ui-widget-header ">
									<th class="ui-state-default ui-th-column ui-th-ltr" style="height:0px;width:16px;">#</th>
									<th class="ui-state-default ui-th-column ui-th-ltr" style="height:0px;width:174px;">Motivo</th>
								</tr>
							</thead>
							<tbody>
								<tr class="jqgfirstrow" style="height:auto">
									<td style="height:0px;width:16px;"></td>
									<td style="height:0px;width:174px;"></td>
								</tr>
								<c:forEach items="${escenario.motivo}" var="motivo" varStatus="status">
								<tr class="ui-widget-content jqgrow ui-row-ltr">
									<td>${status.count}</td>
									<td>${motivo.descripcion}
										<input type="hidden" name="motivos[${status.index}].descripcion" value="${motivo.descripcion}"/></td>
								</tr>
								</c:forEach>
							</tbody>
						</table>
					</fieldset>
					<div class="divOptions">
					</div>				
				</div>
			</form:form>
		</div>
		
	</body>
</html>