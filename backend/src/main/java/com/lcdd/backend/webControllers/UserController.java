package com.lcdd.backend.webControllers;

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
import org.springframework.web.bind.annotation.ResponseStatus;

import com.lcdd.backend.dbrepositories.PurchaseRepository;
import com.lcdd.backend.dbrepositories.RoleRepository;
import com.lcdd.backend.dbrepositories.UserRepository;
import com.lcdd.backend.pojo.Purchase;
import com.lcdd.backend.pojo.Role;
import com.lcdd.backend.pojo.User;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Object> deleteUserById(@PathVariable long id) {
		Optional<User> userFound = userRepository.findById(id);
		
		if(!userFound.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		userRepository.deleteById(id);
		
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@PostMapping("/users/role/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> editUserRole(@PathVariable long id, @RequestBody String newRoleId) {
		
		System.out.println(newRoleId.replaceAll("\"", ""));
		
		Long roleId = Long.parseLong(newRoleId.replaceAll("\"", ""));
		
		Role roleObject = roleRepository.findById(roleId).get();
		
		User user = userRepository.findById(id).get();
		
		user.setRole(roleObject);
		
		userRepository.save(user);
		
		return null;
	}
	
}