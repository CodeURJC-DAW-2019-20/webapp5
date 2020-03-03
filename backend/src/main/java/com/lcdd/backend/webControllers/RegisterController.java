package com.lcdd.backend.webControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lcdd.backend.UserSession;
import com.lcdd.backend.dbrepositories.UserRepository;
import com.lcdd.backend.pojo.RegisterDataForm;
import com.lcdd.backend.pojo.User;

@Controller
public class RegisterController {
	
	@Autowired
	private UserRepository userRepository;
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
		
		userRepository.save(newUser);
		
		userSession.setIsLogggedIn(true);
		userSession.setUsername(newUser.getName());
		
		return "/";
	}
	
}