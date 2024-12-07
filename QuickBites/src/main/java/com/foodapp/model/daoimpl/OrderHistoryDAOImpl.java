package com.foodapp.model.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.foodapp.dbUtils.DbConnect;
import com.foodapp.model.dao.OrderHistoryDAO;
import com.foodapp.model.pojo.OrderHistory;

public class OrderHistoryDAOImpl implements OrderHistoryDAO {

    @Override
    public OrderHistory insertOrderHistory(int userId, int orderId, int restaurantId, int totalAmount, String status) {
        String query = "INSERT INTO OrderHistory (orderId, userId, restaurantId, amount, status, orderDate) VALUES (?, ?, ?, ?, ?, NOW())";
        try (Connection con = DbConnect.connection();
             PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, orderId);
            statement.setInt(2, userId);
            statement.setInt(3, restaurantId);
            statement.setInt(4, totalAmount);
            statement.setString(5, status);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                return new OrderHistory(orderId, userId, restaurantId, totalAmount, status, new Date());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void fetchOrderHistory(int orderHistoryId) {
        // TODO: Implement if required
    }

    @Override
    public void updateorderHistory(int orderHistoryId, String status) {
        String query = "UPDATE OrderHistory SET status = ? WHERE historyId = ?";
        try (Connection con = DbConnect.connection();
             PreparedStatement statement = con.prepareStatement(query)) {
            statement.setString(1, status);
            statement.setInt(2, orderHistoryId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderHistory> fetchOrderHisroryByUserId(int userId) {
        String query = "SELECT * FROM OrderHistory WHERE userId = ?";
        List<OrderHistory> orderHistoryList = new ArrayList<>();
        try (Connection con = DbConnect.connection();
             PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                OrderHistory orderHistory = new OrderHistory(
                    resultSet.getInt("historyId"),
                    resultSet.getInt("orderId"),
                    resultSet.getInt("userId"),
                    resultSet.getInt("restaurantId"),
                    resultSet.getInt("amount"),
                    resultSet.getString("status"),
                    resultSet.getDate("orderDate")
                );
                orderHistoryList.add(orderHistory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderHistoryList;
    }
}
