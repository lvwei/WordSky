package com.eece496.webapp.jdbcdao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.eece496.webapp.pojo.Student;

public class StudentMapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student student = new Student();
		student.setId(rs.getInt(1));
		student.setUsername(rs.getString(2));
		student.setHashedPassword(rs.getString(3));
		student.setFirstName(rs.getString(4));
		student.setLastName(rs.getString(5));
		student.setAuthorization(rs.getInt(6));
		student.setStudentNumber(rs.getString(8));
		return student;
	}

}