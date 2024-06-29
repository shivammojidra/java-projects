<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

	<%@include file="./base.jsp" %>
</head>
<body>
	<h1 align="center">Edit Existing User</h1>
	
	<div class="modal-dialog">
			<div class="modal-content">
				<form method="" action="" id="inp_frm">
					<div class="modal-header">						
						<h4 class="modal-title">Edit User</h4>
					</div>
					<div class="modal-body">					
						<div class="form-group">
							<label>Name</label>
							<input type="hidden" name="id" value="${user.id}" >
							<input type="text" name="name" class="form-control" value="${user.name}" required>
						</div>
						<div class="form-group">
							<label>Email</label>
							<input type="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" class="form-control" value="${user.email}" required>
						</div>
						<div class="form-group">
							<label>Gender</label> <br>
							<input type="radio" name="gender"
					 value="Male" ${user.gender=='Male'?'checked':''} />Male&nbsp;&nbsp;<input
					type="radio" name="gender" value="Female" ${user.gender=='Female'?'checked':''} />Female
						</div>
						<div class="form-group">
							<label>College</label>
							<input type="text" name="college" class="form-control" value="${user.college}" required>
						</div>					
						<div class="form-group">
							<label>Course</label>
							<input type="text" name="course" class="form-control" value="${user.course}" required>
						</div>					
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-success" value="Edit">
					</div>
				</form>
			</div>
		</div>
		
		<script>
	$(document).ready(function(){
		
		$("#inp_frm").on('submit',function(){
			event.preventDefault();
			
			var f = $(this).serialize();
			console.log(f);
			
			$.ajax({
				url: '${pageContext.request.contextPath}/edit-user',
				data: f,
				type: 'POST',
				async: false,
				success: function(data, textStatus, jqXHR){
					//console.log(data);
					console.log("Success.........")
					if(data.trim()==='Success'){		
						window.location.href = ${pageContext.request.contextPath}/;
						//alert("Saved!!")
					}else if(data.trim()==='Exists'){
						//$("#val").html("Wrong Credentials!!")
						alert("User With this Email Already Exists!!")
					}
				},
				error: function(jqXHR, textStatus, errorThrown){
					console.log(data);
					console.log("Error.........")
					
				}
			})
		})
		
		
	})
</script>
		
</body>
</html>