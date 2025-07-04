<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Account</title>

<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

	<%@ include file="includes/navbar.jsp"%>

	<%
	String id = request.getParameter("userId");
	String userName = request.getParameter("userName");
	String email = request.getParameter("email");
	String url = request.getParameter("image");
	%>

	<div class="container mt-5">
		<h2 class="text-center">UPDATE USER ACCOUNT</h2>

		<form action="updateUser" method="POST">

			<div class="text-center mb-4">
				<img src="profileImages/<%=url%>"
					alt="<%=userName%>" class="rounded-circle mx-auto d-block"
					style="width: 200px; height: 200px; object-fit: cover;">
			</div>
			<div class="mb-3 mt-3 w-50 mx-auto">
				<label for="loginUserId">User ID:</label> <input type="text"
					class="form-control" name="userId" value="<%=id%>" readonly>
			</div>
			<div class="mb-3 w-50 mx-auto">
				<label for="loginUserName">User Name:</label> <input type="text"
					class="form-control" name="userName" value="<%=userName%>">
			</div>
			<div class="mb-3 w-50 mx-auto">
				<label for="loginPassword">Password:</label> <input type="password" 
				class="form-control" name="password" placeholder="Enter new password (leave blank to keep existing)">
			</div>
			<div class="mb-3 w-50 mx-auto">
				<label for="loginEmail">Email:</label> <input type="email"
					class="form-control" name="email" value="<%=email%>">
			</div>
			<div class="text-center">
				<input type="submit" class="btn btn-primary btn-lg"
					value="UPDATE ACCOUNT">
			</div>
		</form>
	</div>
</body>
</html>
