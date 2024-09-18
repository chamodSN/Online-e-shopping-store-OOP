<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		
		String id = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String role = request.getParameter("role");
	
	%>
	
	<form action="#" method="POST">
		
		<input type="text" name="userId" value="<%=id %>" readonly>
		<input type="text" name="userName" value="<%=userName %>" readonly>
		<input type="email" name="email" value="<%=email %>" readonly>
		<input type="text" name="role" value="<%=role %>" readonly>
		
		<input type="submit" name="submit" value="delete">
	</form>
	

</body>
</html>