<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<h3>Intefaz Web EIR</h3>
<FONT color="white">
Usuario "a" 
</br>Password="a"
</FONT>
<form:form action="loginForm.htm"  commandName="loginForm">
	<table>
		<tr>
			<td>Usuario:<form:errors
				path="userName" /></FONT></td>
		</tr>
		<tr>
			<td><form:input path="userName" /></td>
		</tr>
		<tr>
			<td>Clave:<FONT color="red"><form:errors
				path="password" /></FONT></td>
		</tr>
		<tr>
			<td><form:password path="password" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Entrar" /></td>
		</tr>
	</table>
</form:form>
</body>
</html>