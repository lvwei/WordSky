package com.eece496.webapp.dao;

import java.util.List;

import com.eece496.webapp.pojo.HoldDate;
import com.eece496.webapp.pojo.Student;
import com.eece496.webapp.pojo.Ta;
import com.eece496.webapp.pojo.User;

public interface HolddateDAO {
	public boolean updateHolddate(HoldDate holddate);
	public boolean addHolddate(HoldDate holddate,int subsectionId);
	public boolean deleteHolddate(int holdDateId);
	public HoldDate getHolddate(int holddateId);
	public  List<HoldDate>getHolddateOfSubsection(int subSectionId);
	public HoldDate getEarliestDateOfStudent(int studentId, int SectionId, java.util.Date afterDate);
	public HoldDate getLatestDateOfStudent(int studentId, int SectionId);
}