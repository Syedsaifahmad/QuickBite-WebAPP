package com.foodapp.model.daoimpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.dbUtils.DbConnect;
import com.foodapp.model.dao.RestaurantDAO;
import com.foodapp.model.pojo.Restaurant;

public class RestaurantDAOImpl implements RestaurantDAO{
	
	//Database connection
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/food_app","root", "root");
	}

	@Override
	public void addRestaurant(Restaurant restaurant) {
		
		String query = "INSERT INTO restaurant (restaurantName, cuisineType, address, rating, isActive, image) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
        	pstmt.setString(1, restaurant.getRestaurantName());
        	pstmt.setString(2, restaurant.getCuisineType());
        	pstmt.setString(3, restaurant.getAddress());
        	pstmt.setInt(4, restaurant.getRating());
        	pstmt.setBoolean(5, restaurant.isActive());
        	pstmt.setString(6, restaurant.getImage());
        	
        	pstmt.executeUpdate();
        	
        	System.out.println("Restaurant Added Successful!");
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
		
	}

	@Override
	public Restaurant getRestaurantById(int restaurantId) {
		Restaurant restaurant = null;
		
		String query = "Select * From restaurant Where restaurantId = ?";
		try(Connection con = getConnection();
			PreparedStatement pstmt = con.prepareStatement(query)){
			
			pstmt.setInt(1, restaurantId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                restaurant = new Restaurant(rs.getInt("restaurantId"),
                							rs.getString("restaurantName"), 
                							rs.getString("cuisineType"), 
                							rs.getString("address"), 
                							rs.getInt("rating"),
                							rs.getBoolean("isActive"),
                							rs.getString("image"));
                }
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return restaurant;
	}
	
	
	
	
	
		@Override
		public List<Restaurant> getAllRestaurant() {
			List<Restaurant> restaurantList = new ArrayList<>();
			String query = "Select * From restaurant";
			try (Connection conn = getConnection();
		             Statement stmt = conn.createStatement();
		             ResultSet rs = stmt.executeQuery(query)) {

		            while (rs.next()) {
		                Restaurant restaurant = new Restaurant(rs.getInt("restaurantId"),
								    							rs.getString("restaurantName"), 
								    							rs.getString("cuisineType"), 
								    							rs.getString("address"), 
								    							rs.getInt("rating"),
								    							rs.getBoolean("isActive"),
					                							rs.getString("image"));
		                restaurantList.add(restaurant);
		                
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
//			System.out.println("RestDAOImp "+restaurantList);
		        return restaurantList;
			
		}
		
			@Override
			public boolean updateRestaurant(Restaurant restaurant) {
				
				String query = "UPDATE restaurant SET restaurantName = ?, cuisineType = ?, address = ?, rating = ?, isActive = ?, image = ? WHERE restaurantId = ?";
		        boolean ans = false;
				try (Connection conn = getConnection();
		             PreparedStatement pstmt = conn.prepareStatement(query)) {

		            pstmt.setString(1, restaurant.getRestaurantName());
		            pstmt.setString(2, restaurant.getCuisineType());
		            pstmt.setString(3, restaurant.getAddress());
		            pstmt.setInt(4, restaurant.getRating());
		            pstmt.setBoolean(5, restaurant.isActive());
		            pstmt.setString(6, restaurant.getImage());
		            pstmt.setInt(7, restaurant.getRestaurantId());
		            pstmt.executeUpdate();

		            System.out.println("Restaurant updated successfully.");
		            ans = true;
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
				return ans;
			}
		
			@Override
			public boolean deleteRestaurant(int restaurantId) {
				boolean ans = false;
				String query = "DELETE FROM restaurant WHERE restaurantId = ?";
				
				try (Connection conn = getConnection();
			            PreparedStatement pstmt = conn.prepareStatement(query)) {
						
			            pstmt.setInt(1, restaurantId);
			            pstmt.executeUpdate();
			            ans = true;
			            System.out.println(" deleted successfully.");
			        } catch (SQLException e) {
						e.printStackTrace();
					}
				
				return ans;
				
			}
			
			
			
			
			public String getRestaurantName(int restaurantId) {
			    String restaurantName = "";
			    String sql = "SELECT restaurantName FROM Restaurant WHERE restaurantId = ?";
			    
			    try (Connection connection = DbConnect.connection();
			         PreparedStatement ps = connection.prepareStatement(sql)) {
			        
			        ps.setInt(1, restaurantId);
			        try (ResultSet rs = ps.executeQuery()) {
			            if (rs.next()) {
			                restaurantName = rs.getString("restaurantName");
			            }
			        }
			    } catch (Exception e) {
			        e.printStackTrace();
			    }
			    return restaurantName;
			}

	
	

}
