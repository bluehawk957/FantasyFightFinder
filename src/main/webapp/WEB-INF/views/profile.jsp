<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<jsp:include page="header.jsp"/>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>${msg}</h1>

	<p> ${loggedInUser.fName}</p>
	<p> ${loggedInUser.lName}</p>
	<p> ${loggedInUser.email}</p>
	<c:if test="${loggedInUser.dm == true}">  
		<p>You are a DM</p>
	</c:if>
	<c:if test="${loggedInUser.dm == false}">  
		<p>You are not a DM</p>
	</c:if>
	
</body>
</html>
<%--        <c:if test="${empty loggedInUser}">
				<a href="#mySignin" data-toggle="modal">Sign in</a>
				<a href="register"><i class="icon-user"></i> Sign up</a>
			</c:if>
			<c:if test="${not empty loggedInUser}">
				<a href="logout">Logout</a>
			</c:if> --%>