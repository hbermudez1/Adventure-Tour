package com.gcu.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * Project Name: CST-339 Milestone Project
 * Version: 1.2
 * Module name: Product Model Class
 * Module version: 1.0
 * Authors: Gabriel Cepleanu
 * Synopsis: This class provides a model for a product.
 */

public class ProductModel {
	private int id;
	
	@NotNull(message="Vacation Name is required.")
	@Size(min=1, max=75, message="Vacation Name can only be between 1 to 75 characters.")
	private String vacationName;
	
	@NotNull(message="Starting Date is required.")
	private Date startingDate;
	
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
	
	public ProductModel() {
		
	}

	public ProductModel(int id, String vacationName, Date startingDate, int daysOfTrip, String photoLink,
			String location, String description, double price) {
		super();
		this.id = id;
		this.vacationName = vacationName;
		this.startingDate = startingDate;
		this.daysOfTrip = daysOfTrip;
		this.photoLink = photoLink;
		this.location = location;
		this.description = description;
		this.price = price;
	}

	public String getVacationName() {
		return vacationName;
	}

	public void setVacationName(String vacationName) {
		this.vacationName = vacationName;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
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

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ProductModel [id=" + id + ", vacationName=" + vacationName + ", startingDate=" + startingDate
				+ ", daysOfTrip=" + daysOfTrip + ", photoLink=" + photoLink + ", location=" + location
				+ ", description=" + description + ", price=" + price + "]";
	}


	
	
}
