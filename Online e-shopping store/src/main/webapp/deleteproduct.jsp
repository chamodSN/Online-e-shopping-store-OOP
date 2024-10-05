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
		int productId = Integer.parseInt(request.getParameter("pid"));
		String productName = request.getParameter("pname");
		String description = request.getParameter("pdescription");
		double price = Double.parseDouble(request.getParameter("pprice"));
		String category = request.getParameter("pcategory");
		int stockQuantity = Integer.parseInt(request.getParameter("pquantity"));
	%>

 <form action="deleteProduct" method="POST">
		
		<input type="number" name="productId" value="<%=productId %>" readonly>
		<input type="text" name="productName" value="<%=productName %>" readonly>
	    <input type="text" name="description" value="<%=description %>" readonly>
	    <input type="text" name="price" value="<%=price %>" readonly>
		<input type="text" name="category" value="<%=category %>" readonly>
		<input type="number" name="stockQuantity" value="<%=stockQuantity %>" readonly>
	
		<input type="submit" name="delete" value="delete">
	</form>
</body>
</html>