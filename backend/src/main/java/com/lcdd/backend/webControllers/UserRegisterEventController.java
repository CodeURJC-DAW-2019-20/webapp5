package com.lcdd.backend.webControllers;


import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lcdd.backend.UserSession;
import com.lcdd.backend.dbrepositories.EventRegisterRepository;
import com.lcdd.backend.dbrepositories.EventRepository;
import com.lcdd.backend.dbrepositories.UserRepository;
import com.lcdd.backend.pojo.Event;
import com.lcdd.backend.pojo.User;
import com.lcdd.backend.pojo.EventRegister;

@Controller
public class UserRegisterEventController {
	
	@Autowired
	private UserSession session;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private EventRegisterRepository repository;
	
	@PostMapping("/userRegisterEvent/{id}")
	public String serveEvent(Model model,@PathVariable Long id, @RequestParam int participants, HttpServletRequest request) {

			User user = userRepository.findByName(session.getUsername());
			Event event = eventRepository.findById(id).get();

			EventRegister register = new EventRegister(user,event,user.getName(),participants);
			event.setMaxParticipants(event.getMaxParticipants()-participants);
			eventRepository.save(event);
			model.addAttribute("event", event);
			repository.save(register);
			return "event-template";

			}
}
