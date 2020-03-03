package com.lcdd.backend.webControllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lcdd.backend.UserSession;
import com.lcdd.backend.dbrepositories.EventRegisterRepository;
import com.lcdd.backend.dbrepositories.EventRepository;
import com.lcdd.backend.dbrepositories.GameRepository;
import com.lcdd.backend.dbrepositories.PurchaseRepository;
import com.lcdd.backend.dbrepositories.RoleRepository;
import com.lcdd.backend.dbrepositories.UserRepository;
import com.lcdd.backend.pojo.EventRegister;
import com.lcdd.backend.pojo.Game;
import com.lcdd.backend.pojo.Purchase;
import com.lcdd.backend.pojo.Role;
import com.lcdd.backend.pojo.User;

@Controller
public class DashboardController {
	
	@Autowired
	private GameRepository gameRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PurchaseRepository purchaseRepository;
	@Autowired
	private EventRegisterRepository eventRegisterRepository;
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private UserSession session;
	
	int i;
	
	@GetMapping("/dashboard")
	public String serveDashboard(Model model) {

		model = fillEvenstTab(model);
		model = fillMerchTab(model);
		model = fillUserTab(model);
		
		if(!session.getIsLogggedIn()) {
			return "redirect:/login";
		}
		
	
		
		return "dashboard";
	}
	
	private Model fillEvenstTab(Model model) {
		
		List<EventRegister> eventRegisterList;
		List<Object[]> eventGameList = eventRepository.countGamesEvent();
		
		String[] gamesArray = new String[eventGameList.size()];
		i = 0;
		for(Object[] object : eventGameList) {
			gamesArray[i] = object[0].toString();
			i++;
		}
		
		Long[] eventsArray = new Long[eventGameList.size()];
		i = 0;
		for(Object[] object : eventGameList) {
			eventsArray[i] = (Long)object[1];
			i++;
		}
		
		eventRegisterList = eventRegisterRepository.findAll();
		
		model.addAttribute("EventRegisterList", eventRegisterList);
		
		model.addAttribute("GamesArray", gamesArray);
		model.addAttribute("EventsArray", eventsArray);
		
		return model;
	}
	
	private Model fillMerchTab(Model model) {

		List<Purchase> purchaseList;
		
		Integer[] salesArray = new Integer[12];
		String[] monthsArray = new String[12];
		
		Integer aux;
		
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -11);
		
		for(int i=0; i<12; i++) {
			aux = purchaseRepository.lastYearPurchasesByMonth(calendar.getTime());
			salesArray[i] = (aux == null) ? 0 : aux;
			monthsArray[i] = new SimpleDateFormat("MMMM").format(calendar.getTime());
			
			calendar.add(Calendar.MONTH, +1);
		}
		
		purchaseList = purchaseRepository.findAll(Sort.by(Sort.Direction.DESC, "date"));
		
		model.addAttribute("PurchaseList", purchaseList);
		
		model.addAttribute("SalesArray", salesArray);
		model.addAttribute("MonthsArray", monthsArray);
		
		return model;
	}
	
	private Model fillUserTab(Model model) {
		List<User> userList;
		List<Role> roleList;
		
		userList = userRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
		roleList = roleRepository.findAll();
		
		model.addAttribute("UserList", userList);
		model.addAttribute("RoleList", roleList);
		
		return model;
	}
	
	
}
