package com.lcdd.backend.webControllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lcdd.backend.UserSession;

@Controller
@ControllerAdvice
public class SessionController {
	@Autowired
	private UserSession session;
	
	@ModelAttribute
    public void addAttributes(Model model, HttpServletRequest request) {
		model.addAttribute("logged",session.getIsLogggedIn());
		model.addAttribute("session", session);
		model.addAttribute("isAdmin", request.isUserInRole("ADMIN"));

    }
	
	@RequestMapping("logOut")
	public String logOut (Model model, HttpServletRequest request) {
		session.setIsLogggedIn(false);
		model.addAttribute("logged",session.getIsLogggedIn());
		return "index";
	}
	
	
}
