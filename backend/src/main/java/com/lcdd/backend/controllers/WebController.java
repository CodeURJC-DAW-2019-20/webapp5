package com.lcdd.backend.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
  
  @RequestMapping("/")
  public String index() {
    return "index";
  }
  
  @RequestMapping("/login")
  public String login() {
    return "login";
  }
  
  @RequestMapping("/loginerror")
  public String logierror() {
    return "loginerror";
  }
  @RequestMapping("/home")
  public String home() {
    return "home";
  }
  @RequestMapping("/admin")
  public String admin(Model model, HttpServletRequest request) {
	  model.addAttribute("admin", request.isUserInRole("ADMIN"));
	  return "admin";
  }
  @RequestMapping("/about_us")
  public String about_us() {
    return "about_us";
  }
 
}