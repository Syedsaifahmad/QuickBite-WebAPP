package com.foodapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapp.dbUtils.DbConnect;
import com.foodapp.model.daoimpl.RestaurantDAOImpl;
import com.foodapp.model.pojo.Restaurant;

@WebServlet("/GetRestaurant")
public class GetRestaurant extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    @Override
    public void init() throws ServletException {
        // Initialize database connection (ensure connection is successful)
        DbConnect db = new DbConnect();
        db.connection();
    }
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Create instance of DAO to interact with the database
        RestaurantDAOImpl restDao = new RestaurantDAOImpl();
        
        // Get the source parameter, default to "main" if null
        String source = req.getParameter("source");
        if (source == null) {
            source = "main";
        }
        
        // Fetch the list of restaurants from the DAO
        List<Restaurant> restList = restDao.getAllRestaurant();
        
        if (restList == null || restList.isEmpty()) {
            req.setAttribute("errorMessage", "No restaurants found.");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            return;  // Stop further processing
        }
        
        // Store restaurant list in session (if needed across multiple requests)
        req.getSession().setAttribute("restaurant", restList);

        // Check the source parameter and forward accordingly
        if ("admin".equals(source)) {
            // Admin view - forward to the admin page
            req.getRequestDispatcher("viewRestaurants.jsp").forward(req, resp);
        } else {
            // Main app view - forward to the home page
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }
    }
}
