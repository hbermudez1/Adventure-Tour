package com.gcu;

import javax.validation.Valid;

/*
 * Project Name: CST-339 Milestone Project
 * Version: 1.1
 * Module name: Login Controller Class
 * Module version: 1.0
 * Authors: Harold Bermudez
 * Synopsis: This class provides the controller for the login page.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gcu.business.AccountsServiceInterface;
import com.gcu.business.UsersServiceInterface;
import com.gcu.model.LoginModel;
import com.gcu.model.UserModel;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

/*
 * Project Name: CST-339 Milestone Project
 * Version: 1.2
 * Module name: Login Controller Class
 * Module version: 1.1
 * Authors: Harold Bermudez and Gabriel Cepleanu
 * Synopsis: This class provides a model for user login.
 */

@Controller
@RequestMapping("/login")

public class LoginController {
	
	@Autowired
	private AccountsServiceInterface loginService;
	
	@GetMapping("/")
	public String display(Model model) {
		//Display Login form view
		model.addAttribute("title", "Login Form");
		model.addAttribute("loginModel", new LoginModel());
		return "login";
		
	}
	@PostMapping("/doLogin")
	public String doLogin(@Valid LoginModel loginModel, BindingResult bindingResult, Model model) 
	{
		UserModel user = loginService.authenticate(loginModel.getUsername(), loginModel.getPassword());
		
		if (bindingResult.hasErrors() || user == null) 
		{
			System.out.println("Error!");
			model.addAttribute("title", "Login Form");
			return "login";
		}
		model.addAttribute("userModel", user);
		return "LoginSuccess";
	}
}