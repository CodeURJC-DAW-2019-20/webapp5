package com.lcdd.backend.webControllers;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WebController {

	@RequestMapping("/admin")
	public String admin(Model model, HttpServletRequest request) {
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
		return "admin";
	}
	@GetMapping(value= {"about-us"})
	public String serveAboutUs(Model model) {
		return "about_us";
	}
	
	@GetMapping(value= {"contact"})
	public String serveContact(Model model) {
		return "contact";
	}
	
	@RequestMapping("/login")
	public String login(Model model) {
		return "login";
	}
	
	@GetMapping("/loginerror")
	public String serveLogError(Model model) {
		return "logerror";
	}

	@RequestMapping(value= {"home","index","/"})
	public String index() {
		return "index";
	}
}