package com.lcdd.backend;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class UserSession {
	private long id;
	private String username;
	private String email;
	private String firstName;
	private String lastName;
	private long roleId;
	private Boolean isLogggedIn = false;
	
	
	public Boolean getIsLogggedIn() {
		return isLogggedIn;
	}

	public void setIsLogggedIn(Boolean isLogggedIn) {
		this.isLogggedIn = isLogggedIn;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	
	
}
