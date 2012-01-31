<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="es-GB">
<head>
	<meta charset="utf-8" />
	<title>Interfaz Web EIR</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui-1.8.17.custom.css"  type="text/css" media="screen" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css" media="screen" />
	<link href="http://bw.imagenes.info/favicon.gif" rel="shortcut icon" type="image/x-icon"/>
	
	<script src="${pageContext.request.contextPath}/js/jquery-1.7.1.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
	  
	<script type="text/javascript">
	$(document).ready(function() {
	  $("#accordion").accordion();
	});
	</script>

</head>
<body>
    <div id="container">
        <tiles:insertAttribute name="header" />

        <div id="main_content"><!-- content and sidebar area -->
            <tiles:insertAttribute name="menu" />
            
            <c:if test="${empty login.permisos}">
            	<div id="contentBGEmpty">
            		<div id="contentEmpty">
            </c:if>
            <c:if test="${!empty login.permisos}">
            	<div id="contentBG">
            		<div id="content">
            </c:if>
            	
                    <tiles:insertAttribute name="body" />
                </div>
            </div>
        </div><!-- end of content and sidebar-->

        <div id="break"></div>
    </div>
    <tiles:insertAttribute name="footer" />
	
</body>
</html>