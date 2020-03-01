package com.lcdd.backend.webControllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.lcdd.backend.dbrepositories.MerchandisingRepository;
import com.lcdd.backend.pojo.Merchandising;


@Controller
public class MerchandisingController {
	
	@Autowired
	MerchandisingRepository repository;
	
	@GetMapping(value= {"merchandising"})
	public String serveMerchandising(Model model) {
		return "merchandising";
	}
	
	@GetMapping("/merchandising/{id}")
    public String getMerchandising(@PathVariable long id, Model model) {
        Optional<Merchandising> merchFound = repository.findById(id);

        if(!merchFound.isPresent()) {
        	return "redirect:/error";
        }

        model.addAttribute("Merchandising", merchFound.get());

        return "merchandising-template";
    }
}