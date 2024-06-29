<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Use of Core</title>
</head>
<body>
	<c:set var="i" value="5" scope="application"/>
	<!--  -->
	<h1> <c:out value="${i}" default="0" /> </h1>
	<%-- <c:remove var="i"/> --%>
	<h1> <c:out value="${i}" default="0" /> </h1>
	<hr>
	
	<c:if test="${i==5}" >
		<h1>Hello variable i</h1>
	</c:if>
	
	<hr>
	
	<c:choose>
		<c:when test="${i > 3 }">
			<h1>Number is greater than 3</h1>
		</c:when>
		<c:when test="${i < 3 }">
			<h1>Number is less than 3</h1>
		</c:when>
		<c:otherwise>
			<h1>Number is 3</h1>
		</c:otherwise>
	</c:choose>
	
	<hr>
	
	<c:forEach var="j" begin="1" end="10" >
		<h3>5 &times; <c:out value="${j} = " /> <c:out value="${5*j}" />  </h3>
	</c:forEach>
	
</body>
</html>