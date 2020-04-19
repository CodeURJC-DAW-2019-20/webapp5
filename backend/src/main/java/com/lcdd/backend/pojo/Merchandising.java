package com.lcdd.backend.pojo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.lcdd.backend.pojo.User.Basico;

@Entity
public class Merchandising {
	@JsonView(Basico.class)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@JsonView(Basico.class)
	@ManyToOne
	private MerchType type;
	@JsonView(Basico.class)
	private String name;
	@JsonView(Basico.class)
	private float price;
	@JsonView(Basico.class)
	private float discount;
	@JsonView(Basico.class)
	private int stock;
	@JsonView(Basico.class)
	private String description;
	@JsonView(Basico.class)
	private boolean haveImage;
	
	@JsonIgnore
	@OneToMany(mappedBy="merch")
	private List<Purchase> purchases = new ArrayList<>();
	
	protected Merchandising(){
		
	}

	
	public Merchandising(String name, MerchType type) {
		this.name = name;
		this.type = type;
	}
	
	
	public Merchandising(String name, MerchType type, float price, float discount, int stock, String description) {
		this.name = name;
		this.type = type;
		this.price = price;
		this.discount = discount;
		this.stock = stock;
		this.description = description;
		
		this.haveImage = false;
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

	public MerchType getType() {
		return type;
	}

	public void setType(MerchType type) {
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

	public boolean isHaveImage() {
		return haveImage;
	}
	
	public void setHaveImage(boolean haveImage) {
		this.haveImage = haveImage;
	}


	
}
