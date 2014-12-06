package com.eece496.webapp.jdbcdao;

import javax.inject.Named;

import com.eece496.webapp.dao.UserDAO;
import com.eece496.webapp.pojo.User;

@Named
public class UserJdbcDAO implements UserDAO {

	@Override
	public User getUser(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
