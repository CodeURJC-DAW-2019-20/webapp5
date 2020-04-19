package com.lcdd.backend.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.lcdd.backend.pojo.User.Basico;

@Entity
public class EventRegister {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@JsonView (User.Basico.class)
	@ManyToOne
	private User user;
	
	@JsonView(Basico.class)
	@ManyToOne
	private Event event;
	@JsonView(Basico.class)
	private String inscriptionName;
	@JsonView(Basico.class)
	private int participantsNumber;
	
	protected EventRegister() { }
	
	public EventRegister(User user, Event event, String inscriptionName, int participantsNumber) {
		this.user = user;
		this.event = event;
		this.inscriptionName = inscriptionName;
		this.participantsNumber = participantsNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public String getInscriptionName() {
		return inscriptionName;
	}

	public void setInscriptionName(String inscriptionName) {
		this.inscriptionName = inscriptionName;
	}

	public int getParticipantsNumber() {
		return participantsNumber;
	}

	public void setParticipantsNumber(int participantsNumber) {
		this.participantsNumber = participantsNumber;
	}
	
	
	
	
	

}
