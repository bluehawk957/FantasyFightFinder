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
										<form action="raceSearch" method="GET">
											<input id="race_name" list="auto" type="text" name="input" placeholder="Search"/>
											<datalist id="auto">
											
											</datalist>
											<button class="submit" id="enter">Search</button>
										</form>	
									</section>
									<section>
										<header>
											<h2>List of Races</h2>
										</header>
										<ul class="link-list">
											<c:forEach var="item" items="${race}" >
												<li><a href="raceSelector?race=${item.name}">${item.name}</a></li>
											</c:forEach>
										</ul>
									</section>

							</div>
							<div class="col-6 col-12-medium imp-medium">

								<!-- Main Content -->
									<section>
										<header>
											<h2>${currentRace.name}</h2>
										</header>
										<p>
											<h3>Your ability score increases are:</h3>${currentRace.asi}
										</p>
										<p>
											<h3>Your size and speed are:</h3>${currentRace.size}, ${currentRace.speed}
										</p>
										<p>
											<h3>Your languages known are:</h3>${currentRace.languages}
										</p>
										<br><h2>Race Features</h2>
										<p>									
											<c:forEach var="item" items="${currentRace.raceParse(currentRace.traits)}" >
												<li>${item}</li>
											</c:forEach>
										</p>
										<p>
											<h4>Reference Book:</h4>${currentRace.refBook}
										</p>
									</section>
									<section>
										<header>
											<h2>${currentSubRace.name}</h2>
										</header>
										<p>
											<h3>Your ability score increases are:</h3>${currentSubRace.asi}
										</p>
										<p>
											<h3>Your languages known are:</h3>${currentSubRace.languages}
										</p>
										<p>									
											<c:forEach var="item" items="${currentSubRace.subRaceParse(currentSubRace.traits)}" >
												<li>${item}</li>
											</c:forEach>
										</p>
										<p>
											<h4>Reference Book:</h4>${currentSubRace.refBook}
										</p>
										<c:if test="${not empty loggedInUser}">
											<a href="addFavRace?item=${currentSubRace.name}" class="bordered-feature-image"><img src="static/images/star.PNG" alt="Image" style="height:80px;width:80px;"/></a>
										</c:if>									
									</section>
							</div>
							<div class="col-3 col-12-medium">

								<!-- Right Sidebar -->									
									<section>
										<header>
											<h2>Sub Races</h2>
										</header>
										<ul class="link-list">
											<c:forEach var="item" items="${currentSubraces}" >
												<li><a href="subRaceSelector?subRace=${item.name}">${item.name}</a></li>
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
											Duis neque nisi, dapibus sed mattis quis, rutrum accumsan sed. Suspendisse eu
											varius nibh. Suspendisse vitae magna eget odio amet mollis. Duis neque nisi,
											dapibus sed mattis quis, sed rutrum accumsan sed. Suspendisse eu varius nibh
											lorem ipsum amet dolor sit amet lorem ipsum consequat gravida justo mollis.
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