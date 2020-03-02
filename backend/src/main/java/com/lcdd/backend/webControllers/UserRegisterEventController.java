package com.lcdd.backend.webControllers;


import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lcdd.backend.UserSession;
import com.lcdd.backend.dbrepositories.UserRepository;
import com.lcdd.backend.pojo.Event;
import com.lcdd.backend.pojo.User;
import com.lcdd.backend.pojo.EventRegister;

public class UserRegisterEventController {
	
	@Autowired
	private UserSession session;
	@Autowired
	private UserRepository userRepository;
	
	
	@RequestMapping("eventUserRegister")
	public void serveEvent(Model model,@RequestParam String participants, HttpServletRequest request) {
		
		if (session.getIsLogggedIn()) {
			model.addAttribute("logged",session.getIsLogggedIn());
			model.addAttribute("session", session);
			User user = userRepository.findById(session.getId()).get();
			
			
			//EventRegister register = new EventRegister(user,"lol",user.getName(),participants);
			System.out.println("registrado correctamente");
		}else {
			System.out.println("no registrado");
			
		}
		
	}
}
