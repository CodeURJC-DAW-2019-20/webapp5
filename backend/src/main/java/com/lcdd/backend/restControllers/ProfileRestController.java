package com.lcdd.backend.restControllers;


import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lcdd.backend.UserSession;
import com.lcdd.backend.dbrepositories.EventRepository;
import com.lcdd.backend.dbrepositories.GameRepository;
import com.lcdd.backend.dbrepositories.UserRepository;
import com.lcdd.backend.pojo.User;
import com.lcdd.backend.services.UserService;

@Controller
@RequestMapping("/api/users")
public class ProfileRestController {
	
	@Autowired
	private UserService userService;
	@Autowired
	UserRepository userRepo;
	@Autowired
	EventRepository eventRepository;
	@Autowired
	GameRepository gameRepository;
	@Autowired
	private UserSession session;
	
	//get all existing users
	@GetMapping("/")
	public ResponseEntity<List<User>> getUsers(HttpSession session) {
		
		List<User> users = userService.findAll();
		return new ResponseEntity<>(users, HttpStatus.OK);

	}
	
	//get an existing user
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id, Authentication auth, 
			HttpServletRequest request, HttpSession session) {
		
		User user = userService.findOne(id);
		
		if (user != null) {
			if ((auth.getName().equals(user.getName())) || (request.isUserInRole("ADMIN")))
				return new ResponseEntity<>(user, HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	//add a new user, permited all
	@PostMapping("/{id}")
	public ResponseEntity<User> postUser(@PathVariable long id, @RequestBody User user) {
		
		boolean result = userService.createAnUser(user);
		if (result == true) {
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	//delete an existing user
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUserById(@PathVariable long id,
			Authentication auth, HttpServletRequest request, HttpSession session) {
		
		User userFound = userService.findOne(id);
		if(userFound!=null) {
			if(auth.getName().equals(userFound.getName()) || (request.isUserInRole("ADMIN"))){
				//delete the user login
				//admin can delete any user
				userService.delete(userFound);
				return new ResponseEntity<>(userFound, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
	}
	
	//update an existing user
	@PutMapping("/{id}")
	public ResponseEntity<User> putUser(@PathVariable long id, @RequestBody User userUpdate,
			Authentication auth, HttpServletRequest request, HttpSession session) {
		
		User userFound = userService.findOne(id);
		if(userFound!=null) {
			if(auth.getName().equals(userFound.getName()) || (request.isUserInRole("ADMIN"))){
				//update the user login
				//admin can update any user
				
				userFound.setName(userUpdate.getName());
				userFound.setFirstName(userUpdate.getFirstName());
				userFound.setLastName(userUpdate.getLastName());
				userFound.setEmail(userUpdate.getEmail());
				
				userService.save(userFound);
				return new ResponseEntity<>(userFound, HttpStatus.OK);
			}
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
			
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}		
	}
	
	
}
