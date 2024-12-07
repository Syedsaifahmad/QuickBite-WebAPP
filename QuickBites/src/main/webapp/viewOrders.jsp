<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.foodapp.model.pojo.OrderItems" %>
<%@ page import="com.foodapp.model.pojo.Orders" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.rtl.min.css" integrity="sha384-dpuaG1suU0eT09tx5plTaGMLBsfDLzUCCUXOY2j/LSvXYuG6Bqs43ALlhIqAJVRb" crossorigin="anonymous">

    <title>Order Details</title>
</head>
<body>
    <div class="container">
        <h1>Order Details</h1>
        
        <% 
            Orders order = (Orders) request.getAttribute("order");
            String restaurantName = (String) request.getAttribute("restaurantName");
            List<OrderItems> orderItemsList = (List<OrderItems>) request.getAttribute("orderItemsList");
        %>

        <p><strong>Order ID:</strong> <%= order.getOrderId() %></p>
        <p><strong>Restaurant Name:</strong> <%= restaurantName %></p>
        <p><strong>Payment Mode:</strong> <%= order.getModeOfPayment() %></p>
        <p><strong>Total Amount:</strong> <%= order.getTotalAmount() %></p>

        <h3>Menu Items</h3>
        <table class="table">
            <thead>
                <tr>
                    <th>Menu Name</th>
                    <th>Quantity</th>
                    <th>Price</th>
                    <th>Subtotal</th>
                </tr>
            </thead>
            <tbody>
                <% 
                    for (OrderItems item : orderItemsList) {
                %>
                <tr>
                    <td><%= item.getMenuName() %></td>
                    <td><%= item.getQuantity() %></td>
                    <td><%= item.getSubTotal() / item.getQuantity() %></td>
                    <td><%= item.getSubTotal() %></td>
                </tr>
                <% 
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>
