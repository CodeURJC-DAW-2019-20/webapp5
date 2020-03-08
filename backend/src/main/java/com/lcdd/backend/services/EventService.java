package com.lcdd.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcdd.backend.dbrepositories.EventRepository;
import com.lcdd.backend.pojo.Event;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Service
public class EventService {
	
	@Autowired
	private EventRepository repository;
	
	public Event findById(long id) {
		return repository.findById(id);
	}

	public List<Event> findAll() {
		return repository.findAll();
	}
	
	public void save(Event event) {
		repository.save(event);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}
	
	public Page<Event> findAllPages(int page, int size) {
		return repository.findAll(PageRequest.of(page,size));
	}
	
	public boolean createEvent(Event event) {
		if(repository.findById(event.getId()) == null) {
			return false;
		}
		if(repository.findByName(event.getName()) != null){
			return false;
		}
		save(event);
		return true;
	}
	

}
