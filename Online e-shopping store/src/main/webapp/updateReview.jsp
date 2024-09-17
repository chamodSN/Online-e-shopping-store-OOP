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
		String revid = request.getParameter("revid");
		String productId = request.getParameter("pid");
		String userId = request.getParameter("uid");
		String rating = request.getParameter("rating");
		String review = request.getParameter("reviewtxt");
		String date = request.getParameter("date");
	
	%>
	
	<form action="updateReview" method="POST">
		
		<input type="text" name="reviewId" value="<%=revid %>" readonly>
		<input type="text" name="productID" value="<%=productId %>" readonly>
		<input type="text" name="userID" value="<%=userId %>" readonly>
		<input type="text" name="rating" value="<%=rating %>" readonly>
		<input type="text" name="review" value="<%=review %>">
		<input type="text" name="date" value="<%=date %>" readonly>
		
		<input type="submit" name="submit" value="update">
	</form>

</body>
</html>