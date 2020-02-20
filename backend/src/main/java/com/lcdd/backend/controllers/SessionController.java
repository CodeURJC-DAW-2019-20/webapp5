package com.lcdd.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.lcdd.backend.UserSession;

@Controller
@ControllerAdvice
public class SessionController {
	@Autowired
	private UserSession session;
	
	@ModelAttribute
    public void addAttributes(Model model) {
		model.addAttribute("session", session);
		model.addAttribute("idLoggedIn", false);
    }
}
