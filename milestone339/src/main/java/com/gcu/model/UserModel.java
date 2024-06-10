package com.gcu.model;

/*
 * Project Name: CST-339 Milestone Project
 * Version: 1.2
 * Module name: User Model Class
 * Module version: 1.0
 * Authors: Gabriel Cepleanu
 * Synopsis: This class provides the model for a user.
 */

public class UserModel {
	private int id;
	private String first;
	private String last;
	private String email;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String username;
	private String password;
	
	public UserModel(int id, String first, String last, String email, String street, String city, String state, String zip,
			String username, String password) {
		super();
		this.id = id;
		this.first = first;
		this.last = last;
		this.email = email;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.username = username;
		this.password = password;
	}
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", first=" + first + ", last=" + last + ", email=" + email + ", street=" + street
				+ ", city=" + city + ", state=" + state + ", zip=" + zip + ", username=" + username + ", password="
				+ password + "]";
	}
	
	
	
}
