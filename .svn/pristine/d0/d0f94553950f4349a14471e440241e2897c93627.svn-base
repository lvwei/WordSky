package com.eece496.webapp;

import java.io.Serializable;

import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;

import org.springframework.context.annotation.Scope;

@Named("helloWorldBean")
@Scope("session")
public class HelloWorldBean implements Serializable {
	
	public HelloWorldBean(){
		System.out.println(">>>>>>>>>>>>>>>>       HelloWorldBean created    <<<<<<<<<<<<<<<<<<<<<<<<");
		ServletContext servletContext = (ServletContext) FacesContext
			    .getCurrentInstance().getExternalContext().getContext();
		System.out.println(servletContext.getInitParameter("primefaces.THEME"));
	}

	private String firstname;
	
	public String getFirstname() {
		System.out.println(">>>>>>>>>>>>>>>>       getFirstname called    <<<<<<<<<<<<<<<<<<<<<<<<");
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
		System.out.println(">>>>>>>>>>>>>>>>       setFirstname called    <<<<<<<<<<<<<<<<<<<<<<<<");
	}
	
	public String onclick(){
		System.out.println(">>>>>>>>>>>>>>>>      2 setFirstname called    <<<<<<<<<<<<<<<<<<<<<<<<");
		return null;
	}
}