package com.foodapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapp.model.dao.RestaurantDAO;
import com.foodapp.model.daoimpl.RestaurantDAOImpl;

@WebServlet("/DeleteRestaurant")
public class DeleteRestaurant extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	 int restaurantId = Integer.parseInt(req.getParameter("id"));
         
         RestaurantDAO restaurantDAO = new RestaurantDAOImpl();
         boolean success = restaurantDAO.deleteRestaurant(restaurantId);
         
         if (success) {
             resp.sendRedirect("viewRestaurants.jsp?status=deleted");
         } else {
             resp.sendRedirect("viewRestaurants.jsp?status=error");
         }
    }

}
