package com.eece496.webapp.jsfbean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.eece496.webapp.dao.CourseDAO;
import com.eece496.webapp.dao.GroupDAO;
import com.eece496.webapp.dao.HolddateDAO;
import com.eece496.webapp.dao.MarkDAO;
import com.eece496.webapp.dao.SectionDAO;
import com.eece496.webapp.dao.SubsectionDAO;
import com.eece496.webapp.dao.UserDAO;
import com.eece496.webapp.developdao.CourseDevDAO;
import com.eece496.webapp.developdao.SectionDevDAO;
import com.eece496.webapp.developdao.UserDevDAO;
import com.eece496.webapp.helperclass.ChangePassword;
import com.eece496.webapp.pojo.Admin;
import com.eece496.webapp.pojo.Course;
import com.eece496.webapp.pojo.HoldDate;
import com.eece496.webapp.pojo.Section;
import com.eece496.webapp.pojo.Subsection;
import com.eece496.webapp.pojo.Ta;
import com.eece496.webapp.pojo.User;
import com.eece496.webapp.service.CWLAccountService;
import com.eece496.webapp.service.Sha1HashService;

@Named("CWLLoginBean")
@Scope("request")
public class CWLLoginBean {
	private String cwlLoginName;
	private String cwlPassword;
	private ChangePassword changePassword;

	@Inject
	UserInfoBean userInfoBean;
	@Inject
	CWLAccountService cwlAccountService;
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
	
	@Inject
	Sha1HashService sha1HashService;


	public CWLLoginBean() {

	}

	public String getCwlLoginName() {
		return cwlLoginName;
	}

	public void setCwlLoginName(String cwlLoginName) {
		this.cwlLoginName = cwlLoginName;
	}

	public String getCwlPassword() {
		return cwlPassword;
	}

	public void setCwlPassword(String cwlPassword) {
		this.cwlPassword = cwlPassword;
	}

	public String cwlLogin() {
		User currentUser = null;
		try {
			currentUser = this.userDAO.getUser(this.cwlLoginName,sha1HashService.sha1(this.cwlPassword));
		} catch (Exception ex) {
			this.printLoginFailureMsg();
			return null;
		}
		if (currentUser != null) {
			if(currentUser.getAuthorization()==User.ADMIN){
			this.userInfoBean.setUser(new Admin(currentUser));

			
			((Admin) this.userInfoBean.getUser()).setCourses(this.courseDAO
					.getCourses(currentUser.getId()));

			return "AdminMainPage.xhtml";
			}
			
			
			/*
			this.userInfoBean.setUser(new Ta());
			this.userInfoBean.getUser().setId(0);
			((Ta) this.userInfoBean.getUser()).setCourse(new Course());
			((Ta) this.userInfoBean.getUser()).getCourse().setCourseName("eece251T1");
			((Ta) userInfoBean.getUser()).getCourse().setStudents(userDAO.getStudentListRegisterInCourse(0));
			((Ta) userInfoBean.getUser()).getCourse().setSections(sectionDAO.getSection(0)); 
			((Ta) userInfoBean.getUser()).getCourse().setTas(userDAO.getTaListMarkCourse(0));
			((Ta) userInfoBean.getUser()).getCourse().setSubSectionPerSec(4);
			((Ta) userInfoBean.getUser()).getCourse().assignGroup();
			
			((Ta) userInfoBean.getUser()).getCourse().sectionGroupAssign();
			for(int i=0;i<((Ta) userInfoBean.getUser()).getCourse().getSections().size();i++)
				((Ta) userInfoBean.getUser()).getCourse().getSections().get(i).divideSection(((Ta) userInfoBean.getUser()).getCourse().getSubSectionPerSec());
			((Ta) userInfoBean.getUser()).getCourse().assignTask();
			return "TaMainPage.xhtml";
			*/
			else if(currentUser.getAuthorization()==User.TA){
			this.userInfoBean.setUser(new Ta(currentUser));
			((Ta) userInfoBean.getUser()).setCourse(courseDAO.getCourseForTa(((Ta) userInfoBean.getUser()).getId()));
			((Ta) userInfoBean.getUser()).getCourse().setSections(sectionDAO.getSection(((Ta) userInfoBean.getUser()).getCourse().getId())); 
			for(int i=0;i<((Ta) userInfoBean.getUser()).getCourse().getSections().size();i++){
				Section section=((Ta) userInfoBean.getUser()).getCourse().getSections().get(i);
				section.setSubSections(subsectionDAO.getSubsection(section.getId()));
				section.setGroups(groupDAO.getGroupOfSection(section.getId()));
				  for(int j=0;j<section.getSubSections().size();j++){
					  Subsection subsection=section.getSubSections().get(j);
					  subsection.setGroups(groupDAO.getGroupOfSubsection(subsection.getId()));
					    for(int l=0;l<subsection.getGroups().size();l++){
					    	System.out.println("group id:"+subsection.getGroups().get(l).getId());
					    	subsection.getGroups().get(l).setStudents(userDAO.getGroupStudent(subsection.getGroups().get(l).getId()));
					    	System.out.println("student size:"+subsection.getGroups().get(l).getStudents().size());
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
			
			return "TaMainPage.xhtml";
			}else if(currentUser.getAuthorization()==User.STUDENT){
				this.userInfoBean.setUser(currentUser);
				return "StudentPage.xhtml";
			}else{
				this.printLoginFailureMsg();
				return null;
			}
			
		} else {
			this.printLoginFailureMsg();
			return null;
		}
	}

	private void printLoginFailureMsg() {
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Failed to login", "Incorrect Username or Password !"));
	}

}