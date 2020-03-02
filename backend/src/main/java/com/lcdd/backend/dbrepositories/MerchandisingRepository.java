package com.lcdd.backend.dbrepositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.lcdd.backend.pojo.Merchandising;

public interface MerchandisingRepository extends JpaRepository<Merchandising, Long> {
	
	Page<Merchandising> findAll(Pageable page);
}
