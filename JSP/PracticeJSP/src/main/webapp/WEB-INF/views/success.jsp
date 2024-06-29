<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Form success page</title>
</head>
<body>
	<h1>Welcome User form was processed successfully</h1>
	<c:out value="${animal.animalName}"></c:out> <br>
	<c:out value="${animal.animalFood}"></c:out>
</body>
</html>