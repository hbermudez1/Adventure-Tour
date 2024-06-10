package com.gcu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.ProductsServiceInterface;
import com.gcu.model.ProductCreateModel;
import com.gcu.model.ProductModel;

/*
 * Project Name: CST-339 Milestone Project
 * Version: 1.4
 * Module name: Product Controller Class
 * Module version: 1.1
 * Authors: Gabriel Cepleanu
 * Synopsis: This class provides the controller for the product pages.
 */

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductsServiceInterface productsService;
	
	@GetMapping("/create")
	public String createProduct(Model model) {
		model.addAttribute("productModel", new ProductCreateModel());
		return "createProduct";
	}
	
	@PostMapping("/delete")
	public String deleteProduct(@Valid ProductModel productModel, BindingResult bindingResult, Model model) {
		productsService.deleteProduct(productModel.getId());
		return showProducts(model);
	}
	
	@PostMapping("/edit")
	public String editProduct(ProductCreateModel productModel, Model model) {
		model.addAttribute("productModel", productModel);
		return "editProduct";
	}
	
	@PostMapping("/doUpdate")
	public String doUpdate(@Valid ProductCreateModel pm, BindingResult bindingResult, Model model) throws ParseException {
		ProductModel update = productsService.createProduct(pm.getVacationName(), new SimpleDateFormat("yyyy-MM-dd").parse(pm.getStartingDate()), pm.getDaysOfTrip(),
				pm.getPhotoLink(), pm.getLocation(), pm.getDescription(), pm.getPrice());
		update.setId(pm.getId());
		
		productsService.updateProduct(pm.getId(), update);
		
		return showProducts(model);
	}
	
	@GetMapping("/all")
	public String showProducts(Model model) {
		List<ProductModel> products = productsService.getProducts();
		model.addAttribute("products", products);
		return "products";
	}
	
	@PostMapping("/doCreate")
	public String doCreate(@Valid ProductCreateModel pm, BindingResult bindingResult, Model model) throws ParseException {
		
		if (bindingResult.hasErrors()) {
			System.out.println("Error creating product.");
			model.addAttribute("productModel", new ProductCreateModel());
			return "createProduct";
		}
		
		ProductModel temp = productsService.createProduct(pm.getVacationName(), new SimpleDateFormat("yyyy-MM-dd").parse(pm.getStartingDate()), pm.getDaysOfTrip(),
				pm.getPhotoLink(), pm.getLocation(), pm.getDescription(), pm.getPrice());
		productsService.addProduct(temp);
		//model.addAttribute("order", temp);
		return showProducts(model);
	}
	

}
