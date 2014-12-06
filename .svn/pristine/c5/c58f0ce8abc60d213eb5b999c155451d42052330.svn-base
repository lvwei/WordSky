package com.eece496.webapp.jdbcdao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.jdbc.core.RowMapper;

import com.eece496.webapp.dao.UserDAO;
import com.eece496.webapp.pojo.MarkTableRow;
import com.eece496.webapp.pojo.Student;

@Named
public class MarkTableRowMapper implements RowMapper<MarkTableRow> {

	@Inject
	private UserDAO userDao;

	@Override
	public MarkTableRow mapRow(ResultSet rs, int rowNum) throws SQLException {
		int markId = rs.getInt(1);
		int studentId = rs.getInt(2);
		int mark = rs.getInt(3);
		String course = rs.getString(4);
		String date = DateFormat.getDateInstance().format(rs.getDate(5));
		Date startTime = new Date(rs.getTime(6).getTime());
		Date endTime = new Date(rs.getTime(7).getTime());
		boolean isIndividualMark = rs.getBoolean(8);

		String sectionTime = DateFormat.getTimeInstance().format(startTime)
				+ " - " + DateFormat.getTimeInstance().format(endTime);
		Student student = this.userDao.getStudent(studentId);
		String studentNumber = student.getStudentNumber();
		String firstName = student.getFirstName();
		String lastName = student.getLastName();

		boolean isModified = false;
		MarkTableRow row = new MarkTableRow(markId, studentNumber, firstName,
				lastName, mark, course, date, sectionTime, isIndividualMark);
		return row;
	}

}
