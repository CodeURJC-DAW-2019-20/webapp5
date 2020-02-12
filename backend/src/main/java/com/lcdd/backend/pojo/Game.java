package com.lcdd.backend.pojo;

public class Game {
	private long id;
	private String name;
	private String acronym;
	
	public Game(long id, String name, String acronym) {
		super();
		this.id = id;
		this.name = name;
		this.acronym = acronym;
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
	
	
}
