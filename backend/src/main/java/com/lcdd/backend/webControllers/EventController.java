package com.lcdd.backend.webControllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lcdd.backend.UserSession;
import com.lcdd.backend.pojo.Event;
import com.lcdd.backend.services.EventService;


@Controller
public class EventController {

	  @Autowired
	  private EventService eventService;
	  @Autowired
	  private UserSession session;
	  
	  @RequestMapping("/event/{id}")
	  public String showEvent(@PathVariable long id, Model model) {
	    
	    Event event = eventService.findById(id);
	    if(event==null){
	      return null;
	    }
	    model.addAttribute("logged",session.getIsLogggedIn());
	    model.addAttribute("event", event);
	    
	    return "event-template";
	  }
	}
