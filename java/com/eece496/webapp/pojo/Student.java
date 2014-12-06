package com.eece496.webapp.pojo;

public class Student {
	
	protected String firstName;
	protected String lastName;
	protected String studentNumber;
	protected String fullName;
	
	public Student(String f, String l,String s){
		this.lastName=l;
		this.firstName=f;
		this.studentNumber=s;
		this.fullName=l+" "+f;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public Student() {

	}
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
}
