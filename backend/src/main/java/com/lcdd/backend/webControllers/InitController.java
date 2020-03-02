package com.lcdd.backend.webControllers;

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
		
		Role presi= new Role("President");
		Role vice= new Role("Vice-president");
		roleRepository.save(new Role("ADMIN"));
		roleRepository.save(presi);
		roleRepository.save(vice);
		roleRepository.save(new Role("Secretary"));
		roleRepository.save(new Role("Treasurer"));
		roleRepository.save(new Role("Vocal"));
		
		MerchType chapa = new MerchType("Chapas");
		MerchType posters = new MerchType("Posters");
		merchTypeRepository.save(chapa);
		merchTypeRepository.save(posters);
		merchTypeRepository.save(new MerchType("Camisetas"));
		merchTypeRepository.save(new MerchType("Otros"));
		
		eventRepository.save(new Event("Evento de lol 1",lol,"URJC Móstoles, S10 Lab 2","03-03-2019", "15:00","Es un torneo de LoL presencial",true,"Un abrazo",5,(long)10,20));
		eventRepository.save(new Event("Evento de magic",magic,"URJC Móstoles, S10 Lab 2","03-03-2019", "15:00","Es un meeting de magic no presencial",false,"",8,(long)1,1));
		eventRepository.save(new Event("Evento de lol 2",lol,"URJC Móstoles, S10 Lab 2","03-03-2019", "15:00","Es un torneo de LoL presencial",false,"",2,(long)4,2));
		eventRepository.save(new Event("Evento de magic 2",magic,"URJC Móstoles, S10 Lab 2","03-03-2019", "15:00","Es un torneo de magic presencial",true,"Un aplauso",1,(long)1,1));
		eventRepository.save(new Event("Evento de lol 3",lol,"URJC Móstoles, S10 Lab 2","03-03-2019", "15:00","Es un torneo de LoL presencial",true,"Las gracias",5,(long)5,2));
		
		
		//User user = new User("user", "pass", "ROLE_USER");
		//userRepository.save(user);
		User carlos = new User("email", "cPabe", "carlos", "pabe", "pass" , presi, "ROLE_ADMIN");
		User victor = new User("email", "ViktorLopezz", "vic", "lopz","pass", vice);
		userRepository.save(carlos);
		userRepository.save(victor);
		
		Merchandising lolPoster = new Merchandising("Poster Lol", posters);
		merchRepository.save(lolPoster);
		merchRepository.save(new Merchandising("Disfraz de furro", posters));
		merchRepository.save(new Merchandising("Bote de ketchup", posters));
		merchRepository.save(new Merchandising("Peluca de dani", posters));
		merchRepository.save(new Merchandising("Jojos referencia", posters));
		merchRepository.save(new Merchandising("Skin de ramus", posters));
		merchRepository.save(new Merchandising("El alma de la LCDD", posters));
		merchRepository.save(new Merchandising("EU4", posters));
		merchRepository.save(new Merchandising("Gamu", posters));
		
		
		Calendar calendar = Calendar.getInstance();
		
		
		calendar.add(Calendar.MONTH, -11);
		purchaseRepository.save(new Purchase(carlos, calendar.getTime(),lolPoster));
		purchaseRepository.save(new Purchase(victor, calendar.getTime(),lolPoster));
		
		
		
		calendar.add(Calendar.MONTH, +5);
		purchaseRepository.save(new Purchase(victor, calendar.getTime(),lolPoster));//+`çç
		
		calendar.add(Calendar.MONTH, +5);
		purchaseRepository.save(new Purchase(carlos, calendar.getTime(),lolPoster));
		
		calendar.add(Calendar.MONTH, +1);
		purchaseRepository.save(new Purchase(victor, calendar.getTime(),lolPoster));
		
	}
}
