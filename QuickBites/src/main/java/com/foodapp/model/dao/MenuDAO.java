package com.foodapp.model.dao;

import java.util.List;

import com.foodapp.model.pojo.Menu;


public interface MenuDAO {
	
	void addMenu(Menu menu);
    Menu getMenuById(int menuId);
    List<Menu> getAllmenu();
    void updateMenu(Menu menu);
    void deleteMenu(int menuId);
    List<Menu> getMenuByRestaurantId(int restaurantId);
}
