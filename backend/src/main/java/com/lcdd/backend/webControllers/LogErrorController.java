package com.lcdd.backend.webControllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogErrorController {
  
  @GetMapping("/loginerror")
  public String serveLogError(Model model) {
    return "logerror";
  }
}