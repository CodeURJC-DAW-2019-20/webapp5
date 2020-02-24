package com.lcdd.backend.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String email;
	private String name;
	private String firstName;
	private String lastName;
	private String passwordHash;
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
	
	@ManyToOne
	private Role role;
	
	@OneToMany(mappedBy="user")
	private List<Purchase> purchases = new ArrayList<>();
	
	@OneToMany(mappedBy="user")
	private List<EventRegister> eventsReg = new ArrayList<>();
	
	protected User() {}

	public User(String email, String username, String password, String firstName, String lastName, String  role,
			List<Purchase> purchases, List<EventRegister> eventsReg) {
		this.email = email;
		this.name = username;
		this.passwordHash = new BCryptPasswordEncoder().encode(password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.roles = new ArrayList<>(Arrays.asList(role));
		this.purchases = purchases;
		this.eventsReg = eventsReg;
	}
	
	public User(String username, String password,String... role) {
		this.name = username;
		this.passwordHash = password;
		this.passwordHash = new BCryptPasswordEncoder().encode(password);
		this.roles = new ArrayList<>(Arrays.asList(role));
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String username) {
		this.name = username;
	}

	public String getPassword() {
		return this.passwordHash;
	}

	public void setPassword(String password) {
		this.passwordHash = password;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public List<String> getRole() {
		return this.roles;
	}
	public void setRole(List<String> role) {
		this.roles = role;
	}

	public List<Purchase> getPurchases() {
		return this.purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	public List<EventRegister> getEventsReg() {
		return this.eventsReg;
	}

	public void setEventsReg(List<EventRegister> eventsReg) {
		this.eventsReg = eventsReg;
	}

	
	
	
}