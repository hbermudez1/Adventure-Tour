package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.gcu.business.AccountsService;

/*
 * Project Name: CST-339 Milestone Project
 * Version: 1.6
 * Module name: Security Configuration Class
 * Module version: 1.1
 * Authors: Gabriel Cepleanu
 * Synopsis: This class provides the configuration for security on the application.
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	AccountsService newAccountsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/product/**").authenticated()
		.antMatchers("/login/", "/register/").permitAll()
		.antMatchers("/api/v1/**").authenticated()
		.antMatchers(HttpMethod.POST, "/api/v1/**").authenticated()
		.antMatchers(HttpMethod.PUT, "/api/v1/**").authenticated()
		.antMatchers(HttpMethod.DELETE, "/api/v1/**").authenticated()
		.and().httpBasic().and().formLogin()
			.loginPage("/login/")
				.usernameParameter("username")
				.passwordParameter("password")
				.permitAll()
		.defaultSuccessUrl("/").and()
			.logout()
				.logoutUrl("/logout")
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.permitAll()
				.logoutSuccessUrl("/")
				.and().csrf().ignoringAntMatchers("/api/**");
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		TempPasswordEncoder temp = new TempPasswordEncoder();
		auth.userDetailsService(newAccountsService).passwordEncoder(temp);
	}
}
