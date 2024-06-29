<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form Success Page</title>
</head>
<body>
	<h1>Form Submitted Successfully</h1>

	<hr>

	<h1>Welcome, <c:out value="${user.userName }"></c:out> </h1>
	<h1>Email is, <c:out value="${user.email }"></c:out> </h1>
	 
	

</body>
</html>