package com.foodapp.model.dao;

import com.foodapp.model.pojo.Orders;

public interface OrdersDAO {
	void insertOrder(int restaurantId, int userId, int totalAmount, String modeOfPayment, String status, String address);
	Orders fetchOrderId(int orderId);
	void updateOrder(int orderId);
	public int insertOrderAndGetId(int restarutntId, int userId, int totalAmount, String modeOfPayment, String status, String address);
}
