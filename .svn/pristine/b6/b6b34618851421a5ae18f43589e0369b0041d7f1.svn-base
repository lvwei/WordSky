package com.eece496.webapp.jdbcdao;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eece496.webapp.dao.MarkTableRowDAO;
import com.eece496.webapp.dao.UserDAO;
import com.eece496.webapp.pojo.MarkTableRow;
import com.eece496.webapp.pojo.User;
import com.eece496.webapp.service.Sha1HashService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class MarkTableRowJdbcDAOTest {
	
	@Inject
	private Sha1HashService sha1HashService;
	
	@Inject
	private UserDAO userDao;
	
	@Inject
	private MarkTableRowDAO markTableRowDao;

	@Test
	public void testGetMarkTableRowOfUser() throws NoSuchAlgorithmException {
		User admin = userDao.getUser("testadmin", this.sha1HashService.sha1("TestAdmin"));
		List<MarkTableRow> adminMarkList = this.markTableRowDao.getMarkTableRowOfUser(admin);
		assertNotNull(adminMarkList);
		assertEquals(6,adminMarkList.size());
		adminMarkList = null;
		User ta = userDao.getTa(2);
		adminMarkList = this.markTableRowDao.getMarkTableRowOfUser(ta);
		assertNotNull(adminMarkList);
		assertEquals(5,adminMarkList.size());
	}

}
