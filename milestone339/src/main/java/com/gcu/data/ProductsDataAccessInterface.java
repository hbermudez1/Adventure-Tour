package com.gcu.data;

import java.util.List;

/*
 * Project Name: CST-339 Milestone Project
 * Version: 1.6
 * Module name: Products Data Access Interface
 * Module version: 1.1
 * Authors: Gabriel Cepleanu
 * Synopsis: This class provides an interface for products data services.
 */

public interface ProductsDataAccessInterface<T> {
	public T getProduct(int id);
	public List<T> getProducts();
	public List<T> searchProducts(String searchTerm);
	public int addProduct(T newProduct);
	public boolean deleteProduct(int id);
	public T updateProduct(int idToUpdate, T updateProduct);
}
