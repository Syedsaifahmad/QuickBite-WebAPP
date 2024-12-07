<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.foodapp.model.pojo.Menu"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu List</title>
<link rel="stylesheet" href="styles.css">
<!-- Link to your CSS file for styling -->
<link rel="stylesheet"
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css"
    integrity="sha384-k6RqeWeci5ZR/Lv4MR0sA0FfDOMyPZ+XzMfdw3iFF1s5mDPCsP5xyiufuhNEWHKZ"
    crossorigin="anonymous">

<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
    crossorigin="anonymous">
<style>
@import url('https://fonts.googleapis.com/css2?family=Protest+Revolution&display=swap');

body {
    background-color: #f7f7f7;
}

#logo {
    font-family: "Protest Revolution", sans-serif;
    font-weight: 400;
    font-style: normal;
}
.navbar {
	position: sticky;
	top: 0;
	z-index: 1000; /* Ensures it stays on top of other content */
}

.menu-row {
    display: flex;
    align-items: center;
    background-color: #fff;
    border: 1px solid #ddd;
    border-radius: 8px;
    padding: 15px;
    margin-bottom: 15px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    transition: transform 0.2s ease;
}

.menu-row:hover {
    transform: scale(1.02);
}

.menu-image {
    width: 150px;
    height: 150px;
    object-fit: cover;
    border-radius: 8px;
    margin-right: 20px;
}

.menu-details {
    flex: 1;
}

.menu-details h5 {
    margin: 0;
    font-size: 1.5em;
    color: #333;
}

.menu-details p {
    margin: 5px 0;
    color: #555;
    font-size: 1em;
}

.menu-details p.price {
    font-weight: bold;
    color: #ff6347;
    font-size: 1.2em;
}

.add-to-cart {
    text-align: right;
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
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
            data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        
            <div class="d-flex">
                <a href="cartItem.jsp" class="btn btn-outline-danger me-2">Cart</a>
                <a href="profile.jsp" class="btn btn-outline-success">Profile</a>
            </div>
    </div>
</nav>

<div class="container mt-4">
    <h2 class="mb-4 text-center">Menu List</h2>
    <%
        List<Menu> menuList = (List<Menu>) session.getAttribute("menuList");
        if (menuList != null && !menuList.isEmpty()) {
            for (Menu menu : menuList) {
    %>
    <div class="menu-row">
        <img src="<%= menu.getImage() %>" class="menu-image" alt="<%= menu.getName() %>">
        <div class="menu-details">
            <h5><%= menu.getName() %></h5>
            <p><strong>Description:</strong> <%= menu.getDescription() %></p>
            <p class="price">₹<%= menu.getPrice() %></p>
            <p><strong>Rating:</strong> <%= menu.getRating() %> / 5</p>
            <p><strong>Status:</strong> <%= menu.isAvailable() ? "Available" : "Not Available" %></p>
        </div>
        <div class="add-to-cart">
            <form action="AddToCartController" method="POST">
                <input type="hidden" name="menuId" value="<%= menu.getMenuId() %>">
                <input type="number" name="quantity" value="1" min="1" class="form-control mb-2">
                <button type="submit" class="btn btn-danger" <%= !menu.isAvailable() ? "disabled" : "" %>>Add to Cart</button>
            </form>
        </div>
    </div>
    <%
            }
        } else {
    %>
    <p class="text-center">No menu items available for this restaurant.</p>
    <%
        }
    %>
</div>

<script>
    const urlParams = new URLSearchParams(window.location.search);
    const error = urlParams.get('error');
    if (error === 'diffRestaurant') {
        alert("You can only add items from one restaurant at a time.");
        history.replaceState(null, "", location.pathname);
    }
</script>
</body>
</html>
