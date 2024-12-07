package com.foodapp.model.pojo;

import java.util.Date;

public class OrderHistory {
	
	private int historyId;
	private int orderId;
	private int userId;
	private int restaurantId;
	private int amount;
	private String status;
	private Date orderDate;
	
	public OrderHistory() {
		super();
	}

	public OrderHistory(int orderId, int userId, int restaurantId, int amount, String status, Date orderDate) {
		super();
		this.orderId = orderId;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.amount = amount;
		this.status = status;
		this.orderDate = orderDate;
	}

	public OrderHistory(int historyId, int orderId, int userId, int restaurantId, int amount, String status,
			Date orderDate) {
		super();
		this.historyId = historyId;
		this.orderId = orderId;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.amount = amount;
		this.status = status;
		this.orderDate = orderDate;
	}

	public int getHistoryId() {
		return historyId;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "OrderHistory [historyId=" + historyId + ", orderId=" + orderId + ", userId=" + userId
				+ ", restaurantId=" + restaurantId + ", amount=" + amount + ", status=" + status + ", orderDate="
				+ orderDate + "]";
	}
}
