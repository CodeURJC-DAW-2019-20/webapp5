package com.lcdd.backend.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcdd.backend.pojo.EventRegister;
import com.lcdd.backend.services.UserRegisterEventService;

@RestController
@RequestMapping("/api/event-register")
public class EventRegisterRestController {
	@Autowired
	private UserRegisterEventService eventRegisterService;
	
	@GetMapping(value={"", "/"})
	public ResponseEntity<List<EventRegister>> getEventList() {
		List<EventRegister> eventRegisterList = eventRegisterService.findAll();
		return new ResponseEntity<>(eventRegisterList, HttpStatus.OK);
	}
}
