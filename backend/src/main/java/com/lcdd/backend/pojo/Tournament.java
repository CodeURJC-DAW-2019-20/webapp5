package com.lcdd.backend.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Tournament {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne
	private EventRegister winner;
	
	private String reward;
	
	public Tournament(){}

	public Tournament(String reward) {
		this.reward = reward;
	}
	
	public Tournament(EventRegister winner, String reward) {
		this.winner = winner;
		this.reward = reward;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public EventRegister getWinner() {
		return winner;
	}

	public void setWinner(EventRegister winner) {
		this.winner = winner;
	}

	public String getReward() {
		return reward;
	}

	public void setReward(String reward) {
		this.reward = reward;
	}
}
