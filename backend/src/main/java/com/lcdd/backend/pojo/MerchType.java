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
	
	private String typeName;
	
	@OneToMany(mappedBy="type")
	private List<Merchandising> merchs = new ArrayList<>();
	
	protected MerchType(){}

	public MerchType(String typeName) {
		this.typeName = typeName;
	}
	
	public MerchType(String typeName, List<Merchandising> merchs) {
		this.typeName = typeName;
		this.merchs = merchs;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return typeName;
	}

	public void setType(String typeName) {
		this.typeName = typeName;
	}

	public List<Merchandising> getMerchs() {
		return merchs;
	}

	public void setMerchs(List<Merchandising> merchs) {
		this.merchs = merchs;
	}
	
	
	
}
