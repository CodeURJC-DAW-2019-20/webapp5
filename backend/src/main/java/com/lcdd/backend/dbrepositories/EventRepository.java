package com.lcdd.backend.dbrepositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcdd.backend.pojo.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
