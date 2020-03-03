package com.lcdd.backend.pojo;


public class RegisterDataForm {

	private String email;
	private String name;
	private String firstName;
	private String lastName;
	private String passwordHash;

	
	public RegisterDataForm(String email, String name, String firstName, String lastName, String passwordHash) {
		super();
		this.email = email;
		this.name = name;
		this.firstName = firstName;
		this.lastName = lastName;
		this.passwordHash = passwordHash;
	}

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	
}
