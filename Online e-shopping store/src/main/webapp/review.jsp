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
	<c:forEach var="review" items="${revData}">
	
		<c:set var="revid" value="${review.review_id}"/>
		<c:set var="pid" value="${review.product_id}"/>
		<c:set var="uid" value="${review.user_id}"/>
		<c:set var="rating" value="${review.rating}"/>
		<c:set var="reviewtxt" value="${review.review_text}"/>
		<c:set var="date" value="${review.review_date}"/>
		
		
		${review.review_id}
		${review.product_id}
		${review.user_id}
		${review.rating}
		${review.review_text}
		${review.review_date}
		
		
	</c:forEach>
	
	<c:url value="updateReview.jsp" var="updateReview">
		<c:param name="revid" value="${revid}"/>
		<c:param name="pid" value="${pid}"/>
		<c:param name="uid" value="${uid}"/>
		<c:param name="rating" value="${rating}"/>
		<c:param name="reviewtxt" value="${reviewtxt}"/>
		<c:param name="date" value="${date}"/>
	</c:url>
	
	<a href="${updateReview}">
	<input type="button" name="update" value="update">
	</a>

</body>
</html>