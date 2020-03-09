package com.lcdd.backend.webControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.lcdd.backend.UserSession;
import com.lcdd.backend.pojo.RegisterDataForm;
import com.lcdd.backend.pojo.User;
import com.lcdd.backend.services.UserService;

@Controller
public class RegisterController {
	
	@Autowired
	private UserService userService;
	@Autowired 
	public UserSession userSession;
	
	@GetMapping(value= {"register"})
	public String serveRegister(Model model) {
		return "register";
	}
	
	@RequestMapping(value = {"/registerUser"}, 
			method = RequestMethod.POST)
	public String registerUser(Model model, RegisterDataForm user) {
		
		User newUser = new User(user.getEmail(),user.getName(),user.getFirstName(),user.getLastName(),user.getPasswordHash(),"ROLE_USER");
		
		userService.save(newUser);
		
		userSession.setIsLogggedIn(true);
		userSession.setUsername(newUser.getName());
		
		return "/";
	}
	
}