package com.lcdd.backend.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MerchType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String type;
	
	@OneToMany(mappedBy="type")
	private List<Merchandising> merchs = new ArrayList<>();
	
	protected MerchType(){}

	public MerchType(String type) {
		this.type = type;
	}
	
	public MerchType(String type, List<Merchandising> merchs) {
		this.type = type;
		this.merchs = merchs;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Merchandising> getMerchs() {
		return merchs;
	}

	public void setMerchs(List<Merchandising> merchs) {
		this.merchs = merchs;
	}
	
	
	
}
