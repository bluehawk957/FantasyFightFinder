<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.io.*,java.util.*" %>
<jsp:include page="header.jsp"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body class="subpage">

				<section id="content">
					<div class="container">
						<div class="row">
							<div class="col-12">
								<section>
								<header>
									<h2>Login</h2>
								</header>
								<form action="login" method="post">
									<input type="text" name="email" placeholder="Email"><br>
									<input type="password" name="password" placeholder="Password"><br>
									<button class="button-large" type="submit">Login</button>
								</form>
								</section>
							</div>
						</div>
					</div>
				</section>
				
				<section id="content">
					<div class="container">
						<div class="row">
							<div class="col-12">
								<!-- Main Content -->
									<section>
										<header>
											<h2>Register Here</h2>
										</header>
										<ul class="quote-list">
											<form:form action="${action}" modelAttribute="user" method="post">
												<li><form:input path="fName" placeholder="First Name"/><br></li>
												<li><form:input path="lName" placeholder="Last Name"/><br></li>
												<li><form:input path="email" placeholder="Email"/><br></li>
												<li><form:input path="password" type="password" placeholder="Password"/><br></li>
												<li><form:input path="repeatPass" type="password" placeholder="Repeat Password"/><br></li>
												<li><form:checkbox path="dm" id="dm" value="false" class="checkbox-input"/>Are you a DM?</li>
												<button class="button-large" type="submit">Register</button>
											</form:form>
										</ul>
									</section>
							</div>
						</div>
					</div>
				</section>



</body>

</html>