package com.eece496.webapp.jdbcdao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.jdbc.core.RowMapper;

import com.eece496.webapp.dao.UserDAO;
import com.eece496.webapp.pojo.Mark;

@Named
public class MarkMapper implements RowMapper<Mark> {
	
	@Inject
	private UserDAO userDao;

	@Override
	public Mark mapRow(ResultSet rs, int rowNum) throws SQLException {
		Mark mark = new Mark();
		mark.setId(rs.getInt(1));
		mark.setMark(rs.getInt(2));
		mark.setStudentId(rs.getInt(3));
		mark.setStudent(this.userDao.getStudent(mark.getStudentId()));
		mark.setHoldDateId(rs.getInt(4));
		mark.setIndividualMark(rs.getBoolean(5));
		return mark;
	}

}
