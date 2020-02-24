package com.lcdd.backend.webControllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginPageController {
	
	@RequestMapping("/login")
	public String login(Model model) {
		return "login";
	}
	
}
