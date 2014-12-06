package com.eece496.webapp.jdbcdao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.eece496.webapp.pojo.Section;

public class SectionMapper implements RowMapper<Section> {

	@Override
	public Section mapRow(ResultSet rs, int rowNum) throws SQLException {
		Section section = new Section();
		section.setId(rs.getInt(1));
		section.setRoom(rs.getString(2));
		section.setStartTime(new Date());
		section.getStartTime().setTime(rs.getTime(3).getTime());
		section.setEndTime(new Date());
		section.getEndTime().setTime(rs.getTime(4).getTime());
		return section;
	}

}
