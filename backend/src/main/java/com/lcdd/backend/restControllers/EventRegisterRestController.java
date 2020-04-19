package com.lcdd.backend.restControllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.lcdd.backend.UserSession;
import com.lcdd.backend.pojo.Event;
import com.lcdd.backend.pojo.EventRegister;
import com.lcdd.backend.pojo.User;
import com.lcdd.backend.services.EventService;
import com.lcdd.backend.services.UserRegisterEventService;
import com.lcdd.backend.services.UserService;

@RestController
@RequestMapping("/api/userRegisterEvent")
public class EventRegisterRestController {
	@Autowired
	private UserRegisterEventService eventRegisterService;
	@Autowired
	private UserService userService;
	@Autowired
	private EventService eventService;
	
	//get all inscriptions
	//only admin
	@JsonView (User.Basico.class)
	@GetMapping(value={"", "/"})
	public ResponseEntity<List<EventRegister>> getEventList() {
		List<EventRegister> eventRegisterList = eventRegisterService.findAll();
		return new ResponseEntity<>(eventRegisterList, HttpStatus.OK);
	}
	
	//register user in an event
	//need user registered
	@PostMapping("/{id}")
	public ResponseEntity<EventRegister> serveEvent(@PathVariable Long id, 
			@RequestBody String participants,Authentication auth,  UserSession session, HttpServletRequest request) {
		
		int i = Integer.parseInt(participants.replaceAll("\"", ""));
		User user = userService.findByName(auth.getName());
		Event event = eventService.findById(id);
		EventRegister register = new EventRegister(user,event,user.getName(),i);
		event.setMaxParticipants(event.getMaxParticipants()-i);
		eventService.save(event);
		eventRegisterService.save(register);
		return new ResponseEntity<>(register, HttpStatus.OK);
	}
}
