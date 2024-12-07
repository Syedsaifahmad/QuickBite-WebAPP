package com.foodapp.model.pojo;

public class Orders {
	private int orderId; 
	private int restaurantId; 
	private int userId;
	private int totalAmount;
	private String modeOfPayment;
	private String status; 
	private String address;
	
	public Orders(){
		super();
	}

	public Orders(int restaurantId, int userId, int totalAmount, String modeOfPayment, String status, String address) {
		super();
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.modeOfPayment = modeOfPayment;
		this.status = status;
		this.address = address;
	}

	public Orders(int orderId, int restaurantId, int userId, int totalAmount, String modeOfPayment, String status,
			String address) {
		super();
		this.orderId = orderId;
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.totalAmount = totalAmount;
		this.modeOfPayment = modeOfPayment;
		this.status = status;
		this.address = address;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getModeOfPayment() {
		return modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		this.modeOfPayment = modeOfPayment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", restaurantId=" + restaurantId + ", userId=" + userId + ", totalAmount="
				+ totalAmount + ", modeOfPayment=" + modeOfPayment + ", status=" + status + ", address=" + address
				+ "]";
	}
	
	
	
}
