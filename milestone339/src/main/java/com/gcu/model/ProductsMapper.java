package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/*
 * Project Name: CST-339 Milestone Project
 * Version: 1.3
 * Module name: Products Mapper Class
 * Module version: 1.0
 * Authors: Gabriel Cepleanu
 * Synopsis: This class provides the mapper between the database table and model.
 */

public class ProductsMapper implements RowMapper<ProductModel> {
	
	/*
	 * products table
	 * 
	 * Class Fields    | Table Fields
	 * --------------------------------------------------
	 * id				PRODUCT_ID
	 * vacationName		VACATION_NAME
	 * startingDate		START_DATE
	 * daysOfTrip		DAYS_OF_TRIP
	 * photoLink		PHOTO_LINK
	 * location			LOCATION
	 * description		DESCRIPTION
	 * price			PRICE
	 * 
	 */

	@Override
	public ProductModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProductModel product = new ProductModel(
				rs.getInt("PRODUCT_ID"),
				rs.getString("VACATION_NAME"),
				rs.getDate("START_DATE"),
				rs.getInt("DAYS_OF_TRIP"),
				rs.getString("PHOTO_LINK"),
				rs.getString("LOCATION"),
				rs.getString("DESCRIPTION"), 
				rs.getDouble("PRICE"));
		return product;
	}

}
