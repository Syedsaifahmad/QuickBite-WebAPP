package com.foodapp.model.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.dbUtils.DbConnect;
import com.foodapp.model.dao.OrderItemsDAO;
import com.foodapp.model.pojo.OrderItems;

public class OrderItemsDAOImpl implements OrderItemsDAO {

    // Method to insert order items
    public OrderItems insertOrderItems(int menuId, int quantity, float subtotal, int orderId) {
        // Prepare the SQL query
        String sql = "INSERT INTO OrderItems (menuId, quantity, subTotal, orderId) VALUES (?, ?, ?, ?)";
        
        // Get a database connection
        try (Connection connection = DbConnect.connection()) {
            // Prepare the statement
            PreparedStatement ps = connection.prepareStatement(sql);

            // Set the parameters in the query
            ps.setInt(1, menuId);     // Set the menuId
            ps.setInt(2, quantity);   // Set the quantity
            ps.setFloat(3, subtotal);   // Set the subtotal
            ps.setInt(4, orderId);    // Set the orderId

            // Execute the query
            int rowsAffected = ps.executeUpdate();

            // If the insert was successful, return the OrderItems object
            if (rowsAffected > 0) {
                OrderItems orderItems = new OrderItems();
                orderItems.setMenuId(menuId);
                orderItems.setQuantity(quantity);
                orderItems.setSubTotal(subtotal);
                orderItems.setOrderId(orderId);
                return orderItems;  // Return the newly created order item
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // If the insertion failed, return null
        return null;
    }
    
    public List<OrderItems> getOrderItemsByOrderId(int orderId) {
        List<OrderItems> orderItemsList = new ArrayList<>();
        String sql = "SELECT oi.orderItemsId, oi.menuId, m.name AS menuName, oi.quantity, oi.subTotal " +
                     "FROM OrderItems oi " +
                     "JOIN Menu m ON oi.menuId = m.menuId " +
                     "WHERE oi.orderId = ?";

        try (Connection connection = DbConnect.connection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            
            ps.setInt(1, orderId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    OrderItems item = new OrderItems();
                    item.setOrderItemsId(rs.getInt("orderItemsId"));
                    item.setMenuId(rs.getInt("menuId"));
                    item.setMenuName(rs.getString("menuName")); // This should now work
                    item.setQuantity(rs.getInt("quantity"));
                    item.setSubTotal(rs.getInt("subTotal"));
                    item.setOrderId(orderId);
                    orderItemsList.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderItemsList;
    }



	@Override
	public List<OrderItems> fetchOrderItems(int orderItemsId) {
		// TODO Auto-generated method stub
		return null;
	}
}
