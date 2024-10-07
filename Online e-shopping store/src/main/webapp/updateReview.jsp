<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Review</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<%@ include file="includes/navbar.jsp"%>

	<%
	String revid = request.getParameter("revid");
	String productId = request.getParameter("pid");
	String userId = request.getParameter("uid");
	String rating = request.getParameter("rating");
	String review = request.getParameter("reviewtxt");
	String date = request.getParameter("date");
	%>

	<div class="container mt-5">
		<h2 class="text-center">Review</h2>
		<form action="updateReview" method="POST" class="w-50 mx-auto">
			<div class="mb-3">
				<label for="orderId" class="form-label">Review ID</label> <input
					type="text" class="form-control" name="orderId" value="<%=revid%>"
					readonly>
			</div>
			<div class="mb-3">
				<label for="customerId" class="form-label">Product ID</label> <input
					type="text" class="form-control" name="customerId"
					value="<%=productId%>" readonly>
			</div>
			<div class="mb-3">
				<label for="cname" class="form-label">User ID</label> <input
					type="text" class="form-control" name="cname" value="<%=userId%>"
					readonly>
			</div>
			<div class="mb-3">
				<label for="contactNum" class="form-label">Rating</label> <input
					type="text" class="form-control" name="contactNum"
					value="<%=rating%>" readonly>
			</div>
			<div class="mb-3">
				<label for="productId" class="form-label">Product ID</label> <input
					type="text" class="form-control" name="productId"
					value="<%=productId%>" readonly>
			</div>
			<div class="mb-3">
				<label for="quantity" class="form-label">Review</label>
				<textarea class="form-control" name="quantity"><%=review%></textarea>
			</div>
			<div class="mb-3">
				<label for="totalPrice" class="form-label">Date</label> <input
					type="text" class="form-control" name="totalPrice"
					value="<%=date%>" readonly>
			</div>
			<div class="text-center">
				<input type="submit" class="btn btn-primary btn-lg" value="Update">
			</div>
		</form>
	</div>
	<%@ include file="includes/footer.jsp"%>
</body>
</html>