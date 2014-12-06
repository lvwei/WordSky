package com.eece496.webapp.jsfbean;

import javax.inject.Named;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@Named
public class SpringContext implements ApplicationContextAware {
	  private static ApplicationContext context;

	  public void setApplicationContext(ApplicationContext context) throws BeansException {
	    this.context = context;
	  }
	  public static ApplicationContext getApplicationContext() {
	    return context;
	  }
}