package com.lcdd.backend.webControllers;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lcdd.backend.pojo.Event;



import com.lcdd.backend.ImageService;
import com.lcdd.backend.dbrepositories.EventRepository;



@Controller
public class EventFormController {
  
	@Autowired
	private EventRepository repository;
	@Autowired
	private ImageService imgService;


	
	@GetMapping(value= {"event-form"})
	public String serveEvent(Model model) {
		return "event-form";
	}
	
	
	@GetMapping("/eventForm")
	public String eventForm(Model model, Event event, 
			@RequestParam MultipartFile imageFile) throws IOException {
	
	event.setHaveImage(true);
		
	repository.save(event);
	
	//model.addAttribute("event", event);
	
	imgService.saveImage("event", event.getId(), imageFile);
	
	model.addAttribute("event", event);
	return "event-template";
	}
  
}