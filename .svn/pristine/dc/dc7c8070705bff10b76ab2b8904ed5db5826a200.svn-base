package com.eece496.webapp.pojo;

public class Student extends User{
	

	protected String studentNumber;
	
	public Student(String l, String f,String s){
		this.lastName=l;
		this.firstName=f;
		this.studentNumber=s;
		this.isPasswordHashed = false;
	}
	
	public Student() {
		this.authorization=User.STUDENT;
		this.username="default";
		this.password="default";
		this.studentNumber="default";

	}
	
	public Student(String username, String password, String firstName,
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
}
