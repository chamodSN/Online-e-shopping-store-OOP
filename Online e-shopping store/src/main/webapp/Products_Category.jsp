<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dao.DBConnect"%>
<%@ page import="com.model.utils.ProductDBUtil"%>
<%@ page import="com.model.entities.Product"%>
<%@ page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
ProductDBUtil pDBU = new ProductDBUtil();

List<Product> electronics = pDBU.getProductDetails("Electronics");

List<Product> homeAndKitchen = pDBU.getProductDetails("Home and Kitchen");

List<Product> fashion = pDBU.getProductDetails("Fashion");

List<Product> sports = pDBU.getProductDetails("Sports");

List<Product> toys = pDBU.getProductDetails("Toys");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<%@ include file="includes/navbar.jsp"%>
	<c:if test="${not empty userSessions }">
		<h1>Name:${userSessions[0].userName }</h1>
		<h1>Id:${userSessions[0].userId }</h1>
	</c:if>

	<div class="container">
		<div class="card-header my-3">ELECTRONIC PRODUCTS</div>
		<div class="row">
			<%
			if (electronics != null && !electronics.isEmpty()) {
				for (Product ep : electronics) {
			%>
			<div class="col-md-3 my-3">
				<div class="card w-100">
					<img class="card-img-top" src="images/<%=ep.getImage()%>"
						alt="Card image cap"
						style="width: 100%; height: 15rem; object-fit: cover;">
					<div class="card-body">
						<h5 class="card-title text-center"><%=ep.getProductName()%></h5>
						<h6 class="price">
							Price: $<%=ep.getPrice()%></h6>
						<h6 class="category">
							Category:
							<%=ep.getCategory()%></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a href="ViewProductServlet?productId=<%=ep.getProductId()%>"
								class="btn btn-primary">View Details</a> <a
								href="AddToCartServlet?productId=<%=ep.getProductId()%>"
								class="btn btn-primary">Add to Cart</a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			} else {
			%>
			<p>No Electronic Products available.</p>
			<%
			}
			%>
		</div>
	</div>

	<div class="container">
		<div class="card-header my-3">HOME AND KITCHEN PRODUCTS</div>
		<div class="row">
			<%
			if (homeAndKitchen != null && !homeAndKitchen.isEmpty()) {
				for (Product hp : homeAndKitchen) {
			%>
			<div class="col-md-3 my-3">
				<div class="card w-100">
					<img class="card-img-top" src="images/<%=hp.getImage()%>"
						alt="Card image cap"
						style="width: 100%; height: 15rem; object-fit: cover;">
					<div class="card-body">
						<h5 class="card-title text-center"><%=hp.getProductName()%></h5>
						<h6 class="price">
							Price: $<%=hp.getPrice()%></h6>
						<h6 class="category">
							Category:
							<%=hp.getCategory()%></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a href="ViewProductServlet?productId=<%=hp.getProductId()%>"
								class="btn btn-primary">View Details</a> <a
								href="AddToCartServlet?productId=<%=hp.getProductId()%>"
								class="btn btn-primary">Add to Cart</a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			} else {
			%>
			<p>No Home and Kitchen Products available.</p>
			<%
			}
			%>
		</div>
	</div>

	<div class="container">
		<div class="card-header my-3">FASHION PRODUCTS</div>
		<div class="row">
			<%
			if (fashion != null && !fashion.isEmpty()) {
				for (Product fp : fashion) {
			%>
			<div class="col-md-3 my-3">
				<div class="card w-100">
					<img class="card-img-top" src="images/<%=fp.getImage()%>"
						alt="Card image cap"
						style="width: 100%; height: 15rem; object-fit: cover;">
					<div class="card-body">
						<h5 class="card-title text-center"><%=fp.getProductName()%></h5>
						<h6 class="price">
							Price: $<%=fp.getPrice()%></h6>
						<h6 class="category">
							Category:
							<%=fp.getCategory()%></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a href="ViewProductServlet?productId=<%=fp.getProductId()%>"
								class="btn btn-primary">View Details</a> <a
								href="AddToCartServlet?productId=<%=fp.getProductId()%>"
								class="btn btn-primary">Add to Cart</a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			} else {
			%>
			<p>No Fashion Products available.</p>
			<%
			}
			%>
		</div>
	</div>

	<div class="container">
		<div class="card-header my-3">SPORTS PRODUCTS</div>
		<div class="row">
			<%
			if (sports != null && !sports.isEmpty()) {
				for (Product sp : sports) {
			%>
			<div class="col-md-3 my-3">
				<div class="card w-100">
					<img class="card-img-top" src="images/<%=sp.getImage()%>"
						alt="Card image cap"
						style="width: 100%; height: 15rem; object-fit: cover;">
					<div class="card-body">
						<h5 class="card-title text-center"><%=sp.getProductName()%></h5>
						<h6 class="price">
							Price: $<%=sp.getPrice()%></h6>
						<h6 class="category">
							Category:
							<%=sp.getCategory()%></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a href="ViewProductServlet?productId=<%=sp.getProductId()%>"
								class="btn btn-primary">View Details</a> <a
								href="AddToCartServlet?productId=<%=sp.getProductId()%>"
								class="btn btn-primary">Add to Cart</a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			} else {
			%>
			<p>No Sports Products available.</p>
			<%
			}
			%>
		</div>
	</div>

	<div class="container">
		<div class="card-header my-3">ELECTRONIC PRODUCTS</div>
		<div class="row">
			<%
			if (toys != null && !toys.isEmpty()) {
				for (Product tp : toys) {
			%>
			<div class="col-md-3 my-3">
				<div class="card w-100">
					<img class="card-img-top" src="images/<%=tp.getImage()%>"
						alt="Card image cap"
						style="width: 100%; height: 15rem; object-fit: cover;">
					<div class="card-body">
						<h5 class="card-title text-center"><%=tp.getProductName()%></h5>
						<h6 class="price">
							Price: $<%=tp.getPrice()%></h6>
						<h6 class="category">
							Category:
							<%=tp.getCategory()%></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a href="ViewProductServlet?productId=<%=tp.getProductId()%>"
								class="btn btn-primary">View Details</a> <a href="#"
								class="btn btn-primary">Add to Cart</a>
						</div>
					</div>
				</div>
			</div>
			<%
			}
			} else {
			%>
			<p>No Toys available.</p>
			<%
			}
			%>
		</div>
	</div>

	<%@ include file="includes/footer.jsp"%>

</body>
</html>