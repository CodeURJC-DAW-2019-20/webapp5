package com.lcdd.backend.webControllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lcdd.backend.UserSession;
import com.lcdd.backend.dbrepositories.EventRepository;
import com.lcdd.backend.pojo.Event;


@Controller
public class EventController {

	  @Autowired
	  private EventRepository eventRepository;
	  @Autowired
	  private UserSession session;
	  
	  @RequestMapping("/event/{id}")
	  public String showEvent(@PathVariable long id, Model model) {
	    
	    Event event = eventRepository.findById(id).get();
	    if(event==null){
	      return null;
	    }
	    model.addAttribute("logged",session.getIsLogggedIn());
	    model.addAttribute("event", event);
	    
	    return "event-template";
	  }
	}
