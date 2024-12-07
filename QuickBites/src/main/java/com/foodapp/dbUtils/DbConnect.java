package com.foodapp.dbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
	
	private static Connection con = null;

	// Static method to return a single connection instance
	public static Connection connection() {
		String url = "jdbc:mysql://localhost:3306/food_app?autoReconnect=true&useSSL=false";
		String dbun = "root";
		String pwd = "root";

		try {
			// Load MySQL JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Initialize the connection if it hasn't been created yet
			if (con == null || con.isClosed()) {
				con = DriverManager.getConnection(url, dbun, pwd);
				System.out.println("Database connected successfully!");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("MySQL JDBC Driver not found.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error connecting to the database.");
			e.printStackTrace();
		}
		return con;
	}
}
