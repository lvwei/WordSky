package com.eece496.webapp.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Named;

import com.eece496.webapp.helperclass.DateUtils;

public class Subsection {
	
	private int groupLimit;
	private List<Group> groups;
	private Date startTime;
	private Date endTime;
	private int id;
	private String room;
	private List<HoldDate> holdDate;
	
	public Subsection(){
		this.groupLimit=2;
		this.groups=new ArrayList<Group>();
		this.holdDate=new ArrayList<HoldDate>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGroupLimit() {
		return groupLimit;
	}
	public void setGroupLimit(int groupLimit) {
		this.groupLimit = groupLimit;
	}
	public List<Group> getGroups() {
		//return this.subsectionDao.getGroupInSubsection(this.id);
		return groups;
	}
	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;

	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;

	}


	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}
	

	public List<HoldDate> getHoldDate() {
		//return this.subsectionDao.getHoldDateInSubsection(this.id);
		return holdDate;
	}

	public void setHoldDate(List<HoldDate> holdDate2) {
		this.holdDate = holdDate2;
	}



}