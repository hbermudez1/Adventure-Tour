package com.gcu;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.UsersServiceInterface;
import com.gcu.model.RegisterModel;
import com.gcu.model.UserModel;

/*
 * Project Name: CST-339 Milestone Project
 * Version: 1.5
 * Module name: Register Controller Class
 * Module version: 1.2
 * Authors: Gabriel Cepleanu
 * Synopsis: This class provides the controller for the registration page.
 */

@Controller
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	private UsersServiceInterface usersService;
	
	@GetMapping("/")
	public String display(Model model) {
		model.addAttribute("registerModel", new RegisterModel());
		return "register";
	}
	
	@PostMapping("/doRegister")
	public String doLogin(@Valid RegisterModel rM, BindingResult bindingResult, Model model) {
		
		UserModel newUser = usersService.createNewUser(rM.getFirst(), rM.getLast(), rM.getEmail(), 
				rM.getStreet(), rM.getCity(), rM.getState(), rM.getZip(), rM.getUsername(), rM.getPassword());
		if (bindingResult.hasErrors() || newUser == null) 
		{
			model.addAttribute("registerModel", new RegisterModel());
			return "register";
		}
		usersService.addUser(newUser);
		
		model.addAttribute("userModel", newUser);
		return "RegisterSuccess";
	}
}
