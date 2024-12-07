package com.foodapp.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapp.model.daoimpl.OrderHistoryDAOImpl;
import com.foodapp.model.daoimpl.OrdersDAOImpl;
import com.foodapp.model.daoimpl.OrderItemsDAOImpl;
import com.foodapp.model.pojo.CartItem;
import com.foodapp.model.pojo.Users;

public class ConfirmOrder extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Users user = (Users) session.getAttribute("user");
        @SuppressWarnings("unchecked")
        Map<Integer, CartItem> cart = (Map<Integer, CartItem>) session.getAttribute("cart");

        if (user == null || cart == null || cart.isEmpty()) {
            resp.sendRedirect("error.jsp");
            return;
        }

        String address = req.getParameter("address");
        String paymentMode = req.getParameter("payment");
        int totalAmount = Integer.parseInt(req.getParameter("total"));

        OrdersDAOImpl ordersDAO = new OrdersDAOImpl();
        OrderItemsDAOImpl orderItemsDAO = new OrderItemsDAOImpl();
        OrderHistoryDAOImpl orderHistoryDAO = new OrderHistoryDAOImpl();

        try {
            // Retrieve restaurantId from the first item in the cart
            int restaurantId = cart.values().iterator().next().getRestaurantId();

            // Insert into Orders table
            int orderId = ordersDAO.insertOrderAndGetId(restaurantId, user.getId(), totalAmount, paymentMode, "Confirmed", address);

            // Insert into OrderItems table
            for (CartItem item : cart.values()) {
                int subtotal = (int) (item.getPrice() * item.getQuantity());
                orderItemsDAO.insertOrderItems(item.getItemId(), item.getQuantity(), subtotal, orderId);
            }

            // Insert into OrderHistory table
            for (CartItem item : cart.values()) {
                int itemTotal = (int) (item.getPrice() * item.getQuantity());
                orderHistoryDAO.insertOrderHistory(user.getId(), orderId, restaurantId, itemTotal, "Confirmed");
            }

            session.removeAttribute("cart");
            resp.sendRedirect("home.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }
}
