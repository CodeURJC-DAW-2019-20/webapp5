package com.lcdd.backend.webControllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.lcdd.backend.UserSession;
import com.lcdd.backend.pojo.EventRegister;
import com.lcdd.backend.pojo.Purchase;
import com.lcdd.backend.pojo.Role;
import com.lcdd.backend.pojo.User;
import com.lcdd.backend.services.EventService;
import com.lcdd.backend.services.PurchaseService;
import com.lcdd.backend.services.RoleService;
import com.lcdd.backend.services.UserRegisterEventService;
import com.lcdd.backend.services.UserService;

@Controller
public class DashboardController {
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;
	@Autowired
	private PurchaseService purchaseService;
	@Autowired
	private UserRegisterEventService eventRegisterService;
	@Autowired
	private EventService eventService;
	
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
		List<Object[]> eventGameList = eventService.countGamesEvent();
		
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
		
		eventRegisterList = eventRegisterService.findAll();
		
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
			aux = purchaseService.lastYearPurchasesByMonth(calendar.getTime());
			salesArray[i] = (aux == null) ? 0 : aux;
			monthsArray[i] = new SimpleDateFormat("MMMM").format(calendar.getTime());
			
			calendar.add(Calendar.MONTH, +1);
		}
		
		purchaseList = purchaseService.findAll(Sort.by(Sort.Direction.DESC, "date"));
		
		model.addAttribute("PurchaseList", purchaseList);
		
		model.addAttribute("SalesArray", salesArray);
		model.addAttribute("MonthsArray", monthsArray);
		
		return model;
	}
	
	private Model fillUserTab(Model model) {
		List<User> userList;
		List<Role> roleList;
					
		userList = userService.findAll(Sort.by(Sort.Direction.ASC, "name"));
		roleList = roleService.findAll();
		
		model.addAttribute("UserList", userList);
		model.addAttribute("RoleList", roleList);
		
		return model;
	}
	
	
}
