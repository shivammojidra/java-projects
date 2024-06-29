<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

	<%@include file="./base.jsp" %>
</head>
<body>
	<h1 align="center">Add New User</h1>
	
	<div class="modal-dialog">
			<div class="modal-content">
				<form method="" action="" id="inp_frm">
					<div class="modal-header">						
						<h4 class="modal-title">Add User</h4>
					</div>
					<div class="modal-body">					
						<div class="form-group">
							<label>Name</label>
							<input type="text" name="name" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Email</label>
							<input type="email" name="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Gender</label> <br>
							<input type="radio" name="gender"
					 value="Male" checked />Male&nbsp;&nbsp;<input
					type="radio" name="gender" value="Female" />Female
						</div>
						<div class="form-group">
							<label>College</label>
							<input type="text" name="college" class="form-control" required>
						</div>					
						<div class="form-group">
							<label>Course</label>
							<input type="text" name="course" class="form-control" required>
						</div>					
					</div>
					<div class="modal-footer">
						<input type="submit" class="btn btn-success" value="Add">
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
				url: "save-user",
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