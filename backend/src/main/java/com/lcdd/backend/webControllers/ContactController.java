package com.lcdd.backend.webControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
	
	@GetMapping(value= {"contact"})
	public String serveContact(Model model) {
		return "contact";
	}
}