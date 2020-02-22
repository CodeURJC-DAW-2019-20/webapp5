package com.lcdd.backend;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lcdd.backend.pojo.User;

@Component
public class DatabaseUserLoader{
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	private void initDataBase() {
		
		userRepository.save(new User("user","pass","ROLE_USER"));
		
		userRepository.save(new User("admin","adminpass","ROLE_USER","ROLE_ADMIN"));
	}
	
	
}