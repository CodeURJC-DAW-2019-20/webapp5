package com.lcdd.backend.webControllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lcdd.backend.dbrepositories.MerchandisingRepository;
import com.lcdd.backend.pojo.Merchandising;


@Controller
public class MerchandisingController {
	
	@Autowired
	MerchandisingRepository repository;
	
	@RequestMapping(value= {"merchandising"})
	public String serveMerchandising(Model model) {
		return "merchandising";
	}
	
	@RequestMapping("/merchandising/{id}")
    public String getMerchandising(@PathVariable long id, Model model) {
        Optional<Merchandising> merchFound = repository.findById(id);

        if(!merchFound.isPresent()) {
        	return "redirect:/error";
        }

        model.addAttribute("merch", merchFound.get());

        return "merchandising-template";
    }
	
	@RequestMapping(value = {"/purchaseMerch/{id}"}, 
			method = RequestMethod.POST)
	public String purchaseMerch(Model model, @PathVariable long id) {
		
		Merchandising merchFound = repository.findById(id).get();
		
        if(merchFound == null) {
        	return "redirect:/error";
        }
        
        merchFound.setStock(merchFound.getStock()-1);
        repository.save(merchFound);
        model.addAttribute("merch", merchFound);
        
        return "merchandising-template";
	}
	
	
	
	@GetMapping("/merchList")
	public ResponseEntity<String> getEventsList(@RequestParam() int pageId) {
		String result = "";
		
		Page<Merchandising> pageMerch = repository.findAll(PageRequest.of(pageId,3));
		
		if(pageMerch.hasContent()) {
			for(Merchandising merch : pageMerch.getContent()) {
				if(merch.getDiscount() > 0) {
					if (merch.isHaveImage()) {
						result += "<div class='col-lg-4 col-sm-6'>" +
							"<div class='l_product_item'>" +
								"<h4>" + merch.getName() + "</h4>" +
								"<h5>" + merch.getPrice() + "€-" + merch.getDiscount() + "%</h5>" +
								"<div class='l_p_img'>" +
									"<img src='/images/merchImages/image-" + merch.getId() +".jpg' width='300' height='300'>" +
									"<h5 class='sale'>Opciones:</h5>" +
								"</div>" +
								"<div class='l_p_text'>" +
									"<ul>" +
										"<li class='p_icon'><a href='/merchandising/" + merch.getId() + "'>Ver Detalles</a></li>" +
									"</ul>" +
								"</div>" +
							"</div>" +
						"</div>";
					} else {
						result += "<div class='col-lg-4 col-sm-6'>" +
							"<div class='l_product_item'>" +
								"<h4>" + merch.getName() + "</h4>" +
								"<h5>" + merch.getPrice() + "€-" + merch.getDiscount() + "%</h5>" +
								"<div class='l_p_img'>" +
									"<img src='/assets/img/merch-image.jpg' width='300' height='300'>" +
									"<h5 class='sale'>Opciones:</h5>" +
								"</div>" +
								"<div class='l_p_text'>" +
									"<ul>" +
										"<li class='p_icon'><a href='/merchandising/" + merch.getId() + "'>Ver Detalles</a></li>" +
									"</ul>" +
								"</div>" +
							"</div>" +
						"</div>";
					}
				} else {
					if (merch.isHaveImage()) {
						result += "<div class='col-lg-4 col-sm-6'>" +
							"<div class='l_product_item'>" +
								"<h4>" + merch.getName() + "</h4>" +
								"<h5>" + merch.getPrice() + "€</h5>" +
								"<div class='l_p_img'>" +
								"<img src='/images/merchImages/image-" + merch.getId() +".jpg' width='300' height='300'>" +
									"<h5 class='sale'>Opciones:</h5>" +
								"</div>" +
								"<div class='l_p_text'>" +
									"<ul>" +
										"<li class='p_icon'><a href='/merchandising/" + merch.getId() + "'>Ver Detalles</a></li>" +
									"</ul>" +
								"</div>" +
							"</div>" +
						"</div>";
					} else {
						result += "<div class='col-lg-4 col-sm-6'>" +
							"<div class='l_product_item'>" +
								"<h4>" + merch.getName() + "</h4>" +
								"<h5>" + merch.getPrice() + "€" + "</h5>" +
								"<div class='l_p_img'>" +
									"<img src='/assets/img/merch-image.jpg' width='300' height='300'>" +
									"<h5 class='sale'>" + "Opciones:" + "</h5>" +
								"</div>" +
								"<div class='l_p_text'>" +
									"<ul>" +
										"<li class='p_icon'><a href='/merchandising/" + merch.getId() + "'>Ver Detalles</a></li>" +
									"</ul>" +
								"</div>" +
							"</div>" +
						"</div>";
					}
				}
				
//				result += "<div class='col-lg-4 col-sm-6'>" +
//						"<div class='l_product_item'>" +
//							"<h4>" + merch.getName() + "</h4>" +
//							"<h5>" + merch.getPrice() + "€" + "</h5>" +
//							"<div class='l_p_img'>" +
//								"<img src='" + "/assets/img/products/lcdd_mug.png" + "' width='300' height='300'>" +
//								"<h5 class='sale'>" + "Opciones:" + "</h5>" +
//							"</div>" +
//							"<div class='l_p_text'>" +
//								"<ul>" +
//									"<li class='p_icon'><a href='" + "#" +"'>Ver Detalles</a></li>" +
//								"</ul>" +
//							"</div>" +
//						"</div>" +
//					"</div>";
			}
		} else {
			result += "nomore";
		}
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
}