package com.gcu.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gcu.business.ProductsServiceInterface;
import com.gcu.model.ProductModel;

/*
 * Project Name: CST-339 Milestone Project
 * Version: 1.6
 * Module name: Products Rest Controller
 * Module version: 1.1
 * Authors: Gabriel Cepleanu
 * Synopsis: This class provides the controller for the products REST service.
 */

@RestController
@RequestMapping("/api/v1/products")
public class ProductsRestController {

	@Autowired
	ProductsServiceInterface productsService;
	
	@GetMapping("/")
	public ResponseEntity<?> getAllProducts() {
		try {
			List<ProductModel> products = productsService.getProducts();
			if (products == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else {
				return new ResponseEntity<>(products, HttpStatus.OK);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProduct(@PathVariable(name="id") int id) {
		try {
			ProductModel product = productsService.getProductById(id);
			if (product != null) {
				return new ResponseEntity<>(product, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/search/{productName}")
	public ResponseEntity<?> searchProducts(@PathVariable(name="productName") String productName) {
		List<ProductModel> products = null;
		try {
			products = productsService.findProductsByName(productName);
			if (products != null && products.size() > 0) {
				return new ResponseEntity<>(products, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/")
	public ResponseEntity<?> addProduct(@RequestBody ProductModel newProduct) {
		boolean results = false;
		try {
			results = productsService.addProduct(newProduct);
			if (results) {
				return new ResponseEntity<>(results, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(name="id") int id) {
		boolean results = false;
		try {
			results = productsService.deleteProduct(id);
			if (results) {
				return new ResponseEntity<>(results, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/")
	public ResponseEntity<?> updateProduct(@RequestBody ProductModel updateProduct) {
		ProductModel results = null;
		try {
			results = productsService.updateProduct(updateProduct.getId(), updateProduct);
			if (results != null) {
				return new ResponseEntity<>(results, HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
