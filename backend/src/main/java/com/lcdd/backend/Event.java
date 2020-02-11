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
	private Image image;
	
	
	public Event() {}
	
	public Event() {
		this.name = name;
		this.game = game;
		this.date = date;
		this.location = location;
		this.description = description;
		this.image = image;
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
	
	
	public void setImage(Image image) {
		this.image = image;
	}
	public Image getImage() {
		return this.image;
	}
}