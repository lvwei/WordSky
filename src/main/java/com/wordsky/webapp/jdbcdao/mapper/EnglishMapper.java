package com.wordsky.webapp.jdbcdao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Named;

import org.springframework.jdbc.core.RowMapper;

import com.wordsky.webapp.pojo.Chinese;
import com.wordsky.webapp.pojo.English;

@Named
public class EnglishMapper implements RowMapper<English> {

	@Override
	public English mapRow(ResultSet rs, int numRow) throws SQLException {
		English en=new English();
        en.setId(rs.getInt(1));
        en.setContent(rs.getString(2));
        en.setDescription(rs.getString(3));
		return en;
	}

}
