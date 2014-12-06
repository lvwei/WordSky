package com.wordsky.webapp.jdbcdao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.inject.Named;
import org.springframework.jdbc.core.RowMapper;
import com.wordsky.webapp.pojo.Chinese;

@Named
public class ChineseMapper implements RowMapper<Chinese> {

	@Override
	public Chinese mapRow(ResultSet rs, int numRow) throws SQLException {
		Chinese ch=new Chinese();
		ch.setId(rs.getInt(1));
        ch.setContent(rs.getString(2));
        ch.setOrigin(rs.getString(3));
        ch.setType(rs.getString(4));
		return ch;
	}

}
