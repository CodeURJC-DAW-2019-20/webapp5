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
	private String date;//yyyy-MM-dd
	private String time;//hh:mm
	private String description;
	private boolean isTournament;
	private Tournament tournament;
	private int groupSize;
	private float inscriptionFee;
	private int maxParticipants;
	
	public Event( String name, String game, String place, String date, String time, String description,
			String isTournament, String tournament, String reward, int groupSize, float inscriptionFee, int maxParticipants) {
		super();
		/**/
			Random rnd = new Random(651465);
			this.id= rnd.nextLong();
		/**/
		this.name = name;
		this.gameId = setNameGameId(game);
		this.place = place;		
		this.date = date;
		this.time = time;
		
		this.tournament = new Tournament(reward,this.id);
		this.description = description;
		if (! isTournament.isEmpty()) {	
			if ( isTournament.equalsIgnoreCase("true")){
				this.isTournament = true;
			} 
		}else {
			this.isTournament = false;
		}
		this.groupSize = groupSize;
		this.inscriptionFee = inscriptionFee;
		this.maxParticipants = maxParticipants;
	}
	
	public long setNameGameId(String game) {
		long id;
		if (game.compareToIgnoreCase("LOL")==0) {
			 id= 1;
		} else if (game.compareToIgnoreCase("MESA")==0) {
			id= 2;
		} else {
			id=-1;
		}
		return id;
	}
	
	public String getNameGameId(long gameId) {
		String game;
		if (gameId==1) {
			game= "LOL";
		} else if (gameId==2) {
			game= "MESA";
		} else {
			game="no definido";
		}
		return game;
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
