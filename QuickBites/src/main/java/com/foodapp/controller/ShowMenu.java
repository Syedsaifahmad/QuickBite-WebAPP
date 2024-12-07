package com.foodapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapp.dbUtils.DbConnect;
import com.foodapp.model.daoimpl.MenuDAOImpl;
import com.foodapp.model.pojo.Menu;

@WebServlet("/ShowMenu")
public class ShowMenu extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        // Initialize database connection
        DbConnect db = new DbConnect();
        db.connection();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Create an instance of MenuDAOImpl
        MenuDAOImpl menuDao = new MenuDAOImpl();
        int id = Integer.parseInt(req.getParameter("id"));

        // Get the source parameter, default to "main" if not provided
        String source = req.getParameter("source");
        if (source == null) {
            source = "main";
        }

        // Fetch the list of menus from the DAO
        List<Menu> menuList = menuDao.getMenuByRestaurantId(id);

        if (menuList == null || menuList.isEmpty()) {
            req.setAttribute("errorMessage", "No menu items found.");
            req.getRequestDispatcher("error.jsp").forward(req, resp);
            return; // Stop further processing
        }

        // Store menu list in session (if needed across multiple requests)
        req.getSession().setAttribute("menuList", menuList);

        // Check the source parameter and forward accordingly
        if ("admin".equals(source)) {
            // Admin view - forward to the admin menu page
            req.getRequestDispatcher("viewMenu.jsp").forward(req, resp);
        } else {
            // Main app view - forward to the home menu page
            req.getRequestDispatcher("menu.jsp").forward(req, resp);
        }
    }
}
