<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Use of Functions</title>
</head>
<body>
	<h1>This page demonstrates JSTL functions tag</h1>

	<c:set var="myCollegeName"
		value="Vishwakarma Government Engineering College"></c:set>

	<h1>
		College name is:
		<c:out value="${myCollegeName}" />
	</h1>
	<h3>
		Length of name is:
		<c:out value="${fn:length(myCollegeName) }" />
	</h3>
	<h3>
		Name in lowerCase is:
		<c:out value="${fn:toLowerCase(myCollegeName) }" />
	</h3>
	<h3>
		Name in UpperCase is:
		<c:out value="${fn:toUpperCase(myCollegeName) }" />
	</h3>

	<h2>
		<c:if test="${fn:contains(myCollegeName,'College') }"> Name Contains 'College' </c:if>
	</h2>

	<hr>
	<h1>Using Model receiving data from Controller</h1>
	<c:out value="${animal.animalName}"></c:out>
	<br>
	<c:out value="${animal.animalFood}"></c:out>

	<hr>

	<ul>

		<c:forEach items="${fruitList}" var="fruit">
			<h2>
				<li><c:out value="${fruit}" /></li>
			</h2>

		</c:forEach>


	</ul>

</body>
</html>