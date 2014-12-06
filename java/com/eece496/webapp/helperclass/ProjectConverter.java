package com.eece496.webapp.helperclass;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;

import com.eece496.webapp.pojo.Course;

public class ProjectConverter implements Converter {
@Override
public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {

		Course c=new Course();
			c.setCourseName(arg2);
		return c;   

}

@Override
public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {

		return ((Course) arg2).getCourseName();

}


}