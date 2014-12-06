package com.eece496.webapp.jsfbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.context.annotation.Scope;

import com.eece496.webapp.dao.CourseDAO;
import com.eece496.webapp.dao.GroupDAO;
import com.eece496.webapp.dao.HolddateDAO;
import com.eece496.webapp.dao.SectionDAO;
import com.eece496.webapp.dao.SubsectionDAO;
import com.eece496.webapp.dao.UserDAO;
import com.eece496.webapp.pojo.Admin;
import com.eece496.webapp.pojo.Group;
import com.eece496.webapp.pojo.HoldDate;
import com.eece496.webapp.pojo.Section;
import com.eece496.webapp.pojo.Student;
import com.eece496.webapp.pojo.Subsection;
import com.eece496.webapp.pojo.Ta;
import com.eece496.webapp.pojo.User;


@Named("CoursePageBean")
@Scope("request")
public class CoursePageBean  {
	@Inject
	UserInfoBean userInfoBean;
	@Inject
	UserDAO userDAO;
	@Inject
	CourseDAO courseDAO;
	@Inject
    SectionDAO sectionDAO;
	@Inject
    GroupDAO groupDAO;
	@Inject
    SubsectionDAO subsectionDAO;
	@Inject
    HolddateDAO holddateDAO;

public String addStudent(){
	   ((Admin) this.userInfoBean.getUser()).getCurrentCourse().addStudents( );
		  
	   return "CourseMainPage.xhtml";
}

public String addStudent2(){
	/*
	   int size=((Admin) this.userInfoBean.getUser()).getCurrentCourse().getStudents().size();
		for(int i=0;i<((Admin) this.userInfoBean.getUser()).getCurrentCourse().getStudentToAdd();i++){
			System.out.println(size+"--"+i);
			userDAO.addStudent(((Admin) this.userInfoBean.getUser()).getCurrentCourse().getStudents().get(size-i-1));
			userDAO.addStudentRegisterCourse(((Admin) this.userInfoBean.getUser()).getCurrentCourse().getStudents().get(size-i-1).getId(), ((Admin) this.userInfoBean.getUser()).getCurrentCourse().getId());		
		}
		*/  
	   return "CourseMainPage.xhtml";
}

public String addTa(){
   ((Admin) this.userInfoBean.getUser()).getCurrentCourse().addTas( );
	   return "CourseMainPage.xhtml";
}

public String addTa2(){
	return "CourseMainPage.xhtml";
}

public String addSection(){
	 ((Admin) this.userInfoBean.getUser()).getCurrentCourse().addSections();
	   return "CourseMainPage.xhtml";
}

public String addSection2(){
	 return "CourseMainPage.xhtml";
}

public String courseMainPage(){
	 
	   return "CourseMainPage.xhtml";
}


public String saveSubsectionPerSec(){
	   return "CourseMainPage.xhtml";
}

public String saveStudent(){
	 return "CourseMainPage.xhtml";
}

public String saveSection(){
	   return "CourseMainPage.xhtml";
}

public String saveTa(){

	   return "CourseMainPage.xhtml";
}

public String saveDate(){
	   return "CourseMainPage.xhtml";
}

public String changeAssignedTa(){
	return "ChangeAssignTa.xhtml";
}

public String changeAssignedTaFinish(){
	return "CourseMainPage.xhtml";
}


public String returnMainPage(){
	return "AdminMainPage.xhtml";
}

public String groupAssignment(){
	((Admin) userInfoBean.getUser()).getCurrentCourse().assignGroup();
	return "CourseMainPage.xhtml";
}


public String sectionMainPage(){

	return "SectionMainPage";
}

public static void selectListener(SelectEvent event) {
	String itemSelected = event.getObject().toString();
	String message =
	String.format("Added '%s' to selections", itemSelected);
	FacesContext context = FacesContext.getCurrentInstance();
	context.addMessage(null, new FacesMessage(message));
	}
public static void unselectListener(UnselectEvent event) {
	String itemSelected = event.getObject().toString();
	String message =
	String.format("Removed '%s' from selections", itemSelected);
	FacesContext context = FacesContext.getCurrentInstance();
	context.addMessage(null, new FacesMessage(message));
	}	

public void absentStudentListener(ActionEvent event){
	HoldDate hD=(HoldDate) event.getComponent().getAttributes().get("hd");
    hD.setApprovedAbsent(true);
    holddateDAO.updateHolddate(hD);   
}



public String sectionDivide(){
	System.out.println("sectionDivide");
	for(int i=0;i<((Admin) userInfoBean.getUser()).getCurrentCourse().getSections().size();i++)
	((Admin) userInfoBean.getUser()).getCurrentCourse().getSections().get(i).divideSection(((Admin) userInfoBean.getUser()).getCurrentCourse().getSubSectionPerSec());
	System.out.println("sectionDivide.....");
	return "CourseMainPage";
}

public String setting(){
	((Admin) userInfoBean.getUser()).getCurrentCourse().sectionGroupAssign();
	for(int i=0;i<((Admin) userInfoBean.getUser()).getCurrentCourse().getSections().size();i++){
		for(int k=0;k<((Admin) userInfoBean.getUser()).getCurrentCourse().getSections().get(i).getGroups().size();k++){
			Group group=((Admin) userInfoBean.getUser()).getCurrentCourse().getSections().get(i).getGroups().get(k);
			groupDAO.addGroup(group, ((Admin) userInfoBean.getUser()).getCurrentCourse().getSections().get(i).getId());
	    	  for(int x=0;x<group.getStudents().size();x++){
	    		  Student student= group.getStudents().get(x);
	    		  System.out.println(student.getId());
	    		  System.out.println(group.getId());
	    		  userDAO.addStudentInGroup(student.getId(), group.getId());
	    	  }
		}
	((Admin) userInfoBean.getUser()).getCurrentCourse().getSections().get(i).divideSection(((Admin) userInfoBean.getUser()).getCurrentCourse().getSubSectionPerSec());
	    for(int j=0;j<((Admin) userInfoBean.getUser()).getCurrentCourse().getSections().get(i).getSubSections().size();j++){
	    	int sectionId=((Admin) userInfoBean.getUser()).getCurrentCourse().getSections().get(i).getId();
	    	Subsection sub=((Admin) userInfoBean.getUser()).getCurrentCourse().getSections().get(i).getSubSections().get(j);
	    	subsectionDAO.addSubsection(sub, sectionId);

	    	
	    	for(int n=0;n<sub.getHoldDate().size();n++){
	    		holddateDAO.addHolddate(sub.getHoldDate().get(n), sub.getId());
	    	}
	    }
	}
	return "CourseMainPage.xhtml";
	
}
public String taskAssignment(){
	
	((Admin) userInfoBean.getUser()).getCurrentCourse().assignTask();
	for(int i=0;i<((Admin) userInfoBean.getUser()).getCurrentCourse().getSections().size();i++){
	Section sec=((Admin) userInfoBean.getUser()).getCurrentCourse().getSections().get(i);
	  for(int j=0;j<sec.getSubSections().size();j++){
		  Subsection sub=sec.getSubSections().get(j);
		    for(int k=0;k<sub.getHoldDate().size();k++){
		    	HoldDate holddate=sub.getHoldDate().get(k);
		    	holddateDAO.updateHolddate(holddate);
		    }
	  }
	}
	return "CourseMainPage.xhtml";
}

public String sectionGroup(){
	((Admin) userInfoBean.getUser()).getCurrentCourse().sectionGroupAssign();
	return "CourseMainPage.xhtml";
}

public void addStudentListener(ActionEvent event){
	Student s=(Student) event.getComponent().getAttributes().get("student");
    userDAO.addStudent(s);
    userDAO.addStudentRegisterCourse(s.getId(), ((Admin) this.userInfoBean.getUser()).getCurrentCourse().getId());
}

public void saveStudentListener(ActionEvent event){
	Student s=(Student) event.getComponent().getAttributes().get("student");
    userDAO.updateStudent(s);
}

public void addTaListener(ActionEvent event){
	Ta ta=(Ta) event.getComponent().getAttributes().get("ta");
    System.out.println(userDAO.addTa(ta));
    System.out.println(userDAO.addTaMarksCourse(ta.getId(), ((Admin) this.userInfoBean.getUser()).getCurrentCourse().getId()));
}

public void saveTaListener(ActionEvent event){
	Ta ta=(Ta) event.getComponent().getAttributes().get("ta");
    userDAO.updateTa(ta);
}

public void saveSectionListener(ActionEvent event){
	Section section=(Section) event.getComponent().getAttributes().get("section");
    sectionDAO.updateSection(section);
}

public void addSectionListener(ActionEvent event){
	Section section=(Section) event.getComponent().getAttributes().get("section");
    sectionDAO.addSection(section, ((Admin) this.userInfoBean.getUser()).getCurrentCourse().getId());
}
}
