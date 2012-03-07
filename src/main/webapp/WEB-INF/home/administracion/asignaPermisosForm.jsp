<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Asigna Permisos </title>
		
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/ui.multiselect.css" />
		<style>
			.multiselect {
				width: 750px;
				height: 300px;
			}

		</style>
		<script src="${pageContext.request.contextPath}/js/jquery.localisation.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/multiselectdeseado.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.BlockUI.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.tmpl.1.1.1.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.scrollTo.js" type="text/javascript"></script>
		
		<script type="text/javascript">
			function cancelar(){
				location.href='${pageContext.request.contextPath}/administracion/perfiles.htm';
			}
			jQuery(document).ready(function(){
				$.localise('ui-multiselect', {language: 'es', path: '${pageContext.request.contextPath}/js/i18n/'});
				$(".multiselect").multiselect();
				$("#edita-permisos").removeClass("hidden");
			});
		</script>
	</head>
	<body>
		<div id="perfiles" class="gridCenter">
			<h2>${tituloPagina}</h2>

			<div id="edita-permisos" class="hidden">
				<form:form method="POST" modelAttribute="perfil" >
					<form:hidden path="idPerfil"/>
					<form:select multiple="true" path="permisosSistema" items="${permisos}" itemLabel="descripcion" itemValue="idPermisoSistema" class="multiselect">
					</form:select>
					<p><input class="ui-button ui-state-default ui-corner-all ui-state-hover" onclick="cancelar();" type="button" value="Cancelar" />
					<input class="ui-button ui-state-default ui-corner-all ui-state-hover" type="submit" value="Aceptar" /></p>
				</form:form>
			</div>
		</div>
	</body>
</html>
