package com.eece496.webapp.jsfbean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.TransferEvent;
import org.springframework.context.annotation.Scope;


import com.eece496.webapp.dao.CourseDAO;
import com.eece496.webapp.dao.GroupDAO;
import com.eece496.webapp.dao.HolddateDAO;
import com.eece496.webapp.dao.MarkDAO;
import com.eece496.webapp.dao.SectionDAO;
import com.eece496.webapp.dao.SubsectionDAO;
import com.eece496.webapp.dao.UserDAO;
import com.eece496.webapp.helperclass.ChangePassword;
import com.eece496.webapp.pojo.Admin;
import com.eece496.webapp.pojo.Course;
import com.eece496.webapp.pojo.HoldDate;
import com.eece496.webapp.pojo.Section;
import com.eece496.webapp.pojo.Subsection;
import com.eece496.webapp.pojo.User;


@Named("AdminPageBean")
@Scope("request")
public class AdminPageBean  {
	@Inject
	UserInfoBean userInfoBean;
	@Inject
	UserDAO userDAO;
	@Inject
	CourseDAO courseDAO;
	@Inject
    SectionDAO sectionDAO;
	@Inject
    SubsectionDAO subsectionDAO;
	@Inject
    GroupDAO groupDAO;
	@Inject
    HolddateDAO holddateDAO;
	@Inject
    MarkDAO markDAO;
	private ChangePassword changePassword;
	
	public ChangePassword getChangePassword() {
		return changePassword;
	}

	public void setChangePassword(ChangePassword changePassword) {
		this.changePassword = changePassword;
	}
	
	
	public String returnMainPage(){
		return "AdminMainPage";
	}
	
	public String courseMainPage(){
		
		((Admin) userInfoBean.getUser()).getCurrentCourse().setStudents(userDAO.getStudentListRegisterInCourse(((Admin) userInfoBean.getUser()).getCurrentCourse().getId()));	
		((Admin) userInfoBean.getUser()).getCurrentCourse().setSections(sectionDAO.getSection(((Admin) userInfoBean.getUser()).getCurrentCourse().getId())); 
		((Admin) userInfoBean.getUser()).getCurrentCourse().setTas(userDAO.getTaListMarkCourse(((Admin) userInfoBean.getUser()).getCurrentCourse().getId()));
		System.out.println(((Admin) userInfoBean.getUser()).getCurrentCourse().getId());
		((Admin) userInfoBean.getUser()).getCurrentCourse().setSubSectionPerSec(4);
		for(int i=0;i<((Admin) userInfoBean.getUser()).getCurrentCourse().getSections().size();i++){
			Section section=((Admin) userInfoBean.getUser()).getCurrentCourse().getSections().get(i);
			section.setSubSections(subsectionDAO.getSubsection(section.getId()));
			section.setGroups(groupDAO.getGroupOfSection(section.getId()));
			  for(int j=0;j<section.getSubSections().size();j++){
				  Subsection subsection=section.getSubSections().get(j);
				  subsection.setGroups(groupDAO.getGroupOfSubsection(subsection.getId()));
				  for(int l=0;l<subsection.getGroups().size();l++){
				    	subsection.getGroups().get(l).setStudents(userDAO.getGroupStudent(subsection.getGroups().get(l).getId()));
				    }
				  subsection.setHoldDate(holddateDAO.getHolddateOfSubsection(subsection.getId()));
				    for(int k=0;k<subsection.getHoldDate().size();k++){
				    	HoldDate holddate=subsection.getHoldDate().get(k);
				    	holddate.setTa(userDAO.getTaOfHolddate(holddate.getId()));
				    	holddate.setStudent(userDAO.getStudentOfHolddate(holddate.getId()));				  	
				    	holddate.setGroupMark(markDAO.getGroupMarkOfHolddate(holddate.getId()));
				    	   for(int m=0;m<holddate.getGroupMark().size();m++){
				    		   
				    	   }
				    }
			  }
		}
		
		return "CourseMainPage.xhtml";
	}

    public String changeInfo(){
    	System.out.println("ChangeInfo");
    	return "ChangeInfo.xhtml";
    }
    
    public String changePassword(){
    	System.out.println("changePassword");
    	return "ChangePassword.xhtml";
    }
    
    public String changeInfoSuccess(){
    	System.out.println("changeInfoSuccess");
    	return "ChangeInfoFinish.xhtml";
    }
    
    public String changePasswordSuccess(){
    	if(this.changePassword.getOldPassword()!=this.userInfoBean.getUser().getPassword()){
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Failed to change password",
							"Incorrect old Password !"));
    		return null;
    	}else if(this.changePassword.getNewPassword()!=this.changePassword.getNewPassword2()){
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Failed to change password",
							"New password not matching!"));
    		return null;
    	}
    	else{
	    	System.out.println("changePasswordSuccess");
	    	return "ChangePasswordSuccess.xhtml";
    	}
    }
    
	public void onTransfer(TransferEvent event) {
	      StringBuilder builder = new StringBuilder();  
	        for(Object item : event.getItems()) {  
	            builder.append(((Course) item).getCourseName()).append("<br />");  
	        }  
	          
	        FacesMessage msg = new FacesMessage();  
	        msg.setSeverity(FacesMessage.SEVERITY_INFO);  
	        msg.setSummary("Items Transferred");  
	        msg.setDetail(builder.toString());  
	          
	        FacesContext.getCurrentInstance().addMessage(null, msg); 
	}
}
