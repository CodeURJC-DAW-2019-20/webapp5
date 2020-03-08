package com.lcdd.backend.webControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.lcdd.backend.dbrepositories.RoleRepository;
import com.lcdd.backend.pojo.Role;
import com.lcdd.backend.pojo.User;
import com.lcdd.backend.services.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Object> deleteUserById(@PathVariable long id) {
		User userFound = userService.findById(id);
		
		if(userFound==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		userService.deleteById(id);
		
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@PostMapping("/users/role/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Object> editUserRole(@PathVariable long id, @RequestBody String newRoleId) {
		
		System.out.println(newRoleId.replaceAll("\"", ""));
		
		Long roleId = Long.parseLong(newRoleId.replaceAll("\"", ""));
		
		Role roleObject = roleRepository.findById(roleId).get();
		
		User user = userService.findById(id);
		
		user.setRole(roleObject);
		
		userService.save(user);
		
		return null;
	}
	
}