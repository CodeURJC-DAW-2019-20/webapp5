package com.lcdd.backend.webControllers;


import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lcdd.backend.pojo.Event;
import com.lcdd.backend.pojo.Game;
import com.lcdd.backend.services.EventService;
import com.lcdd.backend.services.GameService;
import com.lcdd.backend.pojo.EventDataForm;

import com.lcdd.backend.ImageService;
import com.lcdd.backend.UserSession;



@Controller
public class EventFormController {
  
	@Autowired
	private EventService eventService;
	@Autowired
	private ImageService imgService;
	@Autowired
	private GameService gameService;
	@Autowired
	private UserSession session;
	
	@RequestMapping("event-form")
	public String serveEvent(Model model) {
		// model.addAttribute("admin", request.isUserInRole("ADMIN"));
		List<Game> gameList; 
		gameList = gameService.findAll();
		
		model.addAttribute("GameList", gameList);
		 
		return "event-form";
	}
	
	
	@RequestMapping(value = {"/eventForm"}, 
			method = RequestMethod.POST)
	public String eventForm(Model model, EventDataForm data, @RequestParam MultipartFile imageFile) throws IOException {
		
		String name = data.getName();
		int gameId = data.getGame();
		String place = data.getPlace();
		String date = data.getDate();
		String time = data.getTime();
		String description = data.getDescription();
		boolean isTournament = data.isTournament();
		String reward = data.getReward();
		int groupSize = data.getGroupSize();
		float inscriptionFee = data.getInscriptionFee();
		int maxParticipants = data.getMaxParticipants(); 

		Game game = gameService.findById((long)gameId);
		
		if(game != null) {
			return null;
		}		
		
		Event event = new Event(name, game, place, date, time, description, isTournament, reward, groupSize, inscriptionFee, maxParticipants);
		
		if(! imageFile.isEmpty()) {
			event.setHaveImage(true);
			eventService.save(event);
			imgService.saveImage("eventsImages", event.getId(), imageFile);
		}else {
			eventService.save(event);
		}
			
		model.addAttribute("event", event);
		model.addAttribute("logged",session.getIsLogggedIn());
		
		return "event-template";
	}
  
}