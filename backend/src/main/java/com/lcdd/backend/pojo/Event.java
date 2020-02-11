package com.lcdd.backend.pojo;

public class Event {
	private int id;
	private String name;
	private int gameId;
	private String place;
	private String date;
	private String time;
	private String description;
	
	public Event(int id, String name, int gameId, String place, String date, String time, String description) {
		super();
		this.id = id;
		this.name = name;
		this.gameId = gameId;
		this.place = place;
		this.date = date;
		this.time = time;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
