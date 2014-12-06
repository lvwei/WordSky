package com.eece496.webapp.jsfbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.context.annotation.Scope;

import com.eece496.webapp.pojo.Admin;
import com.eece496.webapp.pojo.User;


@Named("SectionPageBean")
@Scope("request")
public class SectionPageBean  {
	@Inject
	UserInfoBean userInfoBean;
	
	public String  returnCoursePage(){
		return "CourseMainPage.xhtml";
	}
	

	
	public String setHoldDate(){
		((Admin) this.userInfoBean.getUser()).getCurrentCourse().getCurrentSection().holdDateSet();
		return"SectionMainPage.xhtml";
	}
	
	public String saveHoldDate(){
		//currentSection.holdDate is updated
		return "SectionMainPage.xhtml";
	}
	
	public String saveSubsectionPerSec(){
		   //currentCourse.saveSubsectionPerSec is updated; need database update
		   return "SectionMainPage.xhtml";
	}
}