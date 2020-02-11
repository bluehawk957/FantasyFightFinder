<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"/>
<!DOCTYPE html>
<html>
<body class="subpage">
		<div id="page-wrapper">
				<section id="content">
					<div class="container">
						<div class="row">
							<div class="col-3 col-3-medium imp-medium">	
								<section>
									<p> ${loggedInUser.fName}</p>
									<p> ${loggedInUser.lName}</p>
									<p> ${loggedInUser.email}</p>
									<c:if test="${loggedInUser.dm == true}">  
										<p>You are a DM</p>
									</c:if>
									<c:if test="${loggedInUser.dm == false}">  
										<p>You are not a DM</p>
									</c:if>
								
								</section>
							</div>
						
							<div class="col-9 col-9-medium imp-medium">							
								<section>
									<h3>My Google Maps Demo</h3>
									    <!--The div element for the map -->
									    <div id="map"></div>
									    	<script>
											// Initialize and add the map
												function initMap() 
												{
													var options =
													{
															zoom:8,
															center:{lat: 38.63, lng: -90.20}
													}
												
													var map = new google.maps.Map(document.getElementById('map'), options);
 
												  // The marker, positioned at VARIABLE
												 /*  var marker = new google.maps.Marker({position:{lat: 38.63, lng: -90.20}, map: map, icon:
													  'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png'});
												  
												  var infoWindow = new google.maps.InfoWindow({
													  content:'<h1> test test</h1>'
												  });
												  
												  marker.addListener('click', function(){
													  infoWindow.open(map, marker);
												  });
												} */
												
												
												<c:forEach var="item" items="${users}" >
													addMarker({coords:{lat: ${item.lat}, lng:${item.lon}},
														content:'${item.fName} ${item.lName} ${item.checkDm()}'});
												
												</c:forEach>												
												
													function addMarker(props)
													{
														var marker = new google.maps.Marker({position:props.coords, map: map,
															icon:props.iconImage});	
														var infoWindow = new google.maps.InfoWindow({
															  content:props.content
														  });
														  
														  marker.addListener('click', function(){
															  infoWindow.open(map, marker);
														  });
														  
													}
																	
													map.addListener('rightclick', function(e) {
														userPlaceMarker(e.latLng, map);
														
														setTimeout(function(){
															location.reload(true);
														}, 250);	
														
														});
													
													function userPlaceMarker(latLng, map) 
														{
															var marker = new google.maps.Marker({
															position: latLng,
															map: map
															});
															
															$.get( "storeMark?coords="+latLng, function( data ) {
																  console.log(data);
																});
																									 
														}	  
															

												}
												//iconImage:'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png',
											</script>
											
										    <script async defer
										    src="https://maps.googleapis.com/maps/api/js?key=AIzaSyB1RDL4QuVoxsaYOkNX2Y5GbcC6gp9H99U&callback=initMap">
										 	</script>
									</section>
							</div>
							<div class="col-12 col-12-medium imp-medium">
								<section>
									<header>
										<h2>Favorite Feats:</h2>
									</header>
									<ul class="link-list">
										<c:forEach var="item" items="${favFeats}" >
											<li><a href="featSelector?feat=${item.trim()}">${item}</a></li>
										</c:forEach>
									</ul>
									
									<header>
										<h2>Favorite Races:</h2>
									</header>
									<ul class="link-list">
										<c:forEach var="item" items="${favRaces}" >
											<li><a href="subRaceSelector?subRace=${item.trim()}">${item}</a></li>
										</c:forEach>
									</ul>
									
									<header>
										<h2>Favorite Classes:</h2>
									</header>
									<ul class="link-list">
										<c:forEach var="item" items="${favClasses}" >
											<li><a href="subClassSelector?subClass=${item.trim()}">${item}</a></li>
										</c:forEach>
									</ul>
								</section>
							</div>
						</div>
					</div>
				</section>
			</div>	

</body>
</html>
<!-- <!DOCTYPE html>
<html>
  <head>
    <style>
       /* Set the size of the div element that contains the map */
      #map {
        height: 400px;  /* The height is 400 pixels */
        width: 100%;  /* The width is the width of the web page */
       }
    </style>
  </head>
  <body>
    <h3>My Google Maps Demo</h3>
    The div element for the map
    <div id="map"></div>
    <script>
// Initialize and add the map
function initMap() {
  // The location of Uluru
  var uluru = {lat: -25.344, lng: 131.036};
  // The map, centered at Uluru
  var map = new google.maps.Map(
      document.getElementById('map'), {zoom: 4, center: uluru});
  // The marker, positioned at Uluru
  var marker = new google.maps.Marker({position: uluru, map: map});
}
    </script>
    Load the API from the specified URL
    * The async attribute allows the browser to render the page while the API loads
    * The key parameter will contain your own API key (which is not needed for this tutorial)
    * The callback parameter executes the initMap() function
   
    <script async defer
    src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&callback=initMap">
    </script>
  </body>
</html> -->