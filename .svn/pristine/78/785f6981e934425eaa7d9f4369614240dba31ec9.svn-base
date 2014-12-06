package com.eece496.webapp.jdbcdao;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eece496.webapp.dao.GroupDAO;
import com.eece496.webapp.pojo.Group;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class GroupJdbcDAOTest {
	
	@Inject
	private GroupDAO groupDao;

	@Test
	public void testGetGroup() {
		List<Group> groupList = this.groupDao.getGroup(1);
		assertNotNull("", groupList);
		assertEquals("", 2, groupList.size());
		groupList = null;
		groupList = this.groupDao.getGroup(5);
		assertNotNull("", groupList);
		assertEquals("", 0, groupList.size());
	}

	@Test
	public void testGetGroupOfSection() {
		List<Group> groupList = this.groupDao.getGroupOfSection(1);
		assertNotNull("", groupList);
		assertEquals("", 2, groupList.size());
		groupList = null;
		groupList = this.groupDao.getGroupOfSection(2);
		assertNotNull("", groupList);
		assertEquals("", 0, groupList.size());
	}

	@Test
	public void testGetGroupOfSubsection() {
		List<Group> groupList = this.groupDao.getGroupOfSubsection(2);
		assertNotNull("", groupList);
		assertEquals("", 2, groupList.size());
		groupList = null;
		groupList = this.groupDao.getGroupOfSubsection(3);
		assertNotNull("", groupList);
		assertEquals("", 2, groupList.size());
		groupList = null;
		groupList = this.groupDao.getGroupOfSubsection(4);
		assertNotNull("", groupList);
		assertEquals("", 0, groupList.size());
	}
	
	@Test
	public void testGetIndividualGroup(){
		Group group = this.groupDao.getIndividualGroup(1);
		assertNotNull("", group);
		assertEquals("", 1, group.getId());
		group = null;
		group = this.groupDao.getIndividualGroup(2);
		assertNotNull("", group);
		assertEquals("", 2, group.getId());
		group = this.groupDao.getIndividualGroup(3);
		assertNull("", group);
	}
	
	@Test
	public void testAddGroup(){
		Group group = new Group();
		this.groupDao.addGroup(group, 2);
		this.groupDao.deleteGroup(group.getId());
	}

}
