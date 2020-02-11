<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.io.*,java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<a href="index">Home</a>
<a href="about">About Us</a>
	<c:if test="${empty loggedInUser}">
		<a href="login">Login Page</a>
	</c:if>
	<c:if test="${not empty loggedInUser}">
		<a href="logout">Logout</a>
	</c:if>
</head>
<body>
	${first }
	
	
	
	
</body>
</html>