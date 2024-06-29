<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SQL with JSP</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<h1>SQL set-up with jsp</h1>
	<br>
	<h2>All Users are:</h2>
	<sql:setDataSource driver="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/demodb" user="root"
		password="$ynoptek@456" var="ds" />

	<sql:query dataSource="${ds}" var="resultSet">select * from practice_table;</sql:query>

	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>Email</th>
					<th>College</th>
					<th>Course</th>
				</tr>
			</thead>

			<c:forEach items="${resultSet.rows}" var="row">
				<tr>
					<td><c:out value="${row.email}"></c:out></td>
					<td><c:out value="${row.college}"></c:out></td>
					<td><c:out value="${row.course}"></c:out></td>
				</tr>
			</c:forEach>

		</table>
	</div>

</body>
</html>