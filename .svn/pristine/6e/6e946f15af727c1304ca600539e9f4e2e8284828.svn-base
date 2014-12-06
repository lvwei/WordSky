package com.eece496.webapp.pojo;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.eece496.webapp.dao.MarkDAO;
import com.eece496.webapp.jdbcdao.MarkJdbcDAO;
import com.eece496.webapp.jsfbean.SpringContext;

import org.springframework.web.context.support.WebApplicationContextUtils;


public class MarkTableRow {
	private int markId;
	private String studentNumber;
	private String firstName;
	private String lastName;
	private int mark;
	private String course;
	private String date;
	private String sectionTime;
	private boolean isIndividualMark;
	private boolean isModified;
	

	private MarkDAO markDAO;
	
	public MarkTableRow(){
		
	}

	public MarkTableRow(int markId, String studentNumber, String firstName,
			String lastName, int mark, String course, String date,
			String sectionTime, boolean isIndividualMark) {
		super();
		this.markId = markId;
		this.studentNumber = studentNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mark = mark;
		this.course = course;
		this.date = date;
		this.sectionTime = sectionTime;
		this.isIndividualMark = isIndividualMark;
		this.isModified = false;
		

		this.markDAO = (MarkDAO) SpringContext.getApplicationContext().getBean("markDao");
	}

	public int getMarkId() {
		return markId;
	}

	public String getStudentNumber() {
		return studentNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getMark() {
		return mark;
	}

	public String getCourse() {
		return course;
	}

	public String getDate() {
		return date;
	}

	public String getSectionTime() {
		return sectionTime;
	}

	public boolean getIsIndividualMark() {
		return isIndividualMark;
	}

	public boolean isModified() {
		return isModified;
	}

	public void setMark(int mark) {
		this.isModified = true;
			System.out.println(this.toString());
			System.out.println("previous: "+ this.mark + "     new: "+ mark);
			this.mark = mark;
			try{
				if(this.markDAO==null)System.out.println("NULL 11111111"+this.markId);
			System.out.println("11111111"+this.markId);
			Mark _mark=this.markDAO.getMarkById(this.markId);
			System.out.println("222222222");
			_mark.setMark(mark);
			System.out.println("333333333");
			boolean v = this.markDAO.updateMark(_mark);
			System.out.println(v);
			}catch(Exception ex){
				ex.printStackTrace();
			}
	}

	@Override
	public String toString() {
		return "MarkTableRow [markId=" + markId + ", studentNumber="
				+ studentNumber + ", firstName=" + firstName + ", lastName="
				+ lastName + ", mark=" + mark + ", course=" + course
				+ ", date=" + date + ", sectionTime=" + sectionTime
				+ ", isIndividualMark=" + isIndividualMark + ", isModified="
				+ isModified + "]";
	}

//	@Override
//	public void setApplicationContext(ApplicationContext arg0)
//			throws BeansException {
//		this.ctx = arg0;
//		
//	}



}
