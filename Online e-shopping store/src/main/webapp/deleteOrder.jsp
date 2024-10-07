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
	<%@ include file="includes/navbar.jsp"%>
	<%
	String orderId = request.getParameter("oid");
	int quantity = Integer.parseInt(request.getParameter("qty"));
	String country = request.getParameter("country");
	String district = request.getParameter("district");
	String shippingAddress = request.getParameter("shippingAdd");
	double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
	int customerId = Integer.parseInt(request.getParameter("cid"));
	String customerName = request.getParameter("cname");
	String contactNumber = request.getParameter("contactNum");
	int productId = Integer.parseInt(request.getParameter("pid"));
	%>

	<div class="container mt-5">
		<h2 class="text-center">Delete Order</h2>
		<form action="deleteOrder" method="POST" class="w-50 mx-auto">
			<div class="mb-3">
				<label for="orderId" class="form-label">Order ID</label> <input
					type="text" class="form-control" name="orderId"
					value="<%=orderId%>" readonly>
			</div>
			<div class="mb-3">
				<label for="customerId" class="form-label">Customer ID</label> <input
					type="text" class="form-control" name="customerId"
					value="<%=customerId%>" readonly>
			</div>
			<div class="mb-3">
				<label for="cname" class="form-label">Customer Name</label> <input
					type="text" class="form-control" name="cname"
					value="<%=customerName%>" readonly>
			</div>
			<div class="mb-3">
				<label for="contactNum" class="form-label">Contact Number</label> <input
					type="text" class="form-control" name="contactNum"
					value="<%=contactNumber%>" readonly>
			</div>
			<div class="mb-3">
				<label for="productId" class="form-label">Product ID</label> <input
					type="text" class="form-control" name="productId"
					value="<%=productId%>" readonly>
			</div>
			<div class="mb-3">
				<label for="quantity" class="form-label">Quantity</label> <input
					type="text" class="form-control" name="quantity"
					value="<%=quantity%>" readonly>
			</div>
			<div class="mb-3">
				<label for="totalPrice" class="form-label">Total Price</label> <input
					type="text" class="form-control" name="totalPrice"
					value="<%=totalPrice%>" readonly>
			</div>
			<div class="mb-3">
				<label for="country" class="form-label">Country</label> <input
					type="text" class="form-control" name="country"
					value="<%=country%>" readonly>
			</div>
			<div class="mb-3">
				<label for="district" class="form-label">District</label> <input
					type="text" class="form-control" name="district"
					value="<%=district%>" readonly>
			</div>
			<div class="mb-3">
				<label for="shippingAdd" class="form-label">Shipping Address</label>
				<textarea class="form-control" rows="4" name="shippingAdd" readonly><%=shippingAddress%></textarea>
			</div>
			<div class="text-center">
				<input type="submit" class="btn btn-primary btn-lg btn-danger"
					value="Delete">
			</div>
		</form>
	</div>

</body>
</html>