package com.gcu.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gcu.model.ProductModel;

public class TempProductsService implements ProductsServiceInterface {
	
	private int currentId;
	private List<ProductModel> products;

	@Override
	public List<ProductModel> getProducts() {

		return products;
	}

	@Override
	public ProductModel getProductById(int id) {

		return null;
	}

	@Override
	public boolean addProduct(ProductModel newProduct) {
		products.add(newProduct);
		return true;
	}

	@Override
	public ProductModel createProduct(String vacationName, Date startingDate, int daysOfTrip, String photoLink,
			String location, String description, double price) {

		return new ProductModel(currentId++, vacationName, startingDate, daysOfTrip, photoLink, location, description, price);
	}

	@Override
	public void init() {
		System.out.println("Creating Product Service Bean.");
		currentId = 0;
		products = new ArrayList<ProductModel>();
	}

	@Override
	public void destroy() {
		System.out.println("Destroying Product Service Bean.");

	}

	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProductModel updateProduct(int it, ProductModel updateProduct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductModel> findProductsByName(String productName) {
		// TODO Auto-generated method stub
		return null;
	}

}
