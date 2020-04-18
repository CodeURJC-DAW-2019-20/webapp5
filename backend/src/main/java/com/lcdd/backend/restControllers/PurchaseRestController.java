package com.lcdd.backend.restControllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcdd.backend.UserSession;
import com.lcdd.backend.pojo.Event;
import com.lcdd.backend.pojo.EventRegister;
import com.lcdd.backend.pojo.Merchandising;
import com.lcdd.backend.pojo.Purchase;
import com.lcdd.backend.pojo.User;
import com.lcdd.backend.services.MerchandisingService;
import com.lcdd.backend.services.PurchaseService;
import com.lcdd.backend.services.UserService;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseRestController {
	
	@Autowired
	private PurchaseService purchaseService;
	@Autowired
	private UserService userService;
	@Autowired
	private MerchandisingService merchService;
	
	@GetMapping(value={"", "/"})
	public ResponseEntity<List<Purchase>> getEventList() {
		List<Purchase> purchaseList = purchaseService.findAll(Sort.by(Sort.Direction.DESC, "date"));
		return new ResponseEntity<>(purchaseList, HttpStatus.OK);
	}
	
	@GetMapping("/lastYearByMonth")
	public ResponseEntity<Object[]> gatLastYearPurchasesByMonth() {
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
		
		Object[] result = new Object[2];
		
		result[0] = monthsArray;
		result[1] = salesArray;
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@PostMapping("/{id}")
	public ResponseEntity<Purchase> serveEvent(@PathVariable Long id, 
			Authentication auth,  UserSession session, HttpServletRequest request) {
		
		User user = userService.findByName(auth.getName());
		Merchandising merch = merchService.findById(id);
		merch.setStock(merch.getStock()-1);
		
		Calendar calendar = Calendar.getInstance();
		
		Purchase purchase = new Purchase(user, calendar.getTime() ,merch);
		
		merchService.save(merch);
		purchaseService.save(purchase);
		
		return new ResponseEntity<>(purchase, HttpStatus.OK);
	}
	
}
