package com.lcdd.backend.webControllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lcdd.backend.UserSession;
import com.lcdd.backend.pojo.Event;
import com.lcdd.backend.pojo.Game;
import com.lcdd.backend.pojo.RegisterDataForm;
import com.lcdd.backend.pojo.User;
import com.lcdd.backend.services.EventService;
import com.lcdd.backend.services.GameService;
import com.lcdd.backend.services.UserService;

@Controller
public class ProfileController {
	@Autowired
	private UserService userService;
	@Autowired
	private EventService eventService;
	@Autowired
	private GameService gameService;
	@Autowired
	private UserSession session;
	
	@GetMapping("/profile")
	public String profileModel(Model model, HttpServletRequest request) {
		model.addAttribute("session", session);
		
		Iterable<Event> eventList = eventService.findAll();
		int count[] = new int[(int) gameService.countGames()+1];
		
		for(Event event: eventList) {
			Game game = event.getGame();
				long gameId = game.getId();
					count[(int)gameId]++;
			
		}
		
		int posicionmayor = 0;
        /* for(int i=0; i<count.length && i<count.length; i++){
            if(count[i]>numeromayor){
                numeromayor = count[i];
            }
        } */
	        
        for ( int i = 1; i < count.length; i++ )
        {
        	if (count[i] > count[posicionmayor] ) posicionmayor = i;
        }
	       
		//long p = 1;  
		Game popular = gameService.findById((long)count[posicionmayor]);
		//Optional<Game> popular = gameRepository.findById(p);   
		model.addAttribute("popular", popular);
		
		return "profile";
	}
	
	@RequestMapping(value= {"/eventSuggestion"}, method = RequestMethod.POST)
	public ResponseEntity<String> getEventsSuggestion(@RequestParam() int pageId) {
		
		Iterable<Event> eventList = eventService.findAll();
		int count[] = new int[(int) gameService.countGames()+1];
		for(Event event: eventList) {
			Game game = event.getGame();
				long gameId = game.getId();
					count[(int)gameId]++;	
		}
		int posicionmayor = 0;
        for ( int i = 1; i < count.length; i++ )
        {
        	if (count[i] > count[posicionmayor] ) posicionmayor = i;
        }
		Game popular = gameService.findById((long)count[posicionmayor]);
		
		String result = "";
		Page<Event> pageEvent = eventService.findAllPagesByGame(popular,pageId,3);
		
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
	
	
	@RequestMapping(value = {"/profile"}, 
			method = RequestMethod.POST)
	public String editUser(Model model, RegisterDataForm user) {
		
		User edit = userService.findByName(session.getUsername());
		
		edit.setEmail(user.getEmail());
		edit.setFirstName(user.getFirstName());
		edit.setLastName(user.getLastName());
		
		session.setEmail(user.getEmail());
		session.setFirstName(user.getFirstName());
		session.setLastName(user.getLastName());
				
		userService.save(edit);
		return "profile";
	}
	
	
	
	
}
