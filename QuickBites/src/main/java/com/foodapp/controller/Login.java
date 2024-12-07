package com.foodapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.foodapp.dbUtils.DbConnect;
import com.foodapp.model.daoimpl.UserDAOImpl;
import com.foodapp.model.pojo.Users;
import com.foodapp.security.Decrypt;

@WebServlet("/Login")
public class Login extends HttpServlet {

    private Connection con;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private HttpSession session;

    @Override
    public void init() throws ServletException {
        DbConnect db = new DbConnect();
        db.connection();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String passWord = req.getParameter("password");

        // Initialize the response writer
        PrintWriter pw = resp.getWriter();

        try {
            UserDAOImpl udao = new UserDAOImpl();
            Users user = udao.getUserByEmail(email);

            // Check if user exists
            if (user == null) {
                pw.println("No user found with that email.");
                return;
            }

            String decryptedPassword = Decrypt.dycrypt(user.getPassword());
//            System.out.println("Decrypted password: " + decryptedPassword);

            // Validate password
            if (decryptedPassword.equals(passWord)) {
                // Set session attributes
                session = req.getSession();
                session.setAttribute("user", user);
                session.setAttribute("name", user.getName());
                session.setAttribute("LoggedInUser", user);

                // Redirect to GetRestaurant servlet with 'main' as source
                resp.sendRedirect("GetRestaurant?source=");
            } else {
                pw.println("Password Mismatch");
            }
        } catch (Exception e) {
            e.printStackTrace();
            pw.println("An error occurred during login.");
        }
    }
}
