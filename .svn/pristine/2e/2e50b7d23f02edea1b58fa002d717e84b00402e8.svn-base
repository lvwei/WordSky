package com.eece496.webapp.jdbcdao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eece496.webapp.dao.HolddateDAO;
import com.eece496.webapp.dao.SectionDAO;
import com.eece496.webapp.dao.UserDAO;
import com.eece496.webapp.pojo.HoldDate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class HolddateJdbcDAOTest {
	
	@Inject
	private HolddateDAO holddateDao;
	
	@Inject
	private UserDAO userDao;

	@Test
	public void testAddAndUpdateHolddate() {
		HoldDate holdDate = new HoldDate();
		holdDate.setDate(new Date());
		holdDate.setStudent(this.userDao.getStudent(3));
		holdDate.setAbsentStudent(null);
		holdDate.setTa(null);
		boolean returnVal = this.holddateDao.addHolddate(holdDate, 3);
		assertTrue(returnVal);
		returnVal = false;
		holdDate.setTa(this.userDao.getTa(2));
		returnVal = this.holddateDao.updateHolddate(holdDate);
		assertTrue(returnVal);
		returnVal = false;
		holdDate.setStudent(null);
		returnVal = this.holddateDao.updateHolddate(holdDate);
		assertTrue(returnVal);
		this.holddateDao.deleteHolddate(holdDate.getId());
	}

	@Test
	public void testGetHolddate() {
		HoldDate holdDate = this.holddateDao.getHolddate(1);
		assertNotNull("", holdDate);
		assertEquals("", 1, holdDate.getId());
		holdDate = null;
		holdDate = this.holddateDao.getHolddate(2);
		assertNotNull("", holdDate);
		assertEquals("", 2, holdDate.getId());
		holdDate = this.holddateDao.getHolddate(3);
		assertNull("", holdDate);
	}

	@Test
	public void testGetHolddateOfSubsection() {
		List<HoldDate> holdDateList = this.holddateDao.getHolddateOfSubsection(1);
		assertNotNull("", holdDateList);
		assertEquals("", 0, holdDateList.size());
		holdDateList = null;
		holdDateList = this.holddateDao.getHolddateOfSubsection(2);
		assertNotNull("", holdDateList);
		assertEquals("", 4, holdDateList.size());
	}
	
	@Test
	public void testGetHolddateByTimeOrder() throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date afterDate = dateFormat.parse("2013-01-01");
		HoldDate holdDate = this.holddateDao.getEarliestDateOfStudent(6, 1, afterDate);
		assertNotNull(holdDate);
		assertEquals(19, holdDate.getId());
		holdDate = null;
		afterDate = dateFormat.parse("2013-02-01");
		holdDate = this.holddateDao.getEarliestDateOfStudent(6, 1, afterDate);
		assertNotNull(holdDate);
		assertEquals(18, holdDate.getId());
		holdDate = null;
		holdDate = this.holddateDao.getLatestDateOfStudent(6, 1);
		assertNotNull(holdDate);
		assertEquals(18, holdDate.getId());
		holdDate = null;
		holdDate = this.holddateDao.getLatestDateOfStudent(8, 1);
		assertNotNull(holdDate);
		assertEquals(2, holdDate.getId());
		holdDate = null;
		holdDate = this.holddateDao.getEarliestDateOfStudent(8, 1, afterDate);
		assertNotNull(holdDate);
		assertEquals(2, holdDate.getId());
	}

}
