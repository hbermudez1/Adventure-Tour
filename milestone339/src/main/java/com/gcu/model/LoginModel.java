package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * Project Name: CST-339 Milestone Project
 * Version: 1.2
 * Module name: Login Model Class
 * Module version: 1.0
 * Authors: Harold Bermudez
 * Synopsis: This class provides the model for login.
 */

public class LoginModel {
	
	@NotNull(message="User name is a required field")
	@Size(min=1, max=32, message="User name must be between 1 and 32 characters")
	
	
	private String username;
	
	@NotNull(message="Password is a required field")
	@Size(min=1, max=32, message="Password must be between 1 and 32 characters")
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginModel [username=" + username + ", password=" + password + "]";
	}
	
	
	
}