<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html><head>    
<title>Spring 3 MVC Multipe Row Submit - viralpatel.net</title>
</head>
<script type="text/javascript">
/*var cnt = 0;
function genera(){
	cnt++;
    document.write("<br>Nombre: " + cnt)  
}*/ 
</script>

<body> 
<h2>Spring MVC Multiple Row Form Submit example</h2>

<form:form method="post" commandName="contactForm">    
				Un dato:
				</br><form:errors path="*" cssClass="error"/>
				</br><form:input path="dato"/>
	<table>    
	<tr>        <th>No.</th>        <th>Name</th>        <th>Lastname</th>        <th>Email</th>        <th>Phone</th>    </tr>    
	<c:forEach items="${contactForm.contacts}" var="contact" varStatus="status">
		<tr>            
			<td align="center">${status.count}</td>            
			<td><input name="contacts[${status.index}].firstname" value="${contact.firstname}"/></td>            
			<td><input name="contacts[${status.index}].lastname" value="${contact.lastname}"/></td>            
			<td><input name="contacts[${status.index}].email" value="${contact.email}"/></td>            
			<td><input name="contacts[${status.index}].phone" value="${contact.phone}"/></td>        
		</tr>
	</c:forEach>
	</table><br/><input type="submit" value="Save" />
	<input type="button" value="Back" onclick="javascript:history.back()"/>
</form:form>

</body>
</html>