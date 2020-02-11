<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"/>
<html>
	<body class="subpage">
		<div id="page-wrapper">

			<!-- Content -->
				<section id="content">
					<div class="container">
						<div class="row">
							<div class="col-3 col-12-medium">

								<!-- Sidebar -->
									<section>
										<form action="featSearch" method="GET">
											<input id="feat_name" list="auto" type="text" name="input" placeholder="Search"/>
											<datalist id="auto">
											
											</datalist>
											<button class="submit" id="enter">Search</button>
										</form>	
									</section>
									<section>
										<header>
											<h2>List of Feats</h2>
										</header>
										<ul class="link-list">
											<c:forEach var="item" items="${feats}" >
												<li><a href="featSelector?feat=${item.name}">${item.name}</a></li>
											</c:forEach>
										</ul>
									</section>
							</div>
							<div class="col-9 col-12-medium imp-medium">

								<!-- Main Content -->
								<section>
										<header>
											<h2>${currentObject.name} </h2>
										</header>
										<p>
											<h3>The prerequisets for this feat are:</h3>${currentObject.preReqs}
										</p>
										<p>
											<h3>Your ability score increases are:</h3>${currentObject.asi}
										</p>
										<br><h2>Feat Features</h2>
										<p>										
											<c:forEach var="item" items="${currentObject.featParse(currentObject.traits)}" >
												<li>${item}</li>
											</c:forEach>
										</p>
										<c:if test="${not empty loggedInUser}">
											<a href="addFavFeat?item=${currentObject.name}" class="bordered-feature-image"><img src="static/images/star.PNG" alt="Image" style="height:80px;width:80px;"/></a>
										</c:if>
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
										<h2>Links to Important Stuff</h2>
										<div>
											<div class="row">
												<div class="col-3 col-12-small">
													<ul class="link-list last-child">
														<li><a href="#">Neque amet dapibus</a></li>
														<li><a href="#">Sed mattis quis rutrum</a></li>
														<li><a href="#">Accumsan suspendisse</a></li>
														<li><a href="#">Eu varius vitae magna</a></li>
													</ul>
												</div>
											</div>
										</div>
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