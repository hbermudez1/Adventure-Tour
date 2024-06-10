package com.gcu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.gcu.business.*;

/*
 * Project Name: CST-339 Milestone Project
 * Version: 1.2
 * Module name: Project Configuration Class
 * Module version: 1.0
 * Authors: Gabriel Cepleanu
 * Synopsis: This class provides the Spring Beans configuration for the application.
 */

@Configuration
public class ProjectConfig {
	@Bean(name="usersService", initMethod="init", destroyMethod="destroy")
	@SessionScope
	public UsersServiceInterface getUsersService() {
		return new TempUsersService();
	}
	
	@Bean(name="loginService", initMethod="init", destroyMethod="destroy")
	@RequestScope
	public AccountsServiceInterface getLoginService() {
		return new TempAccountsService();
	}
	
	@Bean(name="productsService", initMethod="init", destroyMethod="destroy")
	@SessionScope
	public ProductsServiceInterface getProductsService() {
		return new ProductsService();
	}
}
