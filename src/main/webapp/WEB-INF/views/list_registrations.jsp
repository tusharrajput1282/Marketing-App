<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="menu.jsp" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <table>
		<tr>
			<th>First Name </th>
			<th>Last Name </th>
			<th>Email </th>
			<th>Mobile </th>
			<th>Delete </th>
			<th>Update </th>
		</tr>
	    <c:forEach var="registration" items="${registrations}">
	    <tr>
	        <td>${registration.firstName}</td>
	    	<td>${registration.lastName}</td>
	    	<td>${registration.email}</td>
	    	<td>${registration.mobile}</td>
	    	<td><a href="delete?id=${registration.id}">delete</a></td>
	    	<td><a href="update?id=${registration.id}">update</a></td>
	    </tr> 	
	    </c:forEach>
		
	</table>
	

</body>
</html>