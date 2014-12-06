package com.eece496.webapp.jdbcdao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.inject.Named;

import org.springframework.jdbc.core.RowMapper;

import com.eece496.webapp.pojo.Subsection;

@Named
public class SubsectionMapper implements RowMapper<Subsection> {

	@Override
	public Subsection mapRow(ResultSet rs, int numRow) throws SQLException {
		Subsection sub = new Subsection();
		sub.setId(rs.getInt(1));
		sub.setStartTime(new Date());
		sub.getStartTime().setTime(rs.getTime(2).getTime());
		sub.setEndTime(new Date());
		sub.getEndTime().setTime(rs.getTime(3).getTime());
		sub.setRoom(rs.getString(4));
		return sub;
	}

}
