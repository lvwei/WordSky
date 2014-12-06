package com.eece496.webapp.pojo;

import java.util.List;

import javax.inject.Named;

public class Ta extends User{
	
	protected Course course;
	protected String studentNumber;
	
	public Ta(){
		
	}

	public Ta(User user) {
		 this.id = user.getId();
		 this.username = user.getUsername();
		 this.password = user.getPassword();
		 this.firstName = user.getFirstName();
		 this.lastName = user.getLastName();
		 this.authorization = user.getAuthorization();
	}

	public Ta(String userName, String passWord) {
		this.username = userName;
		this.password = passWord;
		this.isPasswordHashed = false;
	}

	public Ta(String username, String password, String firstName,
			String lastName, int auth, String studentNumber) {
		super(username, password, firstName, lastName, auth);
		this.studentNumber = studentNumber;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	public Ta(Course c){
		this.course=c;
		this.authorization=User.TA;
		this.username="default";
		this.studentNumber="default";
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}


}
