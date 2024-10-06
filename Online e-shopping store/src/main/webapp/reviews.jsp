<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.reviewDBUtil"%>
<%@ page import="dao.DBConnect"%>
<%@ page import="model.review"%>
<%@ page import="java.util.*"%>

<%
List<review> reviews = reviewDBUtil.getReviewDetails();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reviews</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>

	<%@ include file="includes/navbar.jsp"%>

	<c:if test="${not empty sessionScope.user_id}">
		<h1>Name: ${sessionScope.userName}</h1>
		<h1>Id: ${sessionScope.user_id}</h1>

		<div class="container mt-2 my-5">
			<div class="card-header my-3">ALL Reviews</div>
			<div class="row">
				<%
				if (reviews != null && !reviews.isEmpty()) {
					for (review r : reviews) {
						if (r.getUser_id() == (Integer) session.getAttribute("user_id")) {
				%>
				<div class="col-md-12 my-3">
					<div class="card w-100">
						<div class="card-body">
							<div class="d-flex justify-content-between align-items-center">
								<h5 class="card-title">
									Review ID:
									<%=r.getReview_id()%>
								</h5>
								<h5 class="card-title">
									Rating:
									<%=r.getRating()%>
								</h5>
								<h5 class="card-title">
									Date:
									<%=r.getReview_date()%>
								</h5><br>
								<a href="viewReviewServlet?reviewId=<%=r.getReview_id()%>"
									class="btn btn-primary">View Review</a>
							</div>
							<div class="mt-3 d-flex justify-content-between">
							<h6 class="card-title">
									Review:<%=r.getReview_text()%>
								</h6>
								
							</div>
						</div>
					</div>
				</div>

				<%
				}
				}
				} else {
				%>
				<p>No reviews available.</p>
				<%
				}
				%>
			</div>
		</div>

	</c:if>
	<c:if test="${empty userSessions}">
		<div class="container mt-5">
			<h3>
				Please <a href="login.jsp">log in</a> to view your reviews.
			</h3>
		</div>
	</c:if>
	<%@ include file="includes/footer.jsp"%>


</body>
</html>