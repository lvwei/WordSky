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

import com.eece496.webapp.dao.HolddateDAO;
import com.eece496.webapp.pojo.Admin;
import com.eece496.webapp.pojo.Course;
import com.eece496.webapp.pojo.HoldDate;
import com.eece496.webapp.pojo.Ta;
import com.eece496.webapp.pojo.User;


@Named("HolddateBean")
@Scope("session")
public class HolddateBean  {
@Inject
HolddateDAO holddateDAO;
	
	public HoldDate getHd() {
		return hd;
	}

	public void setHd(HoldDate hd) {
		this.hd = hd;
	}

	HoldDate hd;
	
	
	public void changeAssignedTaListener(ActionEvent event){
		  
		this.hd =  (HoldDate) event.getComponent().getAttributes().get("HD");
 }
	public void changeAssignedTaFinishListener(ActionEvent event){
		this.hd.setTa( (Ta) event.getComponent().getAttributes().get("NewAssignTa"));
		holddateDAO.updateHolddate(this.hd);
 }
}