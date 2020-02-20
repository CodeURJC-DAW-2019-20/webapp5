package com.lcdd.backend.webControllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lcdd.backend.pojo.Event;

@Controller
public class EventFormController {
  
	//private Event event;

	
	@GetMapping(value= {"event-form"})
	public String serveEvent(Model model) {
		return "event-form";
	}
	
	
	@GetMapping("/eventForm")
	public String eventForm(Model model, Event event){
	
	model.addAttribute("event", event);
	return "event-template";
	}
  
}