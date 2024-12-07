package com.foodapp.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapp.model.pojo.CartItem;

public class RemoveCartItem extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Map<Integer, CartItem> cartMap = (Map<Integer, CartItem>) session.getAttribute("cart");

        int itemId = Integer.parseInt(request.getParameter("itemId"));

        if (cartMap != null && cartMap.containsKey(itemId)) {
            cartMap.remove(itemId);
            session.setAttribute("cart", cartMap);  // Update session with new cart
        }

        response.sendRedirect("cart.jsp");  // Redirect back to cart page
    }
}
