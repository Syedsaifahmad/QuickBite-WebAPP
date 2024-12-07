package com.foodapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapp.model.daoimpl.RestaurantDAOImpl;
import com.foodapp.model.pojo.Restaurant;

@WebServlet("/UpdateRestaurant")
public class UpdateRestaurant extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));
        String restaurantName = req.getParameter("restaurantName");
        String cuisineType = req.getParameter("cuisineType");
        String address = req.getParameter("address");
        int rating = Integer.parseInt(req.getParameter("rating"));
        boolean isActive = Boolean.parseBoolean(req.getParameter("active"));
        String image = req.getParameter("image");

        // Create the Restaurant object with all the retrieved parameters
        Restaurant restaurant = new Restaurant(restaurantId, restaurantName, cuisineType, address, rating, isActive, image);
        
        RestaurantDAOImpl restaurantDAO = new RestaurantDAOImpl();
        boolean success = restaurantDAO.updateRestaurant(restaurant);
        
        if (success) {
            resp.sendRedirect("GetRestaurant?source=admin");
        } else {
            resp.sendRedirect("viewRestaurants.jsp?status=error");
        }
    }
}
