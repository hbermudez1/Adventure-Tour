package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gcu.data.UsersDataService;
import com.gcu.model.UserModel;

/*
 * Project Name: CST-339 Milestone Project
 * Version: 1.5
 * Module name: Accounts Service
 * Module version: 1.0
 * Authors: Gabriel Cepleanu
 * Synopsis: This class provides a service for account authentication.
 */

@Service
public class AccountsService implements UserDetailsService {
	
	@Autowired
	private UsersDataService usersService;
	
	public AccountsService(UsersDataService service) {
		usersService = service;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("AccountsService is searching for " + username);
		UserModel user = usersService.getUserByUsername(username);
		System.out.println(user);
		
		if (user != null) {
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("USER"));
			return new User(user.getUsername(), user.getPassword(), authorities);
		}
		else {
			System.out.println("User not found.");
			throw new UsernameNotFoundException("Username " + username + " was not found");
		}
	}

}
