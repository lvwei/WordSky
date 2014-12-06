package com.eece496.webapp.pojo;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import com.eece496.webapp.dao.HolddateDAO;
import com.eece496.webapp.developdao.UserDevDAO;
import com.eece496.webapp.helperclass.DateUtils;



public class Course {

private int id;	
private String courseName;
private Date startDate;
private Date endDate;
private List<Section> sections;
private List<Group> groups;
private List<Student> students;
private List<Ta> tas;
private String selectStudent;

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

private int studentToAdd;
private int taToAdd;
private int sectionToAdd;
private int groupStudentLimit;
private int subSectionPerSec;
private Section currentSection;



public Course(){
    this.students=new ArrayList<Student>();
    this.tas=new ArrayList<Ta>();
    this.groups=new ArrayList<Group>();
    this.sections=new ArrayList<Section>();
	this.groupStudentLimit=6;
	this.subSectionPerSec=1;//default value 1
}

public Course(String cn){
	this.courseName=cn;
    //this.students=UserDevDAO.getStudent();
    this.tas=new ArrayList<Ta>();
    this.groups=new ArrayList<Group>();
    this.sections=new ArrayList<Section>();
	this.groupStudentLimit=6;
	this.subSectionPerSec=1;//default value 1
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
	//return this.sectionDao.getSectionInCourse(this.id);
	return sections;
}

public void setSections(List<Section> sections) {
	this.sections = sections;
}

public List<Student> getStudents() {
	//return this.userDao.getStudentInCourse(this.id);
	return students;
}

public void setStudents(List<Student> students) {
	this.students = students;
}

public void setTas(List<Ta> tas) {
	
	this.tas = tas;
}
public List<Ta> getTas(){
	//return this.userDao.getTaInCourse(this.id);
	return this.tas;
}

public void addStudents() {
	for(int i=0;i<this.studentToAdd;i++){
	this.students.add(new Student());
	}
}

public void addTas() {
	for(int i=0;i<this.taToAdd;i++){
	this.tas.add(new Ta(this));
	}
}

public void addSections() {
	for(int i=0;i<this.sectionToAdd;i++){
	this.sections.add(new Section());
	}
}
	
public int getNumOfStudent() {
	return this.students.size();

}

public int getNumOfTa() {
	return this.tas.size();

}

public int getStudentToAdd() {
	return studentToAdd;
}

public void setStudentToAdd(int studentToAdd) {
	this.studentToAdd = studentToAdd;
}

public String getSelectStudent() {
	return selectStudent;
}

public void setSelectStudent(String selectStudent) {
	this.selectStudent = selectStudent;
}


public void assignGroup() {
	//simple algorithm for testing
	this.groups=new ArrayList<Group>();
	int numOfGroup=(this.students.size()-1)/this.groupStudentLimit+1;
	System.out.println("NumOfGroup:"+numOfGroup);
	for(int i=0;i<numOfGroup;i++)
		this.groups.add(new Group());
	
	Random r = new Random();

	int realSize=0;
	if(this.students.size()<=this.groups.size()*(this.groupStudentLimit-1)){
		realSize=this.students.size();
	}
	else{
		realSize=this.groups.size()*(this.groupStudentLimit-1);
	}
	System.out.println("realSize: "+realSize);
	for(int j=0;j<realSize;j++){
		
		int assignedGroup = r.nextInt(numOfGroup);
		
		while(this.groups.get(assignedGroup).getStudents().size()==this.groupStudentLimit-1){
			assignedGroup = r.nextInt(numOfGroup);
		}
		this.groups.get(assignedGroup).getStudents().add(this.students.get(j));
		System.out.println(assignedGroup);
		System.out.println(this.students.get(j).getLastName()+" "+this.students.get(j).getFirstName());
	}
	if(this.students.size()>this.groups.size()*(this.groupStudentLimit-1)){
		for(int k=this.groups.size()*(this.groupStudentLimit-1);k<this.students.size();k++){
			
			int assignedGroup = r.nextInt(numOfGroup);
			
			while(this.groups.get(assignedGroup).getStudents().size()==this.groupStudentLimit){
				assignedGroup = r.nextInt(numOfGroup);
			}
			this.groups.get(assignedGroup).getStudents().add(this.students.get(k));
		}	
	}
	
	//this.groups and its students field has been assigned(); update database
}



public List<Group> getGroups() {
	//return this.groupDao.getGroupInCourse(this.id);
	return groups;
}

public void setGroups(List<Group> groups) {
	this.groups = groups;
}


public int getTaToAdd() {
	return taToAdd;
}

public void setTaToAdd(int taToAdd) {
	this.taToAdd = taToAdd;
}

public int getGroupStudentLimit() {
	return groupStudentLimit;
}

public void setGroupStudentLimit(int groupStudentLimit) {
	this.groupStudentLimit = groupStudentLimit;
}


public int getSectionToAdd() {
	return sectionToAdd;
}

public void setSectionToAdd(int sectionToAdd) {
	this.sectionToAdd = sectionToAdd;
}

public int getSubSectionPerSec() {
	return subSectionPerSec;
}

public void setSubSectionPerSec(int subSectionPerSec) {
	this.subSectionPerSec = subSectionPerSec;
}

public Section getCurrentSection() {
	return currentSection;
}

public void setCurrentSection(Section currentSection) {
	this.currentSection = currentSection;
}


public String chooseStudent(){
	return "CourseMainPage.xhtml";
}

public void sectionListener(ActionEvent event){
	this.currentSection=  (Section) event.getComponent().getAttributes().get("section");
}


public void sectionGroupAssign(){
	
	System.out.println("sectionGroupAssign");
	System.out.println("sectionGroupAssign group size:"+this.groups.size());
	for(int i=0;i<this.groups.size();i++){
	System.out.println("sectionGroupAssign:"+i);
		Random r = new Random();			
		int assignedSection = r.nextInt(this.sections.size());
		while(this.sections.get(assignedSection).getGroups().size()==this.sections.get(assignedSection).getGroupLimit()){
			assignedSection = r.nextInt(this.sections.size());
		}
		
		this.sections.get(assignedSection).getGroups().add(this.groups.get(i));
	}
	
	System.out.println("sectionGroupAssign.........");
}
@SuppressWarnings("null")
public void assignTask(){
	for(int i=0;i<this.sections.size();i++){
		for(int j=0;j<this.sections.get(i).getSubSections().size();j++){
			for(int k=0;k<this.sections.get(i).getSubSections().get(j).getHoldDate().size();k++){				
				
				//ta assignment
				Random r = new Random();			
				int markingTa = r.nextInt(this.tas.size());
				Subsection subsection=this.sections.get(i).getSubSections().get(j);
				this.sections.get(i).getSubSections().get(j).getHoldDate().get(k).setTa(this.tas.get(markingTa));
				//student assignment
				int markingStudentGroup=0;
				int[] markingStudent = {0,0};
				if(k==0){
				markingStudentGroup=r.nextInt(subsection.getGroups().size());
				markingStudent[markingStudentGroup]=r.nextInt(subsection.getGroups().get(markingStudentGroup).getStudents().size());
				}
				else{
					markingStudentGroup=(markingStudentGroup+1)%subsection.getGroups().size();
					markingStudent[markingStudentGroup]=(markingStudent[markingStudentGroup]+1)%subsection.getGroups().get(markingStudentGroup).getStudents().size();
				}
				this.sections.get(i).getSubSections().get(j).getHoldDate().get(k).setStudent(subsection.getGroups().get(markingStudentGroup).getStudents().get(markingStudent[markingStudentGroup]));
			}
		}
	}
	
}



public void absentStudentReportListener(ActionEvent event){
	HoldDate hD=(HoldDate) event.getComponent().getAttributes().get("hd");
    hD.setAbsentStudent(hD.getIndividualMark().getStudent());
}

public void reportAbsentListener(ActionEvent event){
	HoldDate hD=(HoldDate) event.getComponent().getAttributes().get("HD");
    Student s=(Student) event.getComponent().getAttributes().get("newStudent");
    hD.setAbsentStudent(hD.getStudent());
    hD.setStudentAbsent(true);
    hD.setApprovedAbsent(false);
    hD.setStudent(s);
    hD.getIndividualMark().setStudent(s);
}
}
