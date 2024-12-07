package com.foodapp.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapp.model.daoimpl.OrderHistoryDAOImpl;
import com.foodapp.model.pojo.CartItem;
import com.foodapp.model.pojo.OrderHistory;
import com.foodapp.model.pojo.Users;


public class PlaceOrder extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");

        if (user == null || cart == null || cart.isEmpty()) {
            response.sendRedirect("error.jsp"); // Redirect to an error page if user/cart is invalid
            return;
        }

        int userId = user.getId();
        int restaurantId = 0; // Assuming all items belong to the same restaurant
        int totalAmount = 0;
        String status = "Pending";

        for (CartItem item : cart.values()) {
            totalAmount += item.getPrice() * item.getQuantity();
            restaurantId = item.getRestaurantId();
        }

        // Insert into OrderHistory
        OrderHistoryDAOImpl orderHistoryDAO = new OrderHistoryDAOImpl();
        OrderHistory orderHistory = orderHistoryDAO.insertOrderHistory(userId, 0, restaurantId, totalAmount, status);

        if (orderHistory != null) {
            // Clear cart after successful order
            session.removeAttribute("cart");
            session.setAttribute("orderHistory", orderHistory);

            response.sendRedirect("success.jsp"); // Redirect to success page
        } else {
            response.sendRedirect("error.jsp"); // Redirect to error page in case of failure
        }
    }
}
