package com.lcdd.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lcdd.backend.dbrepositories.PurchaseRepository;
import com.lcdd.backend.dbrepositories.UserRepository;
import com.lcdd.backend.pojo.Purchase;
import com.lcdd.backend.pojo.User;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Object> deleteUserById(@PathVariable long id) {
		Optional<User> userFound = userRepository.findById(id);
		
		if(!userFound.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		userRepository.deleteById(id);
		
		return new ResponseEntity<>(userFound.get(), HttpStatus.OK);
	}
	
	@PostMapping("/users/role/{id}")
	public ResponseEntity<Object> editUserRole(@PathVariable long id, @RequestBody Object objRole) {
		
		Long newRoleId = (Long)objRole;
		
		System.out.println(newRoleId);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}