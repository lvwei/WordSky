package com.wordsky.webapp.jdbcdao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Named;

import org.springframework.jdbc.core.RowMapper;

import com.wordsky.webapp.pojo.Chinese;
import com.wordsky.webapp.pojo.Remember_p;

@Named
public class Remember_pMapper implements RowMapper<Remember_p> {

	@Override
	public Remember_p mapRow(ResultSet rs, int numRow) throws SQLException {
		Remember_p rp=new Remember_p();
		rp.setId(rs.getInt(1));
        rp.setContent(rs.getString(2));
        rp.setTarget(rs.getString(3));
        rp.setType(rs.getString(4));
		return rp;
	}

}
