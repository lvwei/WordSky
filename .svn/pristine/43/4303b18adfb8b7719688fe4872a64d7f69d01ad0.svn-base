package com.eece496.webapp.developdao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Named;

import org.primefaces.model.DualListModel;

import com.eece496.webapp.dao.CourseDAO;
import com.eece496.webapp.dao.UserDAO;
import com.eece496.webapp.pojo.Admin;
import com.eece496.webapp.pojo.Course;
import com.eece496.webapp.pojo.Group;
import com.eece496.webapp.pojo.HoldDate;
import com.eece496.webapp.pojo.Section;
import com.eece496.webapp.pojo.Student;
import com.eece496.webapp.pojo.Subsection;
import com.eece496.webapp.pojo.Ta;
import com.eece496.webapp.pojo.User;

//@Named
public class CourseDevDAO implements CourseDAO {
	
	@Override
	public Course getCourse(int courseId){
		return new Course();
	}
	

	
	@Override
	public DualListModel<Course> getCourses(int userId) {
		List<Course> randCourse = new ArrayList<Course>();
		randCourse.add(new Course("eece253T1"));
		randCourse.add(new Course("eece253T2"));
		randCourse.add(new Course("eece261T1"));
		randCourse.add(new Course("eece261T2"));
		return new DualListModel<Course>(new ArrayList<Course>(), randCourse);
	}

	@Override
	public Course getCourseForTa(int userId) {
		Course a = new Course();

		return a;
	}
	

}