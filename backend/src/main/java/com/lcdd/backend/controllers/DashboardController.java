package com.lcdd.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {
	
	@GetMapping("/dashboard")
	public String serveDashboard(Model model) {
		return "dashboard";
	}
}
