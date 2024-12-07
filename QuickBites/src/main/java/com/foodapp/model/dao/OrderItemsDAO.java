package com.foodapp.model.dao;

import java.util.List;

import com.foodapp.model.pojo.OrderItems;

public interface OrderItemsDAO {
	
	public OrderItems insertOrderItems(int menuId, int quantity, float subtotal, int orderId);
	public List<OrderItems> fetchOrderItems(int orderItemsId);
}
