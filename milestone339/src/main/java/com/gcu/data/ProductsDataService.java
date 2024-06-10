package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gcu.model.ProductModel;
import com.gcu.model.ProductsMapper;

/*
 * Project Name: CST-339 Milestone Project
 * Version: 1.6
 * Module name: Products Data Service Class
 * Module version: 1.1
 * Authors: Gabriel Cepleanu
 * Synopsis: This class provides a data service for products.
 */

@Repository
public class ProductsDataService implements ProductsDataAccessInterface<ProductModel> {
	
	@Autowired
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	
	public ProductsDataService(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	@Override
	public ProductModel getProduct(int id) {
		ProductModel product = null;
		try {
			product = jdbcTemplate.queryForObject("SELECT * FROM products WHERE PRODUCT_ID = ?", new ProductsMapper(), new Object[] {id});
		} catch (Exception e) {
			System.out.println("Product with ID " + id + " was not found.");
		}
		
		return product;
	}

	@Override
	public List<ProductModel> getProducts() {
		return jdbcTemplate.query("SELECT * FROM products", new ProductsMapper());
	}

	@Override
	public List<ProductModel> searchProducts(String searchTerm) {
		return jdbcTemplate.query("SELECT * FROM products WHERE VACATION_NAME LIKE ?", new ProductsMapper(), new Object[] {"%" + searchTerm + "%"});
	}

	@Override
	public int addProduct(ProductModel newProduct) {
		return jdbcTemplate.update("INSERT INTO products (VACATION_NAME, START_DATE, DAYS_OF_TRIP, PHOTO_LINK, LOCATION, DESCRIPTION, PRICE) VALUES (?,?,?,?,?,?,?)",
				newProduct.getVacationName(),
				newProduct.getStartingDate(),
				newProduct.getDaysOfTrip(),
				newProduct.getPhotoLink(),
				newProduct.getLocation(),
				newProduct.getDescription(),
				newProduct.getPrice());
	}

	@Override
	public boolean deleteProduct(int id) {
		int result = jdbcTemplate.update("DELETE FROM products WHERE PRODUCT_ID = ?", new Object[] {id});
		return result > 0;
	}

	@Override
	public ProductModel updateProduct(int idToUpdate, ProductModel updateProduct) {
		int result = jdbcTemplate.update(
				"UPDATE products SET VACATION_NAME = ?, START_DATE = ?, DAYS_OF_TRIP = ?, PHOTO_LINK = ?, LOCATION = ?, DESCRIPTION = ?, PRICE = ? WHERE PRODUCT_ID = ?",
				updateProduct.getVacationName(),
				updateProduct.getStartingDate(),
				updateProduct.getDaysOfTrip(),
				updateProduct.getPhotoLink(),
				updateProduct.getLocation(),
				updateProduct.getDescription(),
				updateProduct.getPrice(),
				idToUpdate);
		if (result > 0) {
			return updateProduct;
		}
		return null;
	}


}
