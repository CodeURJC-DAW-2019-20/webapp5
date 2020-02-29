package com.lcdd.backend.webControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {
	
  @RequestMapping("/profile")
  public String eventTemplate(Model model){
    return "profile";
  }
}