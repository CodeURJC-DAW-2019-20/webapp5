package com.lcdd.backend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BackendController {
	
	@RequestMapping("/event-template")
	public String eventTemplate(Model model, Event event){
		
		model.addAttribute("event", event);
		
		return "event-template";
	}
}