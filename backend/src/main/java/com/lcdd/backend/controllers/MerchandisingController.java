package com.lcdd.backend.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MerchandisingController {
	
  @RequestMapping("merchandising")
  public String merchModel(Model model){
    return "merchandising";
  }
}