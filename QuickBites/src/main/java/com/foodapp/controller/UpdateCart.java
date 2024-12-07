package com.foodapp.controller;
import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapp.model.pojo.CartItem;


public class UpdateCart extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    int itemId = Integer.parseInt(request.getParameter("itemId"));
	    int quantity = Integer.parseInt(request.getParameter("quantity"));

	    HttpSession session = request.getSession();
	    Map<Integer, CartItem> cartMap = (Map<Integer, CartItem>) session.getAttribute("cart");

	    if (cartMap != null && cartMap.containsKey(itemId)) {
	        CartItem item = cartMap.get(itemId);
	        item.setQuantity(quantity);
	        cartMap.put(itemId, item);
	    }

	    response.sendRedirect("cartItem.jsp");
	}

}
