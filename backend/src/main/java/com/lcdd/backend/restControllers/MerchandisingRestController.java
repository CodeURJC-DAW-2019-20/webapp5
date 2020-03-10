package com.lcdd.backend.restControllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lcdd.backend.ImageService;
import com.lcdd.backend.pojo.MerchType;
import com.lcdd.backend.pojo.Merchandising;
import com.lcdd.backend.services.MerchTypeService;
import com.lcdd.backend.services.MerchandisingService;


@RestController
@RequestMapping("/api/merchandisings")
public class MerchandisingRestController {
	
	@Autowired
	private MerchandisingService service;
	@Autowired
	private MerchTypeService serviceType;
	@Autowired 
	private ImageService serviceImage;

	//every user
	@GetMapping("/")
	public ResponseEntity<List<Merchandising>> getMerchandising() {
		List<Merchandising> merch = service.findAll();
		return new ResponseEntity<>(merch, HttpStatus.OK);
	}
	//every user
	@GetMapping("/pages/{id}")
	public ResponseEntity<Page<Merchandising>> getMerchandisingPages(@PathVariable int id) {
		Page<Merchandising> merch = service.findAllPages(id, 3);
		return new ResponseEntity<>(merch, HttpStatus.OK);
	}
	
	//every user
	@GetMapping("/types")
	public ResponseEntity<List<MerchType>> getMerchTypeNames() {
		List<MerchType> type = serviceType.findAll();
		return new ResponseEntity<>(type, HttpStatus.OK);
	}

	//every user
	@GetMapping("/{id}")
	public ResponseEntity<Merchandising> getMerchandising(@PathVariable long id) {
		Merchandising merch = service.findById(id);
		return new ResponseEntity<>(merch, HttpStatus.OK);
	}
	//every user
	@GetMapping("/{id}/image")
	public ResponseEntity<Object> getMerchandisingImage(@PathVariable long id) throws IOException{
		Merchandising merch = service.findById(id);
		
	if (merch.isHaveImage()) {
		return this.serviceImage.createResponseFromImage("merchImages", id);
	}
		return new ResponseEntity<>(merch, HttpStatus.NOT_FOUND);
	}

	//only admin
	@PostMapping("/")
	public ResponseEntity<Merchandising> postMerch(@RequestBody Merchandising merch) {
		
		boolean result = service.createMerch(merch);
		if(result == true) {
			return new ResponseEntity<>(merch, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	//only admin
	
	//@PutMapping("/{id}/image")
	@PostMapping("/{id}/image")
	public ResponseEntity<Merchandising> postMerchandisingImage(@PathVariable long id, @RequestParam MultipartFile imageFile)
			throws IOException {

		Merchandising merch = service.findById(id);

		//merch.isHaveImage();
		merch.setHaveImage(true);
		service.save(merch);

		serviceImage.saveImage("merchImages", merch.getId(), imageFile);
		return new ResponseEntity<>(HttpStatus.CREATED);

	}
	
	//only admin
	@PutMapping("/{id}")
	public ResponseEntity<Merchandising> updateMerch(@PathVariable long id, @RequestBody Merchandising updateMerch,
			HttpServletRequest request, HttpSession session){
		Merchandising merch = service.findById(id);
		if(merch.getName()!= null) {
			merch.setName(updateMerch.getName());
	}
		if(merch.getPrice()!= 0) {
			merch.setPrice(updateMerch.getPrice());
	}
		if(merch.getDiscount()!= 0) {
			merch.setDiscount(updateMerch.getDiscount());
	}
		if(merch.getStock()!= 0) {
			merch.setStock(updateMerch.getStock());
	}
		if(merch.getType()!= null) {
			merch.setType(updateMerch.getType());
	}
		if(merch.getDescription()!= null) {
			merch.setDescription(updateMerch.getDescription());
	}
		service.save(merch);
		return new ResponseEntity<>(merch, HttpStatus.OK);
	}
	


	//only admin
	@DeleteMapping("/{id}")
	public ResponseEntity<Merchandising> deleteMerch(@PathVariable long id) {
		Merchandising merch = service.findById(id);
		service.delete(id);
		return new ResponseEntity<>(merch, HttpStatus.OK);
	}


}
