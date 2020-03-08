package com.lcdd.backend.webControllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lcdd.backend.UserSession;
import com.lcdd.backend.dbrepositories.UserRepository;
import com.lcdd.backend.pojo.Event;
import com.lcdd.backend.pojo.Game;
import com.lcdd.backend.pojo.RegisterDataForm;
import com.lcdd.backend.pojo.User;
import com.lcdd.backend.services.EventService;
import com.lcdd.backend.services.GameService;

@Controller
public class ProfileController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	private EventService eventService;
	@Autowired
	private GameService gameService;
	@Autowired
	private UserSession session;
	
	@GetMapping("profile")
	public String profileModel(Model model, HttpServletRequest request) {
		model.addAttribute("session", session);
		
		Iterable<Event> eventList = eventService.findAll();
		int count[] = new int[5];
		
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
	
	@RequestMapping(value = {"/profile"}, 
			method = RequestMethod.POST)
	public String editUser(Model model, RegisterDataForm user) {
		
		User edit = userRepository.findByName(session.getUsername());
		
		edit.setEmail(user.getEmail());
		edit.setFirstName(user.getFirstName());
		edit.setLastName(user.getLastName());
		
		session.setEmail(user.getEmail());
		session.setFirstName(user.getFirstName());
		session.setLastName(user.getLastName());
				
		userRepository.save(edit);
		return "profile";
	}
	
	
	
	
}
