package com.lcdd.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginErrorController {
  
  @GetMapping("/loginerror")
  public String serveLogError(Model model) {
    return "login_error";
  }
}