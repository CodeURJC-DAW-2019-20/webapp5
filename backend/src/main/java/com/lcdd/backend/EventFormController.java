package com.lcdd.backend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EventFormController {
  
  @RequestMapping("/eventForm")
  public String eventForm(Model model, Event evento){
    
    //int a = 1;
	  model.addAttribute("event", evento);
    
    return "event-template";
  }
  
  
  /*@RequestMapping("/eventTemplate")
	public String eventFormTemplate(Model model){
		
		model.addAttribute("name" , "Partido de futbol");
		model.addAttribute("game" , "futbol");
		model.addAttribute("date" , "15/15/15");
		model.addAttribute("location" , "madrid");
		model.addAttribute("description" , "esto es una descripción");
		model.addAttribute("image", "/assets/img/event-image.png");
		
		return "event-template";
	}*/
  
}