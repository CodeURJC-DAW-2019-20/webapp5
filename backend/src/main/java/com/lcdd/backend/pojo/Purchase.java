package com.lcdd.backend.pojo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Purchase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private User user;
	private float price;
	private LocalDate date;
	private Merchandising merch;
	
	public Purchase() { }
	
	public Purchase(User user, float price, LocalDate date, Merchandising merch) {
		this.user = user;
		this.price = price;
		this.date = date;
		this.merch = merch;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Merchandising getMerch() {
		return merch;
	}

	public void setMerch(Merchandising merch) {
		this.merch = merch;
	}	
}
