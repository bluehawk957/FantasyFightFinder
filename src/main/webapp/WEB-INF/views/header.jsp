<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.io.*,java.util.*" %>



<!DOCTYPE HTML>
<!--
	Halcyonic by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->


			<!-- Header -->
<head>
	<title>FightFinder</title>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
	<link rel="stylesheet" href="static/assets/css/main.css" />
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <style>
       /* Set the size of the div element that contains the map */
      #map {
        height: 460px;  /* The height is 400 pixels */
        width: 100%;  /* The width is the width of the web page */
       }
  </style>
  <style>
  .ui-autocomplete-loading {
    background: white url("images/ui-anim_basic_16x16.gif") right center no-repeat;
  }
  </style>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#race_name").autocomplete({
				source: "nameAutoCompleteR", 
				minLength: 2,
				})
			});
	</script>
	<script type="text/javascript">
		$(function() {
			$("#all_name").autocomplete({
				source: "nameAutoCompleteA", 
				minLength: 3,
				})
			});
	</script>
	<script type="text/javascript">
		$(function() {
			$("#feat_name").autocomplete({
				source: "nameAutoCompleteF", 
				minLength: 2,
				})
			});
	</script>
	
</head>
	
<div id="page-wrapper">
    		<section id="header">	
					<div class="container">
						<div class="row">
							<div class="col-12">

								<!-- Logo -->
									<a href="index" id="logo"><img src="static/images/logo.png" alt="logo" /></a>

								<!-- Nav -->
									<nav id="nav">
										<a href="index">Home</a>
										<a href="racePage">Races</a>
										<a href="classPage">Classes</a>
										<a href="featsPage">Feats</a>
										<a href="spells">Spells</a>	
										
										<c:if test="${empty loggedInUser}">
											<a href="login">Login/Register</a>	
										</c:if>
										<c:if test="${not empty loggedInUser}">
											<a href="map">Profile</a>
											<a href="logout">Logout</a>	
										</c:if>
										
									</nav>
							</div>	

						</div>	
					</div>
			</section>
		</div>