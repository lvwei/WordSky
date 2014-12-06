package com.eece496.webapp.serviceimpl;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.eece496.webapp.ProjectConfiguration;
import com.eece496.webapp.service.CWLAccountService;

@Named
public class CWLAccountServiceImpl implements CWLAccountService {
	public boolean login(String username, String password){
		if (ProjectConfiguration.IS_DB_READY) {
			return false;
		} else {
			if (username.equalsIgnoreCase(password)) {
				return true;
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Failed to login",
								"Incorrect Username or Password !"));
				return false;
			}
		}
	}
}
