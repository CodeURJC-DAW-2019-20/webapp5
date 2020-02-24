package com.lcdd.backend.controllers;

import java.util.Calendar;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lcdd.backend.dbrepositories.EventRepository;
import com.lcdd.backend.dbrepositories.GameRepository;
import com.lcdd.backend.dbrepositories.MerchTypeRepository;
import com.lcdd.backend.dbrepositories.MerchandisingRepository;
import com.lcdd.backend.dbrepositories.PurchaseRepository;
import com.lcdd.backend.dbrepositories.RoleRepository;
import com.lcdd.backend.dbrepositories.UserRepository;
import com.lcdd.backend.pojo.Event;
import com.lcdd.backend.pojo.Game;
import com.lcdd.backend.pojo.MerchType;
import com.lcdd.backend.pojo.Merchandising;
import com.lcdd.backend.pojo.Purchase;
import com.lcdd.backend.pojo.Role;
import com.lcdd.backend.pojo.User;

@Controller
public class InitController {
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private MerchTypeRepository merchTypeRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MerchandisingRepository merchRepository;
	
	@Autowired
	private PurchaseRepository purchaseRepository;
	
	
	@PostConstruct
	public void init() {
		Game lol = new Game("League of Legends", "LoL");
		Game magic = new Game("Magic: The Gathering Arena", "MTG Arena");
		gameRepository.save(lol);
		gameRepository.save(magic);
		gameRepository.save(new Game("Teamfight Tactics", "TFT"));
		gameRepository.save(new Game("Legends of Runaterra", "LoR"));
		gameRepository.save(new Game("HeartStone", "HS"));
		
		roleRepository.save(new Role("ADMIN"));
		roleRepository.save(new Role("President"));
		roleRepository.save(new Role("Vice-president"));
		roleRepository.save(new Role("Secretary"));
		roleRepository.save(new Role("Treasurer"));
		roleRepository.save(new Role("Vocals"));
		
		MerchType chapa = new MerchType("Chapas");
		MerchType posters = new MerchType("Chapas");
		merchTypeRepository.save(chapa);
		merchTypeRepository.save(posters);
		merchTypeRepository.save(new MerchType("Camisetas"));
		merchTypeRepository.save(new MerchType("Otros"));
		
		eventRepository.save(new Event(lol, "Lol"));
		eventRepository.save(new Event(lol, "Lol2"));
		eventRepository.save(new Event(magic, "Cartas magicas"));
		
		User carlos = new User("cPabe");
		User victor = new User("ViktorLopezz");
		userRepository.save(carlos);
		userRepository.save(victor);
		
		Merchandising lolPoster = new Merchandising("Poster Lol", posters);
		merchRepository.save(lolPoster);
		
		
		Calendar calendar = Calendar.getInstance();
		
		
		calendar.add(Calendar.MONTH, -11);
		purchaseRepository.save(new Purchase(carlos, calendar.getTime(),lolPoster));
		purchaseRepository.save(new Purchase(victor, calendar.getTime(),lolPoster));
		
		calendar.add(Calendar.MONTH, +5);
		purchaseRepository.save(new Purchase(victor, calendar.getTime(),lolPoster));
		
		calendar.add(Calendar.MONTH, +5);
		purchaseRepository.save(new Purchase(carlos, calendar.getTime(),lolPoster));
		
		calendar.add(Calendar.MONTH, +1);
		purchaseRepository.save(new Purchase(victor, calendar.getTime(),lolPoster));
		
	}
}
