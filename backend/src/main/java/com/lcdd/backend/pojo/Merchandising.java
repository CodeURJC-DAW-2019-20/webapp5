package com.lcdd.backend.pojo;

public class Merchandising {
	private long id;
	private String name;
	private String type;
	private float price;
	private float discount;
	private int stock;
	private String description;
	
	public Merchandising(long id, String name, String type, float price, float discount, int stock,
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
		this.discount = discount;
		this.stock = stock;
		this.description = description;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
