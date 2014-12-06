package com.eece496.webapp.jdbcdao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.eece496.webapp.pojo.Course;

public class CourseMapper implements RowMapper<Course> {

	@Override
	public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
		Course course = new Course();
		course.setId(rs.getInt(1));
		course.setCourseName(rs.getString(2));
		course.setStartDate(rs.getDate(3));
		course.setEndDate(rs.getDate(4));
		return course;
	}

}