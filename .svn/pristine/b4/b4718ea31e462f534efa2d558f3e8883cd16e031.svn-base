package com.eece496.webapp.jdbcdao;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.primefaces.model.DualListModel;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.eece496.webapp.dao.CourseDAO;
import com.eece496.webapp.pojo.Course;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class CourseJdbcDAOTest {

	@Inject
	private CourseDAO courseDao;

	@Test
	public void testGetCourse1() {
		Course course = this.courseDao.getCourse(1);
		assertEquals("message", 1, course.getId());
		assertEquals("message", true,
				course.getCourseName().equalsIgnoreCase("EECE 253 T1"));
		assertNull("message", course.getStartDate());
		assertNull("message", course.getEndDate());
	}

	@Test
	public void testGetCourse2() {
		Course course = this.courseDao.getCourse(3);
		assertEquals("message", 3, course.getId());
		assertEquals("message", true,
				course.getCourseName().equalsIgnoreCase("EECE 253 T2"));
		assertNull("message", course.getStartDate());
		assertNull("message", course.getEndDate());
	}

	@Test
	public void testGetCourse3() {
		Course course = this.courseDao.getCourse(4);
		assertEquals("message", 4, course.getId());
		assertEquals("message", true,
				course.getCourseName().equalsIgnoreCase("EECE 261 T1"));
		assertNull("message", course.getStartDate());
		assertNull("message", course.getEndDate());
	}

	@Test
	public void testGetCourse4() {
		Course course = this.courseDao.getCourse(5);
		assertEquals("message", 5, course.getId());
		assertEquals("message", true,
				course.getCourseName().equalsIgnoreCase("EECE 261 T2"));
		assertNull("message", course.getStartDate());
		assertNull("message", course.getEndDate());
	}

	@Test
	public void testGetCourse5() {
		Course course = this.courseDao.getCourse(10);
		assertNull("message", course);
	}

	@Test
	public void testGetCourses1() {
		DualListModel<Course> dualList = this.courseDao.getCourses(1);
		assertEquals("message", 1, dualList.getSource().size());
		assertEquals("message", 4, dualList.getTarget().size());
	}

	@Test
	public void testGetCourses2() {
		DualListModel<Course> dualList = this.courseDao.getCourses(2);
		assertEquals("message", 5, dualList.getSource().size());
		assertEquals("message", 0, dualList.getTarget().size());
		System.out.println(dualList.toString());
	}

	@Test
	public void testGetCourseForTa1() {
		Course course = this.courseDao.getCourseForTa(2);
		assertEquals("message", true,
				course.getCourseName().equalsIgnoreCase("EECE 253 T1"));
	}

	@Test
	public void testGetCourseForTa2() {
		Course course = this.courseDao.getCourseForTa(1);
		assertNull("message", course);
	}

}
