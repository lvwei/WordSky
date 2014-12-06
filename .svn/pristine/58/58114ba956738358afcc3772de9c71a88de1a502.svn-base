package com.eece496.webapp.jdbcdao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eece496.webapp.dao.SubsectionDAO;
import com.eece496.webapp.pojo.Subsection;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class SubsectionJdbcDAOTest {
	
	@Inject
	private SubsectionDAO subsectionDao;

	@Test
	public void testAddSubsection() {
		boolean returnVal = false;
		Subsection subToAdd = new Subsection();
		subToAdd.setStartTime(new Date());
		subToAdd.getStartTime().setHours(17);
		subToAdd.setEndTime(new Date());
		subToAdd.getEndTime().setHours(18);
		returnVal = this.subsectionDao.addSubsection(subToAdd, 1);
		assertEquals(true, returnVal);
		returnVal = false;
		returnVal = this.subsectionDao.deleteSubsection(subToAdd.getId());
		assertEquals(true, returnVal);
	}

	@Test
	public void testGetIndividualSubsection() {
		Subsection sub = this.subsectionDao.getIndividualSubsection(1);
		assertNull("", sub);
		sub = this.subsectionDao.getIndividualSubsection(2);
		assertNotNull("", sub);
		assertEquals("", 2, sub.getId());
		sub = null;
		sub = this.subsectionDao.getIndividualSubsection(3);
		assertNotNull("", sub);
		assertEquals("", 3, sub.getId());
	}

	@Test
	public void testGetSubsection() {
		List<Subsection> subList = this.subsectionDao.getSubsection(1);
		assertNotNull("", subList);
		assertEquals("", 2, subList.size());
		subList = null;
		subList = this.subsectionDao.getSubsection(2);
		assertNotNull("", subList);
		assertEquals("", 0, subList.size());
	}
	
	@Test
	public void testUpdateSubsection(){
		Subsection sub = this.subsectionDao.getIndividualSubsection(2);
		sub.getStartTime().setHours(23);
		boolean returnVal = this.subsectionDao.updateSection(sub);
		assertTrue(returnVal);
		sub.getStartTime().setHours(13);
		this.subsectionDao.updateSection(sub);
	}

}
