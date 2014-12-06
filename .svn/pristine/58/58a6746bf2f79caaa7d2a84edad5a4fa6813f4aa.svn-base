package com.eece496.webapp.serviceimpl;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eece496.webapp.service.Sha1HashService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class Sha1HashServiceImplTest {
	
	@Inject
	private Sha1HashServiceImpl sha1HashService;

	@Test
	public void testSha1() {
		try {
			System.out.println(this.sha1HashService.sha1("TestAdmin"));
			System.out.println(this.sha1HashService.sha1("TestAdmin").length());
			System.out.println(this.sha1HashService.sha1("TestTa"));
			System.out.println(this.sha1HashService.sha1("TestStudent"));
			System.out.println(this.sha1HashService.sha1("TestTa2"));
			System.out.println(this.sha1HashService.sha1("TestTa3"));
			System.out.println(this.sha1HashService.sha1("TestTa3").length());
			System.out.println(this.sha1HashService.sha1("TestStudent2"));
			System.out.println(this.sha1HashService.sha1("TestStudent3"));
			System.out.println(this.sha1HashService.sha1("TestStudent4"));
			System.out.println(this.sha1HashService.sha1("TestStudent5"));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
