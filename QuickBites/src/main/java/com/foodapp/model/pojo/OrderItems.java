package com.foodapp.model.pojo;

public class OrderItems {
	private int orderItemsId;
	private int menuId;
	private int quantity;
	private float subTotal;
	private int orderId;
	private String menuName;
	
	
	public OrderItems() {
		super();
	}

	public OrderItems(int menuId, int quantity, float subTotal, int orderId) {
		super();
		this.menuId = menuId;
		this.quantity = quantity;
		this.subTotal = subTotal;
		this.orderId = orderId;
	}

	public OrderItems(int orderItemsId, int menuId, int quantity, float subTotal, int orderId) {
		super();
		this.orderItemsId = orderItemsId;
		this.menuId = menuId;
		this.quantity = quantity;
		this.subTotal = subTotal;
		this.orderId = orderId;
	}

	public String getMenuName() {
	    return menuName;
	}

	public void setMenuName(String menuName) {
	    this.menuName = menuName;
	}
	
	public int getOrderItemsId() {
		return orderItemsId;
	}

	public void setOrderItemsId(int orderItemsId) {
		this.orderItemsId = orderItemsId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	@Override
	public String toString() {
		return "OrderItems [orderItemsId=" + orderItemsId + ", menuId=" + menuId + ", quantity=" + quantity
				+ ", subTotal=" + subTotal + ", orderId=" + orderId + "]";
	}
	
}
