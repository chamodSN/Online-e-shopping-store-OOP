<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.productDBUtil"%>
<%@ page import="dao.DBConnect"%>
<%@ page import="model.reviewDBUtil"%>
<%@ page import="model.review"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<%@ include file="includes/navbar.jsp"%>

	<!-- Product Information -->
	<c:forEach var="product" items="${productData}">

		<c:set var="pid" value="${product.productId}" />
		<c:set var="pname" value="${product.productName}" />
		<c:set var="pdescription" value="${product.description}" />
		<c:set var="pprice" value="${product.price}" />
		<c:set var="pcategory" value="${product.category}" />
		<c:set var="pquantity" value="${product.stockQuantity}" />
		<c:set var="pimg" value="${product.image}" />
		<c:set var="pcolor" value="${product.color}" />
		<c:set var="pwar" value="${product.warranty}" />

		<div class="container my-5">
			<div class="card">
				<div class="row no-gutters">
					<div class="col-md-6">
						<img src="images/${product.image}" class="card-img"
							alt="${product.productName}"
							style="width: 100%; height: 30rem; object-fit: contain;">
					</div>
					<div class="col-md-6">
						<div class="card-body">
							<h3 class="card-title">${product.productName}</h3>
							<p class="card-text">
								<b>Description:</b><br>${product.description}
							</p>
							<p class="card-text">
								<b>Category:</b> ${product.category}
							</p>
							<h4 class="card-text">
								<b>Price:</b> $${product.price}
							</h4>
							<p
								class="card-text ${product.stockQuantity > 0 ? 'text-success':'text-danger'}">
								${product.stockQuantity > 0 ? 'In Stock':'Out Of Stock'}
								${product.stockQuantity} available</p>
							<p class="card-text">
								<b>Color:</b> ${product.color}
							</p>
							<p class="card-text">
								<b>Warranty:</b> ${product.warranty} Months
							</p>
							<a href="#"
								class="btn btn-primary ${product.stockQuantity > 0 ? '' : 'disabled'}">
								Add to Cart </a> <a
								href="AddOrder.jsp?productId=${product.productId}&price=${product.price}&proName=${product.productName}"
								class="btn btn-primary ${product.stockQuantity > 0 ? '' : 'disabled'}">
								Buy Now </a>
						</div>
					</div>
				</div>
			</div>
		</div>

		<c:if test="${not empty userSessions}">
			<h1>Name: ${userSessions[0].userName}</h1>
			<h1>Id: ${userSessions[0].user_id}</h1>

			<form action="addReview" method="POST" class="container my-5">
				<h2 class="text-center">Add Your Review</h2>

				<input type="hidden" name="userId"
					value="${userSessions[0].user_id}"> <input type="hidden"
					name="proId" value="${product.productId}">

				<div class="form-group">
					<label for="rating">Rate (1 to 5):</label> <select name="rating"
						class="form-control" required>
						<option value="" disabled selected>Select a rating</option>
						<option value="1">1 - Very Poor</option>
						<option value="2">2 - Poor</option>
						<option value="3">3 - Average</option>
						<option value="4">4 - Good</option>
						<option value="5">5 - Excellent</option>
					</select>
				</div>

				<div class="form-group">
					<label for="review">Your Review:</label>
					<textarea name="review" rows="5" class="form-control"
						placeholder="Write your review here..." required></textarea>
				</div>

				<div class="text-center">
					<input type="submit" name="submit" value="Submit Review"
						class="btn btn-primary">
				</div>
			</form>
		</c:if>
	</c:forEach>



	<div class="container mt-2 my-5">
		<div class="row">
			<div class="col-md-12">
				<c:forEach var="reviews" items="${reviewData}">
					<div class="card mb-3">
						<div class="card-body">
							<h5 class="card-title">Rating: ${reviews.rating}/5</h5>
							<p class="card-text">${reviews.review_text}</p>
							<p class="card-text">
								<small class="text-muted">Reviewed on
									${reviews.review_date}</small>
							</p>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>



	<c:url value="updateproduct.jsp" var="updateproduct">
		<c:param name="pid" value="${pid}" />
		<c:param name="pname" value="${pname}" />
		<c:param name="pdescription" value="${pdescription}" />
		<c:param name="pprice" value="${pprice}" />
		<c:param name="pcategory" value="${pcategory}" />
		<c:param name="pquantity" value="${pquantity}" />
		<c:param name="pcolor" value="${pcolor}" />
		<c:param name="pwar" value="${pwar}" />
	</c:url>

	<c:url value="deleteproduct.jsp" var="deleteproduct">
		<c:param name="pid" value="${pid}" />
		<c:param name="pname" value="${pname}" />
		<c:param name="pdescription" value="${pdescription}" />
		<c:param name="pprice" value="${pprice}" />
		<c:param name="pcategory" value="${pcategory}" />
		<c:param name="pimg" value="${pimg}" />
		<c:param name="pcolor" value="${pcolor}" />
		<c:param name="pwar" value="${pwar}" />
	</c:url>

	<div class="container text-center my-4">
		<a href="${updateproduct}"><input type="button" name="update"
			value="Update" class="btn btn-primary mx-3"></a> <a
			href="${deleteproduct}"><input type="button" name="delete"
			value="Delete" class="btn btn-primary mx-3"></a>
	</div>

	<%@ include file="includes/footer.jsp"%>
</body>
</html>
