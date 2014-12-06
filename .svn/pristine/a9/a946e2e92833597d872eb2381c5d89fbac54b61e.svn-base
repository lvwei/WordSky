package com.eece496.webapp.dao;

import java.util.List;

import com.eece496.webapp.pojo.HoldDate;
import com.eece496.webapp.pojo.Mark;
import com.eece496.webapp.pojo.Student;
import com.eece496.webapp.pojo.Ta;
import com.eece496.webapp.pojo.User;

public interface MarkDAO {
	public boolean updateMark(Mark mark);
	public boolean addMark(Mark mark,int studentId,int holddateId);
	public boolean deleteMark(int holdDateId);
	public Mark getIndividualMark(int holdDateId);
	public Mark getMarkById(int markId);
	public List<Mark> getGroupMarkOfHolddate(int holddateId);
	public int getAvgMarkOfStudent(int studentId);
}