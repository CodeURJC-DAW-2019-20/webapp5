package com.lcdd.backend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BackendController {
	
	@RequestMapping("/eventTemplate")
	public String eventTemplate(Model model){
		
		model.addAttribute("name" , "Partido de futbol");
		model.addAttribute("game" , "futbol");
		model.addAttribute("date" , "15/15/15");
		model.addAttribute("location" , "madrid");
		model.addAttribute("description" , "esto es una descripción");
		model.addAttribute("image", "/assets/img/event-image.png");
		
		return "event-template";
	}
}