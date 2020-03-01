package com.lcdd.backend.webControllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.lcdd.backend.ImageService;
import com.lcdd.backend.dbrepositories.MerchTypeRepository;
import com.lcdd.backend.dbrepositories.MerchandisingRepository;
import com.lcdd.backend.pojo.MerchDataForm;
import com.lcdd.backend.pojo.MerchType;
import com.lcdd.backend.pojo.Merchandising;

@Controller
public class MerchandisingFormController {
	
	@Autowired
	private MerchandisingRepository repository;
	@Autowired
	private ImageService imgService;
	@Autowired
	private MerchTypeRepository merchTypeRepository;
	
	@RequestMapping(value = {"merchandising-form"})
	public String serveMerchandising(Model model) {
		List<MerchType> merchtype; 
		merchtype = merchTypeRepository.findAll();
		
		model.addAttribute("MerchList", merchtype);
		
		return "merchandising-form";
	}
	
	
	@RequestMapping(value = {"/merchForm"}, 
			method = RequestMethod.POST)
	public String merchForm(Model model, MerchDataForm data, @RequestParam MultipartFile imageFile) throws IOException {
		
		String name = data.getName();
		int typeId = data.getType();
		float price = data.getPrice();
		float discount = data.getDiscount();
		int stock = data.getStock();
		String description = data.getDescription();
		
		Optional<MerchType> merchtype = merchTypeRepository.findById((long)typeId);
		
		if(!merchtype.isPresent()) {
			return null;
		}	
		
		Merchandising merch = new Merchandising(name, merchtype.get(), price, discount, stock, description);
		if(! imageFile.isEmpty()) {
			merch.setHaveImage(true);
			repository.save(merch);
			imgService.saveImage("merchImages", merch.getId(), imageFile);
		}else {
			repository.save(merch);
		} 
			
		model.addAttribute("merch", merch);
	
		return "merchandising-template";
	}
}
