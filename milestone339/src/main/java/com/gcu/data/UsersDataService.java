package com.gcu.data;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.gcu.model.UserModel;
import com.gcu.model.UsersMapper;

@Repository
public class UsersDataService implements UsersDataAccessInterface<UserModel> {
	
	@Autowired
	DataSource dataSource;
	JdbcTemplate jdbcTemplate;
	
	public UsersDataService(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	@Override
	public UserModel getUser(int id) {
		UserModel user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE USER_ID = ?", new UsersMapper(), new Object[] {id});
		return user;
	}

	@Override
	public List<UserModel> getUsers() {
		return jdbcTemplate.query("SELECT * FROM users", new UsersMapper());
	}

	@Override
	public int addUser(UserModel newUser) {
		return jdbcTemplate.update("INSERT INTO users (FIRST_NAME, LAST_NAME, EMAIL, STREET, CITY, STATE, ZIP, USERNAME, PASSWORD) VALUES (?,?,?,?,?,?,?,?,?)",
				newUser.getFirst(),
				newUser.getLast(),
				newUser.getEmail(),
				newUser.getStreet(),
				newUser.getCity(),
				newUser.getState(),
				newUser.getZip(),
				newUser.getUsername(),
				newUser.getPassword());
	}

	@Override
	public boolean deleteUser(int id) {
		int result = jdbcTemplate.update("DELETE FROM users WHERE USER_ID = ?", new Object[] {id});
		return result > 0;
	}

	@Override
	public UserModel updateUser(int idToUpdate, UserModel updateUser) {
		int result = jdbcTemplate.update(
				"UPDATE products SET FIRST_NAME = ?, LAST_NAME = ?, EMAIL = ?, STREET = ?, CITY = ?, STATE = ?, ZIP = ?, USERNAME = ?, PASSWORD = ? WHERE USER_ID = ?",
				updateUser.getFirst(),
				updateUser.getLast(),
				updateUser.getEmail(),
				updateUser.getStreet(),
				updateUser.getCity(),
				updateUser.getState(),
				updateUser.getZip(),
				updateUser.getUsername(),
				updateUser.getPassword(),
				idToUpdate);
		if (result > 0) {
			return updateUser;
		}
		return null;
	}

	@Override
	public UserModel authenticate(String username, String password) {
		List<UserModel> users = jdbcTemplate.query("SELECT * FROM users WHERE USERNAME LIKE ? AND PASSWORD LIKE ?", new UsersMapper(), new Object[] {username, password});
		if (users.size() == 1) {
			return users.get(0);
		}
		return null;
	}

	@Override
	public UserModel getUserByUsername(String username) {
		UserModel user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE USERNAME = ?", new UsersMapper(), new Object[] {username});
		return user;
	}

}
