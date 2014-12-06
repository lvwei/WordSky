package com.eece496.webapp.jdbcdao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.eece496.webapp.pojo.User;

public class AdminMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getInt(1));
		user.setUsername(rs.getString(2));
		user.setHashedPassword(rs.getString(3));
		user.setFirstName(rs.getString(4));
		user.setLastName(rs.getString(5));
		user.setAuthorization(rs.getInt(6));
		return user;
	}

}