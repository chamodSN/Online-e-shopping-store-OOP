<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Info</title>
<link rel="stylesheet" href="css/bootstrap.min.css">

<style>
table {
	border-collapse: separate;
	border-spacing: 20px;
}
</style>
</head>
<body>
	<%@ include file="includes/navbar.jsp"%>
	<c:forEach var="order" items="${orderData}">

		<c:set var="oid" value="${order.orderId}" />
		<c:set var="qty" value="${order.quantity}" />
		<c:set var="country" value="${order.country}" />
		<c:set var="district" value="${order.district}" />
		<c:set var="shippingAdd" value="${order.shippingAddress}" />
		<c:set var="totalPrice" value="${order.totalPrice}" />
		<c:set var="cid" value="${order.customerId}" />
		<c:set var="cname" value="${order.customerName}" />
		<c:set var="contactNum" value="${order.contactNumber}" />
		<c:set var="pid" value="${order.productId}" />

		<div class="container mt-5 w-50">
			<h2 class="text-center mb-4">ORDER INFO</h2>

			<table class="table">
				<tr class="table-primary text-center">
					<td>Order ID</td>
					<td>${order.orderId}</td>
				</tr>

				<tr class="table-primary text-center">
					<td>Quantity</td>
					<td>${order.quantity}</td>
				</tr>

				<tr class="table-primary text-center">
					<td>Country</td>
					<td>${order.country}</td>
				</tr>
				<tr class="table-primary text-center">
					<td>District</td>
					<td>${order.district}</td>
				</tr>
				<tr class="table-primary text-center">
					<td>Shipping Address</td>
					<td>${order.shippingAddress}</td>
				</tr>
				<tr class="table-primary text-center">
					<td>Total Price</td>
					<td>${order.totalPrice}</td>
				</tr>
				<tr class="table-primary text-center">
					<td>Customer ID</td>
					<td>${order.customerId}</td>
				</tr>
				<tr class="table-primary text-center">
					<td>Customer Name</td>
					<td>${order.customerName}</td>
				</tr>
				<tr class="table-primary text-center">
					<td>Contact Number</td>
					<td>${order.contactNumber}</td>
				</tr>
				<tr class="table-primary text-center">
					<td>Product ID</td>
					<td>${order.productId}</td>
				</tr>
			</table>

		</div>
	</c:forEach>

	<c:url value="updateOrder.jsp" var="updateOrder">
		<c:param name="oid" value="${oid}" />
		<c:param name="qty" value="${qty}" />
		<c:param name="country" value="${country}" />
		<c:param name="district" value="${district}" />
		<c:param name="shippingAdd" value="${shippingAdd}" />
		<c:param name="totalPrice" value="${totalPrice}" />
		<c:param name="cid" value="${cid}" />
		<c:param name="cname" value="${cname}" />
		<c:param name="contactNum" value="${contactNum}" />
		<c:param name="pid" value="${pid}" />

	</c:url>

	<c:url value="deleteOrder.jsp" var="deleteOrder">
		<c:param name="oid" value="${oid}" />
		<c:param name="qty" value="${qty}" />
		<c:param name="country" value="${country}" />
		<c:param name="district" value="${district}" />
		<c:param name="shippingAdd" value="${shippingAdd}" />
		<c:param name="totalPrice" value="${totalPrice}" />
		<c:param name="cid" value="${cid}" />
		<c:param name="cname" value="${cname}" />
		<c:param name="contactNum" value="${contactNum}" />
		<c:param name="pid" value="${pid}" />

	</c:url>
	
	<div class="text-center">
		<a href="${updateOrder}">

			<button type="submit" class="btn btn-primary text-cener mb-2 mt-3">UPDATE
				ORDER</button> <br>
		</a>
	</div>

	<div class="text-center">
		<a href="${deleteOrder}">

			<button type="submit" class="btn btn-primary text-cener mb-2 mt-3">DELETE
				ORDER</button> <br>
		</a>
	</div>

</body>
</html>




