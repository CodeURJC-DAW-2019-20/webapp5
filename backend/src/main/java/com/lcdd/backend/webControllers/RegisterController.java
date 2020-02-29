package com.lcdd.backend.webControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegisterController {
	
	@GetMapping(value= {"register"})
	public String serveRegister(Model model) {
		return "register";
	}
}