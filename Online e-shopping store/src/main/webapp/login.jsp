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
	<form action="login" method="POST">
	
	<div class="container">
	
  <div class="form-group">
    <label for="exampleInputUserName">userName</label>
    <input type="text" class="form-control" name="loginUserName" placeholder="Enter User Name">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" name="loginPassword" placeholder="Password">
  </div>
  
  <input type="submit" name="submit" value="login">
  
  </div>
</form>

</body>
</html>