package com.foodapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapp.model.daoimpl.OrderHistoryDAOImpl;
import com.foodapp.model.pojo.OrderHistory;
import com.foodapp.model.pojo.Users;

@WebServlet("/GetOrderHistory")
public class GetOrderHistory extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve the user from the session
        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("user");
        
        
        
        System.out.println("GetOrderHistory Page");
        if (user == null) {
            // Redirect to login if user is not authenticated
            response.sendRedirect("login.html");
            return;
        }

        // Get the userId
        int userId = user.getId();

        // Fetch order history from DAO
        OrderHistoryDAOImpl orderHistoryDAO = new OrderHistoryDAOImpl();
        List<OrderHistory> orderHistoryList = orderHistoryDAO.fetchOrderHisroryByUserId(userId);

        // Set the order history list as a request attribute
        request.setAttribute("orderHistoryList", orderHistoryList);

        // Forward to the JSP to display the order history
        request.getRequestDispatcher("orderHistory.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
