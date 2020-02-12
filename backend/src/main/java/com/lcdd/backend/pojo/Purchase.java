package com.lcdd.backend.pojo;

import java.time.LocalDate;

public class Purchase {
	private long id;
	private long userId;
	private float price;
	private LocalDate date;
	private long merchId;
	
	public Purchase(long id, long userId, float price, LocalDate date, long merchId) {
		super();
		this.id = id;
		this.userId = userId;
		this.price = price;
		this.date = date;
		this.merchId = merchId;
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
	public long getMerchId() {
		return merchId;
	}
	public void setMerchId(long merchId) {
		this.merchId = merchId;
	}
	
	
}
