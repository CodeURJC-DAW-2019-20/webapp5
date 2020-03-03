package com.lcdd.backend.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Game {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String acronym;
	
	@OneToMany(mappedBy="game")
	private List<Event> events = new ArrayList<>();
	
	protected Game(){ }

	public Game(String name, String acronym) {
		this.name = name;
		this.acronym = acronym;
	}
	
	public Game(String name, String acronym, List<Event> events) {
		this.name = name;
		this.acronym = acronym;
		this.events = events;
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

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
	
	
	
}
