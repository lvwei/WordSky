package com.eece496.webapp.developdao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Named;

import org.primefaces.model.DualListModel;

import com.eece496.webapp.dao.CourseDAO;
import com.eece496.webapp.dao.GroupDAO;
import com.eece496.webapp.dao.SectionDAO;
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
public class SectionDevDAO implements SectionDAO {

	@Override
	public Section getIndividualSection(int sectionId){
		return new Section();
	}


	
	
	@Override
	@SuppressWarnings("deprecation")
	public  List<Section>getSection(int courseId){
		List<Section> randSection=new ArrayList<Section>();
		for(int i=0;i<2;i++){
			randSection.add(new Section());
			Date start=new Date();
			start.setHours(1+i);
			Date end=new Date();
			end.setHours(5+i);
			randSection.get(i).setStartTime(start);
			randSection.get(i).setEndTime(end);
			List<Date> hd=new ArrayList<Date>();
			hd.add(new Date());
			hd.add(new Date());
			randSection.get(i).setHoldDate(hd);
		}

		return randSection;
	}




	@Override
	public boolean updateSection(Section section) {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public boolean addSection(Section section, int courseId) {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public boolean deleteSection(int sectionId) {
		// TODO Auto-generated method stub
		return false;
	}




	@Override
	public boolean cleanSection() {
		// TODO Auto-generated method stub
		return false;
	}


}