package com.lcdd.backend.restControllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
	@GetMapping(value={"", "/"})
	public ResponseEntity<List<EventRegister>> getEventList() {
		List<EventRegister> eventRegisterList = eventRegisterService.findAll();
		return new ResponseEntity<>(eventRegisterList, HttpStatus.OK);
	}
	
	//register user in an event
	//need user registered
	@PostMapping("/{id}")
	public ResponseEntity<EventRegister> serveEvent(@PathVariable Long id, 
			@RequestParam int participants, UserSession session, HttpServletRequest request) {
		User user = userService.findByName(session.getUsername());
		Event event = eventService.findById(id);
		EventRegister register = new EventRegister(user,event,user.getName(),participants);
		event.setMaxParticipants(event.getMaxParticipants()-participants);
		eventService.save(event);
		eventRegisterService.save(register);
		return new ResponseEntity<>(register, HttpStatus.OK);
	}
}
