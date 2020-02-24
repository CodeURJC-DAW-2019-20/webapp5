package com.lcdd.backend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	
	@GetMapping("/userForm")
	public String getUserForm() {
		return "user-form/user-view";
	}	
}