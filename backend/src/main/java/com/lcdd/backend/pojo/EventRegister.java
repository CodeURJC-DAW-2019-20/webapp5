package com.lcdd.backend.pojo;

@Entity
public class EventRegister {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private User user;
	private Event event;
	private String inscriptionName;
	private int participantsNumber;
	
	public EventRegister() { }
	
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
