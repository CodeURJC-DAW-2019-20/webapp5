package com.lcdd.backend.pojo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;

//@Entity
public class Event {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	private String name;
	private long gameId;
	private String place;
	private LocalDate date;//yyyy-MM-dd
	private LocalTime time;
	private String description;
	private boolean isTournament;
	private int groupSize;
	private float inscriptionFee;
	private int maxParticipants;
	
	public Event( String name, String game, String place, String description,
			boolean isTournament, int groupSize, float inscriptionFee, int maxParticipants) {
		super();
		
		Random rnd = new Random(651465);
		this.id= rnd.nextLong();
		
		this.name = name;
		this.gameId = game.compareToIgnoreCase("LOL");
		this.place = place;
		/*
		LocalDate datesss =  LocalDate.now();
		LocalTime timesss = LocalTime.now();
		 
		this.date = datesss;
		this.time = timesss;
		
		*/
		this.description = description;
		if (isTournament){
			this.isTournament = isTournament;
		}else {
			this.isTournament = false;
		}
		
		this.groupSize = groupSize;
		this.inscriptionFee = inscriptionFee;
		this.maxParticipants = maxParticipants;
	}
	
	public long getNameGameId(String gameId) {
		if (gameId.compareToIgnoreCase("LOL")==0) {
			return 1;
		}
		return -1;
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
	public long getGameId() {
		return gameId;
	}
	public void setGameId(long gameId) {
		this.gameId = gameId;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isTournament() {
		return isTournament;
	}
	public void setTournament(boolean isTournament) {
		this.isTournament = isTournament;
	}
	public int getGroupSize() {
		return groupSize;
	}
	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}
	public float getInscriptionFee() {
		return inscriptionFee;
	}
	public void setInscriptionFee(float inscriptionFee) {
		this.inscriptionFee = inscriptionFee;
	}
	public int getMaxParticipants() {
		return maxParticipants;
	}
	public void setMaxParticipants(int maxParticipants) {
		this.maxParticipants = maxParticipants;
	}
	
	
}
