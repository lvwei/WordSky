package com.eece496.webapp.dao;

import java.util.List;

import com.eece496.webapp.pojo.Group;
import com.eece496.webapp.pojo.Student;
import com.eece496.webapp.pojo.User;

public interface GroupDAO {
	public Group getIndividualGroup(int groupId);
	
	public boolean addGroup(Group group,int sectionId);
	
	public boolean deleteGroup(int groupId);

	
	public List<Group> getGroup(int courseId);

	public List<Group> getGroupOfSection(int sectionId);

	public List<Group> getGroupOfSubsection(int subsectionId);

	boolean cleanGroup();
}