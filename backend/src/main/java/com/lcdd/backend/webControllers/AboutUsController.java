package com.lcdd.backend.webControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutUsController {
	
	@GetMapping(value= {"about-us"})
	public String serveAboutUs(Model model) {
		return "about_us";
	}
}
