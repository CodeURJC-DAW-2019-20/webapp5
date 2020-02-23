package com.lcdd.backend.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// import es.urjc.code.security.User;

@Controller
public class WebController {
  
  @RequestMapping("/")
  public String index() {
    return "index";
  }
  
  @RequestMapping("/loginerror")
  public String loginerror(Model model) {
    return "login_error";
  }
  @RequestMapping("/home")
  public String home() {
    return "home";
  }
  @RequestMapping("/admin")
  public String admin(Model model, HttpServletRequest request) {
	  // User user = userRepository.findByName(request.getUserPrincipal().getName());	
	  model.addAttribute("admin", request.isUserInRole("ADMIN"));
	  // model.addAttribute("username", user.getName());
	  return "admin";
  }
  @RequestMapping("/about_us")
  public String about_us() {
    return "about_us";
  }
  @RequestMapping("/contact")
  public String contact() {
    return "contact";
  }
  @RequestMapping("/events")
  public String events() {
    return "events";
  }
  @RequestMapping("/merchandaising")
  public String merchandaising() {
    return "merchandaising";
  }
  @RequestMapping("/register")
  public String register() {
    return "register";
  }
  @RequestMapping("/event_form")
  public String event_form(Model model, HttpServletRequest request) {
	  model.addAttribute("admin", request.isUserInRole("ADMIN"));
	  return "event_form";
  }
  @RequestMapping("/merch_form")
  public String merch_form(Model model, HttpServletRequest request) {
	  model.addAttribute("admin", request.isUserInRole("ADMIN"));
	  return "merch_form";
  }
 
}