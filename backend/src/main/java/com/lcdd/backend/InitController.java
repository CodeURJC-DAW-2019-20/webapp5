package com.lcdd.backend;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lcdd.backend.dbrepositories.GameRepository;
import com.lcdd.backend.dbrepositories.MerchTypeRepository;
import com.lcdd.backend.dbrepositories.RoleRepository;
import com.lcdd.backend.pojo.Game;
import com.lcdd.backend.pojo.MerchType;
import com.lcdd.backend.pojo.Role;

@Controller
public class InitController {
	@Autowired
	private GameRepository gameRepository;
	
	@Autowired
	private MerchTypeRepository merchTypeRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	@PostConstruct
	public void init() {
		gameRepository.save(new Game("League of Legends", "LoL"));
		gameRepository.save(new Game("Teamfight Tactics", "TFT"));
		gameRepository.save(new Game("Legends of Runaterra", "LoR"));
		gameRepository.save(new Game("Magic: The Gathering Arena", "MTG Arena"));
		gameRepository.save(new Game("HeartStone", "HS"));
		
		roleRepository.save(new Role("ADMIN"));
		roleRepository.save(new Role("President"));
		roleRepository.save(new Role("Vice-president"));
		roleRepository.save(new Role("Secretary"));
		roleRepository.save(new Role("Treasurer"));
		roleRepository.save(new Role("Vocals"));
		
		merchTypeRepository.save(new MerchType("Chapas"));
		merchTypeRepository.save(new MerchType("Posters"));
		merchTypeRepository.save(new MerchType("Camisetas"));
		merchTypeRepository.save(new MerchType("Otros"));
	}
}
