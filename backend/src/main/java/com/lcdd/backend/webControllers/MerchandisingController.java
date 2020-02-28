package com.lcdd.backend.webControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MerchandisingController {
	
	@GetMapping(value= {"merchandising"})
	public String serveMerchandising(Model model) {
		return "merchandising";
	}
}