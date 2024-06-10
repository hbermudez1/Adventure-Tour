package com.gcu.business;

import java.util.Date;
import java.util.List;

import com.gcu.model.ProductModel;

public interface ProductsServiceInterface {
	public List<ProductModel> getProducts();
	public ProductModel getProductById(int id);
	public boolean addProduct(ProductModel newProduct);
	public ProductModel createProduct(String vacationName, Date startingDate, int daysOfTrip, String photoLink,
			String location, String description, double price);
	public boolean deleteProduct(int id);
	public ProductModel updateProduct(int id, ProductModel updateProduct);
	public List<ProductModel> findProductsByName(String productName);
	public void init();
	public void destroy();
}
