package com.lcdd.backend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserProfile {
	
  @RequestMapping("/event-form")
  public String eventTemplate(Model model){

    int a = 1;
    model.addAttribute("event", a);

    return "event-form";
  }
}