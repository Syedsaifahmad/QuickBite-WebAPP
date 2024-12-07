package com.foodapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapp.model.daoimpl.RestaurantDAOImpl;
import com.foodapp.model.pojo.Restaurant;

@WebServlet("/EditRestaurant")
public class EditRestaurant extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int restaurantId = Integer.parseInt(req.getParameter("restaurantId"));

		RestaurantDAOImpl restaurantDAO = new RestaurantDAOImpl();
		Restaurant restaurant = restaurantDAO.getRestaurantById(restaurantId);

		req.setAttribute("restaurant", restaurant);
		req.setAttribute("activeStatus", restaurant.isActive());
		RequestDispatcher dispatcher = req.getRequestDispatcher("editRestaurant.jsp");
		dispatcher.forward(req, resp);

	}

}
