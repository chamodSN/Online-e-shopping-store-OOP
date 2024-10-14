<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.model.entities.Product"%>
<%@page import="com.model.entities.Cart"%>
<%@ page import="com.model.utils.ProductDBUtil"%>
<%@page import="java.util.*"%>

<%

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
List<Cart> cartProduct = null;
if (cart_list != null) {
	
	ProductDBUtil pDBU = new ProductDBUtil();
	
	cartProduct = pDBU.getCartProducts(cart_list);
	request.setAttribute("cart_list", cart_list);
}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<%@ include file="includes/navbar.jsp"%>

	<c:if test="${not empty userSessions }">
		<h1>Name:${userSessions[0].userName }</h1>
		<h1>Id:${userSessions[0].userId }</h1>
	</c:if>
	<%
			if (cart_list != null) {
				for (Cart c : cartProduct) {
			%>

	<div class="col-md-12 my-3">
		<div class="card w-100">
			<div class="card-body">
				<div class="d-flex justify-content-between align-items-center">
					<h5 class="card-title">
						Product ID:
						<%=c.getProductId()%>
					</h5>
					<h5 class="card-title">
						Product Name:
						<%=c.getProductName()%>
					</h5>
					<h5 class="card-title">
						Product Category:
						<%=c.getCategory()%>
					</h5>
					<h6 class="price">
						Price: $<%=c.getPrice()%>
					</h6>
				</div>
				<div class="mt-3 d-flex justify-content-between">
					<a href="ViewProductServlet?productId=<%=c.getProductId()%>"
						class="btn btn-primary">View Product</a> <a
						href="RemoveFromCartServlet?productId=<%=c.getProductId()%>"
						class="btn btn-primary">Remove</a>
				</div>
			</div>
		</div>
	</div>
	
	<%
				}
				}
				else {
				%>
				<p>No products available.</p>
				<%
				}
				%>

	<%@ include file="includes/footer.jsp"%>
</body>
</html>

