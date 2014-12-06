package com.eece496.webapp.jsfbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.TransferEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.DualListModel;
import org.springframework.context.annotation.Scope;

import com.eece496.webapp.ProjectConfiguration;
import com.eece496.webapp.helperclass.ChangePassword;
import com.eece496.webapp.helperclass.CourseList;
import com.eece496.webapp.pojo.Admin;
import com.eece496.webapp.pojo.Course;
import com.eece496.webapp.pojo.Student;
import com.eece496.webapp.pojo.User;
import com.eece496.webapp.service.CWLAccountService;
import com.eece496.webapp.serviceimpl.CWLAccountServiceImpl;

@Named("CWLLoginBean")
@Scope("session")
//@ManagedBean(name="CWLLoginBean")
//@SessionScoped

public class CWLLoginBean implements Serializable{
	private String cwlLoginName;
	private String cwlPassword;
	private User user;
	private DualListModel<String> ss;
	private ChangePassword changePassword;
	 private static final String languageString = 
			    "Java,C,C++,PHP,C#,Python,Visual Basic,Objective-C,Perl,Ruby,JavaScript,Delphi," +
			    "Lisp,SQL,Pascal,Ada,NXT-G,SAS,RPG,Lua,ABAP,Object Pascal,Go,Scheme,Fortran," +
			    "Tc,D,COBOL,Logo,CL,APL,JavaFX Script,R,JScript.NET,C shell,ActionScript,Scratch," +
			    "IDL,Haskell,Alice,Prolog,Erlang,Smalltalk,Forth,Awk,ML,Scala,ABC,Algol,Applescript," +
			    "Bash,bc,Beta,CFML,cg,Clean,Clipper,Cobra,cT,Curl,Dylan,Eiffel,Euphoria,F#,Factor," +
			    "Groovy,Icon,Io,J,LabVIEW,LabWindows/CVI,MAD,MAX/MSP,Modula-2,Modula-3,MUMPS,Natural," +
			    "Oberon,Objective Caml,Occam,Oz,PL/I,Postscript,PowerShell,Q,REALbasic,S,SIGNAL,SPSS," +
			    "Squirrel,Verilog,VHDL,XBase,XSLT,Z shell";
private static final String[] languageArray = languageString.split(",");


	
	@Inject
	CWLAccountService cwlAccountService;
	public  CWLLoginBean(){	
		//this.cwlAccountService=new CWLAccountServiceImpl();
		ArrayList<String> t=new ArrayList<String>();
		t.add("eece345");
		t.add("eece234");
		t.add("eece256");
		this.ss=new DualListModel<String>(t,new ArrayList<String>());
		
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ChangePassword getChangePassword() {
		return changePassword;
	}

	public void setChangePassword(ChangePassword changePassword) {
		this.changePassword = changePassword;
	}

	public CWLAccountService getCwlAccountService() {
		return cwlAccountService;
	}

	public void setCwlAccountService(CWLAccountService cwlAccountService) {
		this.cwlAccountService = cwlAccountService;
	}

	public DualListModel<String> getSs() {
		return ss;
	}

	public void setSs(DualListModel<String> ss) {
		this.ss = ss;
	}

	public String cwlLogin() {
		if(this.cwlAccountService.login(this.cwlLoginName, this.cwlPassword)){
			this.user=new Admin();
			this.user.setUsername(this.cwlLoginName);

			/*
			for(int i=0;i<4;i++){
				System.out.println(this.admin.getCourses().getSource().get(i).getCourseName());
			}
			*/
			return "AdminMainPage.xhtml";
		}else{
			return null;
		}
	}
	
	public String returnMainPage(){
		return "AdminMainPage";
	}

    public String changeInfo(){
    	System.out.println("ChangeInfo");
    	/*
		for(int i=0;i<4;i++){
			System.out.println(this.admin.getCourses().getSource().get(i).getCourseName());
		}
		*/
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
    	if(this.changePassword.getOldPassword()!=this.user.getPassword()){
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
    
   public String addStudent(){
	   ((Admin) this.user).getCourses().getTarget().get(((Admin) this.user).getCurrentCourse()).addStudents( );
	   return "AdminMainPage.xhtml";
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
	
	public List<String> suggestedStudent(String languagePrefix) {
		System.out.println(CourseList.suggestStudent().get(0));
		List<String> matches = new ArrayList<String>();
		for(String possibleStudent: languageArray) {
		if(possibleStudent.toUpperCase()
		.startsWith(languagePrefix.toUpperCase())) {
		matches.add(possibleStudent);
		}
		}
		return(matches);
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

}