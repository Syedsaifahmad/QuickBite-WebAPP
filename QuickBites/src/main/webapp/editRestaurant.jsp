<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.foodapp.model.pojo.Restaurant"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Restaurant</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
            background: #fff;
            padding: 20px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        label {
            font-weight: bold;
            color: #555;
        }

        input[type="text"], input[type="number"], input[type="radio"] {
            margin-top: 5px;
        }

        input[type="text"], input[type="number"] {
            width: 100%;
            padding: 10px;
            font-size: 14px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }

        button {
            padding: 10px 15px;
            font-size: 16px;
            font-weight: bold;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }

        .form-group {
            display: flex;
            flex-direction: column;
        }

        .radio-group {
            display: flex;
            gap: 15px;
            align-items: center;
        }

        .radio-group label {
            font-weight: normal;
            color: #333;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1><a href="#" class="previous">Edit Restaurant</a></h1>
        <form action="UpdateRestaurant" method="post">
            <!-- Hidden field for restaurantId -->
            <input type="hidden" name="restaurantId" value="${restaurant.restaurantId}" />

            <div class="form-group">
                <label for="restaurantName">Restaurant Name:</label>
                <input type="text" name="restaurantName" value="${restaurant.restaurantName}" required />
            </div>

            <div class="form-group">
                <label for="cuisineType">Cuisine Type:</label>
                <input type="text" name="cuisineType" value="${restaurant.cuisineType}" required />
            </div>

            <div class="form-group">
                <label for="address">Address:</label>
                <input type="text" name="address" value="${restaurant.address}" required />
            </div>

            <div class="form-group">
                <label for="rating">Rating:</label>
                <input type="number" name="rating" value="${restaurant.rating}" min="1" max="5" required />
            </div>

            <div class="form-group">
                <label for="image">Image URL:</label>
                <input type="text" name="image" value="${restaurant.image}" />
            </div>
            
            <div class="form-group">
            	<lable for="active">Active Status:</lable>
            	<input type="text" name="active" value="${activeStatus }"/>
            </div>

            <!-- Submit button to update restaurant -->
            <button type="submit">Update Restaurant</button>
        </form>
    </div>
</body>
</html>
