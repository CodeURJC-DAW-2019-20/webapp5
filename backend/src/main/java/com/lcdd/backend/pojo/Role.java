package com.lcdd.backend.pojo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.lcdd.backend.pojo.User.Basico;

@Entity
public class Role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonView(Basico.class)
	private long id;
	@JsonView(Basico.class)
	private String name;
	
	@JsonIgnore
	@OneToMany(mappedBy="role")
	private List<User> users = new ArrayList<>();
	
	protected Role() {	}

	public Role(String name) {
		this.name = name;
	}
	
	public Role(String name, List<User> users) {
		super();
		this.name = name;
		this.users = users;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
	
}
