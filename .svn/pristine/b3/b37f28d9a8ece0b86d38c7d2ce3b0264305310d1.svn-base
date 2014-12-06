package com.eece496.webapp.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import com.eece496.webapp.helperclass.CourseList;


public class Admin extends User{
	
	protected DualListModel<Course> courses;
	protected List<Ta> tas;
	protected int currentCourse;
	
	public Admin(){	
	 this.courses=new DualListModel<Course>(CourseList.ramdomCourse(),new ArrayList<Course>());

     this.currentCourse=0;
	}
	
	public void setCourses(DualListModel<Course> courses) {
		this.courses = courses;
	}

	public DualListModel<Course> getCourses(){
		return this.courses;
	}
	
	public void setTas(List<Ta> tas) {
		this.tas = tas;
	}
	public List<Ta> getTas(){
		return this.tas;
	}



	public int getCurrentCourse() {
		return currentCourse;
	}

	public void setCurrentCourse(int currentCourse) {
		this.currentCourse = currentCourse;
	}





	
	
}
