package com.lcdd.backend;


public class Event {
	
	private String name;
	private String game;
	private String date;
	private String hour;
	private String award;
	private String description;
	//private Image image;
	
	
	public Event() {}
	
	public Event(
			String name,
			String game,
			String date,
			String award,
			String description) {
		this.name = name;
		this.game = game;
		this.date = date;
		this.award = award;
		this.description = description;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	
	
	public void setGame(String game) {
		this.game = game;
	}
	public String getGame() {
		return this.game;
	}
	
	
	public void setDate(String date) {
		this.date = date;
	}
	public String getDate() {
		return this.date;
	}
	
	
	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public void setAward(String award) {
		this.award = award;
	}
	public String getAward() {
		return this.award;
	}
	
	
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return this.description;
	}
	

}