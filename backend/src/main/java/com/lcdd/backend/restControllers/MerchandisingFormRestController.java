package com.lcdd.backend.restControllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lcdd.backend.ImageService;

import com.lcdd.backend.pojo.MerchDataForm;
import com.lcdd.backend.pojo.MerchType;
import com.lcdd.backend.pojo.Merchandising;
import com.lcdd.backend.services.MerchTypeService;
import com.lcdd.backend.services.MerchandisingService;

@RestController
public class MerchandisingFormRestController {
	
	@Autowired
	private MerchandisingService serviceMerch;
	@Autowired
	private ImageService imgService;
	@Autowired
	private MerchTypeService serviceType;
	
	@RequestMapping(value = {"merchandising-form"})
	public String serveMerchandising(Model model) {
		List<MerchType> merchtype; 
		merchtype = serviceType.findAll();
		
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
		
		Optional<MerchType> merchtype = serviceType.findById((long)typeId);
		
		if(!merchtype.isPresent()) {
			return null;
		}	
		
		Merchandising merch = new Merchandising(name, merchtype.get(), price, discount, stock, description);
		if(! imageFile.isEmpty()) {
			merch.setHaveImage(true);
			serviceMerch.save(merch);
			imgService.saveImage("merchImages", merch.getId(), imageFile);
		}else {
			serviceMerch.save(merch);
		} 
			
		model.addAttribute("merch", merch);
	
		return "merchandising-template";
	}
}
