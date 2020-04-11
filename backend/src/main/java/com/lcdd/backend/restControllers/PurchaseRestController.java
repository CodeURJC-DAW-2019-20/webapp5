package com.lcdd.backend.restControllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcdd.backend.pojo.Purchase;
import com.lcdd.backend.services.PurchaseService;

@RestController
@RequestMapping("/api/purchase")
public class PurchaseRestController {
	
	@Autowired
	private PurchaseService purchaseService;
	
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

}
