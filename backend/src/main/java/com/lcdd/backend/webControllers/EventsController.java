package com.lcdd.backend.webControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.lcdd.backend.pojo.Event;
import com.lcdd.backend.pojo.Game;
import com.lcdd.backend.services.EventService;
import com.lcdd.backend.services.GameService;

@Controller
public class EventsController {
	
	@Autowired
	private EventService eventService;
	@Autowired
	private GameService gameService;
	
//	private static int eventsShownCounter = 1;
//	private Iterator<Event> eventsListIterator;

	@GetMapping(value= {"events"})
	public String serveEvents(Model model) {
		return "events";
	}
	
//	*******************************
	@GetMapping("/eventList")
	public ResponseEntity<String> getEventsList(@RequestParam() int pageId, @RequestParam(required = false) String game) {
		String result = "";
		long gameId;
		Page<Event> pageEvent;
		Game gameObject;

		if(game.equals("null")) {
			pageEvent = eventService.findAll(PageRequest.of(pageId,3));
			
			
		}else {
			gameId = Long.parseLong(game);
			gameObject = gameService.findById(gameId);
			pageEvent = eventService.findAllPagesByGame(gameObject,pageId,3);
		}
		
		
		if(pageEvent.hasContent()) {
			for(Event event : pageEvent.getContent()) {
				if (event.isHaveImage()) {
					result += "<div class='col-sm-4'>" + 
									"<a href='/event/" + event.getId() + "'>" + 
										"<img src='/images/eventsImages/image-" + event.getId() +".jpg' width='300'>" + 
										"<h3 class='mt-2'>" + event.getName() + "</h3>" + 
									"</a>" + 
									"<p>" + event.getDescription() + "</p>" + 
								"</div>";
				} else {
					result += "<div class='col-sm-4'>" + 
									"<a href='/event/" + event.getId() + "'>" + 
										"<img src='/assets/img/event-image.jpg' width='300'>" + 
										"<h3 class='mt-2'>" + event.getName() + "</h3>" + 
									"</a>" + 
									"<p>" + event.getDescription() + "</p>" + 
								"</div>";
				}
				
			}
		} else {
			result += "nomore";
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

}