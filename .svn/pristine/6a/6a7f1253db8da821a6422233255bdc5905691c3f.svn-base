package com.eece496.webapp.jdbcdao;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eece496.webapp.dao.MarkDAO;
import com.eece496.webapp.pojo.Mark;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MarkJdbcDAOTest {
	
	@Inject 
	MarkDAO markDao;
	

	@Test
	public void testAddMark() {
		boolean returnVal = false;
		Mark markToAdd = new Mark();
		markToAdd.setMark(80);
		markToAdd.setIndividualMark(false);
		returnVal = this.markDao.addMark(markToAdd, 7, 2);
		assertEquals(true, returnVal);
		returnVal = false;
		returnVal = this.markDao.deleteMark(markToAdd.getId());
		assertEquals(true, returnVal);
	}

	@Test
	public void testGetIndividualMark() {
		Mark mark = this.markDao.getIndividualMark(10);
		assertNull("", mark);
		mark = this.markDao.getIndividualMark(2);
		assertNotNull("", mark);
		assertEquals("", 2, mark.getId());
		assertEquals("", 8, mark.getStudentId());
		assertEquals("", 85, mark.getMark());
		assertEquals("", 2, mark.getHoldDateId());
		assertEquals("", true, mark.isIndividualMark());
		mark = this.markDao.getIndividualMark(1);
		assertNotNull("", mark);
		assertEquals("", 1, mark.getId());
		mark = this.markDao.getIndividualMark(3);
		assertNull("", mark);
	}

	@Test
	public void testGetGroupMarkOfHolddate() {
		List<Mark> markList = null;
		markList = this.markDao.getGroupMarkOfHolddate(1);
		assertNotNull("", markList);
		assertEquals("", 4, markList.size());
		markList = null;
		markList = this.markDao.getGroupMarkOfHolddate(2);
		assertNotNull("", markList);
		assertEquals("", 0, markList.size());
		markList = null;
		markList = this.markDao.getGroupMarkOfHolddate(3);
		assertNotNull("", markList);
		assertEquals("", 0, markList.size());
	}
	
	@Test
	public void testUpdateMark() {
		Mark mark = this.markDao.getIndividualMark(1);
		assertNotNull(mark);
		assertEquals(75, mark.getMark());
		mark.setMark(20);
		this.markDao.updateMark(mark);
		mark = null;
		mark = this.markDao.getIndividualMark(1);
		assertNotNull(mark);
		assertEquals(20, mark.getMark());
		mark.setMark(75);
		this.markDao.updateMark(mark);
		assertEquals(75, mark.getMark());
	}
	
	@Test
	public void testGetMarkById(){
		Mark mark = this.markDao.getMarkById(4);
		assertNotNull(mark);
	}
	
	@Test
	public void testGetAvgMarkOfStudent(){
		assertEquals(85,this.markDao.getAvgMarkOfStudent(8));
		assertEquals(75,this.markDao.getAvgMarkOfStudent(9));
	}

}
