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


import com.lcdd.backend.ImageService;
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
	
	@RequestMapping("event-form")
	public String serveEvent(Model model) {
		
		List<Game> gameList; 
		gameList = gameRepository.findAll();
		
		model.addAttribute("GameList", gameList);
		 
		return "event-form";
	}
	
	
	@RequestMapping(value = {"/eventForm"}, 
			method = RequestMethod.POST,
			consumes = "application/x-www-form-urlencoded;charset=UTF-8")
	@ResponseBody
	public String eventForm(Model model, @RequestBody Map<String,String> myMap) {
		
		String name = myMap.get("name");
		Long gameId = Long.parseLong(myMap.get("game"));
		String place = myMap.get("place");
		String date = myMap.get("date");
		String time = myMap.get("time");
		String description = myMap.get("description");
		boolean isTournament = Boolean.parseBoolean(myMap.get("isTournament"));
		String reward = myMap.get("reward");
		int groupSize = Integer.parseInt(myMap.get("groupSize"));
		float inscriptionFee = Float.parseFloat(myMap.get("inscriptionFee"));
		int maxParticipants = Integer.parseInt(myMap.get("maxParticipants")); 

		Optional<Game> game = gameRepository.findById(gameId);
		
		if(!game.isPresent()) {
			return null;
		}		
		
		Event event = new Event(name, game.get(), place, date, time, description, isTournament, reward, groupSize, inscriptionFee, maxParticipants);
		
		repository.save(event);
		
		model.addAttribute("event", event);
		/*
	event.setHaveImage(true);
		
	repository.save(event);
	
	//model.addAttribute("event", event);
	
	imgService.saveImage("event", event.getId(), imageFile);
	model.addAttribute("event", event);
	*/
	return "event-form";
	}
  
}