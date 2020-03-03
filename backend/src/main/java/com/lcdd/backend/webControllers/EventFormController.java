package com.lcdd.backend.webControllers;


import java.io.IOException;
import java.util.Map;
import java.util.Optional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lcdd.backend.pojo.Event;
import com.lcdd.backend.pojo.Game;
import com.lcdd.backend.pojo.EventDataForm;

import com.lcdd.backend.ImageService;
import com.lcdd.backend.UserSession;
import com.lcdd.backend.dbrepositories.EventRepository;
import com.lcdd.backend.dbrepositories.GameRepository;



@Controller
public class EventFormController {
  
	@Autowired
	private EventRepository repository;
	@Autowired
	private ImageService imgService;
	@Autowired
	private GameRepository gameRepository;
	@Autowired
	private UserSession session;
	
	@RequestMapping("event-form")
	public String serveEvent(Model model) {
		// model.addAttribute("admin", request.isUserInRole("ADMIN"));
		List<Game> gameList; 
		gameList = gameRepository.findAll();
		
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

		Optional<Game> game = gameRepository.findById((long)gameId);
		
		if(!game.isPresent()) {
			return null;
		}		
		
		Event event = new Event(name, game.get(), place, date, time, description, isTournament, reward, groupSize, inscriptionFee, maxParticipants);
		
		if(! imageFile.isEmpty()) {
			event.setHaveImage(true);
			repository.save(event);
			imgService.saveImage("eventsImages", event.getId(), imageFile);
		}else {
			repository.save(event);
		}
			
		model.addAttribute("event", event);
		model.addAttribute("logged",session.getIsLogggedIn());
		
		return "event-template";
	}
  
}