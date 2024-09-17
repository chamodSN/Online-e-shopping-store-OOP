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

<c:forEach var="user" items="${userDetails}">
   
   <c:set var="userId" value="${user.user_id}"/>
   <c:set var="userName" value="${user.userName}"/>
   <c:set var="password" value="${user.password}"/>
   <c:set var="email" value="${user.email}"/>
   <c:set var="role" value="${user.role}"/>
   
   ${user.user_id}
   ${user.userName}
   ${user.password}
   ${user.email}
   ${user.role}
</c:forEach>

<c:url value="updateProfile.jsp" var="updateProfile">
	<c:param name="userId" value="${userId}"/>
	<c:param name="userName" value="${userName}"/>
	<c:param name="password" value="${password}"/>
	<c:param name="email" value="${email}"/>
	<c:param name="role" value="${role}"/>
</c:url>

<a href="${updateProfile}">
	<input type="button" name="update" value="update">
</a>


</body>
</html>