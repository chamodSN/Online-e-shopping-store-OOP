<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<%@ include file="includes/navbar.jsp"%>

	<div class="container mt-5">
		<h2 class="text-center">USER LOGIN</h2>
		<form action="login" method="POST">
			<div class="mb-3 mt-3 w-50 mx-auto">
				<label for="loginUserName">User Name:</label> <input type="text"
					class="form-control" name="loginUserName"
					placeholder="Enter User Name" required>
			</div>
			<div class="mb-3 w-50 mx-auto">
				<label for="loginPassword">Password:</label> <input type="password"
					class="form-control" name="loginPassword" placeholder="Password"
					required>
			</div>
			<div class="text-center">
				<input type="submit" class="btn btn-primary btn-lg" value="Login"><br><br>
				<a href="createAccount.jsp" class="text-decoration-none">CREATE ACCOUNT</a>
			</div>
		</form>
	</div>
	<%@ include file="includes/footer.jsp"%>
</body>
</html>


