package com.gcu.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.UsersDataService;
import com.gcu.model.UserModel;

/*
 * Project Name: CST-339 Milestone Project
 * Version: 1.2
 * Module name: Temporary Accounts Service Class
 * Module version: 1.0
 * Authors: Gabriel Cepleanu
 * Synopsis: This class provides services for user accounts. Temporary module that will be replaced later.
 */

public class TempAccountsService implements AccountsServiceInterface {
	
	@Autowired
	private UsersDataService usersService;

	@Override
	public void init() {
		System.out.println("Accounts Service Bean was created.");
		
	}

	@Override
	public void destroy() {
		System.out.println("Accounts Service Bean was destroyed.");

	}

	@Override
	public UserModel authenticate(String username, String password) {
		System.out.println(usersService.getUserByUsername(username));
		return usersService.authenticate(username, password);
	}

}
