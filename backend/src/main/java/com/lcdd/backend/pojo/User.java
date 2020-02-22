package com.lcdd.backend.pojo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class User {
	private long id;
	private String email;
	private String usermail;
	private String passwordHash;
	private String firstName;
	private String lastName;
	private int role;
	
	public User(long id, String email, String usermail, String password, String firstName, String lastName, int role) {
		super();
		this.id = id;
		this.email = email;
		this.usermail = usermail;
		this.passwordHash = new BCryptPasswordEncoder().encode(password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsermail() {
		return usermail;
	}
	public void setUsermail(String usermail) {
		this.usermail = usermail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	
	
}
