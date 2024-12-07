package com.foodapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapp.model.daoimpl.OrderItemsDAOImpl;
import com.foodapp.model.daoimpl.OrdersDAOImpl;
import com.foodapp.model.daoimpl.RestaurantDAOImpl;
import com.foodapp.model.pojo.OrderItems;
import com.foodapp.model.pojo.Orders;

@WebServlet("/viewOrderServlet")
public class ViewOrderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get the orderId from the request
        int orderId = Integer.parseInt(req.getParameter("orderId"));

        // Instantiate DAO implementations
        OrdersDAOImpl ordersDAO = new OrdersDAOImpl();
        OrderItemsDAOImpl orderItemsDAO = new OrderItemsDAOImpl();
        RestaurantDAOImpl restaurantDAO = new RestaurantDAOImpl();

        try {
            // Fetch order details
            Orders order = ordersDAO.fetchOrderId(orderId);

            // Fetch restaurant name
            String restaurantName = restaurantDAO.getRestaurantName(order.getRestaurantId());

            // Fetch order items
            List<OrderItems> orderItemsList = orderItemsDAO.getOrderItemsByOrderId(orderId);

            // Set data as request attributes
            req.setAttribute("order", order);
            req.setAttribute("restaurantName", restaurantName);
            req.setAttribute("orderItemsList", orderItemsList);

            // Forward to viewOrders.jsp
            req.getRequestDispatcher("viewOrders.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("error.jsp");
        }
    }
}
