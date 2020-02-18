package com.lcdd.backend;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//import org.joda.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lcdd.backend.pojo.Event;

@Controller
public class EventFormController {
  
	//private Event event;
	
  @RequestMapping("/eventForm")
  public String eventForm(Model model, Event event){
    
    //int a = 1;
	//System.out.println("llego ak controlador");
	//Event event;
	  
	//model.addAttribute("name", name);
	
	//model.addAttribute("event.set", getNameGameId(game));
	
	//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
	  //String dates = "16/08/2016";

	  //convert String to LocalDate
	 // LocalDate localDate = LocalDate.parse(date);
	
	//LocalDate localDate = new LocalDate(date);
	
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