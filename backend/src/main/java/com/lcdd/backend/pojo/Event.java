package com.lcdd.backend.pojo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Event {
	private long id;
	private String name;
	private long gameId;
	private String place;
	private LocalDate date;
	private LocalTime time;
	private String description;
	private boolean isTournament;
	private boolean isSingleParticipation;
	private float inscriptionFee;
	private int maxParticipants;
	
	public Event(long id, String name, long gameId, String place, LocalDate date, LocalTime time, String description,
			boolean isTournament, boolean isSingleParticipation, float inscriptionFee, int maxParticipants) {
		super();
		this.id = id;
		this.name = name;
		this.gameId = gameId;
		this.place = place;
		this.date = date;
		this.time = time;
		this.description = description;
		this.isTournament = isTournament;
		this.isSingleParticipation = isSingleParticipation;
		this.inscriptionFee = inscriptionFee;
		this.maxParticipants = maxParticipants;
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
	public boolean isSingleParticipation() {
		return isSingleParticipation;
	}
	public void setSingleParticipation(boolean isSingleParticipation) {
		this.isSingleParticipation = isSingleParticipation;
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
