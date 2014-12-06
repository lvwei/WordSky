package com.eece496.webapp.pojo;

public class User {
	public static final int ADMIN = 1;
	public static final int TA = 2;
	public static final int STUDENT = 3;
	protected String username;
	protected String firstName;
	protected String lastName;
	protected String password;
	protected int id;
	protected boolean isPasswordHashed;
	
	public User(){
		this.isPasswordHashed = false;
	}

	public User(String username, String password, String firstName,
			String lastName, int auth) {
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.authorization = auth;
		this.isPasswordHashed = false;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	protected int authorization;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setHashedPassword(String password) {
		this.password = password;
		this.isPasswordHashed = true;
	}

	public int getAuthorization() {
		return authorization;
	}

	public void setAuthorization(int authorization) {
		this.authorization = authorization;
	}

	public boolean isPasswordHashed() {
		return isPasswordHashed;
	}

	public void setPasswordHashed(boolean isPasswordHashed) {
		this.isPasswordHashed = isPasswordHashed;
	}


}
