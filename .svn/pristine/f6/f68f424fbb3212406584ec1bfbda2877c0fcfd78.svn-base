package com.eece496.webapp.jdbcdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DualListModel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.eece496.webapp.dao.UserDAO;
import com.eece496.webapp.jdbcdao.mapper.AdminMapper;
import com.eece496.webapp.jdbcdao.mapper.StudentMapper;
import com.eece496.webapp.jdbcdao.mapper.TaMapper;
import com.eece496.webapp.pojo.Course;
import com.eece496.webapp.pojo.Student;
import com.eece496.webapp.pojo.Ta;
import com.eece496.webapp.pojo.User;
import com.eece496.webapp.service.Sha1HashService;

@Named
public class UserJdbcDAO implements UserDAO {

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	@Inject
	private Sha1HashService sha1HashService;

	@Override
	public boolean addTa(Ta ta) {
		final String INSERT_SQL = "insert into ta (id, student_number) values(?, ?)";
		if (!this.addUser(ta)) {
			return false;
		}
		try {
			this.jdbcTemplate.update(INSERT_SQL, ta.getId(),
					ta.getStudentNumber());
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public User getUser(String username, String password) {
		int userId = this.getUserId(username, password);
		if (userId <= 0) {
			return null;
		}
		int auth = this.getUserAuth(userId);
		if (auth == User.ADMIN) {
			return this.getAdmin(userId);
		} else if (auth == User.TA) {
			return this.getTa(userId);
		} else if (auth == User.STUDENT) {
			return this.getStudent(userId);
		}
		return null;
	}

	@Override
	public List<Ta> getTaListMarkCourse(int courseId) {
		List<Ta> taList = new LinkedList<Ta>();
		final String SQL_QUERY = "SELECT * FROM users, ta "
				+ "WHERE users.id = ta.id AND users.id IN ("
				+ "SELECT user_id FROM ta_marks_course "
				+ "WHERE course_id = ?" + ")";
		try {
			taList = this.jdbcTemplate.query(SQL_QUERY,
					new Object[] { courseId }, new TaMapper());
		} catch (Exception ex) {
		}
		return taList;
	}

	@Override
	public List<Student> getStudentListRegisterInCourse(int courseId) {
		List<Student> studentList = new LinkedList<Student>();
		final String SQL_QUERY = "SELECT * FROM users, students WHERE users.id = students.id AND users.id IN ( SELECT user_id FROM students_register_courses  WHERE course_id = ? )";
		try {
			studentList = this.jdbcTemplate.query(SQL_QUERY,
					new Object[] { courseId }, new StudentMapper());
		} catch (Exception ex) {
		}
		return studentList;
	}

	@Override
	public List<Student> getGroupStudent(int groupId) {
		List<Student> studentList = new LinkedList<Student>();
		final String SQL_QUERY = "SELECT * FROM users, students WHERE users.id = students.id AND users.id IN ( SELECT user_id FROM students_in_groups  WHERE group_id= ? )";
		try {
			studentList = this.jdbcTemplate.query(SQL_QUERY,
					new Object[] { groupId }, new StudentMapper());
		} catch (Exception ex) {
		}
		return studentList;
	}

	@Override
	public Ta getTaOfHolddate(int holddateId) {
		int userId = -1;
		final String SQL_QUERY = "select ta_id from hold_dates where id = ?";
		try {
			userId = this.jdbcTemplate.queryForInt(SQL_QUERY,
					new Object[] { holddateId });
		} catch (Exception ex) {
		}
		return this.getTa(userId);
	}

	@Override
	public Student getStudentOfHolddate(int holddateId) {
		int userId = -1;
		final String SQL_QUERY = "select student_id from hold_dates where id = ?";
		try {
			userId = this.jdbcTemplate.queryForInt(SQL_QUERY,
					new Object[] { holddateId });
		} catch (Exception ex) {
		}
		return this.getStudent(userId);
	}

	@Override
	public Student getAbsentStudentOfHolddate(int holddateId) {
		int userId = -1;
		final String SQL_QUERY = "select absent_student_id from hold_dates where id = ?";
		try {
			userId = this.jdbcTemplate.queryForInt(SQL_QUERY,
					new Object[] { holddateId });
		} catch (Exception ex) {
		}
		return this.getStudent(userId);
	}

	private int getUserId(String username, String password) {
		int userId = -1;
		final String SQL_QUERY = "select id from users where username LIKE ? and password LIKE ?";
		try {
			userId = this.jdbcTemplate.queryForInt(SQL_QUERY, new Object[] {
					username, password });
		} catch (Exception ex) {
		}
		return userId;
	}

	private int getUserAuth(int userId) {
		int auth = -1;
		final String SQL_QUERY = "select authorization from users where id = ?";
		try {
			auth = this.jdbcTemplate.queryForInt(SQL_QUERY,
					new Object[] { userId });
		} catch (Exception ex) {
		}
		return auth;
	}

	private User getAdmin(int userId) {
		User user = null;
		final String SQL_QUERY = "select * from users where id = ?";
		try {
			user = this.jdbcTemplate.queryForObject(SQL_QUERY,
					new Object[] { userId }, new AdminMapper());
		} catch (Exception ex) {
		}
		return user;
	}

	@Override
	public Ta getTa(int userId) {
		Ta ta = null;
		final String SQL_QUERY = "select * from users, ta where users.id = ? and users.id = ta.id";
		try {
			ta = this.jdbcTemplate.queryForObject(SQL_QUERY,
					new Object[] { userId }, new TaMapper());
		} catch (Exception ex) {
		}
		return ta;
	}

	@Override
	public Student getStudent(int userId) {
		Student student = null;
		final String SQL_QUERY = "select * from users, students where users.id = ? and users.id = students.id";
		try {
			student = this.jdbcTemplate.queryForObject(SQL_QUERY,
					new Object[] { userId }, new StudentMapper());
		} catch (Exception ex) {
		}
		return student;
	}


	@Override
	public boolean addTaMarksCourse(int taId, int courseId) {
		final String INSERT_SQL = "insert into ta_marks_course (user_id, course_id) values(?, ?)";
		try {
			this.jdbcTemplate.update(INSERT_SQL, taId, courseId);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public boolean addStudentRegisterCourse(int studentId, int courseId) {
		final String INSERT_SQL = "insert into students_register_courses (user_id, course_id) values(?, ?)";
		try {
			this.jdbcTemplate.update(INSERT_SQL, studentId, courseId);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public boolean addStudentInGroup(int studentId, int groupId) {
		final String INSERT_SQL = "insert into students_in_groups (user_id, group_id) values(?, ?)";
		try {
			this.jdbcTemplate.update(INSERT_SQL, studentId, groupId);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public boolean addStudent(Student student) {
		final String INSERT_SQL = "insert into students (id, student_number) values(?, ?)";
		if (!this.addUser(student)) {
			return false;
		}
		try {
			this.jdbcTemplate.update(INSERT_SQL, student.getId(),
					student.getStudentNumber());
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteTaMarksCourse(int taId, int courseId) {
		final String INSERT_SQL = "delete from ta_marks_course where user_id = ? AND course_id = ?";
		try {
			this.jdbcTemplate.update(INSERT_SQL, taId, courseId);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteStudentRegisterCourse(int studentId, int courseId) {
		final String INSERT_SQL = "delete from students_register_courses where user_id = ? AND course_id = ?";
		try {
			this.jdbcTemplate.update(INSERT_SQL, studentId, courseId);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteStudentInGroup(int studentId, int groupId) {
		final String INSERT_SQL = "delete from students_in_groups where user_id = ? AND group_id = ?";
		try {
			this.jdbcTemplate.update(INSERT_SQL, studentId, groupId);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteUser(int userId) {
		final String DELETE_SQL = "delete from users where id = ?";
		try {
			this.jdbcTemplate.update(DELETE_SQL, userId);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public boolean addUser(User user) {
		this.sha1HashService.hashPassword(user);
		final String INSERT_SQL = "insert into users (username, password, first_name, last_name, authorization) values(?, ?, ?, ?, ?)";
		long autoGeneratedKey = -1;
		final User _user = user;
		KeyHolder keyHolder = new GeneratedKeyHolder();
		try {
			this.jdbcTemplate.update(new PreparedStatementCreator() {
				public PreparedStatement createPreparedStatement(
						Connection connection) throws SQLException {
					PreparedStatement ps = connection.prepareStatement(
							INSERT_SQL, new String[] { "id" });
					ps.setString(1, _user.getUsername());
					ps.setString(2, _user.getPassword());
					ps.setString(3, _user.getFirstName());
					ps.setString(4, _user.getLastName());
					ps.setInt(5, _user.getAuthorization());
					return ps;
				}
			}, keyHolder);
			autoGeneratedKey=  (Long) keyHolder.getKey();
		} catch (Exception ex) {
			return false;
		}
		user.setId((int)autoGeneratedKey);
		return true;
	}

	@Override
	public boolean updateStudent(Student student) {
		final String SQL_QUERY = "update students set student_number = ? where id = ?";
		try {
			this.jdbcTemplate.update(SQL_QUERY,
					student.getStudentNumber(), student.getId());
		} catch (Exception sqlEx) {
			return false;
		}
		return this.updateUser(student);
	}

	@Override
	public boolean updateTa(Ta ta) {
		final String SQL_QUERY = "update ta set student_number = ? where id = ?";
		try {
			this.jdbcTemplate.update(SQL_QUERY,
					ta.getStudentNumber(), ta.getId());
		} catch (Exception sqlEx) {
			return false;
		}
		return this.updateUser(ta);
	}
	
	@Override
	public boolean updateUser(User user){
		if(!user.isPasswordHashed()){
			this.sha1HashService.hashPassword(user);
		}
		final String SQL_QUERY = "update users set username = ?, password = ?, first_name = ?, last_name = ?, authorization = ? where id = ?";
		try {
			this.jdbcTemplate.update(SQL_QUERY,
					user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getAuthorization(), user.getId());
		} catch (Exception sqlEx) {
			return false;
		}
		return true;
	}

}
