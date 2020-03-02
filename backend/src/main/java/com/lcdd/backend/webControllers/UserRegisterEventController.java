package com.lcdd.backend.webControllers;


import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lcdd.backend.UserSession;

public class UserRegisterEventController {
	
	@Autowired
	private UserSession session;
	
	@RequestMapping("eventUserRegister")
	public void serveEvent(Model model,@RequestParam int participants, HttpServletRequest request) {
		
		if (session.getIsLogggedIn()) {
			model.addAttribute("logged",session.getIsLogggedIn());
			model.addAttribute("session", session);
	
			//EventRegister register = new EventRegister(session.,event,user.getName(),participants);
			System.out.println("registrado correctamente");
		}else {
			System.out.println("no registrado");
			
		}
		
	}
}
