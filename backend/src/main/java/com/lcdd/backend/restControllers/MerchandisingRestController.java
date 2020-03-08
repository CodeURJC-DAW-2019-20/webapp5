package com.lcdd.backend.restControllers;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lcdd.backend.pojo.MerchType;
import com.lcdd.backend.pojo.Merchandising;
import com.lcdd.backend.services.MerchTypeService;
import com.lcdd.backend.services.MerchandisingService;


@RestController
@RequestMapping("/api/merchandising")
public class MerchandisingRestController {
	
	@Autowired
	private MerchandisingService service;
	@Autowired
	private MerchTypeService serviceType;

	//every user
	@GetMapping("/")
	public ResponseEntity<List<Merchandising>> getMerchandising() {
		List<Merchandising> merch = service.findAll();
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
		Merchandising merch = service.findById(id).get();
		return new ResponseEntity<>(merch, HttpStatus.OK);
	}

	//only admin
	@PostMapping("/")
	public ResponseEntity<Merchandising> createMerch(@RequestBody Merchandising merch) {
		boolean bol = service.createMerch(merch);
		if(bol == true) {
			return new ResponseEntity<>(merch, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	//only admin
	@PutMapping("/{id}")
	public Merchandising updateMerch(@PathVariable long id, @RequestBody Merchandising updatedMerch){

		service.findById(id).get(); //Returns with 404 if not found in database
		
		updatedMerch.setId(id);
		service.save(updatedMerch);
		return updatedMerch;
	}

	//only admin
	@DeleteMapping("/{id}")
	public Merchandising deleteMerch(@PathVariable long id) {

		Merchandising deletedBook = service.findById(id).get();
		service.delete(id);
		return deletedBook;
	}


}
