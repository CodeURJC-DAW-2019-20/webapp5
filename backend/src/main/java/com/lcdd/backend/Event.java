package com.lcdd.backend;

import java.awt.Image;

import org.springframework.stereotype.Controller;

@Controller
public class Event {
	
	private String name;
	private String game;
	private String date;
	private String location;
	private String description;
	private String image;
	
	
	public Event() {
		this.name = "Partido de futbol";
		this.game = "futbol";
		this.date = "15/15/15";
		this.location = "madrid";
		this.description = "esto es una descripción";
		this.image = "/assets/img/event-image.png";
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
	
	
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLocation() {
		return this.location;
	}
	
	
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDescription() {
		return this.description;
	}
	
	
	public void setImage(String image) {
		this.image = image;
	}
	public String getImage() {
		return this.image;
	}
}