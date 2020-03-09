package com.lcdd.backend.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcdd.backend.dbrepositories.EventRegisterRepository;
import com.lcdd.backend.pojo.EventRegister;
import com.lcdd.backend.pojo.User;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@Service
public class UserRegisterEventService {
	
	@Autowired
	private EventRegisterRepository repository;
	
	public EventRegister findById(long id) {
		return repository.findById(id);
	}

	public List<EventRegister> findAll() {
		return repository.findAll();
	}
	
	public List<User> findByEventId(long id) {
		Iterator<EventRegister> allUsersIterator = repository.findAll().iterator();
		List<User> eventRegisterUsers = new ArrayList();
		while (allUsersIterator.hasNext()) {
			EventRegister nextEventRegister = allUsersIterator.next();
			if (nextEventRegister.getEvent().getId() == id) {
				eventRegisterUsers.add(nextEventRegister.getUser());
			}
		}
		return eventRegisterUsers;
	}
	
	public void save(EventRegister eventRegister) {
		repository.save(eventRegister);
	}

	public void deleteById(long id) {
		repository.deleteById(id);
	}
	
	public Page<EventRegister> findAllPages(int page, int size) {
		return repository.findAll(PageRequest.of(page,size));
	}
	
	public boolean createEvent(EventRegister eventRegister) {
		if(repository.findById(eventRegister.getId()) == null) {
			return false;
		}
		save(eventRegister);
		return true;
	}
	

}