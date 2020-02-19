package com.lcdd.backend.pojo;

public class Tournament {
	
	private long id;
	private long winnerId;
	private String reward;
	private long eventId;
	
	public Tournament(String reward, long eventId) {
		super();
		this.id = 1;
		this.reward = reward;
		this.eventId = eventId;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getWinnerId() {
		return winnerId;
	}
	public void setWinnerId(long winnerId) {
		this.winnerId = winnerId;
	}
	public String getReward() {
		return reward;
	}
	public void setReward(String reward) {
		this.reward = reward;
	}
	public long getEventId() {
		return eventId;
	}
	public void setEventId(long eventId) {
		this.eventId = eventId;
	}
	
	
}
