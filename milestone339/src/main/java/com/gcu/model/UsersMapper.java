package com.gcu.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UsersMapper implements RowMapper<UserModel> {
	
	/*
	 * users table
	 * 
	 * Class Fields    | Table Fields
	 * --------------------------------------------------
	 * id				USER_ID
	 * first			FIRST_NAME
	 * last				LAST_NAME
	 * email			EMAIL
	 * street			STREET
	 * city				CITY
	 * state			STATE
	 * zip				ZIP
	 * username			USERNAME
	 * password			PASSWORD
	 * 
	 */

	@Override
	public UserModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserModel user = new UserModel(
				rs.getInt("USER_ID"),
				rs.getString("FIRST_NAME"),
				rs.getString("LAST_NAME"),
				rs.getString("EMAIL"),
				rs.getString("STREET"),
				rs.getString("CITY"),
				rs.getString("STATE"),
				rs.getString("ZIP"),
				rs.getString("USERNAME"),
				rs.getString("PASSWORD"));
		return user;
	}

}
