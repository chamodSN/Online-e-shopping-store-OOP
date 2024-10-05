<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Order</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

	<%@ include file="includes/navbar.jsp"%>

	<div class="container mt-5">
		<h2 class="text-center">Add Order</h2>
		<form action="addOrder" method="POST" class="w-50 mx-auto">
			<div class="mb-3">
				<label for="customerName" class="form-label">Customer Name</label> <input
					type="text" class="form-control" name="customerName" required>
			</div>
			<div class="mb-3">
				<label for="quantity" class="form-label">Quantity</label> <input
					type="number" class="form-control" name="quantity" required>
			</div>
			<div class="mb-3">
				<label for="country" class="form-label">Country</label> <input
					type="text" class="form-control" name="country"required">
			</div>

			<div class="mb-3">
				<label for="district" class="form-label">District</label> <input
					type="text" class="form-control" name="district" required>
			</div>

			<div class="mb-3">
				<label for="contactNumber" class="form-label">Contact Number</label>
				<input type="text" class="form-control" name="contactNumber">
			</div>

			<div class="mb-3">
				<label for="shippingAddress" class="form-label">Shipping
					Address</label>
				<textarea name="shippingAddress" class="form-control" rows="4"
					required></textarea>
			</div>

			<div class="text-center">
				<input type="submit" class="btn btn-primary btn-lg"
					value="Add Order">
			</div>
		</form>
	</div>
	<%@ include file="includes/footer.jsp"%>

</body>
</html>