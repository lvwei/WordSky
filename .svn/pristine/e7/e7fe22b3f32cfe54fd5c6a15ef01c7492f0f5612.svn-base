package com.eece496.webapp.jsfbean;

import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.eece496.webapp.dao.MarkTableRowDAO;
import com.eece496.webapp.dao.UserDAO;
import com.eece496.webapp.pojo.MarkTableRow;
import com.eece496.webapp.pojo.User;
import com.eece496.webapp.service.Sha1HashService;

@Named
@Scope("request")
public class MarkTableBean {
	private List<MarkTableRow> markTableRows;
	private List<MarkTableRow> filteredTableRows;
	
	@Inject
	private Sha1HashService sha1HashService;
	
	@Inject
	private UserDAO userDao;
	
	@Inject
	private MarkTableRowDAO markTableRowDao;
	
	@Inject
	UserInfoBean userInfoBean;

	public MarkTableBean() {
	}
	
	@PostConstruct
   public void initialize(){
		User user = this.userInfoBean.getUser();
		this.markTableRows = this.markTableRowDao.getMarkTableRowOfUser(user);
		System.out.println(">>>>>>>>>>>>>>>>" + markTableRows.size());
	   
   }
	public List<MarkTableRow> getMarkTableRows() {

		
		return markTableRows;
	}

	public List<MarkTableRow> getFilteredTableRows() {
		return filteredTableRows;
	}

	public void setMarkTableRows(List<MarkTableRow> markTableRows) {
		this.markTableRows = markTableRows;
	}

	public void setFilteredTableRows(List<MarkTableRow> filteredTableRows) {
		this.filteredTableRows = filteredTableRows;
	}
}
