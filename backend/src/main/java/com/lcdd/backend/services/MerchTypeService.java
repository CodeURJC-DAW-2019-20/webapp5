package com.lcdd.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.lcdd.backend.dbrepositories.MerchTypeRepository;
import com.lcdd.backend.pojo.MerchType;

@Service
public class MerchTypeService {
	
	@Autowired
	private MerchTypeRepository repository;
	
	public Optional<MerchType> findById(long id) {
		return repository.findById(id);
	}

	public List<MerchType> findAll() {
		return repository.findAll();
	}
	public void save(MerchType merchtype) {
		repository.save(merchtype);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}
	
	public Page<MerchType> findAllPages(int page, int size) {
		return repository.findAll(PageRequest.of(page,size));
	}
}
