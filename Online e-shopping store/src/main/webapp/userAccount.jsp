<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user account</title>
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
<c:choose>
	<c:when  test="${not empty userSessions }">
		<h1>Name:${userSessions[0].userName }</h1>
		<h1>Id:${userSessions[0].userId }</h1>

	<c:forEach var="user" items="${sessionScope.userSessions}">

		<c:set var="userId" value="${user.userId}" />
		<c:set var="userName" value="${user.userName}" />
		<c:set var="password" value="${user.password}" />
		<c:set var="email" value="${user.email}" />
		<c:set var="imageUrl" value="${user.profileImage}" />

		<div class="container mt-5 w-50">
			<h2 class="text-center mb-4">USER INFO</h2>

			<div class="text-center mb-4">
				<img src="profileImages/${user.profileImage}"
					alt="${user.userName}" class="rounded-circle mx-auto d-block"
					style="width: 200px; height: 200px; object-fit: cover;">
			</div>

			<table class="table">
				<tr class="table-primary text-center">
					<td>USER ID</td>
					<td>${user.userId}</td>
				</tr>

				<tr class="table-primary text-center">
					<td>USER NAME</td>
					<td>${user.userName}</td>
				</tr>

				<tr class="table-primary text-center">
					<td>PASSWORD</td>
					<td>${user.password}</td>
				</tr>
				<tr class="table-primary text-center">
					<td>E MAIL</td>
					<td>${user.email}</td>
				</tr>
			</table>

		</div>
	</c:forEach>

	<c:url value="updateProfile.jsp" var="updateProfile">
		<c:param name="userId" value="${userId}" />
		<c:param name="userName" value="${userName}" />
		<c:param name="password" value="${password}" />
		<c:param name="email" value="${email}" />
		<c:param name="image" value="${imageUrl}" />
	</c:url>

	<div class="text-center">
		<a href="${updateProfile}">

			<button type="submit" class="btn btn-primary text-cener mb-2 mt-3">UPDATE
				ACCOUNT</button> <br>
		</a>
	</div>

	<c:url value="deleteProfile.jsp" var="deleteProfile">
		<c:param name="userId" value="${userId}" />
		<c:param name="userName" value="${userName}" />
		<c:param name="password" value="${password}" />
		<c:param name="email" value="${email}" />
		<c:param name="image" value="${imageUrl}" />
	</c:url>

	<div class="text-center">
		<a href="${deleteProfile}">

			<button type="submit" class="btn btn-primary text-cener mb-2 mt-3">DELETE
				ACCOUNT</button>

		</a>
	</div>
	<div class="text-center">
		<form action="logout" method="post">
			<button type="submit" class="btn btn-primary text-center mb-2 mt-3">LOG
				OUT</button>
		</form>
	</div>
	
	</c:when >
	
	<c:otherwise>
            <div class="container text-center mt-5">
                <h2>Please log in to access your account</h2>
                <a href="login.jsp">
                    <button class="btn btn-primary">Log In</button>
                </a>
            </div>
        </c:otherwise>
</c:choose>
</body>
</html>