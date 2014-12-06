package com.eece496.webapp.jdbcdao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.eece496.webapp.pojo.Ta;

public class TaMapper implements RowMapper<Ta> {

	@Override
	public Ta mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ta ta = new Ta();
		ta.setId(rs.getInt(1));
		ta.setUsername(rs.getString(2));
		ta.setHashedPassword(rs.getString(3));
		ta.setFirstName(rs.getString(4));
		ta.setLastName(rs.getString(5));
		ta.setAuthorization(rs.getInt(6));
		ta.setStudentNumber(rs.getString(8));
		return ta;
	}

}