package com.foodapp.model.dao;

import java.util.List;

import com.foodapp.model.pojo.Restaurant;


public interface RestaurantDAO {
	
	void addRestaurant(Restaurant restaurant);
    Restaurant getRestaurantById(int restaurantId);
    List<Restaurant> getAllRestaurant();
    boolean updateRestaurant(Restaurant restaurant);
    boolean deleteRestaurant(int restaurantId);

}
