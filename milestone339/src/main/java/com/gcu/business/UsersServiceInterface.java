package com.gcu.business;

import java.util.List;

import com.gcu.model.UserModel;

/*
 * Project Name: CST-339 Milestone Project
 * Version: 1.2
 * Module name: Users Service Interface
 * Module version: 1.0
 * Authors: Gabriel Cepleanu
 * Synopsis: This class provides an interface for user services.
 */

public interface UsersServiceInterface {
	public List<UserModel> getUsers();
	public UserModel getUserById(int id);
	public boolean addUser(UserModel newUser);
	public boolean deleteUser(int id);
	public boolean updateUser(int id, UserModel newUser);
	public UserModel createNewUser(String first, String last, String email, String street, String city, String state, String zip, String username, String password);
	public void init();
	public void destroy();
}
