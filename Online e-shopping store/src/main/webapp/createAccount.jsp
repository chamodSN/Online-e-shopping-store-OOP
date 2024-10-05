<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Account</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<%@ include file="includes/navbar.jsp"%>
	<div class="container mt-5">
		<h2 class="text-center">CREATE USER ACCOUNT</h2>
		<form action="register" method="POST" enctype="multipart/form-data" class="w-50 mx-auto">
			<div class="mb-3 mt-3 w-50 mx-auto">
				<label for="exampleInputUserName">User Name</label> <input
					type="text" class="form-control" name="userName"
					placeholder="Enter Username" required>
			</div>

			<div class="mb-3 mt-3 w-50 mx-auto">
				<label for="exampleInputPassword1">Password</label> <input
					type="password" class="form-control" name="password"
					placeholder="Enter Password" required>
			</div>

			<div class="mb-3 mt-3 w-50 mx-auto">
				<label for="exampleInputEmail">Email</label> <input type="email"
					class="form-control" name="email" placeholder="Enter Email"
					required>
			</div>

			<div class="mb-3 mt-3 w-50 mx-auto">
				<label for="image" class="form-label">Profile Image</label> <input
					type="file" class="form-control" name="image" required>
			</div>
			<div class="text-center">
				<input type="submit" class="btn btn-primary btn-lg" value="REGISTER">
			</div>

		</form>

	</div>
</body>
</html>