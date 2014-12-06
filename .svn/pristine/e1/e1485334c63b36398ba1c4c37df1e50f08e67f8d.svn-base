package com.eece496.webapp.dao;

import java.util.List;

import org.primefaces.model.DualListModel;

import com.eece496.webapp.pojo.Course;
import com.eece496.webapp.pojo.Student;
import com.eece496.webapp.pojo.Ta;
import com.eece496.webapp.pojo.User;

public interface UserDAO {
	public boolean updateStudent(Student student);
	
	public boolean updateTa(Ta ta);
	
	
	public boolean addTaMarksCourse(int taId, int courseId);
	
	public boolean deleteTaMarksCourse(int taId, int courseId);
	
	public boolean addStudentRegisterCourse(int studentId,int courseId);
	
	public boolean deleteStudentRegisterCourse(int studentId,int courseId);
	
	public boolean addStudentInGroup(int studentId,int groupId );
	
	public boolean deleteStudentInGroup(int studentId,int groupId );
	
	public boolean addTa(Ta ta);
	
	public boolean addStudent(Student student);
	
	public boolean deleteUser(int userId);
	
	public boolean addUser(User user);
	
	public User getUser(String username, String password);

	public List<Ta> getTaListMarkCourse(int courseId);

	public List<Student> getStudentListRegisterInCourse(int courseId);

	public List<Student> getGroupStudent(int groupId);

	public Student getAbsentStudentOfHolddate(int holddateId);

	public Student getStudentOfHolddate(int holddateId);

	public Ta getTaOfHolddate(int holddateId);

	Ta getTa(int userId);

	Student getStudent(int userId);

	boolean updateUser(User user);

}
