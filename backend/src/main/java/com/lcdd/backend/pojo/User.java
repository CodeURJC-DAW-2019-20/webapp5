package com.lcdd.backend.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String email;
	private String usermail;
	private String password;
	private String firstName;
	private String lastName;
	
	@ManyToOne
	private Role role;
	
	@OneToMany(mappedBy="user")
	private List<Purchase> purchases = new ArrayList<>();
	
	@OneToMany(mappedBy="user")
	private List<EventRegister> eventsReg = new ArrayList<>();
	
	protected User() {}

	public User(String email, String usermail, String password, String firstName, String lastName, Role role,
			List<Purchase> purchases, List<EventRegister> eventsReg) {
		this.email = email;
		this.usermail = usermail;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.purchases = purchases;
		this.eventsReg = eventsReg;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	public List<EventRegister> getEventsReg() {
		return eventsReg;
	}

	public void setEventsReg(List<EventRegister> eventsReg) {
		this.eventsReg = eventsReg;
	}

	
	
	
}