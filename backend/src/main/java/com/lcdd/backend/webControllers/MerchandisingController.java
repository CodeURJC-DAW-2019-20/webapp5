package com.lcdd.backend.webControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.lcdd.backend.pojo.Merchandising;
import com.lcdd.backend.services.MerchandisingService;


@Controller
public class MerchandisingController {
	
	@Autowired
	private MerchandisingService service;
	
	@RequestMapping("/merchandising/{id}")
    public String getMerchandising(@PathVariable long id, Model model) {
        
		Merchandising merchFound = service.findById(id);
        if(merchFound == null) {
        	return null;
        }

        model.addAttribute("merch", merchFound);

        return "merchandising-template";
    }
}