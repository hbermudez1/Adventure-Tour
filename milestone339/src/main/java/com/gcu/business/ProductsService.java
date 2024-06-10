package com.gcu.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gcu.data.ProductsDataService;
import com.gcu.model.ProductModel;

/*
 * Project Name: CST-339 Milestone Project
 * Version: 1.6
 * Module name: Products Service Class
 * Module version: 1.2
 * Authors: Gabriel Cepleanu
 * Synopsis: This class provides a service for products.
 */

public class ProductsService implements ProductsServiceInterface {
	
	@Autowired
	ProductsDataService productsDAO;

	@Override
	public List<ProductModel> getProducts() {
		return productsDAO.getProducts();
	}

	@Override
	public ProductModel getProductById(int id) {
		return productsDAO.getProduct(id);
	}

	@Override
	public boolean addProduct(ProductModel newProduct) {
		return productsDAO.addProduct(newProduct) > 0;
	}

	@Override
	public ProductModel createProduct(String vacationName, Date startingDate, int daysOfTrip, String photoLink,
			String location, String description, double price) {
		return new ProductModel(-1, vacationName, startingDate, daysOfTrip, photoLink, location, description, price);
	}

	@Override
	public void init() {
		System.out.println("Creating Products Service Bean...");

	}

	@Override
	public void destroy() {
		System.out.println("Destroying Products Service Bean...");

	}

	@Override
	public boolean deleteProduct(int id) {
		return productsDAO.deleteProduct(id);
	}

	@Override
	public ProductModel updateProduct(int id, ProductModel updateProduct) {
		return productsDAO.updateProduct(id, updateProduct);
	}

	@Override
	public List<ProductModel> findProductsByName(String productName) {
		return productsDAO.searchProducts(productName);
	}

}
