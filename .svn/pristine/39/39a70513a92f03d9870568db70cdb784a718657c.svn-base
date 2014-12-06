package com.eece496.webapp.jdbcdao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.eece496.webapp.dao.CourseDAO;
import com.eece496.webapp.jdbcdao.mapper.CourseMapper;
import com.eece496.webapp.pojo.Course;

@Named
public class CourseJdbcDAO implements CourseDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public Course getCourse(int courseId) {
		Course course = null;
		final String SQL_QUERY = "SELECT * FROM courses where id = ?";
		try {
			course = this.jdbcTemplate.queryForObject(SQL_QUERY,
					new Object[] { courseId }, new CourseMapper());
		} catch (Exception sqlEx) {

		}
		return course;
	}

	@Override
	public DualListModel<Course> getCourses(int userId) {

		List<Course> sourceList = this.getCoursesNotManagedByAdmin(userId);

		List<Course> targetList = this.getCoursesManagedByAdmin(userId);

		DualListModel<Course> dualList = new DualListModel<Course>(sourceList,
				targetList);

		return dualList;
	}

	@Override
	public Course getCourseForTa(int userId) {
		Course course = null;
		final String SQL_QUERY = "SELECT * "
				+ "FROM courses c, ta_marks_course tmc "
				+ "WHERE c.id = tmc.course_id and tmc.user_id = ?";
		try {
			course = this.jdbcTemplate.queryForObject(SQL_QUERY,
					new Object[] { userId }, new CourseMapper());
		} catch (Exception sqlEx) {

		}
		return course;
	}

	private List<Course> getCoursesManagedByAdmin(int userId) {
		List<Course> list = null;
		final String SQL_QUERY = "SELECT * "
				+ "FROM courses c, admin_manages_courses amc "
				+ "WHERE c.id = amc.course_id AND amc.user_id = ?";

		try {
			list = this.jdbcTemplate.query(SQL_QUERY, new Object[] { userId },
					new CourseMapper());
		} catch (Exception sqlEx) {

		}
		return list;
	}

	private List<Course> getCoursesNotManagedByAdmin(int userId) {
		List<Course> list = null;
		final String SQL_QUERY = "SELECT * " + "FROM courses c1 "
				+ "WHERE c1.id not in " + "(SELECT c2.id "
				+ "FROM courses c2, admin_manages_courses amc "
				+ "WHERE c2.id = amc.course_id AND amc.user_id = ?)";

		try {
			list = this.jdbcTemplate.query(SQL_QUERY, new Object[] { userId },
					new CourseMapper());
		} catch (Exception sqlEx) {

		}
		return list;
	}

}
