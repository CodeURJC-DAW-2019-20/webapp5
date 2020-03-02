package com.lcdd.backend.webControllers;


import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lcdd.backend.UserSession;
import com.lcdd.backend.pojo.EventRegister;
import com.lcdd.backend.pojo.User;

public class UserRegisterEventController {
	
	@Autowired
	private UserSession session;
	
	@RequestMapping("eventRegister")
	public void serveEvent(@RequestParam int participants, Model model, HttpServletRequest request) {
		
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
