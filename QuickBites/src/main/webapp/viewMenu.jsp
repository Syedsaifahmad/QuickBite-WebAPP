<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.foodapp.model.pojo.Menu"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Menu Details</title>
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

        .menu-card {
            width: 100%;
            margin: 20px;
            background-color: black;
            color: #ffffff;
            border-radius: 8px;
            transition: transform 0.3s ease-in-out;
        }

        .menu-card:hover {
            transform: scale(1.05);
        }

        .card-title {
            font-size: 1.5rem;
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
            width: 100%;
            height: 200px;
            object-fit: cover;
            border-top-left-radius: 8px;
            border-top-right-radius: 8px;
        }

        .active-image {
            filter: none;
        }

        .inactive-image {
            filter: grayscale(100%) contrast(100%) brightness(80%);
        }
    </style>
</head>
<body>
    <nav class="navbar">
        Menu Details
    </nav>

    <!-- Menu Details -->
    <div class="container mt-4">
        <div class="row">
            <%
                List<Menu> menuList = (List<Menu>) session.getAttribute("menuList");
                if (menuList != null && !menuList.isEmpty()) {
                    for (Menu menu : menuList) {
                        String imageClass = menu.isAvailable() ? "active-image" : "inactive-image";
            %>
                        <div class="col-md-4 mb-4">
                            <div class="card menu-card">
                                <!-- Menu Image -->
                                <img src="<%=menu.getImage()%>" 
                                    class="card-img-top fixed-image <%= imageClass %>" 
                                    alt="<%=menu.getName()%>">

                                <div class="card-body">
                                    <h5 class="card-title"><%=menu.getName()%></h5>
                                    <p class="card-text">
                                        <strong>Description:</strong> <%=menu.getDescription()%><br>
                                        <strong>Price:</strong> $<%=menu.getPrice()%><br>

                                        <!-- Rating -->
                                        <strong>Rating:</strong>
                                        <% 
                                            float rating = menu.getRating();
                                            for (int i = 0; i < 5; i++) {
                                                if (i < rating) {
                                        %>
                                                    <span>&#9733;</span>
                                        <% 
                                                } else {
                                        %>
                                                    <span>&#9734;</span>
                                        <% 
                                                }
                                            }
                                        %> / 5<br>

                                        <!-- Availability -->
                                        <strong>Status:</strong> 
                                        <%= menu.isAvailable() ? "<span style='color: green;'>Available</span>" : "<span style='color: red;'>Not Available</span>" %>
                                    </p>

                                    <!-- Edit and Delete Buttons -->
                                    <a href="EditMenu?menuId=<%= menu.getMenuId() %>" class="btn btn-edit">Edit</a>
                                    <a href="DeleteMenu?menuId=<%=menu.getMenuId()%>" class="btn btn-danger" 
                                       onclick="return confirm('Are you sure you want to delete this menu item?')">Delete</a>
                                </div>
                            </div>
                        </div>
            <% 
                    }
                } else {
            %>
                    <div class="col-12 text-center">
                        <p>No menu items found</p>
                    </div>
            <% 
                }
            %>
        </div>
    </div>
</body>
</html>
