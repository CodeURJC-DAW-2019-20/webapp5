package com.lcdd.backend.webControllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lcdd.backend.UserSession;
import com.lcdd.backend.dbrepositories.EventRepository;
import com.lcdd.backend.dbrepositories.GameRepository;
import com.lcdd.backend.dbrepositories.UserRepository;
import com.lcdd.backend.pojo.Event;
import com.lcdd.backend.pojo.EventRegister;
import com.lcdd.backend.pojo.Game;
import com.lcdd.backend.pojo.RegisterDataForm;
import com.lcdd.backend.pojo.User;

@Controller
public class ProfileController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	EventRepository eventRepository;
	@Autowired
	GameRepository gameRepository;
	@Autowired
	private UserSession session;
	
	@GetMapping("profile")
	public String profileModel(Model model, HttpServletRequest request) {
		model.addAttribute("session", session);
		
		Iterable<Event> eventList = eventRepository.findAll();
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
		Optional<Game> popular = gameRepository.findById((long)count[posicionmayor]);
		//Optional<Game> popular = gameRepository.findById(p);   
		model.addAttribute("popular", popular.get());
		
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
