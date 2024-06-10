package com.gcu.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * Project Name: CST-339 Milestone Project
 * Version: 1.2
 * Module name: Product Creation Model Class
 * Module version: 1.0
 * Authors: Gabriel Cepleanu
 * Synopsis: This class provides a model for creating a product.
 * This is a temporary class that will be removed in a future version.
 */

public class ProductCreateModel {
	
	private int id;

	@NotNull(message="Vacation Name is required.")
	@Size(min=1, max=75, message="Vacation Name can only be between 1 to 75 characters.")
	private String vacationName;
	
	@NotNull(message="Starting Date is required.")
	@Size(min=1, message="Date must be set.")
	private String startingDate;
	
	@NotNull(message="Days of Trip is required.")
	private int daysOfTrip;
	
	@NotNull(message="Photo Link is required.")
	@Size(min=1, max=75, message="Photo Link can only be between 1 to 50 characters.")
	private String photoLink;
	
	@NotNull(message="Location is required.")
	@Size(min=1, max=75, message="Location can only be between 1 to 50 characters.")
	private String location;
	
	@NotNull(message="Description is required.")
	@Size(min=1, max=200, message="Description can only be between 1 to 200 characters.")
	private String description;
	
	@NotNull(message="Price is required.")
	private double price;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVacationName() {
		return vacationName;
	}

	public void setVacationName(String vacationName) {
		this.vacationName = vacationName;
	}

	public String getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(String startingDate) {
		this.startingDate = startingDate;
	}

	public int getDaysOfTrip() {
		return daysOfTrip;
	}

	public void setDaysOfTrip(int daysOfTrip) {
		this.daysOfTrip = daysOfTrip;
	}

	public String getPhotoLink() {
		return photoLink;
	}

	public void setPhotoLink(String photoLink) {
		this.photoLink = photoLink;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
