<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Product</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<%@ include file="includes/navbar.jsp"%>

	<%
	int productId = Integer.parseInt(request.getParameter("pid"));
	String productName = request.getParameter("pname");
	String description = request.getParameter("pdescription");
	Double price = Double.parseDouble(request.getParameter("pprice"));
	String category = request.getParameter("pcategory");
	int stockQuantity = Integer.parseInt(request.getParameter("pquantity"));
	String color = request.getParameter("pcolor");
	int warranty = Integer.parseInt(request.getParameter("pwar"));
	%>

	<div class="container mt-5">
		<h2 class="text-center">Update Product</h2>
		<form action="updateProduct" method="POST"class="w-50 mx-auto">
			<div class="mb-3">
				<label for="proId" class="form-label">Product ID</label> <input
					type="number" class="form-control" name="proId"
					value="<%=productId%>" readonly>

			</div>
			<div class="mb-3">
				<label for="productName" class="form-label">Product Name</label> <input
					type="text" class="form-control" name="productName"
					value="<%=productName%>">
			</div>

			<div class="mb-3">
				<label for="description" class="form-label">Description</label>
				<textarea name="description" class="form-control" rows="4"><%=description%></textarea>
			</div>


			<div class="mb-3">
				<label for="price" class="form-label">Price</label> <input
					type="text" class="form-control" name="price" value="<%=price%>">
			</div>

			<div class="mb-3">
				<label for="category" class="form-label">Category</label> <input
					type="text" class="form-control" name="category"
					value="<%=category%>" readonly>
			</div>

			<div class="mb-3">
				<label for="color" class="form-label">Color</label> <input
					type="text" class="form-control" name="color" value="<%=color%>">
			</div>

			<div class="mb-3">
				<label for="warranty" class="form-label">Warranty (Months)</label> <input
					type="number" class="form-control" name="warranty"
					value="<%=warranty%>">
			</div>


			<div class="mb-3">
				<label for="stockQuantity" class="form-label">Stock Quantity</label>
				<input type="number" class="form-control" name="stockQuantity"
					value="<%=stockQuantity%>" required>
			</div>

			<div class="text-center">
				<input type="submit" class="btn btn-primary btn-lg"
					value="Update Product">
			</div>
		</form>
	</div>
	<%@ include file="includes/footer.jsp"%>
</body>
</html>