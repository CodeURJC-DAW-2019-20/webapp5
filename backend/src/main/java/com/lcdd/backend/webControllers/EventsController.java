package com.lcdd.backend.webControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.lcdd.backend.pojo.Event;
import com.lcdd.backend.dbrepositories.EventRepository;

import java.util.Iterator;
import java.util.List;

@Controller
public class EventsController {
	
	//private List<Event> eventsList;
	@Autowired
	private static EventRepository repository;
	
	private static int eventsShownCounter = 1;
	private static Iterator<Event> eventsListIterator = getEventsList().iterator();
	
	@GetMapping(value= {"events"})
	public String serveEvents(Model model) {
		return "events";
	}
	
	private static List<Event> getEventsList() {
		return repository.findAll();
	}
	
	public String getCodeblockSixFirstEvents() {
		String codeblock = "";
		while ((eventsListIterator.hasNext()) && (eventsShownCounter <= 6)) {
			Event event = eventsListIterator.next();
			codeblock += getCodeblockNextColumn(event);
			eventsShownCounter++;
		}
		return codeblock;
	}
	
	public String getCodeblockNextThreeEvents() {
		String codeblock = "";
		int newEventsCounter = 1;
		while ((eventsListIterator.hasNext()) && (newEventsCounter <= 3)) {
			Event event = eventsListIterator.next();
			codeblock += getCodeblockNextColumn(event);
			newEventsCounter++;
			eventsShownCounter++;
		}
		return codeblock;
	}
	
	private String getCodeblockNextColumn(Event event) {
		return "<div class=\"col-sm-4\">" + 
					"<a href=\"#\">" + 
						"<img src=\"./assets/img/events/event.jpg\" width=\"300\">" + 
						"<h3 class=\"mt-2\">" + event.getName() + "</h3>" + 
					"</a>" + 
					"<p>" + event.getDescription() + "</p>" + 
				"</div>";
	}


}