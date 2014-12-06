package com.eece496.webapp.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import com.eece496.webapp.developdao.UserDevDAO;


public class Admin extends User{
	
	protected DualListModel<Course> courses;
	protected Course currentCourse;
	
	public Admin(){	
 
	}
	
	public Admin(User user){	
		 this.id = user.getId();
		 this.username = user.getUsername();
		 this.password = user.getPassword();
		 this.firstName = user.getFirstName();
		 this.lastName = user.getLastName();
		 this.authorization = user.getAuthorization();
	}
	
	public void setCourses(DualListModel<Course> courses) {
		this.courses = courses;
	}

	public DualListModel<Course> getCourses(){
		//return this.userDao.getCourseInAdmin(this.id);
		return this.courses;
	}
	


	public Course getCurrentCourse() {
		return currentCourse;
	}

	public void setCurrentCourse(Course currentCourse) {
		this.currentCourse = currentCourse;
	}


	public void courseListener(ActionEvent event){
		  
			this.currentCourse =  (Course) event.getComponent().getAttributes().get("course");
	 }
	
	
	
}
