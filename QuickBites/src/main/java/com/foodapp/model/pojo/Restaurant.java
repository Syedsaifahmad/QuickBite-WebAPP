package com.foodapp.model.pojo;

public class Restaurant {
	private int restaurantId;
	private String restaurantName;
	private String cuisineType;
	private String address;
	private int rating;
	private boolean isActive;
	private String image;
	
	public Restaurant() {
		super();
	}

	public Restaurant(String restaurantName, String cuisineType, String address, int rating, boolean isActive,
			String image) {
		super();
		this.restaurantName = restaurantName;
		this.cuisineType = cuisineType;
		this.address = address;
		this.rating = rating;
		this.isActive = isActive;
		this.image = image;
	}

	public Restaurant(int restaurantId, String restaurantName, String cuisineType, String address, int rating,
			boolean isActive, String image) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.cuisineType = cuisineType;
		this.address = address;
		this.rating = rating;
		this.isActive = isActive;
		this.image = image;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", cuisineType="
				+ cuisineType + ", address=" + address + ", rating=" + rating + ", isActive=" + isActive + ", image="
				+ image + "]";
	}
}
