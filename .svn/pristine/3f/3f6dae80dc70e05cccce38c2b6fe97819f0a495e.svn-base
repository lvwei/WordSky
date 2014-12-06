package com.eece496.webapp.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;



public class Course {
	
private String courseName;
private Date startDate;
private Date endDate;
private List<Section> sections;
private List<Student> students;
private String selectStudent;
private int numOfStudents;
private int studentToAdd;



public Course(){
	this.students=new ArrayList<Student>();
	this.students.add(new Student("defalut","defalut","defalut"));
	this.studentToAdd=0;
}

public Course(String cn){
	this.courseName=cn;
}

public String getCourseName() {
	return courseName;
}

public void setCourseName(String courseName) {
	this.courseName = courseName;
}

public Date getStartDate() {
	return startDate;
}

public void setStartDate(Date startDate) {
	this.startDate = startDate;
}

public Date getEndDate() {
	return endDate;
}

public void setEndDate(Date endDate) {
	this.endDate = endDate;
}

public List<Section> getSections() {
	return sections;
}

public void setSections(List<Section> sections) {
	this.sections = sections;
}

public List<Student> getStudents() {
	return students;
}

public void setStudents(List<Student> students) {
	this.students = students;
}

public void addStudents() {
	for(int i=0;i<this.studentToAdd;i++)
	this.students.add(new Student());
}
public  int getNumOfStudents() {
	return numOfStudents;
}

public void setNumOfStudents(int numOfStudents) {
	this.numOfStudents = numOfStudents;
}

public int getStudentToAdd() {
	return studentToAdd;
}

public void setStudentToAdd(int studentToAdd) {
	this.studentToAdd = studentToAdd;
	System.out.println(this.courseName+" "+this.studentToAdd+ "students to add.");
}

public String getSelectStudent() {
	return selectStudent;
}

public void setSelectStudent(String selectStudent) {
	this.selectStudent = selectStudent;
}

public String chooseStudent(){
	return "AdminMainPage.xhtml";
}
}
