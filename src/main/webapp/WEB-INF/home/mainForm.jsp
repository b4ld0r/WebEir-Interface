<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="es-GB">
<head>
	<meta charset="utf-8" />
	<title>Interfaz Web EIR</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui-1.8.17.custom.css"  type="text/css" media="screen" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css" media="screen" />
	<link rel="stylesheet" type="text/css" href="print.css" media="print" />
	
	<script src="${pageContext.request.contextPath}/js/html5.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-1.7.1.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
	  
	<script type="text/javascript">
	$(document).ready(function() {
	  $("#accordion").accordion();
	});
	</script>

</head>
<body>
	<div id="header">
		<div id="logoSystem" >
			<img src="${pageContext.request.contextPath}/img/iweir.png" />
		</div>
		<div>
			<img src="${pageContext.request.contextPath}/img/huawei.png"/>
		</div>
		<div>
			<img src="${pageContext.request.contextPath}/img/telefonica.png"/>
		</div>
	</div>
	
	<div id="main_content"><!-- content and sidebar area -->
		<div id="sidebar">
			<tiles:insertAttribute name="menu" />
		</div>
		
		<div id="content">
			<div>
				<h3><tiles:insertAttribute name="title" /></h3>
				<p>Contenido</p>
                                <div id="banner-style"><tiles:insertAttribute name="header" /></div>
<div id="primary-style"><tiles:insertAttribute name="body" /></div>

		</div>
		
	</div><!-- end of content and sidebar-->
	
	<div id="footer">
		<tiles:insertAttribute name="footer" />
	</div>
	
</body>
</html>