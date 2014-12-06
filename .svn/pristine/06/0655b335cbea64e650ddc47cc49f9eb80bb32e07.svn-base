package com.eece496.webapp.jsfbean;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.eece496.webapp.dao.MarkDAO;

@Named
@Scope("request")
public class StudentPageBean {
	
	private int averageMark;
	
	@Inject
	private UserInfoBean userInfoBean;
	
	@Inject
	private MarkDAO markDao;

	@PostConstruct
	public void init(){
		int studentId = userInfoBean.getUser().getId();
		this.averageMark = this.markDao.getAvgMarkOfStudent(studentId);
	}
	
	public int getAverageMark() {
		return averageMark;
	}

	public void setAverageMark(int averageMark) {
		this.averageMark = averageMark;
	}

}
