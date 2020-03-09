package com.lcdd.backend.webControllers;


import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.lcdd.backend.UserSession;
import com.lcdd.backend.pojo.Event;
import com.lcdd.backend.pojo.User;
import com.lcdd.backend.services.UserService;
import com.lcdd.backend.services.EventService;
import com.lcdd.backend.services.UserRegisterEventService;
import com.lcdd.backend.pojo.EventRegister;

@Controller
public class UserRegisterEventController {
	
	@Autowired
	private UserSession session;
	@Autowired
	private UserService userService;
	@Autowired
	private EventService eventService;
	@Autowired
	private UserRegisterEventService eventRegisterService;
	
	@PostMapping("/userRegisterEvent/{id}")
	public String serveEvent(Model model,@PathVariable Long id, @RequestParam int participants, HttpServletRequest request) {
		User user = userService.findByName(session.getUsername());
		Event event = eventService.findById(id);
		EventRegister register = new EventRegister(user,event,user.getName(),participants);
		event.setMaxParticipants(event.getMaxParticipants()-participants);
		eventService.save(event);
		model.addAttribute("event", event);
		eventRegisterService.save(register);
		return "event-template";
	}
	
}
