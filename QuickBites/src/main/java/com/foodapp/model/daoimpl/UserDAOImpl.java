package com.foodapp.model.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.foodapp.dbUtils.DbConnect;
import com.foodapp.model.dao.UserDAO;
import com.foodapp.model.pojo.Users;
import com.foodapp.security.Encrypt;

public class UserDAOImpl implements UserDAO {

    @Override
    public void addUser(Users user) {
        String query = "INSERT INTO users (id, name, email, mobile, password, address) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection con = DbConnect.connection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, user.getId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, Encrypt.encrypt(user.getPassword())); 
            pstmt.setString(5, user.getMobile());
            pstmt.setString(6, user.getAddress());

            pstmt.executeUpdate();
            System.out.println("User added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Users getUserByEmail(String email) {
        String query = "SELECT * FROM users WHERE email = ?";
        Users user = null;

        try (Connection con = DbConnect.connection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, email);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    user = new Users(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("mobile"),
                        rs.getString("password"),
                        rs.getString("address")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Users getUserById(int uid) {
        String query = "SELECT * FROM users WHERE id = ?";
        Users user = null;

        try (Connection con = DbConnect.connection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, uid);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    user = new Users(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("mobile"),
                        rs.getString("password"),
                        rs.getString("address")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<Users> getAllUsers() {
        List<Users> users = new ArrayList<>();
        String query = "SELECT * FROM users";

        try (Connection con = DbConnect.connection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Users user = new Users(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("mobile"),
                    rs.getString("password"),
                    rs.getString("address")
                );
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public void updateUser(Users user) {
        String query = "UPDATE users SET name = ?, email = ?, mobile = ?, password = ?, address = ? WHERE id = ?";
        try (Connection con = DbConnect.connection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getMobile());
            pstmt.setString(4, user.getPassword());
            pstmt.setString(5, user.getAddress());
            pstmt.setInt(6, user.getId());

            pstmt.executeUpdate();
            System.out.println("User updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {
        String query = "DELETE FROM users WHERE id = ?";
        try (Connection con = DbConnect.connection();
             PreparedStatement pstmt = con.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("User deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
