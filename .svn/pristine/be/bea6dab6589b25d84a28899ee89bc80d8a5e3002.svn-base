package com.eece496.webapp.jsfbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.context.annotation.Scope;

import com.eece496.webapp.dao.HolddateDAO;
import com.eece496.webapp.dao.MarkDAO;
import com.eece496.webapp.pojo.Admin;
import com.eece496.webapp.pojo.ExtendHolddate;
import com.eece496.webapp.pojo.HoldDate;
import com.eece496.webapp.pojo.Mark;
import com.eece496.webapp.pojo.Section;
import com.eece496.webapp.pojo.Student;
import com.eece496.webapp.pojo.Subsection;
import com.eece496.webapp.pojo.Ta;
import com.eece496.webapp.pojo.User;


@Named("TaPageBean")
@Scope("session")
public class TaPageBean implements Serializable {
	@Inject
	UserInfoBean userInfoBean;
	@Inject
	MarkDAO markDAO;
	@Inject
	HolddateDAO holddateDAO;
	private Date date;
	private List<ExtendHolddate> exhd;
	private ExtendHolddate currentEhd;
	private String message="No missing marking";
	private HoldDate currentHolddate;


	public HoldDate getCurrentHolddate() {
		return currentHolddate;
	}

	public void setCurrentHolddate(HoldDate currentHolddate) {
		this.currentHolddate = currentHolddate;
	}

	
	@SuppressWarnings("deprecation")
	@PostConstruct
	   public void initialize(){
		for(int i=0;i<((Ta) userInfoBean.getUser()).getCourse().getSections().size();i++){
			Section section=((Ta) userInfoBean.getUser()).getCourse().getSections().get(i);
			  for(int j=0;j<section.getSubSections().size();j++){
				  Subsection subsection=section.getSubSections().get(j);
				  for(int k=0;k<subsection.getHoldDate().size();k++){
					  HoldDate holddate=subsection.getHoldDate().get(k);
					   Date test=new Date();
					   //test.setDate(14);
					   
					  if(test.getTime()-holddate.getDate().getTime()>86400000 && holddate.getTa().getId()==this.userInfoBean.getUser().getId()){
						  System.out.println(test.getTime()-holddate.getDate().getTime());
						  if(holddate.getIndividualMark()==null){
					        	 this.setMessage("You have missing mark not assigned.");
					         }
					   
					  }
				  }
			  }
		}		   
	   }
	   
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ExtendHolddate getCurrentEhd() {
		return currentEhd;
	}

	public void setCurrentEhd(ExtendHolddate currentEhd) {
		this.currentEhd = currentEhd;
	}

	public List<ExtendHolddate> getExhd() {
		return exhd;
	}

	public void setExhd(List<ExtendHolddate> exhd) {
		this.exhd = exhd;
	}

	public String taMainPage(){
		return "TaMainPage.xhtml";
	}
	
	public void handleDate(){
		this.exhd=new ArrayList<ExtendHolddate>();
		for(int i=0;i<((Ta) userInfoBean.getUser()).getCourse().getSections().size();i++){
			Section section=((Ta) userInfoBean.getUser()).getCourse().getSections().get(i);
			  for(int j=0;j<section.getSubSections().size();j++){
				  Subsection subsection=section.getSubSections().get(j);
				  for(int k=0;k<subsection.getHoldDate().size();k++){
					  HoldDate holddate=subsection.getHoldDate().get(k);
					 System.out.println(holddate.getDate().getTime()-this.date.getTime());
					  if(holddate.getDate().getTime()-this.date.getTime()>=0&&holddate.getDate().getTime()-this.date.getTime()<86400000&&holddate.getTa().getId()==this.userInfoBean.getUser().getId()){
						  ExtendHolddate xh=new ExtendHolddate();
						  xh.setHolddate(holddate);
						  xh.setStartTime(subsection.getStartTime());
						  xh.setEndTime(subsection.getEndTime());
						  xh.setRoom(subsection.getRoom());
						  System.out.println("before:"+subsection.getGroups().size());
						  System.out.println("before:"+subsection.getGroups().get(0).getStudents().size());
						  xh.setGroups(subsection.getGroups());
						  System.out.println(xh.getGroups().size());
						  System.out.println(xh.getGroups().get(0).getStudents().size());
						  this.exhd.add(xh);
						 // System.out.println(xh.getStartTime());
						  //System.out.println(xh.getEndTime());
					  }
				  }
			  }
		}
	}

	public UserInfoBean getUserInfoBean() {
		return userInfoBean;
	}

	public void setUserInfoBean(UserInfoBean userInfoBean) {
		this.userInfoBean = userInfoBean;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public void markListener(ActionEvent event){
		System.out.println("markListener");
		ExtendHolddate e=(ExtendHolddate) event.getComponent().getAttributes().get("xhd");
	    this.currentEhd=e;
	    System.out.println(currentEhd.getStartTime());
	    System.out.println(currentEhd.getEndTime());
	}
	
	public void groupmarkZeroListener(ActionEvent event){
		System.out.println("markListener");
		Mark m=(Mark) event.getComponent().getAttributes().get("mark");		
	    m.setMark(0);
	    markDAO.updateMark(m);
	}
	
	public String markPage(){
		System.out.println("markPage");
		return "TaMarkPage.xhtml";
	}
	
	public String returnMainPage(){
		return "TaMainPage.xhtml";
	}
	
	public String returnMarkPage(){
		return "TaMarkPage.xhtml";
	}
	
	public String groupMarkPage(){
		return "TaGroupmarkPage.xhtml";
	}
	
	public String assignIndividualMark(){
		HoldDate hd=this.getCurrentEhd().getHolddate();
		if(hd.getIndividualMark()==null){
		hd.setIndividualMark(new Mark());
		hd.getIndividualMark().setStudent(hd.getStudent());
		hd.getIndividualMark().setMark(this.getCurrentEhd().getIndividualMark());
		hd.getIndividualMark().setIndividualMark(true);
		markDAO.addMark(hd.getIndividualMark(), hd.getStudent().getId(), hd.getId());
		return "TaMarkPage.xhtml";
		}else{
			hd.getIndividualMark().setMark(this.getCurrentEhd().getIndividualMark());
			hd.getIndividualMark().setIndividualMark(true);
			markDAO.updateMark(hd.getIndividualMark());
			return "TaMarkPage.xhtml";
		}
	}
	
	public String assignGroupMark(){
		HoldDate hd=this.getCurrentEhd().getHolddate();
		List<Mark> marks=new ArrayList<Mark>();
		for(int i=0;i<this.getCurrentEhd().getGroups().size();i++){
			for (int j=0;j<this.getCurrentEhd().getGroups().get(i).getStudents().size();j++){
				Mark mark=new Mark();
				mark.setMark(this.getCurrentEhd().getGroupMark());
				mark.setStudent(this.getCurrentEhd().getGroups().get(i).getStudents().get(j));
				mark.setIndividualMark(false);
				markDAO.addMark(mark, mark.getStudent().getId(), hd.getId());
				marks.add(mark);
			}
		}
		hd.setGroupMark(marks);
		return "TaGroupmarkPage.xhtml";
	}
	
	public String selectPage(){
		this.exhd=new ArrayList<ExtendHolddate>();
		for(int i=0;i<((Ta) userInfoBean.getUser()).getCourse().getSections().size();i++){
			Section section=((Ta) userInfoBean.getUser()).getCourse().getSections().get(i);
			  for(int j=0;j<section.getSubSections().size();j++){
				  Subsection subsection=section.getSubSections().get(j);
				  for(int k=0;k<subsection.getHoldDate().size();k++){
					  HoldDate holddate=subsection.getHoldDate().get(k);
					 // System.out.println(holddate.getDate().getTime()-this.date.getTime());
					  if(holddate.getDate().getTime()-this.date.getTime()<86400000&&holddate.getTa().getId()==this.userInfoBean.getUser().getId()){
						  ExtendHolddate xh=new ExtendHolddate();
						  xh.setHolddate(holddate);
						  xh.setStartTime(subsection.getStartTime());
						  xh.setEndTime(subsection.getEndTime());
						  xh.setRoom(subsection.getRoom());
						  this.exhd.add(xh);
					  }
				  }
			  }
		}
		return "TaSelectPage.xhtml";
	}
	
	
	public String ChangeAssignStudent(){
		return "ChangeAssignStudent.xhtml";
	}
	
	public String ChangeAssignStudentFinish(){
		return "TaMarkPage.xhtml";
	}
	
	public void absentStudentListener(ActionEvent event){
		HoldDate hD=(HoldDate) event.getComponent().getAttributes().get("hd");
		this.getCurrentEhd().getHolddate().setAbsentStudent(this.getCurrentEhd().getHolddate().getStudent());
		this.getCurrentEhd().getHolddate().setStudentAbsent(true);
	}
	
	public void absentStudentFinishListener(ActionEvent event){
		Student s=(Student) event.getComponent().getAttributes().get("student");
	    this.getCurrentEhd().getHolddate().setStudent(s);
	    holddateDAO.updateHolddate(this.getCurrentEhd().getHolddate());
	}
}