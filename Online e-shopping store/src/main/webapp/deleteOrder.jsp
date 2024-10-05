<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	    String orderId = request.getParameter("oid");
		int quantity = Integer.parseInt(request.getParameter("qty"));
	    String country = request.getParameter("country");
		String district = request.getParameter("district");
		String shippingAddress = request.getParameter("shippingAdd");
		double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
		int customerId = Integer.parseInt(request.getParameter("cid"));
		String customerName = request.getParameter("cname");
		String contactNumber = request.getParameter("contactNum");
		int productId = Integer.parseInt(request.getParameter("pid"));
		
	%>
	<form action="deleteOrder" method="POST">
	
		<input type="text" name="orderId" value="<%=orderId %>" readonly>
		<input type="text" name="quantity" value="<%=quantity %>"readonly>
		<input type="text" name="country" value="<%=country %>"readonly>
		<input type="text" name="district" value="<%=district %>"readonly>
		<input type="text" name="shippingAdd" value="<%=shippingAddress %>" readonly>
	    <input type="text" name="totalPrice" value="<%=totalPrice %>" readonly>
		<input type="text" name="customerId" value="<%=customerId %>" readonly>
		<input type="text" name="cname" value="<%=customerName %>" readonly>
		<input type="text" name="contactNum" value="<%=contactNumber %>" readonly>
		<input type="text" name="productId" value="<%=productId %>" readonly>
		
		<input type="submit" name="submit" value="delete">
	</form>
	
	
</body>
</html>