package com.lcdd.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcdd.backend.dbrepositories.MerchandisingRepository;
import com.lcdd.backend.pojo.Merchandising;

import es.codeurjc.daw.library.book.Book;

@Service
public class MerchandisingService {
	
	@Autowired
	private MerchandisingRepository repository;
	
	public Optional<Merchandising> findById(long id) {
		return repository.findById(id);
	}

	public List<Merchandising> findAll() {
		return repository.findAll();
	}
	public void save(Merchandising merch) {
		repository.save(merch);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}

}
