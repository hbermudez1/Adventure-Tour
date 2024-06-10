package com.gcu.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * Project Name: CST-339 Milestone Project
 * Version: 1.5
 * Module name: Register Model Class
 * Module version: 1.2
 * Authors: Gabriel Cepleanu
 * Synopsis: This class provides the model for registration.
 */

public class RegisterModel {
	
	@NotNull(message="First Name is required.")
	@Size(min=1, max=30, message="First Name can only be between 1 to 30 characters.")
	private String first;
	
	@NotNull(message="Last Name is required.")
	@Size(min=1, max=40, message="Last Name can only be between 1 to 40 characters.")
	private String last;
	
	@NotNull(message="Email is required.")
	@Size(min=1, max=50, message="Email can only be between 1 to 50 characters.")
	private String email;
	
	@NotNull(message="Street is required.")
	@Size(min=1, max=45, message="Street can only be between 1 to 45 characters.")
	private String street;
	
	@NotNull(message="City is required.")
	@Size(min=1, max=45, message="City can only be between 1 to 45 characters.")
	private String city;
	
	@NotNull(message="State is required.")
	@Size(min=1, max=45, message="State can only be between 1 to 45 characters.")
	private String state;
	
	@NotNull(message="Zip is required.")
	@Size(min=1, max=45, message="Zip can only be between 1 to 45 characters.")
	private String zip;
	
	@NotNull(message="Username is required.")
	@Size(min=1, max=20, message="Username can only be between 1 to 20 characters.")
	private String username;
	
	@NotNull(message="Password is required.")
	@Size(min=1, max=40, message="Password can only be between 1 to 40 characters.")
	private String password;
	
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
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
		return "RegisterModel [first=" + first + ", last=" + last + ", email=" + email + ", street=" + street
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + ", username=" + username + ", password="
				+ password + "]";
	}
	
}
