<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="dao.DBConnect"%>
<%@ page import="model.productDBUtil"%>
<%@ page import="model.product"%>
<%@ page import="java.util.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
List<product> products = productDBUtil.getProductDetails();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<%@ include file="includes/navbar.jsp"%>
	<img class="card-img-top mt-3" src="images/homeImg.png"
						alt="Home Image"
						style="width: 100%; height: 15rem; object-fit: cover;">
						
	<c:if test="${not empty userSessions }">
		<h1>Name:${userSessions[0].userName }</h1>
		<h1>Id:${userSessions[0].user_id }</h1>
	</c:if>

	<div class="container">
		<div class="card-header my-3">ALL PRODUCTS</div>
		<div class="row">
			<%
			if (products != null && !products.isEmpty()) {
				for (product p : products) {
			%>
			<div class="col-md-3 my-3">
				<div class="card w-100">
					<img class="card-img-top" src="images/<%=p.getImage()%>"
						alt="Card image cap"
						style="width: 100%; height: 15rem; object-fit: cover;">
					<div class="card-body">
						<h5 class="card-title text-center"><%=p.getProductName()%></h5>
						<h6 class="price">
							Price: $<%=p.getPrice()%></h6>
						<h6 class="category">
							Category:
							<%=p.getCategory()%></h6>
						<div class="mt-3 d-flex justify-content-between">
							<a href="viewProductServlet?productId=<%=p.getProductId()%>"
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
			<p>No products available.</p>
			<%
			}
			%>
		</div>
	</div>

	<%@ include file="includes/footer.jsp"%>
</body>
</html>