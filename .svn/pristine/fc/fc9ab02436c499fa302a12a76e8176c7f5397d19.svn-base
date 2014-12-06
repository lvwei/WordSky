package com.eece496.webapp.jdbcdao;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eece496.webapp.dao.SectionDAO;
import com.eece496.webapp.pojo.Section;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class SectionJdbcDAOTest {
	
	@Inject
	private SectionDAO sectionDao;

	@Test
	public void testGetIndividualSection() {
		Section section = this.sectionDao.getIndividualSection(1);
		assertNotNull("", section);
		assertEquals("", 1, section.getId());
		section = this.sectionDao.getIndividualSection(2);
		assertNotNull("", section);
		assertEquals("", 2, section.getId());
		section = this.sectionDao.getIndividualSection(3);
		assertNull("", section);
	}

	@Test
	public void testGetSection() {
		List<Section> sectionList = this.sectionDao.getSection(1);
		assertNotNull("", sectionList);
		assertEquals("", 2, sectionList.size());
		sectionList = null;
		sectionList = this.sectionDao.getSection(2);
		assertNotNull("", sectionList);
		assertEquals("", 0, sectionList.size());
	}
	
	@Test
	public void addSectionTest(){
		Section section = new Section();
		section.setRoom("test room");
		Date time = new Date();
		time.setHours(20);time.setMinutes(2);time.setSeconds(1);
		section.setStartTime(time);
		section.setEndTime(time);
		boolean returnVal = false;
		returnVal=this.sectionDao.addSection(section, 3);
		assertEquals(true, returnVal);
		returnVal = false;
		returnVal = this.sectionDao.deleteSection(section.getId());
		assertEquals(true, returnVal);
	}
	@Test
	public void testUpdateSection() {
		Section section = this.sectionDao.getIndividualSection(1);
		section.getEndTime().setHours(22);
		boolean returnVal = this.sectionDao.updateSection(section);
		assertTrue(returnVal);
		returnVal = false;
		section.setRoom("test room");
		returnVal = this.sectionDao.updateSection(section);
		assertTrue(returnVal);
		section.getEndTime().setHours(14);
		section.setRoom("Kaiser 2020");
		this.sectionDao.updateSection(section);
	}
}
