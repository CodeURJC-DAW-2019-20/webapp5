package com.lcdd.backend.pojo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
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
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<Purchase> purchases = new ArrayList<>();
	
	@OneToMany(mappedBy="user")
	private List<EventRegister> eventsReg = new ArrayList<>();
	
	protected User() {}

	public User(String username) {
		this.name = username;
	}
	public User(String email, String name, String firstName, String lastName, String password, String  role,
			List<Purchase> purchases, List<EventRegister> eventsReg) {
		this.email = email;
		this.name = name;
		this.passwordHash = new BCryptPasswordEncoder().encode(password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.roles = new ArrayList<>(Arrays.asList(role));
		this.purchases = purchases;
		this.eventsReg = eventsReg;
	}
	
	public User(String email, String name, String firstName, String lastName, String passwordHash, Role role,String... roles) {
		super();
		this.email = email;
		this.name = name;
		this.firstName = firstName;
		this.lastName = lastName;
		this.passwordHash = new BCryptPasswordEncoder().encode(passwordHash);
		this.role = role;
		this.roles = new ArrayList<>(Arrays.asList(roles));
	}

	public User(String email, String name, String firstName, String lastName, String passwordHash, String... roles) {
		super();
		this.email = email;
		this.name = name;
		this.firstName = firstName;
		this.lastName = lastName;
		this.passwordHash = new BCryptPasswordEncoder().encode(passwordHash);
		this.roles = new ArrayList<>(Arrays.asList(roles));
	}
	
	

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
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
	public void addEventRegister(EventRegister register) {
		this.eventsReg.add(register);
	}
	
	
}