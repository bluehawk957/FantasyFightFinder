<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"/>
<!DOCTYPE HTML>
<!--
	Halcyonic by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
	<body class="subpage">
		<div id="page-wrapper">
			<!-- Content -->
				<section id="content">
					<div class="container">
						<div class="row">
							<div class="col-3 col-12-medium">

								<!-- Left Sidebar -->
									<section>
										<header>
											<h2>List of Classes</h2>
										</header>
										<ul class="link-list">
											<c:forEach var="item" items="${charClass}" >
												<li><a href="charClassSelector?charClass=${item.name}">${item.name}</a></li>
											</c:forEach>
										</ul>
									</section>

							</div>
							<div class="col-6 col-12-medium imp-medium">

								<!-- Main Content -->
									<section>
										<header>
											<h2>${currentClass.name}</h2>
										</header>
										<p>
											<h3>Your hit die is:</h3>${currentClass.hitDie}
										</p>
										<p>
											<h3>Your weapon proficiencies are:</h3>${currentClass.weaponProf}
										</p>
										<p>
											<h3>Your armor proficiencies are:</h3>${currentClass.armorProf}
										</p>
										<p>
											<h3>You are proficient in the following saving throws:</h3>${currentClass.saves}
										</p>
										<p>
											<h3>Your starting equipment is as follows:</h3>${currentClass.equipment}
										</p>
										<br><h2>Class Features</h2>
										<p>									
											<c:forEach var="item" items="${currentTraits}" >	
												
													<p>${item.name}<br>
													<c:forEach var="parsedItem" items="${currentClass.parseByPercent(item.details)}" >
														<li>${parsedItem}</li>
													</c:forEach>
													</p>
											</c:forEach>
										</p> 
									</section>
									<section>
										<header>
											<h2>${currentSubClass.name}</h2>
										</header>						
										<p>									
											
												<c:forEach var="item" items="${currentSubTraits}" >	
													<p>${item.name}<br>
													<c:forEach var="parsedItem" items="${currentClass.parseByPercent(item.details)}" >
														<li>${parsedItem}</li>
													</c:forEach>
													</p>
											</c:forEach>
											
										</p>
										<p>
											<h3>Reference Book:</h3>${currentSubClass.refBook}
										</p>
										<c:if test="${not empty loggedInUser}">
											<a href="addFavClass?item=${currentSubClass.name}" class="bordered-feature-image"><img src="static/images/star.PNG" alt="Image" style="height:80px;width:80px;"/></a>
										</c:if>		
									</section>
							</div>
							<div class="col-3 col-12-medium">

								<!-- Right Sidebar -->
									<section>
										<header>
											<h2>Sub Classes</h2>
										</header>
										<ul class="link-list">
											<c:forEach var="item" items="${currentSubClasses}" >
												<li><a href="subClassSelector?subClass=${item.trim()}">${item}</a></li>
											</c:forEach>
										</ul>										
									</section>

							</div>
						</div>
					</div>
				</section>

			<!-- Footer -->
				<section id="footer">
					<div class="container">
						<div class="row">
							<div class="col-8 col-12-medium">

								<!-- Links -->
									<section>
										
									</section>

							</div>
							<div class="col-4 col-12-medium imp-medium">

								<!-- Blurb -->
									<section>
										<h2>An Informative Text Blurb</h2>
										<p>
											We appreciate your time and patronage with us. We are a non profit web-page and have no intent to go commercial with
											this product. This product was built purley for educational purposes.
										</p>
									</section>

							</div>
						</div>
					</div>
				</section>

			<!-- Copyright -->
				<div id="copyright">
					&copy; Untitled. All rights reserved. | Design: <a href="http://html5up.net">HTML5 UP</a>
				</div>

		</div>

		<!-- Scripts -->
			<script src="assets/js/jquery.min.js"></script>
			<script src="assets/js/browser.min.js"></script>
			<script src="assets/js/breakpoints.min.js"></script>
			<script src="assets/js/util.js"></script>
			<script src="assets/js/main.js"></script>

	</body>
</html>