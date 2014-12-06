package com.eece496.webapp.pojo;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.inject.Named;

import com.eece496.webapp.helperclass.DateUtils;

public class HoldDate {
	private Date date;
	private Ta ta;
	private int id;
	private Student student;
	private String question;

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	private Student absentStudent;
	private Mark individualMark;
	private List<Mark> groupMark;
	Boolean studentAbsent = false;
	Boolean approvedAbsent=false;

	public Boolean getApprovedAbsent() {
		return approvedAbsent;
	}

	public void setApprovedAbsent(Boolean approvedAbsent) {
		this.approvedAbsent = approvedAbsent;
	}

	public Mark getIndividualMark() {
		return individualMark;
	}

	public void setIndividualMark(Mark individualMark) {
		this.individualMark = individualMark;
	}

	public List<Mark> getGroupMark() {
		return groupMark;
	}

	public void setGroupMark(List<Mark> groupMark) {
		this.groupMark = groupMark;
	}

	public HoldDate() {
		 this.studentAbsent = false;
		 this.approvedAbsent=false;
		this.student=null;
		this.ta=null;
		this.absentStudent=null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Student getAbsentStudent() {
		return absentStudent;
	}

	public void setAbsentStudent(Student absentStudent) {
		this.absentStudent = absentStudent;
	}

	public Boolean getStudentAbsent() {
		return studentAbsent;
	}

	public void setStudentAbsent(Boolean studentAbsent) {
		this.studentAbsent = studentAbsent;
	}

	public Ta getTa() {
		return ta;
	}

	public void setTa(Ta ta) {
		this.ta = ta;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}