package com.lcdd.backend.webControllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lcdd.backend.UserSession;
import com.lcdd.backend.dbrepositories.UserRepository;
import com.lcdd.backend.pojo.RegisterDataForm;
import com.lcdd.backend.pojo.User;

@Controller
public class ProfileController {
	@Autowired
	UserRepository userRepository;
	@Autowired
	private UserSession session;
	
	@GetMapping("profile")
	public String profileModel(Model model, HttpServletRequest request) {
		model.addAttribute("session", session);
		System.out.println(session.getFirstName());
		return "profile";
	}
	
	@RequestMapping(value = {"/profile"}, 
			method = RequestMethod.POST)
	public String editUser(Model model, RegisterDataForm user) {
		
		User edit = userRepository.findByName(session.getUsername());
		
		edit.setEmail(user.getEmail());
		edit.setFirstName(user.getFirstName());
		edit.setLastName(user.getLastName());
		
		session.setEmail(user.getEmail());
		session.setFirstName(user.getFirstName());
		session.setLastName(user.getLastName());
		
		
		userRepository.save(edit);
		return "profile";
	}
	
	
	
	
}
