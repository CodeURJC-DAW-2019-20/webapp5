package com.lcdd.backend.restControllers;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lcdd.backend.pojo.Merchandising;
import com.lcdd.backend.services.MerchandisingService;


@RestController
@RequestMapping("/api/merchandising")
public class MerchandisingRestController {
	
	@Autowired
	private MerchandisingService service;

	@GetMapping("/")
	public Collection<Merchandising> getMerchandising() {
		return service.findAll();
	}

	@GetMapping("/titles")
	public Collection<String> getMerchNames() {
		return service.findAll().stream().map(b -> b.getName()).collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public Merchandising getMerchandising(@PathVariable long id) {
		return service.findById(id).get();
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Merchandising createBook(@RequestBody Merchandising merch) {
		service.save(merch);
		System.out.println(merch.getId());
		return merch;
	}

	@PutMapping("/{id}")
	public Merchandising updateBook(@PathVariable long id, @RequestBody Merchandising updatedMerch){

		service.findById(id).get(); //Returns with 404 if not found in database
		
		updatedMerch.setId(id);
		service.save(updatedMerch);
		return updatedMerch;
	}

	@DeleteMapping("/{id}")
	public Merchandising deleteBook(@PathVariable long id) {

		Merchandising deletedBook = service.findById(id).get();
		service.delete(id);
		return deletedBook;
	}


}
