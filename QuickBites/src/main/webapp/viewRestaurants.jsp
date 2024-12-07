<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.foodapp.model.pojo.Restaurant"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Restaurant Details</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
        }

        .navbar {
            background-color: #333;
            color: #fff;
            padding: 15px;
            text-align: center;
            font-size: 24px;
        }

        .restaurant-card {
            width: 100%; /* Ensure full width for responsiveness */
            margin: 20px;
            background-color: black;
            color: #ffffff;
            border-radius: 8px;
            transition: transform 0.3s ease-in-out;
        }

        .restaurant-card:hover {
            transform: scale(1.05);
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
            background-color: #e74c3c;
            color: white;
            border: none;
        }

        .btn:hover {
            background-color: #c0392b;
        }

        .btn-edit {
            background-color: #007bff;
            color: white;
        }

        .btn-edit:hover {
            background-color: #0056b3;
        }

        .fixed-image {
            width: 100%; /* Makes the image fill the card's width */
            height: 200px; /* Set a fixed height for consistency */
            object-fit: cover;
            border-top-left-radius: 8px;
            border-top-right-radius: 8px;
        }

        /* Apply color to active images */
        .active-image {
            filter: none; /* No filter, keeping the image in color */
        }

        /* Apply black-and-white filter for inactive images */
        .inactive-image {
            filter: grayscale(100%) contrast(100%) brightness(80%);
        }
        
    </style>
</head>
<body>
    <nav class="navbar">
        Restaurant Details
    </nav>

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
                                        <strong>Cuisine Type:</strong> <%=restaurant.getCuisineType()%><br>
                                        <strong>Address:</strong> <%=restaurant.getAddress()%><br>

                                        <!-- Rating as Stars -->
                                        <strong>Rating:</strong>
                                        <% 
                                            int rating = restaurant.getRating();
                                            for (int i = 0; i < 5; i++) {
                                                if (i < rating) {
                                        %>
                                                    <span>&#9733;</span> <!-- Solid star -->
                                        <% 
                                                } else {
                                        %>
                                                    <span>&#9734;</span> <!-- Empty star -->
                                        <% 
                                                }
                                            }
                                        %>
                                        / 5<br>

                                        <!-- Status: Active or Inactive -->
                                        <strong>Status:</strong> 
                                        <%= restaurant.isActive() ? "<span style='color: green;'>Active</span>" : "<span style='color: red;'>Inactive</span>" %>
                                    </p>
                                    <!-- Edit and Delete Buttons -->
                                    <a href="EditRestaurant?restaurantId=<%= restaurant.getRestaurantId() %>" class="btn btn-edit">Edit</a>
                                    <a href="DeleteRestaurant?id=<%=restaurant.getRestaurantId()%>" class="btn btn-danger" 
                                       onclick="return confirm('Are you sure you want to delete this restaurant?')">Delete</a>
                                	<a href="ShowMenu?restaurantId=<%= restaurant.getRestaurantId() %>&source=admin" class="btn btn-edit">View Menu</a>
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
</body>
</html>
