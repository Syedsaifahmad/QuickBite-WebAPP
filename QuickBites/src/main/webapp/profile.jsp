<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.foodapp.model.pojo.Users"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.rtl.min.css"
	integrity="sha384-dpuaG1suU0eT09tx5plTaGMLBsfDLzUCCUXOY2j/LSvXYuG6Bqs43ALlhIqAJVRb"
	crossorigin="anonymous">

<!--Bootstrap Icone-->

<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<link rel="stylesheet" href="style1.css">


<title>Profile</title>

<style>
@import
	url('https://fonts.googleapis.com/css2?family=Protest+Revolution&display=swap')
	;

#logo {
	font-family: "Protest Revolution", sans-serif;
	font-weight: 400;
	font-style: normal;
}

body {
	background-color: #f9f9f9;
	/* Very light white shade for the background */
}

.navbar {
	position: sticky;
	top: 0;
	z-index: 1000; /* Ensures it stays on top of other content */
}

.user-form {
	background-color: #ffffff;
	/* Slightly darker white shade for the card */
	border: 2px solid #007bff;
	box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
	/* Adds a subtle shadow for more distinction */
}
</style>
</head>
<body>
	<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="home.jsp">
				<h1 id="logo">QUICKBITE</h1>
			</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="d-flex">
				<a href="cartItem.jsp" class="btn btn-outline-danger me-2">Cart</a>
				<a href="profile.jsp" class="btn btn-outline-success active me-2">Profile</a>
			</div>
		</div>
	</nav>

	<!-- Profile details card -->
	<%Users user =(Users) session.getAttribute("LoggedInUser"); %>
	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="user-form text-center border rounded p-4">
					<i class="bi bi-person" style="font-size: 60px;"></i>
					<h2>User Details</h2>
					<div class="form-group mb-3">
						<label>Name:</label> <span><%= user.getName() %></span>
					</div>
					<div class="form-group mb-3">
						<label>Email:</label> <span><%= user.getEmail() %></span>
					</div>
					<div class="form-group mb-3">
						<label>Phone:</label> <span><%= user.getMobile() %></span>
					</div>
					<a href="Logout"><button type="button" class="btn btn-success">Logout</button></a>
				</div>
			</div>
		</div>
	</div>






	<!-- Option 1: Bootstrap Bundle with Popper -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>

</body>
</html>