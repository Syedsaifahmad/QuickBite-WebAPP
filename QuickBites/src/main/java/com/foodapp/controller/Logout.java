package com.foodapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get the current session, if exists
        HttpSession session = req.getSession(false);
        
        // Check if session exists and invalidate it
        if (session != null) {
            session.invalidate();
        }
        
        // Redirect to login page (or home page)
        resp.sendRedirect("login.html");
    }
}
