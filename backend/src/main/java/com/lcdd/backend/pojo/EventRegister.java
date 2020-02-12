package com.lcdd.backend.pojo;

public class EventRegister {
	private long id;
	private long userId;
	private long eventId;
	private String inscriptionName;
	private int participants_number;
	
	public EventRegister(long id, long userId, long eventId, String inscriptionName, int participants_number) {
		super();
		this.id = id;
		this.userId = userId;
		this.eventId = eventId;
		this.inscriptionName = inscriptionName;
		this.participants_number = participants_number;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public long getEventId() {
		return eventId;
	}
	public void setEventId(long eventId) {
		this.eventId = eventId;
	}
	public String getInscriptionName() {
		return inscriptionName;
	}
	public void setInscriptionName(String inscriptionName) {
		this.inscriptionName = inscriptionName;
	}
	public int getParticipants_number() {
		return participants_number;
	}
	public void setParticipants_number(int participants_number) {
		this.participants_number = participants_number;
	}
	
	
	
	
}
