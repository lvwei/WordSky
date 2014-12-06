package com.eece496.webapp.developdao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Named;

import org.primefaces.model.DualListModel;

import com.eece496.webapp.dao.UserDAO;
import com.eece496.webapp.pojo.Admin;
import com.eece496.webapp.pojo.Course;
import com.eece496.webapp.pojo.Group;
import com.eece496.webapp.pojo.HoldDate;
import com.eece496.webapp.pojo.Section;
import com.eece496.webapp.pojo.Student;
import com.eece496.webapp.pojo.Subsection;
import com.eece496.webapp.pojo.Ta;
import com.eece496.webapp.pojo.User;

//@Named
public class UserDevDAO implements UserDAO {

	@Override
	public User getUser(String username, String password) {
		if (username.equalsIgnoreCase(password)) {
			return new Admin();
		} else {
			return null;
		}
	}

	@Override
	public  List<Ta>getTaListMarkCourse(int courseId){
		List<Ta> randTa=new ArrayList<Ta>();
		for(int i=0;i<4;i++){
		randTa.add(new Ta());
		randTa.get(i).setId(i);
		randTa.get(i).setFirstName("F");
		}

		return randTa;
	}
	
	@Override
	public List<Student>getStudentListRegisterInCourse(int courseId){
		List<Student> randStudent=new ArrayList<Student>();
		for(int i=0;i<22;i++){
			String last="L"+Integer.toString(i);
			String first="F"+Integer.toString(i);
			String s="S"+Integer.toString(i);
		randStudent.add(new Student(last,first,s));
		}

		return randStudent;
	}
	
	
	@Override
	public  List<Student>getGroupStudent(int groupId){
		List<Student> a=new ArrayList<Student>();


		return a;
	}
	
	
	@Override
	public  Ta getTaOfHolddate(int holddateId){
		Ta a=new Ta();

		return a;
	}
	@Override
	public  Student getStudentOfHolddate(int holddateId){
		Student a=new Student();

		return a;
	}	
	
	@Override
	public  Student getAbsentStudentOfHolddate(int holddateId){
		Student a=new Student();

		return a;
	}

	@Override
	public boolean addTa(Ta ta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addTaMarksCourse(int taId, int courseId) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean addStudent(Student student){
		return false;
	}
	
	@Override
	public boolean addStudentRegisterCourse(int studentId,int courseId){
		return false;
	}
	@Override
	public boolean addStudentInGroup(int studentId,int groupId ){
		return false;
	}

	@Override
	public Ta getTa(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudent(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteTaMarksCourse(int taId, int courseId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStudentRegisterCourse(int studentId, int courseId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStudentInGroup(int studentId, int groupId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStudent(Student student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTa(Ta ta) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
