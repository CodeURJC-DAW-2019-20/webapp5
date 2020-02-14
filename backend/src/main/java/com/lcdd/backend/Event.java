package com.lcdd.backend;

import java.util.Date;

public class Event {
	
	private int id;
	private String name;
	private int game_id;
	private String place;
	private Date date;
	private String time; //tipo de dato TIME?
	private String description;
	private boolean is_tournament;
	private boolean is_single_participant;
	private float inscription_fee;
	private int max_participants;
	
	//private String award;   ??
	//private Image image;
	
	
	public Event() {}
	

}