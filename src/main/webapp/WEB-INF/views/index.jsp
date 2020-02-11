<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"/>
<!DOCTYPE HTML>
<html>
	<body class="subpage2">
		<div id="page-wrapper">
    		<section id="header">			
				<div id="banner">
					<div class="container">
						<div class="row">
							<div class="col-6 col-12-medium">

								<!-- Banner Copy -->
									<p>Welcome to the best DnD resource site on the interwebs</p>
									<section>
										<form action="allSearch" method="GET">
											<input id="all_name" list="auto" type="text" name="input" placeholder="Type Anything"/>
											<datalist id="auto">
											
											</datalist>
											<button class="button-large" type ="submit" id="enter">Search</button>
										</form>	
									</section>

							</div>
							<div class="col-6 col-12-medium imp-medium">

								<!-- Banner Image -->
									<a href="#" class="bordered-feature-image"><img src="static/images/main.jpg" alt="" /></a>

							</div>
						</div>
					</div>
				</div>
			</section>

			<!-- Features -->
				<section id="features">
					<div class="container">
						<div class="row">
							<div class="col-3 col-6-medium col-12-small">

								<!-- Feature #1 -->
									<section>
										<a href="racePage" class="bordered-feature-image"><img src="static/images/red dragon born.jpg" alt="" /></a>
										<h2>Races</h2>
										<p>
											These are the <a href="racePage">Races</a>. Choose your birthright
											and start slaying!
										</p>
									</section>

							</div>
							<div class="col-3 col-6-medium col-12-small">

								<!-- Feature #2 -->
									<section>
										<a href="#" class="bordered-feature-image"><img src="static/images/bladesong.png" alt="" /></a>
										<h2>Classes</h2>
										<p>
											These are the <a href="http://html5up.net">Classes</a> to choose from,
											learn your skills and train to fight. Begin your adventure!
										</p>
									</section>

							</div>
							<div class="col-3 col-6-medium col-12-small">

								<!-- Feature #3 -->
									<section>
										<a href="featsPage" class="bordered-feature-image"><img src="static/images/feat.jpg" alt="" /></a>
										<h2>Feats</h2>
										<p>
											Here are the <a href="featsPage">Feats</a>, as you grow in knowledge
											and talent your powers grow too!
										</p>
									</section>

							</div>
							<div class="col-3 col-6-medium col-12-small">

								<!-- Feature #4 -->
									<section>
										<a href="spells" class="bordered-feature-image"><img src="static/images/fireball.jpg" alt="" /></a>
										<h2>Spells</h2>
										<p>
											Here are the <a href="spells">Spells</a>. Be it you're own wit,
											or the divine power of a god, let the power flow forth from you and decimate your
											enemies.
										</p>
									</section>

							</div>
						</div>
					</div>
				</section>

			<!-- Content -->
				<!-- <section id="content">
					<div class="container">
						<div class="row aln-center">
							<div class="col-4 col-12-medium">

								Box #1
									<section>
										<header>
											<h2>Builds to play with</h2>
											<h3>A forum to discuss new build ideas</h3>
										</header>
										<a href="#" class="feature-image"><img src="static/images/pic05.jpg" alt="" /></a>
										<p>
											THIS IS WHERE I WOULD LIKE TO BE ABLE TO PULL SPECIFIC INFORMATION
											FROM A FORUM. I SHOULD PROBABLY LOOK UP CODE FOR HOW FORUMS PAGES
											WORK.
										</p>
									</section>

							</div>
							<div class="col-4 col-6-medium col-12-small">

								Box #2
									<section>
										<header>
											<h2>Rules Discussions</h2>
											<h3>A subheading about what we do</h3>
										</header>
										<ul class="check-list">
											<li>Sed mattis quis rutrum accum</li>
											<li>Eu varius nibh suspendisse lorem</li>
											<li>Magna eget odio amet mollis justo</li>
											<li>Facilisis quis sagittis mauris</li>
											<li>Amet tellus gravida lorem ipsum</li>
										</ul>
									</section>

							</div>
							<div class="col-4 col-6-medium col-12-small">

								Box #3
									<section>
										<header>
											<h2>Unearthed Arcana!</h2>
											<h3>And a final subheading about our clients</h3>
										</header>
										<ul class="quote-list">
											<li>
												<img src="static/images/pic06.jpg" alt="" />
												<p>"Neque nisidapibus mattis"</p>
												<span>Jane Doe, CEO of UntitledCorp</span>
											</li>
											<li>
												<img src="static/images/pic07.jpg" alt="" />
												<p>"Lorem ipsum consequat!"</p>
												<span>John Doe, President of FakeBiz</span>
											</li>
											<li>
												<img src="static/images/pic08.jpg" alt="" />
												<p>"Magna veroeros amet tempus"</p>
												<span>Mary Smith, CFO of UntitledBiz</span>
											</li>
										</ul>
									</section>

							</div>
						</div>
					</div>
				</section> -->

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
														<li><a href="#">About</a></li>

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
			<script src="static/assets/js/jquery.min.js"></script>
			<script src="static/assets/js/browser.min.js"></script>
			<script src="static/assets/js/breakpoints.min.js"></script>
			<script src="static/assets/js/util.js"></script>
			<script src="static/assets/js/main.js"></script>

	</body>
</html>