package com.eece496.webapp.jdbcdao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.jdbc.core.RowMapper;

import com.eece496.webapp.dao.UserDAO;
import com.eece496.webapp.pojo.HoldDate;

@Named
public class HoldDateMapper implements RowMapper<HoldDate> {

	@Inject
	private UserDAO userDao;

	@Override
	public HoldDate mapRow(ResultSet rs, int numRow) throws SQLException {
		HoldDate holdDate = new HoldDate();
		int ta_id, student_id, absent_student_id;
		holdDate.setId(rs.getInt(1));
		holdDate.setDate(rs.getDate(2));
		ta_id = rs.getInt(3);
		student_id = rs.getInt(4);
		absent_student_id = rs.getInt(5);
		holdDate.setStudentAbsent(rs.getBoolean(7));
		holdDate.setApprovedAbsent(rs.getBoolean(8));
		holdDate.setQuestion(rs.getString(9));

		holdDate.setTa(this.userDao.getTa(ta_id));
		holdDate.setStudent(this.userDao.getStudent(student_id));
		if (holdDate.getStudentAbsent()) {
			holdDate.setAbsentStudent(this.userDao
					.getStudent(absent_student_id));
		}
		return holdDate;
	}

}
