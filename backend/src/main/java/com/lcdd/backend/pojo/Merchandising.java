package com.lcdd.backend.pojo;

public class Merchandising {
	private long id;
	private String name;
	private long typeId;
	private float price;
	private float discount;
	private int stock;
	private String description;
	
	public Merchandising(long id, String name, long typeId, float price, float discount, int stock,
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.typeId = typeId;
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

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
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
