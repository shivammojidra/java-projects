<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>This is ModelAndView example</h1>
	
	<h2>Receiving Data from controller</h2>
	
	<c:out value="${myAnimal.animalName}">Else value</c:out> <br>
	<c:out value="${myAnimal.animalFood}">Else value</c:out>
	
</body>
</html>