package com.lcdd.backend.services;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.lcdd.backend.dbrepositories.PurchaseRepository;
import com.lcdd.backend.pojo.Purchase;

@Service
public class PurchaseService {

	@Autowired
	private PurchaseRepository repository;
	
	public Purchase findById(long id) {
		return repository.findById(id);
	}

	public List<Purchase> findAll() {
		return repository.findAll();
	}
	
	public List<Purchase> findAll(Sort sort){
		return repository.findAll(sort);
	}
	
	public void save(Purchase purchase) {
		repository.save(purchase);
	}
	
	public void deleteById(long id) {
		repository.deleteById(id);
	}
	
	public Integer lastYearPurchasesByMonth(Date date) {
		return repository.lastYearPurchasesByMonth(date);
	}
	
}
