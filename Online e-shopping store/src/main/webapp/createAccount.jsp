<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

<form action="register" method="POST">
    <div class="container">
        <!-- User Name Input -->
        <div class="form-group">
            <label for="exampleInputUserName">User Name</label>
            <input type="text" class="form-control" name="userName" placeholder="Enter Username" required>
        </div>
        
        <!-- Password Input -->
        <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" class="form-control" name="password" placeholder="Enter Password" required>
        </div>
        
        <!-- Email Input -->
        <div class="form-group">
            <label for="exampleInputEmail">Email</label>
            <input type="email" class="form-control" name="email" placeholder="Enter Email" required>
        </div>
        
        <!-- Role Dropdown Selection -->
        <div class="form-group">
            <label for="role">Role</label>
            <select class="form-control" name="role" required>
                <option value="buyer">Buyer</option>
                <option value="seller">Seller</option>
            </select>
        </div>
        
        <!-- Submit Button -->
        <input type="submit" name="submit" value="Register" class="btn btn-primary">
    </div>
</form>


</body>
</html>