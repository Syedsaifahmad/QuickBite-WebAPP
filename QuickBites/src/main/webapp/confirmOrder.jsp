<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.foodapp.model.pojo.Users" %>
<%@ page import="com.foodapp.model.pojo.CartItem" %>
<%@ page import="com.foodapp.model.pojo.Menu" %>
<%@ page import="com.foodapp.model.pojo.Restaurant" %>
<%@ page import="com.foodapp.model.daoimpl.RestaurantDAOImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirm Order</title>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;700&family=Roboto&display=swap');

        body {
            background: linear-gradient(135deg, #ffcc00, #ff6600);
            font-family: 'Poppins', sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }
        .container {
            width: 40%;
            padding: 20px;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0px 4px 12px rgba(0, 0, 0, 0.1);
        }
        h1 {
            text-align: center;
            color: #333;
            font-size: 28px;
            margin-bottom: 20px;
        }
        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }
        label {
            font-size: 16px;
            color: #555;
            font-weight: bold;
        }
        input[type="text"], input[type="number"], select, textarea {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }
        button {
            padding: 10px 20px;
            background-color: #ff6600;
            color: white;
            font-size: 16px;
            font-weight: bold;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease, transform 0.2s ease;
        }
        button:hover {
            background-color: #cc5200;
            transform: scale(1.05);
        }
        .item {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .item input {
            border: none;
            background: none;
            font-size: 14px;
        }
        .total {
            font-size: 20px;
            font-weight: bold;
            text-align: right;
            margin-top: 20px;
            color: #ff6600;
        }
    </style>
    <script>
        // Function to show an alert after order confirmation
        function showOrderSuccessAlert() {
            alert('Your order has been placed successfully!');
        }
    </script>
</head>
<body>
<%
    // Retrieve session attributes
    Users user = (Users) session.getAttribute("user");
    Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");
    double totalPrice = 0.0;
%>

<div class="container">
    <h1>Confirm Order</h1>
    <form action="ConfirmOrder" method="POST" onsubmit="showOrderSuccessAlert()">
        <!-- User Name -->
        <label for="username">User Name</label>
        <input type="text" id="username" name="username" 
               value="<%= user != null ? user.getName() : "" %>" readonly>

        <!-- Items in Cart -->
        <% if (cart != null && !cart.isEmpty()) { %>
            <% 
                for (CartItem item : cart.values()) { 
                    double itemTotal = item.getPrice() * item.getQuantity();
                    totalPrice += itemTotal;
            %>
            <div class="item">
                <input type="text" value="<%= item.getName() %> x<%= item.getQuantity() %>" readonly>
                <span>₹<%= String.format("%.2f", itemTotal) %></span>
                <!-- Hidden inputs for submission -->
                <input type="hidden" name="itemName" value="<%= item.getName() %>">
                <input type="hidden" name="itemQuantity" value="<%= item.getQuantity() %>">
                <input type="hidden" name="itemPrice" value="<%= item.getPrice() %>">
            </div>
            <% } %>
        <% } %>

        <!-- Total Amount -->
        <div class="total">
            Total: ₹<%= String.format("%.2f", totalPrice) %>
        </div>
        <input type="hidden" name="total" value="<%= (int) Math.round(totalPrice) %>">

        <!-- Delivery Address -->
        <label for="address">Delivery Address</label>
        <textarea id="address" name="address" placeholder="Enter your delivery address" rows="3" required></textarea>

        <!-- Payment Mode -->
        <label for="payment">Payment Mode</label>
        <select id="payment" name="payment" required>
            <option value="" disabled selected>Select payment mode</option>
            <option value="cash">Cash</option>
            <option value="card">Card</option>
            <option value="upi">UPI</option>
        </select>

        <!-- Submit Button -->
        <button type="submit">Confirm Order</button>
    </form>
</div>

</body>
</html>
