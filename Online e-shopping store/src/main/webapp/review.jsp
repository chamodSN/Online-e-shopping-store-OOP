<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Review</title>
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
    <c:forEach var="review" items="${revData}">

        <c:set var="revid" value="${review.review_id}" />
        <c:set var="pid" value="${review.product_id}" />
        <c:set var="uid" value="${review.user_id}" />
        <c:set var="rating" value="${review.rating}" />
        <c:set var="reviewtxt" value="${review.review_text}" />
        <c:set var="date" value="${review.review_date}" />

        <div class="container mt-5 w-50">
            <h2 class="text-center mb-4">REVIEW INFO</h2>

            <table class="table">
                <tr class="table-primary text-center">
                    <td>Review ID</td>
                    <td>${review.review_id}</td>
                </tr>

                <tr class="table-primary text-center">
                    <td>Product ID</td>
                    <td>${review.product_id}</td>
                </tr>

                <tr class="table-primary text-center">
                    <td>User ID</td>
                    <td>${review.user_id}</td>
                </tr>
                <tr class="table-primary text-center">
                    <td>Date</td>
                    <td>${review.review_date}</td>
                </tr>
                <tr class="table-primary text-center">
                    <td>Rating</td>
                    <td>${review.rating}</td>
                </tr>
                <tr class="table-primary text-center">
                    <td>Review</td>
                    <td>${review.review_text}</td>
                </tr>
            </table>

            <c:url value="updateReview.jsp" var="updateReview">
                <c:param name="revid" value="${revid}" />
                <c:param name="pid" value="${pid}" />
                <c:param name="uid" value="${uid}" />
                <c:param name="rating" value="${rating}" />
                <c:param name="reviewtxt" value="${reviewtxt}" />
                <c:param name="date" value="${date}" />
            </c:url>

            <c:url value="deleteReview.jsp" var="deleteReview">
                <c:param name="revid" value="${revid}" />
                <c:param name="pid" value="${pid}" />
                <c:param name="uid" value="${uid}" />
                <c:param name="rating" value="${rating}" />
                <c:param name="reviewtxt" value="${reviewtxt}" />
                <c:param name="date" value="${date}" />
            </c:url>

            <div class="text-center mt-4">
                <a href="${updateReview}"><input type="button" name="update" value="Update" class="btn btn-primary"></a>
                <a href="${deleteReview}"><input type="button" name="delete" value="Delete" class="btn btn-primary"></a>
            </div>
        </div>

    </c:forEach>
    <%@ include file="includes/footer.jsp"%>
</body>
</html>
