package com.lcdd.backend.restControllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcdd.backend.pojo.Game;
import com.lcdd.backend.pojo.User;
import com.lcdd.backend.pojo.Event;
import com.lcdd.backend.pojo.EventRegister;
import com.lcdd.backend.services.GameService;
import com.lcdd.backend.services.UserRegisterEventService;
import com.lcdd.backend.services.EventService;


@RestController
@RequestMapping("/api/events")
public class EventRestController {
	
	@Autowired
	private EventService eventService;
	@Autowired
	private GameService gameService;
	@Autowired
	private UserRegisterEventService userRegService;

	//every user
	@GetMapping("/")
	public ResponseEntity<List<Event>> getEvent() {
		List<Event> event = eventService.findAll();
		return new ResponseEntity<>(event, HttpStatus.OK);
	}
	
	//every user
	@GetMapping("/games")
	public ResponseEntity<List<Game>> getEventGame() {
		List<Game> games = gameService.findAll();
		return new ResponseEntity<>(games, HttpStatus.OK);
	}

	//every user
	@GetMapping("/{id}")
	public ResponseEntity<Event> getEvent(@PathVariable long id) {
		Event event = eventService.findById(id);
		return new ResponseEntity<>(event, HttpStatus.OK);
	}
	
	//get all users registered in an event
	@GetMapping("{id}/userRegistered")
	public ResponseEntity<List<User>> getUsersInEventRegister(@PathVariable long id, HttpSession session) {
		//admin can see all users
		List<User> registeredUsers = userRegService.findByEventId(id);
		if (!registeredUsers.isEmpty()) {
			return new ResponseEntity<>(registeredUsers, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	//only admin
	@PostMapping("/")
	public ResponseEntity<Event> createEvent(@RequestBody Event event) {
		boolean bol = eventService.createEvent(event);
		if(bol == true) {
			return new ResponseEntity<>(event, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	//only admin
	@PutMapping("/{id}")
	public ResponseEntity<Event> updateEventId(@PathVariable long id, @RequestBody Event updateEvent,
			HttpServletRequest request, HttpSession session){
		Event event = eventService.findById(id); //Returns with 404 if not found in database
		
		if(event.getName() != null) {
			event.setName(updateEvent.getName());
	}
		if(event.getPlace()!= null) {
			event.setPlace(updateEvent.getPlace());
	}
		if(event.getDate()!= null) {
			event.setDate(updateEvent.getDate());
	}
		if(event.getTime()!= null) {
			event.setTime(updateEvent.getTime());
	}
		if(event.getDescription()!= null) {
			event.setDescription(updateEvent.getDescription());
	}
		if(event.isTournament()!= updateEvent.isTournament()) {
			event.setTournament(updateEvent.isTournament());
	}
		if(event.getGroupSize() != 0) {
			event.setGroupSize(updateEvent.getGroupSize());
	}
		if(event.getInscriptionFee() != 0) {
			event.setInscriptionFee(updateEvent.getInscriptionFee());
	}
		if(event.getMaxParticipants() != 0) {
			event.setMaxParticipants(updateEvent.getMaxParticipants());
	}
		eventService.save(event);
		return new ResponseEntity<>(event, HttpStatus.OK);
	}

	//only admin
	@DeleteMapping("/{id}")
	public ResponseEntity<Event> deleteEvent(@PathVariable long id) {
		Event event = eventService.findById(id);
		eventService.delete(id);
		return new ResponseEntity<>(event, HttpStatus.OK);
	}
	
}