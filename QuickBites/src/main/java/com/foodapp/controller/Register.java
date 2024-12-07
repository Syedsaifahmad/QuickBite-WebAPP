package com.foodapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foodapp.dbUtils.DbConnect;
import com.foodapp.security.Encrypt;

@WebServlet("/register")
public class Register extends HttpServlet
{
	private Connection con;
	String insertUser = "INSERT INTO users (name, email, mobile, password, address) VALUES (?, ?, ?, ?, ?)";
	private PreparedStatement pstmt;
	private int status;
	private PrintWriter out;

	@Override
	public void init() throws ServletException {
        con = DbConnect.connection();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter pw = resp.getWriter();
		String password = req.getParameter("password");
		
		String PWD = Encrypt.encrypt(password);


		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String mobile = req.getParameter("mobile");
		String address = req.getParameter("address");

		try 
		{	
		pstmt = con.prepareStatement(insertUser);
		pstmt.setString(1, name);
		pstmt.setString(2, email);
		pstmt.setString(3, mobile);
		pstmt.setString(4, PWD);
		pstmt.setString(5, address);

		status = pstmt.executeUpdate();

		
		if(status != 0) {
			resp.sendRedirect("login.html");
		}
		else {
			pw.println("Registration Faild!");
		}

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void destroy() {
		try {
			pstmt.close();
			con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
