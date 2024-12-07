package com.foodapp.model.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.model.dao.MenuDAO;
import com.foodapp.model.pojo.Menu;

public class MenuDAOImpl implements MenuDAO {

    // Database connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/food_app", "root", "root");
    }

	@Override
	public void addMenu(Menu menu) {
		String query = "INSERT INTO menu (menuId, restaurantId, name, description, price, rating, isAvailable, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";		
	
		try (Connection conn = getConnection() ; PreparedStatement pstmt = conn.prepareStatement(query)) 
		{
	        	pstmt.setInt(1, menu.getMenuId());
	        	pstmt.setInt(2, menu.getRestaurantId());
	            pstmt.setString(3, menu.getName());
	            pstmt.setString(4, menu.getDescription());
	            pstmt.setFloat(5, menu.getPrice());
	            pstmt.setFloat(6, menu.getRating());
	            pstmt.setBoolean(7, menu.isAvailable());
	            pstmt.setString(8, menu.getImage());
	            pstmt.executeUpdate();

	            System.out.println("Menu added successfully.");
	     } 
		 catch (SQLException e) 
		 {
	            e.printStackTrace();
	     }
	}

		@Override
		public Menu getMenuById(int menuId) {
			
			String query = "SELECT * FROM menu WHERE menuId = ?";
	        Menu menu = null;
	        try (Connection conn = getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(query)) {

	            pstmt.setInt(1, menuId);
	            ResultSet rs = pstmt.executeQuery();

	            if (rs.next()) {
	                menu = new Menu(rs.getInt("menuId"), rs.getInt("restaurantId"), rs.getString("name"), rs.getString("description"), rs.getFloat("price"), rs.getFloat("rating"), rs.getBoolean("isAvailable"),rs.getString("image"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return menu;
			
		}
		
		@Override
		public List<Menu> getMenuByRestaurantId(int restaurantId) {
		    List<Menu> menuList = new ArrayList<>();
		    String query = "SELECT * FROM menu WHERE restaurantId = ?";

		    try (Connection conn = getConnection();
		         PreparedStatement pstmt = conn.prepareStatement(query)) {

		        pstmt.setInt(1, restaurantId);
		        ResultSet rs = pstmt.executeQuery();

		        while (rs.next()) {
		            Menu menu = new Menu(
		                rs.getInt("menuId"),
		                rs.getInt("restaurantId"),
		                rs.getString("name"),
		                rs.getString("description"),
		                rs.getFloat("price"),
		                rs.getFloat("rating"),
		                rs.getBoolean("isAvailable"),
						rs.getString("image")
		            );
		            menuList.add(menu);
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return menuList;
		}
		
		
	
		@Override
		public List<Menu> getAllmenu() {
			
			List<Menu> menuList = new ArrayList<>();
	        String query = "SELECT * FROM menu";
	        try (Connection conn = getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(query)) {

	            while (rs.next()) {
	                Menu menu = new Menu(rs.getInt("menuId"), rs.getInt("restaurantId"), rs.getString("name"), rs.getString("description"), rs.getFloat("price"), rs.getFloat("rating"), rs.getBoolean("isAvailable"),rs.getString("image"));
	                menuList.add(menu);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return menuList;
			
			
		}
		
		
		
		
	
		@Override
		public void updateMenu(Menu menu) {
			
			String query = "UPDATE menu SET  restaurantId = ?, name = ?, description = ?, price =?, rating = ?, isAvailable = ?, image =? WHERE menuId = ?";
	        try (Connection conn = getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(query)) {

	            pstmt.setInt(1, menu.getRestaurantId());
	            pstmt.setString(2, menu.getName());
	            pstmt.setString(3, menu.getDescription());
	            pstmt.setFloat(4, menu.getPrice());
	            pstmt.setFloat(5, menu.getRating());
	            pstmt.setBoolean(6, menu.isAvailable());
	            pstmt.setString(7, menu.getImage());
	            pstmt.setInt(8, menu.getMenuId());
	            pstmt.executeUpdate();

	            System.out.println("User updated successfully.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
			
		}
		
		
		
		@Override
		public void deleteMenu(int menuId) {
			
			String query = "DELETE FROM menu Where menuId = ?";
			try (Connection conn = getConnection();
		             PreparedStatement pstmt = conn.prepareStatement(query)) {

		            pstmt.setInt(1, menuId);
		            pstmt.executeUpdate();

		            System.out.println("Menu deleted successfully.");
		        } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

}
