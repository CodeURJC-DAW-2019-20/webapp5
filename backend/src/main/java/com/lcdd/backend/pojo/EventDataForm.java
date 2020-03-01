package com.lcdd.backend.pojo;

public class EventDataForm {

	
	private String name;
	private int game;
	private String place;
	private String date;
	private String time;
	private String description;
	private boolean isTournament;
	private String reward;
	private int groupSize;
	private float inscriptionFee;
	private int maxParticipants;
	
	
	public EventDataForm(String name, int game, String place, String date, String time, String description,
			boolean isTournament, String reward, int groupSize, float inscriptionFee, int maxParticipants) {
		super();
		this.name = name;
		this.game = game;
		this.place = place;
		this.date = date;
		this.time = time;
		this.description = description;
		this.isTournament = isTournament;
		this.reward = reward;
		this.groupSize = groupSize;
		this.inscriptionFee = inscriptionFee;
		this.maxParticipants = maxParticipants;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getGame() {
		return game;
	}


	public void setGame(int game) {
		this.game = game;
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


	public String getReward() {
		return reward;
	}


	public void setReward(String reward) {
		this.reward = reward;
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
