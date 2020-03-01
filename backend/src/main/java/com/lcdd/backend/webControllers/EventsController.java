package com.lcdd.backend.webControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventsController {
	
	@GetMapping(value= {"events"})
	public String serveEvents(Model model) {
		return "events";
	}
}