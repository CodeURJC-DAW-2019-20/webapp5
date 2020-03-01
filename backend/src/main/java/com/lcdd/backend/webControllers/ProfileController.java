package com.lcdd.backend.webControllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lcdd.backend.UserSession;
import com.lcdd.backend.dbrepositories.UserRepository;

@Controller
public class ProfileController {
	@Autowired
	UserRepository repository;
	@Autowired
	private UserSession session;
	
	@GetMapping("profile")
	public String profileModel(Model model, HttpServletRequest request) {
		model.addAttribute("logged",session.getIsLogggedIn());
		model.addAttribute("session", session);
		
		return "profile";
	}
	
	
	
	
}
