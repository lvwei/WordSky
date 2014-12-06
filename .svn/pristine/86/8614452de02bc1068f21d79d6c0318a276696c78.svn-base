package com.eece496.webapp.pojo;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.inject.Named;

import com.eece496.webapp.helperclass.DateUtils;

public class Section {
	
	private int groupLimit;
	private List<Group> groups;
	private List<Subsection> subSections;
	private Date startTime;
	private Date endTime;
	private String room;
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int holdDateToSet;
	private List<Date> holdDate;
	
	public Section(){
		
		this.groupLimit=2;
		this.subSections=new ArrayList<Subsection>();
		this.groups=new ArrayList<Group>();
		this.holdDate=new ArrayList<Date>();
		this.room="default";
		
	}
	
	public int getGroupLimit() {
		return groupLimit;
	}
	public void setGroupLimit(int groupLimit) {
		this.groupLimit = groupLimit;
	}
	public List<Group> getGroups() {
		//return this.sectionDao.getGroupInSection(this.id);
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
	

	public List<Date> getHoldDate() {
		//return this.sectionDao.getHoldDateInSection(this.id);
		return holdDate;
	}

	public void setHoldDate(List<Date> holdDate) {
		this.holdDate = holdDate;
	}

	public List<Subsection> getSubSections() {
		//return this.sectionDao.getSubsectionInSection(this.id);
		return subSections;
	}

	public void setSubSections(List<Subsection> subSections) {
		this.subSections = subSections;
	}

	public int getHoldDateToSet() {
		return holdDateToSet;
	}

	public void setHoldDateToSet(int holdDateToSet) {
		this.holdDateToSet = holdDateToSet;
	}
	
	public void holdDateSet() {
		this.holdDate=new ArrayList<Date>();
		for(int i=0;i<this.holdDateToSet;i++){
		this.holdDate.add(new Date());				
		}
		
	}

	public void divideSection(int divideNum){
		System.out.println("divideSection");
		this.subSections=new ArrayList<Subsection>();
		long interval=this.endTime.getTime()-this.startTime.getTime();
		long jump=interval/divideNum;
		Date start=new Date();
		Date end=new Date();	
		start.setTime(this.startTime.getTime()-jump);
		end.setTime(this.startTime.getTime());
		
		
		for(int i=0;i<divideNum;i++){
			start.setTime(start.getTime()+jump);
			end.setTime(end.getTime()+jump);
			this.subSections.add(new Subsection());
			Date starttime=new Date();
			starttime.setTime(start.getTime());
			Date endtime=new Date();
			endtime.setTime(end.getTime());
			this.subSections.get(i).setStartTime(starttime);
			this.subSections.get(i).setEndTime(endtime);
			this.subSections.get(i).setGroups(this.groups);
			this.subSections.get(i).setRoom(this.room);
			List<HoldDate> hds=new ArrayList<HoldDate>();
			for(int j=0;j<this.holdDate.size();j++){
			HoldDate hd=new HoldDate();	
			/*
			List<Mark> groupMark=new ArrayList<Mark>();
				for(int k=0;k<this.groups.size();k++){
					for(int l=0;l<this.groups.get(k).getStudents().size();l++){
						groupMark.add(new Mark(this.groups.get(k).getStudents().get(l)));
					}
				}
				
				hd.setGroupMark(groupMark);
				*/
				Date date=new Date();
				date.setTime(this.holdDate.get(j).getTime());
				hd.setDate(date);
				hds.add(hd);
			}
			this.subSections.get(i).setHoldDate(hds);
		}
		System.out.println("divideSection.......");
	}
}