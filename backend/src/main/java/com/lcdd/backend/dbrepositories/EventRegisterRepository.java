package com.lcdd.backend.dbrepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcdd.backend.pojo.EventRegister;

public interface EventRegisterRepository extends JpaRepository<EventRegister, Long> {
	

}
