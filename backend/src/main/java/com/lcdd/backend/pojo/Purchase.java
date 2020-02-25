package com.lcdd.backend.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Purchase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private User user;
	
	private float price;
	private Date date;
	
	@ManyToOne
	private Merchandising merch;
	
	protected Purchase() { }
	
	public Purchase(User user, Date date, Merchandising merch) {
		this.user = user;
		this.date = date;
		this.merch = merch;
	}
	
	public Purchase(User user, float price, Date date, Merchandising merch) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Merchandising getMerch() {
		return merch;
	}

	public void setMerch(Merchandising merch) {
		this.merch = merch;
	}	
}
