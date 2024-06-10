package com.gcu.business;
// test
import com.gcu.model.UserModel;

/*
 * Project Name: CST-339 Milestone Project
 * Version: 1.2
 * Module name: Accounts Service Interface
 * Module version: 1.0
 * Authors: Gabriel Cepleanu
 * Synopsis: This class provides an interface for account services.
 */

public interface AccountsServiceInterface {
	public UserModel authenticate(String username, String password);
	public void init();
	public void destroy();
}
