package com.eece496.webapp.dao;

import com.eece496.webapp.pojo.User;

public interface UserDAO {
	public User getUser(String username, String password);
}
