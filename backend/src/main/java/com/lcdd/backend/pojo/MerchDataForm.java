package com.lcdd.backend.pojo;

public class MerchDataForm {

	
	private String name;
	private int type;
	private long price;
	private float discount;
	private int stock;
	private String description;
	
	
	public MerchDataForm(String name, int type, long price, float discount, int stock, String description) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.discount = discount;
		this.stock = stock;
		this.description = description;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	public long getPrice() {
		return price;
	}


	public void setPrice(long price) {
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


