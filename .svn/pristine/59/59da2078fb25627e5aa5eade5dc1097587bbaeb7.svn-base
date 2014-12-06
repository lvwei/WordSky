package com.eece496.webapp.helperclass;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.TransferEvent;

import com.eece496.webapp.pojo.Course;
import com.eece496.webapp.pojo.Student;
import com.eece496.webapp.ProjectConfiguration;
import com.eece496.webapp.service.CWLAccountService;

@Named
public class CourseList {

	public static List<Course>ramdomCourse(){
		List<Course> randCourse=new ArrayList<Course>();
		randCourse.add(new Course("eece253"));
		randCourse.add(new Course("eece263"));
		randCourse.add(new Course("eece273"));
		randCourse.add(new Course("eece243"));
		randCourse.add(new Course("eece223"));
		return randCourse;
	}
	
	public static List<Student>ramdomStudent(){
		List<Student> randStudent=new ArrayList<Student>();

		for(int i=0;i<10;i++){
			String t="eece"+Integer.toString(i);
			randStudent.add(new Student(t,"a",Integer.toString(i)));
		}
		return randStudent;
	}
	
	
	public static List<String>suggestStudent(){
		List<String> randStudent=new ArrayList<String>();

		for(int i=0;i<10;i++){
			String t="eece"+Integer.toString(i);
			randStudent.add(t);
		}
		return randStudent;
	}
	
}
