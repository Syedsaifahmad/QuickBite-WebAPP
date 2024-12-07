package com.foodapp.model.dao;

import java.util.List;

import com.foodapp.model.pojo.OrderHistory;

public interface OrderHistoryDAO {
	
	public OrderHistory insertOrderHistory(int userId, int orderId, int restaurantId, int amount, String status);
	public void fetchOrderHistory(int orderHIstoryId);
	public void updateorderHistory(int orderHistoryId, String status);
	public List<OrderHistory> fetchOrderHisroryByUserId(int userId);
	
}
