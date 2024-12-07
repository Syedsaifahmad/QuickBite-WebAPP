package com.foodapp.model.dao;

import java.io.IOException;
import java.util.List;

import com.foodapp.model.pojo.Users;

public interface UserDAO 
{
	void addUser(Users user);
    Users getUserById(int uid);
    Users getUserByEmail(String email);
    List<Users> getAllUsers();
    void updateUser(Users user);
    void deleteUser(int uid) throws IOException;
}
