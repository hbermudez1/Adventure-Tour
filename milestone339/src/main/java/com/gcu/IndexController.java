package com.gcu;

/*
 * Project Name: CST-339 Milestone Project
 * Version: 1.2
 * Module name: Index Controller Class
 * Module version: 1.0
 * Authors: Gabriel Cepleanu
 * Synopsis: This class provides the controller for the index page.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// Set the URL path to main directory
@Controller
@RequestMapping("/")
public class IndexController {
	@GetMapping("/")
	public String display(Model model) {
		// Send an attribute to the main page
		model.addAttribute("title", "Main Page");
		
		// Return name of the HTML document to load
		return "index";
	}
}
