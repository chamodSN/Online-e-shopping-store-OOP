<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="order" items="${orderData}">
	
	<c:set var ="oid" value="${order.orderId}"/>
	<c:set var ="qty" value="${order.quantity}"/>
	<c:set var ="country" value="${order.country}"/>
	<c:set var ="district" value="${order.district}"/>
	<c:set var ="shippingAdd" value="${order.shippingAddress}"/>
	<c:set var ="totalPrice" value="${order.totalPrice}"/>
	<c:set var ="cid" value="${order.customerId}"/>
	<c:set var ="cname" value="${order.customerName}"/>
	<c:set var ="contactNum" value="${order.contactNumber}"/>
	<c:set var ="pid" value="${order.productId}"/>
	
	${order.orderId}
	${order.quantity}
	${order.country}
	${order.district}
	${order.shippingAddress}
	${order.totalPrice}
	${order.customerId}
	${order.customerName}
	${order.contactNumber}
	${order.productId}
	
	</c:forEach>
	
	<c:url value="updateOrder.jsp" var="updateOrder">
		<c:param name="oid" value="${oid}"/>
		<c:param name="qty" value="${qty}"/>
		<c:param name="country" value="${country}"/>
		<c:param name="district" value="${district}"/>
		<c:param name="shippingAdd" value="${shippingAdd}"/>
		<c:param name="totalPrice" value="${totalPrice}"/>
		<c:param name="cid" value="${cid}"/>
		<c:param name="cname" value="${cname}"/>
		<c:param name="contactNum" value="${contactNum}"/>
		<c:param name="pid" value="${pid}"/>
		
	</c:url>
	
	<c:url value="deleteOrder.jsp" var="deleteOrder">
		<c:param name="oid" value="${oid}"/>
		<c:param name="qty" value="${qty}"/>
		<c:param name="country" value="${country}"/>
		<c:param name="district" value="${district}"/>
		<c:param name="shippingAdd" value="${shippingAdd}"/>
		<c:param name="totalPrice" value="${totalPrice}"/>
		<c:param name="cid" value="${cid}"/>
		<c:param name="cname" value="${cname}"/>
		<c:param name="contactNum" value="${contactNum}"/>
		<c:param name="pid" value="${pid}"/>
		
	</c:url>
	
	<a href="${updateOrder}">
	<input type="button" name="update" value="update">
	</a>
	
	<br><br>
	<a href="${deleteOrder}">
	<input type="button" name="delete" value="delete">
	</a>
	
</body>
</html>




