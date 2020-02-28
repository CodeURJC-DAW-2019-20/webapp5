package com.lcdd.backend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {
	
	@GetMapping("profile")
	public String profileModel(Model model) {
		return "user-form/user-view";
	}
}