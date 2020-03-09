package com.lcdd.backend.dbrepositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcdd.backend.pojo.EventRegister;

public interface EventRegisterRepository extends JpaRepository<EventRegister, Long> {
	
	EventRegister findById(long id);
	List<EventRegister> findByEventId(long id);
	
}
