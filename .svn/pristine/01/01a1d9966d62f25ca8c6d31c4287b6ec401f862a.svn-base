package com.eece496.webapp.jdbcdao;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eece496.webapp.dao.UserDAO;
import com.eece496.webapp.pojo.Student;
import com.eece496.webapp.pojo.Ta;
import com.eece496.webapp.pojo.User;
import com.eece496.webapp.service.Sha1HashService;
import com.eece496.webapp.serviceimpl.Sha1HashServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class UserJdbcDAOTest {

	@Inject
	private UserDAO userDao;
	
	@Inject
	private Sha1HashServiceImpl sha1HashService;
	

	@Test
	public void userExisted() throws NoSuchAlgorithmException {
		User user = this.userDao.getUser("TestAdmin", this.sha1HashService.sha1("TestAdmin"));
		assertNotNull(user);
		assertEquals("message", 1, user.getId());
		assertEquals(true, user.isPasswordHashed());
	}

	@Test
	public void userNotExisted() {
		User user = null;
		try {
			user = this.userDao.getUser("TestAdmin", this.sha1HashService.sha1("Testadmin"));
		} catch (Exception ex) {
			System.out.println("ex");
		}
		assertNull("message", user);
	}

	@Test
	public void taExisted() throws NoSuchAlgorithmException {
		Ta ta = (Ta) this.userDao.getUser("TestTa", this.sha1HashService.sha1("TestTa"));
		assertEquals("message", 2, ta.getId());
		assertEquals("message", true,
				ta.getUsername().equalsIgnoreCase("testta"));
		assertEquals("message", true, ta.getPassword().equals(this.sha1HashService.sha1("TestTa")));
		assertEquals("message", 2, ta.getAuthorization());
		assertEquals("message", true, ta.getStudentNumber().equals("40383091"));
	}

	@Test
	public void studentExisted() throws NoSuchAlgorithmException {
		Student student = (Student) this.userDao.getUser("Teststudent",
				this.sha1HashService.sha1("TestStudent"));
		assertEquals("message", 3, student.getId());
		assertEquals("message", true,
				student.getUsername().equalsIgnoreCase("Teststudent"));
		assertEquals("message", true,
				student.getPassword().equals(this.sha1HashService.sha1("TestStudent")));
		assertEquals("message", 3, student.getAuthorization());
		assertEquals("message", true,
				student.getStudentNumber().equals("40383092"));
	}

	@Test
	public void testGetTa() {
		List<Ta> taList = this.userDao.getTaListMarkCourse(1);
		assertNotNull("message", taList);
		assertEquals("message", 2, taList.size());
	}

	@Test
	public void testGetTa2() {
		List<Ta> taList = this.userDao.getTaListMarkCourse(3);
		assertNotNull("message", taList);
		assertEquals("message", 0, taList.size());
	}

	@Test
	public void testGetTa3() {
		List<Ta> taList = this.userDao.getTaListMarkCourse(4);
		assertNotNull("message", taList);
		assertEquals("message", 1, taList.size());
	}

	@Test
	public void testGetStudent() {
		List<Student> studentList = this.userDao.getStudentListRegisterInCourse(1);
		assertNotNull("message", studentList);
		assertEquals("message", 5, studentList.size());
	}

	@Test
	public void testGetStudent2() {
		List<Student> studentList = this.userDao.getStudentListRegisterInCourse(3);
		assertNotNull("message", studentList);
		assertEquals("message", 2, studentList.size());
	}

	@Test
	public void testGetStudent3() {
		List<Student> studentList = this.userDao.getStudentListRegisterInCourse(4);
		assertNotNull("message", studentList);
		assertEquals("message", 0, studentList.size());
	}
	
	@Test
	public void testGetGroupStudent() {
		List<Student> studentList = this.userDao.getGroupStudent(1);
		assertNotNull("message", studentList);
		assertEquals("message", 2, studentList.size());
		studentList = null;
		studentList = this.userDao.getGroupStudent(2);
		assertNotNull("message", studentList);
		assertEquals("message", 3, studentList.size());
	}
	
	@Test
	public void testGetTaOfHolddate(){
		Ta ta = this.userDao.getTaOfHolddate(1);
		assertNotNull("message", ta);
		assertEquals("message", 2, ta.getId());
		assertEquals("message", true, ta.getUsername().equalsIgnoreCase("testta"));
		ta = null;
		ta = this.userDao.getTaOfHolddate(2);
		assertNotNull("message", ta);
		assertEquals("message", 4, ta.getId());
		assertEquals("message", true, ta.getUsername().equalsIgnoreCase("testta2"));
	}
	
	@Test
	public void testGetStudentOfHolddate(){
		Student student = this.userDao.getStudentOfHolddate(1);
		assertNotNull("message", student);
		assertEquals("message", 6, student.getId());
		assertEquals("message", true, student.getUsername().equalsIgnoreCase("teststudent2"));
		student = null;
		student = this.userDao.getStudentOfHolddate(2);
		assertNotNull("message", student);
		assertEquals("message", 8, student.getId());
		assertEquals("message", true, student.getUsername().equalsIgnoreCase("teststudent4"));
	}
	
	@Test
	public void testGetAbsentStudentOfHolddate(){
		Student student = this.userDao.getAbsentStudentOfHolddate(2);
		assertNull("message", student);
		student = null;
		student = this.userDao.getAbsentStudentOfHolddate(1);
		assertNotNull("message", student);
		assertEquals("message", 8, student.getId());
		assertEquals("message", true, student.getUsername().equalsIgnoreCase("teststudent4"));
	}
	
	@Test
	public void testAddDeleteUser(){
		User userForAdd = new User("testblahblahblah","test","test","test",1 );
		boolean returnValue = this.userDao.addUser(userForAdd);
		assertEquals(true,returnValue);
		
		User user = this.userDao.getUser(userForAdd.getUsername(), userForAdd.getPassword());
		assertNotNull(user);
		assertEquals(user.getId(), userForAdd.getId());
		assertEquals(user.getUsername(), userForAdd.getUsername());
		assertEquals(user.getLastName(), userForAdd.getLastName());
		assertEquals(user.getFirstName(), userForAdd.getFirstName());
		assertEquals(user.getAuthorization(), userForAdd.getAuthorization());
		
		returnValue = this.userDao.deleteUser(userForAdd.getId());
		assertEquals(true, returnValue);
	}
	
	@Test
	public void testAddDeleteTaAndStudent(){
		Student studentToAdd = new Student("teststudentblahblahblah","testStudent","test","test",3, "40483093");
		Ta taToAdd = new Ta("testtablahblahblah","testStudent","test","test",2, "40483094");
		boolean returnVal = false;
		returnVal = this.userDao.addStudent(studentToAdd);
		assertEquals(true, returnVal);
		returnVal = this.userDao.addStudent(studentToAdd);
		assertEquals(false, returnVal);
		returnVal = this.userDao.addTa(taToAdd);
		assertEquals(true, returnVal);
		returnVal = this.userDao.addTa(taToAdd);
		assertEquals(false, returnVal);
		
		this.userDao.deleteUser(studentToAdd.getId());
		this.userDao.deleteUser(taToAdd.getId());
	}
	
	@Test
	public void testTaMarksCourse(){
		boolean returnVal = false;
		returnVal = this.userDao.deleteTaMarksCourse(5, 4);
		assertEquals(true, returnVal);
		returnVal = false;
		returnVal = this.userDao.addTaMarksCourse(5, 4);
		assertEquals(true, returnVal);
		returnVal = this.userDao.addTaMarksCourse(5, 4);
		assertEquals(false, returnVal);
	}
	
	@Test
	public void testStudentRegisterCourse(){
		boolean returnVal = false;
		returnVal = this.userDao.addStudentRegisterCourse(3, 3);
		assertEquals(true, returnVal);
		returnVal = this.userDao.addStudentRegisterCourse(3, 3);
		assertEquals(false, returnVal);
		returnVal = this.userDao.deleteStudentRegisterCourse(3, 3);
		assertEquals(true, returnVal);
	}
	
	@Test
	public void testStudentInGroup(){
		boolean returnVal = false;
		returnVal = this.userDao.deleteStudentInGroup(9, 2);
		assertEquals(true, returnVal);
		returnVal = false;
		returnVal = this.userDao.addStudentInGroup(9, 2);
		assertEquals(true, returnVal);
		returnVal = this.userDao.addStudentInGroup(9, 2);
		assertEquals(false, returnVal);
	}
	
	@Test
	public void testUpdateStudent(){
		Student student = this.userDao.getStudent(3);
		student.setFirstName("testfirstName");
		student.setStudentNumber("Testblahblahblah");
		boolean returnVal = this.userDao.updateStudent(student);
		assertTrue(returnVal);
		student.setFirstName("Test");
		student.setStudentNumber("40383092");
		this.userDao.updateStudent(student);
	}
	
	@Test
	public void testUpdateTat(){
		Ta ta = this.userDao.getTa(2);
		ta.setFirstName("testfirstName");
		ta.setStudentNumber("Testblahblahblah");
		boolean returnVal = this.userDao.updateTa(ta);
		assertTrue(returnVal);
		ta.setFirstName("Test");
		ta.setStudentNumber("40383091");
		this.userDao.updateTa(ta);
	}
}
