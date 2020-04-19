package com.lcdd.backend.pojo;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.lcdd.backend.pojo.User.Basico;

@Entity
public class Purchase {
	@JsonView (User.Basico.class)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@JsonView (User.Basico.class)
	@ManyToOne
	private User user;
	@JsonView(Basico.class)
	private float price;
	@JsonView(Basico.class)
	private Date date;
	
	@JsonView(Basico.class)
	@ManyToOne
	private Merchandising merch;
	
	protected Purchase() { }
	
	public Purchase(User user, Date date, Merchandising merch) {
		this.user = user;
		this.date = date;
		this.price = merch.getPrice();
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
