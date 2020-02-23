package com.lcdd.backend.pojo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private Game game;
	
	private String place;
	private LocalDate date;
	private LocalTime time;
	private String description;
	private boolean isTournament;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Tournament tournament;
	
	private boolean isSingleParticipation;
	private float inscriptionFee;
	private int maxParticipants;
	
	@OneToMany(mappedBy="event")
	private List<EventRegister> registrations = new ArrayList<>();
	
	
	protected Event() { }


	
	public Event(Game game, String description) {
		this.game = game;
		this.description = description;
	}



	public Event(Game game, String place, LocalDate date, LocalTime time, String description, boolean isTournament,
			Tournament tournament, boolean isSingleParticipation, float inscriptionFee, int maxParticipants,
			List<EventRegister> registrations) {
		this.game = game;
		this.place = place;
		this.date = date;
		this.time = time;
		this.description = description;
		this.isTournament = isTournament;
		this.tournament = tournament;
		this.isSingleParticipation = isSingleParticipation;
		this.inscriptionFee = inscriptionFee;
		this.maxParticipants = maxParticipants;
		this.registrations = registrations;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public Game getGame() {
		return game;
	}


	public void setGame(Game game) {
		this.game = game;
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


	public Tournament getTournament() {
		return tournament;
	}


	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
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


	public List<EventRegister> getRegistrations() {
		return registrations;
	}


	public void setRegistrations(List<EventRegister> registrations) {
		this.registrations = registrations;
	}
}
