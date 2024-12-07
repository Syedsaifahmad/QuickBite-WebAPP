<%@ page language="java" contentType="text/html; charset-ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="com.foodapp.model.pojo.Restaurant"%>
<%@ page import="java.util.List"%>


<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
	integrity="sha384-k6RqeWeci5ZR/Lv4MR0sA0FfDOMyPZ+XzMfdw3iFF1s5mDPCsP5xyiufuhNEWHKZ"
	crossorigin="anonymous">


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<title>QuickBite - Food Delivery</title>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Protest+Revolution&display=swap')
	;

body {
	background-color: #C8ACD6;
	margin: 0;
	padding: 0;
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
	z-index: -1;
}

.navbar {
	position: sticky;
	top: 0;
	z-index: 1000; /* Ensures it stays on top of other content */
}

#logo {
	font-family: "Protest Revolution", sans-serif;
	font-weight: 400;
	font-style: normal;
}

ul li {
	font-size: 20px;
}

.hero-section {
	color: #ffffff;
	text-align: center;
	padding: 100px 20px;
	background-color: black;
}

.hero-section h2 {
	font-size: 50px;
	margin: 0;
}

.hero-section p {
	font-size: 18px;
	margin: 20px 0;
}

.nav-link {
	display: block;
	padding: var(--bs-nav-link-padding-y) var(--bs-nav-link-padding-x);
	font-size: var(--bs-nav-link-font-size);
	font-weight: var(--bs-nav-link-font-weight);
	color: #f8f9fa;
	font-weight: 400;
	text-decoration: none;
	background: 0 0;
	border: 0;
	transition: color .15s ease-in-out, background-color .15s ease-in-out,
		border-color .15s ease-in-out;
}

.custom-title {
	font-size: 40px;
	color: #c2133c;
	font-weight: bold;
	font-family: cursive;
	text-decoration: underline; /* Adds an underline */
}

.card-title {
	font-weight: bold;
	color: #484845;
	font-family: cursive;
}

.btn {
	font-family: cursive;
}

table {
	width: 100%;
	border-collapse: collapse;
	margin: 20px 0;
}

table, th, td {
	border: 1px solid #ddd;
}

th, td {
	padding: 8px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover:not(.active) {
	background-color: #111;
}

.active {
	background-color: #04AA6D;
}

.restaurant-card {
	width: 18rem;
	margin: 20px;
	/*background-image: url("https://images.pexels.com/photos/28957623/pexels-photo-28957623/free-photo-of-aerial-night-view-of-paris-featuring-les-invalides.jpeg"); /* Set your background image URL here */
	background-size: cover;
	background-color: black;
	background-position: center;
	color: #ffffff;
}

.card-title {
	font-size: 1.5rem; /* Larger font for restaurant name */
	font-weight: bold;
	color: #f1f1f1;
}

.card-text {
	font-size: 0.9rem;
	color: #f1f1f1;
}

.btn {
	font-family: cursive;
}

.carousel-item img {
	object-fit: cover;
	width: 100%;
	height: 350px; /* Set new height here */
}

.carousel-inner {
	height: 350px; /* Match the height here */
	overflow: hidden;
	background-color: #333;
}

.fixed-image {
	width: 100%; /* Makes the image fill the card's width */
	height: 200px; /* Set a fixed height for consistency */
	object-fit: cover;
	/* Ensures the image is cropped to fit within the set dimensions */
	border-top-left-radius: 0.25rem;
	border-top-right-radius: 0.25rem;
}

/* Apply color to active images */
.active-image {
	filter: none; /* No filter, keeping the image in color */
}

/* Apply black-and-white filter for inactive images */
.inactive-image {
	filter: grayscale(100%) contrast(100%) brightness(80%);
	/* Black and white with slight brightness */
}

.contact-info h5 {
	color: #f8c70e;
}

.contact-info a {
	text-decoration: none;
}

.contact-info a:hover {
	text-decoration: underline;
}

.btn-primary {
	background-color: #f8c70e;
	border: none;
}

.btn-primary:hover {
	background-color: #d4a90d;
}

.form-control:focus {
	border-color: #f8c70e;
	box-shadow: 0 0 5px rgba(248, 199, 14, 0.5);
}

.footer {
	background-color: #222;
	color: #fff;
	padding: 20px 0;
}

.footer h5 {
	color: #f8c70e;
	margin-bottom: 15px;
}

.footer p, .footer a {
	color: #ddd;
	font-size: 14px;
}

.footer a:hover {
	color: #f8c70e;
	text-decoration: none;
}

.footer-section {
	margin-bottom: 20px;
}

.footer-links {
	list-style: none;
	padding: 0;
}

.footer-links li {
	margin: 5px 0;
}

.footer-links a {
	color: #ddd;
	text-decoration: none;
}

.footer-links a:hover {
	text-decoration: underline;
}

.social-icons a {
	color: #ddd;
	margin-right: 10px;
	font-size: 18px;
}

.social-icons a:hover {
	color: #f8c70e;
}

.footer-bottom-text {
	font-size: 12px;
	margin-top: 10px;
	color: #aaa;
}

.mapContact {
	border-radius: 8px;
}
</style>
</head>
<body>


	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark"
		style="background-color: #000000;">
		<div class="container-fluid">
			<!-- Logo on the left -->
			<a class="navbar-brand" href="#">
				<h1 id="logo">QUICKBITE</h1>
			</a>

			<!-- Toggler for mobile view -->
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<!-- Centered navigation items -->
				<ul class="navbar-nav mx-auto mb-2 mb-lg-0">
					<li class="nav-item mx-3"><a class="nav-link active"
						aria-current="page" href="#">Home</a></li>
					<li class="nav-item mx-3"><a class="nav-link" href="#">About
							Us</a></li>
					<li class="nav-item mx-3"><a class="nav-link" href="#">Clients</a></li>
					<li class="nav-item mx-3"><a class="nav-link" href="#">Contact
							Us</a></li>
				</ul>

				<!-- Cart and Order History buttons on the right with icons -->
				<div class="d-flex">
					<!-- Order History Button with icon -->
					<a href="GetOrderHistory" class="btn btn-outline-success me-2">
						<i class="bi bi-clock-history"></i> <!-- Order History Icon -->
						Order History
					</a>

					<!-- Cart Button with icon -->
					<a href="cartItem.jsp" class="btn btn-outline-danger me-2"> <i
						class="bi bi-cart"></i> <!-- Cart Icon --> Cart
					</a>

					<!-- Profile Button -->
					<a href="profile.jsp" class="btn btn-outline-success me-2"> <i
						class="bi bi-person"></i> <!-- Profile Icon --> Profile
					</a>
				</div>
			</div>
		</div>
	</nav>

	<!-- Bootstrap Icons CDN -->
	<link
		href="https://cdn.jsdelivr.net/npm/bootstrap-icons/font/bootstrap-icons.css"
		rel="stylesheet">



	<!-- Hero Section -->
	<!-- -Slider- -->

	<div id="carouselExampleIndicators" class="carousel slide"
		data-bs-ride="carousel">
		<!-- Indicators -->
		<div class="carousel-indicators">
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="0" class="active" aria-current="true"
				aria-label="Slide 1"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="1" aria-label="Slide 2"></button>
			<button type="button" data-bs-target="#carouselExampleIndicators"
				data-bs-slide-to="2" aria-label="Slide 3"></button>
		</div>

		<!-- Carousel Items -->
		<div class="carousel-inner">
			<div class="carousel-item active">
				<img src="https://i.imgur.com/rtJHT2p.jpeg" class="d-block w-100"
					alt="Slide 1" style="height: 500px; object-fit: cover;">
			</div>
			<div class="carousel-item">
				<img src="https://i.imgur.com/PpLnJxD.jpeg" class="d-block w-100"
					alt="Slide 2" style="height: 500px; object-fit: cover;">
			</div>
			<div class="carousel-item">
				<img src="https://i.imgur.com/nfwlBhd.jpeg" class="d-block w-100"
					alt="Slide 3" style="height: 500px; object-fit: cover;">
			</div>
		</div>

		<!-- Navigation Controls -->
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>




	<!-- Restaurants -->

	<div class="container-fluid">
		<!--Tagline-->
		<div class="row">
			<div class="col-12">
				<h3 class="custom-title display-6 text-center mt-5 mb-4">Restaurants</h3>
			</div>
		</div>
	</div>


	<!-- Restaurant Details Table -->

	<div class="container mt-4">
		<div class="row">
			<%
        List<Restaurant> restaurantList = (List<Restaurant>) session.getAttribute("restaurant");
        if (restaurantList != null && !restaurantList.isEmpty()) {
            for (Restaurant restaurant : restaurantList) {
                String imageClass = restaurant.isActive() ? "active-image" : "inactive-image";
        %>
			<div class="col-md-4 mb-4">
				<div class="card restaurant-card">
					<!-- Restaurant Image with Conditional Class -->
					<img src="<%=restaurant.getImage()%>"
						class="card-img-top fixed-image <%= restaurant.isActive() ? "active-image" : "inactive-image" %>"
						alt="<%=restaurant.getRestaurantName()%>">

					<div class="card-body">
						<h5 class="card-title"><%=restaurant.getRestaurantName()%></h5>
						<p class="card-text">
							<strong>Cuisine Type:</strong>
							<%=restaurant.getCuisineType()%><br> <strong>Address:</strong>
							<%=restaurant.getAddress()%><br>

							<!-- Rating as Stars -->
							<strong>Rating:</strong>
							<%
                        int rating = restaurant.getRating();
                        for (int i = 0; i < 5; i++) {
                            if (i < rating) {
                        %>
							<span>&#9733;</span>
							<!-- Solid star -->
							<%
                            } else {
                        %>
							<span>&#9734;</span>
							<!-- Empty star -->
							<%
                            }
                        }
                        %>
							/ 5<br>

							<!-- Status: Active or Inactive -->
							<strong>Status:</strong>
							<%
                        if (restaurant.isActive()) {
                        %>
							<span style="color: green;">Active</span>
							<%
                        } else {
                        %>
							<span style="color: red;">Inactive</span>
							<%
                        }
                        %>
						</p>

						<!-- View Menu Button with Conditional Class and Disabled State -->
						<a href="ShowMenu?id=<%=restaurant.getRestaurantId()%>"
							class="btn <%= restaurant.isActive() ? "btn-danger" : "btn-secondary disabled" %>"
							<% if (!restaurant.isActive()) { %> onclick="return false;"
							<% } %> name="restId">View Menu</a>
					</div>
				</div>
			</div>

			<%
            }
        } else {
        %>
			<div class="col-12 text-center">
				<p>No restaurants found</p>
			</div>
			<%
        }
        %>
		</div>
	</div>


	<div class="container mt-5 mb-5">
		<div class="row align-items-center bg-light mapContact">
			<!-- Contact Form Section -->
			<div class="col-md-6">
				<h3>Contact Us</h3>
				<form action="ContactServlet" method="post">
					<div class="mb-3">
						<label for="name" class="form-label">Name</label> <input
							type="text" class="form-control" id="name" name="name"
							placeholder="Enter your name" required>
					</div>
					<div class="mb-3">
						<label for="email" class="form-label">Email</label> <input
							type="email" class="form-control" id="email" name="email"
							placeholder="Enter your email" required>
					</div>
					<div class="mb-3">
						<label for="message" class="form-label">Message</label>
						<textarea class="form-control" id="message" name="message"
							rows="4" placeholder="Enter your message" required></textarea>
					</div>
					<button type="submit" class="btn btn-primary">Send Message</button>
				</form>
			</div>

			<!-- Contact Information Section -->
			<!-- Map Section -->
			<div class="col-md-6">
				<div class="map-container">
					<h5>Find Us on the Map</h5>
					<iframe
						src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3888.8662858112966!2d77.60805687484037!3d12.916314487393954!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3bae3d6411bbb945%3A0x884e5e751a18bc1!2sTAP%20Academy%20BTM!5e0!3m2!1sen!2sin!4v1733059638692!5m2!1sen!2sin"
						width="600" height="450" style="border: 0;" allowfullscreen=""
						loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
				</div>
			</div>
		</div>
	</div>





	<!-- footer  -->
	<footer class="footer">
		<div class="container">
			<div class="row">
				<!-- About Section -->
				<div class="col-md-4 footer-section">
					<h5>About QuickBite</h5>
					<p>QuickBite is your trusted food delivery service, bringing
						delicious meals from your favorite restaurants straight to your
						doorstep.</p>
				</div>
				<!-- Quick Links Section -->
				<div class="col-md-4 footer-section">
					<h5>Quick Links</h5>
					<ul class="footer-links">
						<li><a href="#home">Home</a></li>
						<li><a href="#menu">Menu</a></li>
						<li><a href="#restaurants">Restaurants</a></li>
						<li><a href="#contact">Contact Us</a></li>
					</ul>
				</div>
				<!-- Contact Section -->
				<div class="col-md-4 footer-section">
					<h5>Contact Us</h5>
					<p>
						Email: <a href="mailto:support@quickbite.com">support@quickbite.com</a>
					</p>
					<p>Phone: +123 456 7890</p>
					<div class="social-icons">
						<a href="#"><i class="fab fa-facebook-f"></i></a> <a href="#"><i
							class="fab fa-twitter"></i></a> <a href="#"><i
							class="fab fa-instagram"></i></a> <a href="#"><i
							class="fab fa-linkedin"></i></a>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-12 text-center">
					<p class="footer-bottom-text">© 2024 QuickBite. All rights
						reserved.</p>
				</div>
			</div>
		</div>
	</footer>



	<!-- Bootstrap script -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>
