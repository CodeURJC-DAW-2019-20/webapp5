package com.lcdd.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lcdd.backend.pojo.Event;

@Controller
public class EventFormController {
  
	
	
  @RequestMapping("/eventForm")
  public String eventForm(Model model, Event event){
    
    //int a = 1;
	System.out.println("llego ak controlador");
	
	model.addAttribute("event", event);
	
    
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