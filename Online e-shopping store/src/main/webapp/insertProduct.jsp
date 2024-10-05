<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Product</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-5">
		<h2 class="text-center">Insert Product</h2>
		<form action="insertProduct" method="POST"
			enctype="multipart/form-data" class="w-50 mx-auto">
			<div class="mb-3">
				<label for="productName" class="form-label">Product Name</label> <input
					type="text" class="form-control" name="productName"
					placeholder="Enter product name" required>
			</div>

			<div class="mb-3">
				<label for="description" class="form-label">Description</label>
				<textarea name="description" class="form-control" rows="4"
					placeholder="Enter product description" required></textarea>
			</div>

			<div class="mb-3">
				<label for="price" class="form-label">Price</label> <input
					type="text" class="form-control" name="price"
					placeholder="Enter price" required>
			</div>

			<div class="mb-3">
				<label for="category" class="form-label">Category</label> <select
					name="category" class="form-select" required>
					<option value="" disabled selected>-- Select A Category --</option>
					<option value="electronics">Electronics</option>
					<option value="fashion">Fashion</option>
					<option value="home">Home and Kitchen</option>
					<option value="books">Books</option>
					<option value="toys">Toys</option>
				</select>
			</div>

			<div class="mb-3">
				<label for="color" class="form-label">Color</label> <input
					type="text" class="form-control" name="color"
					placeholder="Enter product color" required>
			</div>

			<div class="mb-3">
				<label for="warranty" class="form-label">Warranty (Months)</label> <input
					type="number" class="form-control" name="warranty"
					placeholder="Enter warranty period in months" min="0" required>
			</div>


			<div class="mb-3">
				<label for="stockQuantity" class="form-label">Stock Quantity</label>
				<input type="number" class="form-control" name="stockQuantity"
					placeholder="Enter stock quantity" min="0" required>
			</div>

			<div class="mb-3">
				<label for="imageUrl" class="form-label">Product Image</label> <input
					type="file" class="form-control" name="image" required>
			</div>

			<div class="text-center">
				<input type="submit" class="btn btn-primary btn-lg"
					value="Add Product">
			</div>
		</form>
	</div>
</body>
</html>
