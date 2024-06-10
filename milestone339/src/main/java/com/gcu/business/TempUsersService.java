package com.gcu.business;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.UsersDataService;
import com.gcu.model.UserModel;

/*
 * Project Name: CST-339 Milestone Project
 * Version: 1.2
 * Module name: Temporary Users Service Class
 * Module version: 1.0
 * Authors: Gabriel Cepleanu
 * Synopsis: This class provides services for user data. Temporary module that will be replaced later.
 */

public class TempUsersService implements UsersServiceInterface {
	
	@Autowired
	UsersDataService usersDAO;

	@Override
	public List<UserModel> getUsers() {
		return usersDAO.getUsers();
	}

	@Override
	public UserModel getUserById(int id) {
		// TODO Auto-generated method stub
		return usersDAO.getUser(id);
	}

	@Override
	public boolean addUser(UserModel newUser) {
		return usersDAO.addUser(newUser) > 0;
	}
	
	public UserModel createNewUser(String first, String last, String email, String street, String city, String state, String zip,
			String username, String password) {
		return new UserModel(-1, first, last, email, street, city, state, zip, username, password);
	}

	@Override
	public boolean deleteUser(int id) {
		return usersDAO.deleteUser(id);
	}

	@Override
	public boolean updateUser(int id, UserModel newUser) {
		return usersDAO.updateUser(id, newUser) != null;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		System.out.println("Users Service Bean was created.");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("Destroying TempUsersService Bean...");
	}

}
