package com.foodapp.model.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.foodapp.dbUtils.DbConnect;
import com.foodapp.model.dao.OrdersDAO;
import com.foodapp.model.pojo.Orders;

public class OrdersDAOImpl implements OrdersDAO {

	@Override
	public void insertOrder(int restaurantId, int userId, int totalAmount, String modeOfPayment, String status, String address) {
	    // Define the SQL query for inserting a new order
	    String sql = "INSERT INTO Orders (restaurantId, userId, totalAmount, modeOfPayment, status, address) VALUES (?, ?, ?, ?, ?, ?)";

	    // Establish a connection and execute the query
	    try (Connection connection = DbConnect.connection();
	         PreparedStatement ps = connection.prepareStatement(sql)) {

	        // Set parameters for the query
	        ps.setInt(1, restaurantId);      // Restaurant ID
	        ps.setInt(2, userId);            // User ID
	        ps.setInt(3, totalAmount);       // Total Amount
	        ps.setString(4, modeOfPayment);  // Mode of Payment
	        ps.setString(5, status);         // Status
	        ps.setString(6, address);        // Address

	        // Execute the query
	        ps.executeUpdate();
	        System.out.println("Order inserted successfully.");

	    } catch (Exception e) {
	        // Handle exceptions
	        e.printStackTrace();
	        System.err.println("Failed to insert order: " + e.getMessage());
	    }
	}



    @Override
    public Orders fetchOrderId(int orderId) {
        Orders order = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = DbConnect.connection();
            String sql = "SELECT * FROM Orders WHERE orderId = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, orderId);
            rs = ps.executeQuery();

            if (rs.next()) {
                order = new Orders();
                order.setOrderId(rs.getInt("orderId"));
                order.setRestaurantId(rs.getInt("restaurantId"));
                order.setUserId(rs.getInt("userId"));
                order.setTotalAmount(rs.getInt("totalAmount"));
                order.setModeOfPayment(rs.getString("modeOfPayment"));
                order.setStatus(rs.getString("status"));
                order.setAddress(rs.getString("address"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return order;
    }
    public int insertOrderAndGetId(int restaurantId, int userId, int totalAmount, String modeOfPayment, String status, String address) {
        String sql = "INSERT INTO Orders (restaurantId, userId, totalAmount, modeOfPayment, status, address) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DbConnect.connection();
             PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) { // Use RETURN_GENERATED_KEYS

            // Set the parameters
        	ps.setInt(1, restaurantId);
            ps.setInt(2, userId);
            ps.setInt(3, totalAmount);
            ps.setString(4, modeOfPayment);
            ps.setString(5, status);
            ps.setString(6, address);

            // Execute the update
            ps.executeUpdate();

            // Retrieve the generated orderId
            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1); // Return the generated key
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1; // Return -1 if insertion fails
    }



    @Override
    public void updateOrder(int orderId) {
        // Implementation for updating an order (not needed for now)
    }
}
