package com.lcdd.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
	
	@GetMapping("/dashboard")
	public String serveDashboard(Model model) {
		model.addAttribute("testo", "holamundo");
		model.addAttribute("testa", "hijodeputa");
		model.addAttribute("teste", "subnormal");
		return "dashboard";
	}
}
