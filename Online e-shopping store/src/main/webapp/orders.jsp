<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.productDBUtil"%>
<%@ page import="dao.DBConnect"%>
<%@ page import="model.orderDBUtil"%>
<%@ page import="model.order"%>
<%@ page import="java.util.*"%>

<%
List<order> orders = orderDBUtil.getOrderDetails();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
	<%@ include file="includes/navbar.jsp"%>

	<c:if test="${not empty sessionScope.user_id}">
		<h1>Name: ${sessionScope.userName}</h1>
		<h1>Id: ${sessionScope.user_id}</h1>

		<div class="container mt-2 my-5">
			<div class="card-header my-3">ALL ORDERS</div>
			<div class="row">
				<%
				if (orders != null && !orders.isEmpty()) {
					for (order o : orders) {
						if (o.getCustomerId() == (Integer) session.getAttribute("user_id")) {
				%>
				<div class="col-md-12 my-3">
					<div class="card w-100">
						<div class="card-body">
							<div class="d-flex justify-content-between align-items-center">
								<h5 class="card-title">
									Product ID:
									<%=o.getProductId()%>
								</h5>
								<h5 class="card-title">
									Product Name:
									<%=o.getProductName()%>
								</h5>
								<h6 class="price">
									Price: $<%=o.getTotalPrice()%>
								</h6>
								<h6 class="quantity">
									Quantity:
									<%=o.getQuantity()%>
								</h6>
							</div>
							<div class="mt-3 d-flex justify-content-between">
								<a href="viewOrderServlet?orderId=<%=o.getOrderId()%>"
									class="btn btn-primary">View Order</a> <a href="order.jsp"
									class="btn btn-primary">Add to Cart</a>
							</div>
						</div>
					</div>
				</div>

				<%
				}
				}
				} else {
				%>
				<p>No orders available.</p>
				<%
				}
				%>
			</div>
		</div>

	</c:if>
	<c:if test="${empty userSessions}">
		<div class="container mt-5">
			<h3>
				Please <a href="login.jsp">log in</a> to view your orders.
			</h3>
		</div>
	</c:if>
	<%@ include file="includes/footer.jsp"%>

</body>
</html>