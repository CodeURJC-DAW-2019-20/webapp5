package com.lcdd.backend.pojo;

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

import org.springframework.beans.factory.annotation.Autowired;


@Entity
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private Game game;

	private String name;
	private String place;
	private String date;//yyyy-MM-dd
	private String time;//hh:mm
	private String description;
	private boolean isTournament;
	private boolean haveImage;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Tournament tournament;
	
	private int groupSize;
	private float inscriptionFee;
	private int maxParticipants;
	
	@OneToMany(mappedBy="event")
	private List<EventRegister> registrations = new ArrayList<>();
	
	
	protected Event() { }
	
	public Event( String name, String game, String place, String date, String time, String description,
			String isTournament, String reward, int groupSize, float inscriptionFee, int maxParticipants) {
		super();
		
		this.name = name;
		//this.gameId = setNameGameId(game);
		this.place = place;		
		this.date = date;
		this.time = time;
		
		this.tournament = new Tournament(reward);
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
		//this.game = gameRepository.findByAcronym(game);
	}
	/*
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
	*/
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
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Tournament getTournament() {
		return tournament;
	}
	
	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
	
	public int getGroupSize() {
		return groupSize;
	}
	
	public void setGroupSize(int groupSize) {
		this.groupSize = groupSize;
	}
	
	public boolean isHaveImage() {
		return haveImage;
	}
	
	public void setHaveImage(boolean haveImage) {
		this.haveImage = haveImage;
	}

	
}
