package com.lcdd.backend.webControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lcdd.backend.pojo.Event;
import com.lcdd.backend.dbrepositories.EventRepository;

//import java.util.Iterator;
//import java.util.List;

@Controller
public class EventsController {
	
	//private List<Event> eventsList;
	@Autowired
	private EventRepository repository;
	
//	private static int eventsShownCounter = 1;
//	private Iterator<Event> eventsListIterator;
	
	
	
	

	@GetMapping(value= {"events"})
	public String serveEvents(Model model) {
		return "events";
	}
	
//	**************COSAS GRANIZO*****************
	@GetMapping("/eventList")
	public String getEventsList(@RequestParam() int pageId) {
		String result = "";
		
		Page<Event> pageEvent = repository.findAll(PageRequest.of(pageId,6));
		
		for(Event event : pageEvent) {
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
								"<a href='#'>" + 
									"<img src='/assets/img/events/placeholder_event_img.jpg' width='300'>" + 
									"<h3 class='mt-2'>" + event.getName() + "</h3>" + 
								"</a>" + 
								"<p>" + event.getDescription() + "</p>" + 
							"</div>";
			}
			
		}
		System.out.println(pageId);
		return result;
	}
	

	
	
	
	
//	*************COSAS CARLOS***********
//	private List<Event> getEventsList() {
//		return repository.findAll();
//	}
//	
//	public String getCodeblockSixFirstEvents() {
//		this.eventsListIterator = getEventsList().iterator();
//		String codeblock = "";
//		while ((eventsListIterator.hasNext()) && (eventsShownCounter <= 6)) {
//			Event event = eventsListIterator.next();
//			codeblock += getCodeblockNextColumn(event);
//			eventsShownCounter++;
//		}
//		return codeblock;
//	}
//	
//	public String getCodeblockNextThreeEvents() {
//		String codeblock = "";
//		int newEventsCounter = 1;
//		while ((eventsListIterator.hasNext()) && (newEventsCounter <= 3)) {
//			Event event = eventsListIterator.next();
//			codeblock += getCodeblockNextColumn(event);
//			newEventsCounter++;
//			eventsShownCounter++;
//		}
//		return codeblock;
//	}
//	
//	private String getCodeblockNextColumn(Event event) {
//		return "<div class=\"col-sm-4\">" + 
//					"<a href=\"#\">" + 
//						"<img src=\"./assets/img/events/event.jpg\" width=\"300\">" + 
//						"<h3 class=\"mt-2\">" + event.getName() + "</h3>" + 
//					"</a>" + 
//					"<p>" + event.getDescription() + "</p>" + 
//				"</div>";
//	}


}