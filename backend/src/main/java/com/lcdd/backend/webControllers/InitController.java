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
		MerchType poster = new MerchType("Posters");
		MerchType camiseta = new MerchType("Camisetas");
		MerchType figura = new MerchType("Figuras");
		MerchType taza = new MerchType("Tazas");
		merchTypeRepository.save(chapa);
		merchTypeRepository.save(poster);
		merchTypeRepository.save(camiseta);
		merchTypeRepository.save(figura);
		merchTypeRepository.save(taza);
		merchTypeRepository.save(new MerchType("Otros"));
		
//		eventRepository.save(new Event("Evento de lol 1",lol,"URJC Móstoles, S10 Lab 2","03-03-2019", "15:00","Es un torneo de LoL presencial",true,"Un abrazo",5,(long)10,20));
		Event event1 = new Event("Evento de lol 1",lol,"URJC Móstoles, S10 Lab 2","03-03-2019", "15:00","Es un torneo de LoL presencial",true,"Un abrazo",5,(long)10,20);
        event1.setHaveImage(true);
        eventRepository.save(event1);
        Event event2 = new Event("Evento de magic",magic,"URJC Móstoles, S10 Lab 2","03-03-2019", "15:00","Es un meeting de magic no presencial",false,"",8,(long)1,1);
        event2.setHaveImage(true);
        eventRepository.save(event2);
        Event event3 = new Event("Evento de lol 2",lol,"URJC Móstoles, S10 Lab 2","03-03-2019", "15:00","Es un torneo de LoL presencial",false,"",2,(long)4,2);
        event3.setHaveImage(true);
        eventRepository.save(event3);
        Event event4 = new Event("Evento de magic 2",magic,"URJC Móstoles, S10 Lab 2","03-03-2019", "15:00","Es un torneo de magic presencial",true,"Un aplauso",1,(long)1,1);
		event4.setHaveImage(true);
        eventRepository.save(event4);
        Event event5 = new Event("Evento de lol 3",lol,"URJC Móstoles, S10 Lab 2","03-03-2019", "15:00","Es un torneo de LoL presencial",true,"Las gracias",5,(long)5,2);
		event5.setHaveImage(true);
        eventRepository.save(event5);
		
		
		//User user = new User("user", "pass", "ROLE_USER");
		//userRepository.save(user);
		User carlos = new User("email", "cPabe", "carlos", "pabe", "pass" , presi, "ROLE_ADMIN");
		User victor = new User("email", "ViktorLopezz", "vic", "lopz","pass", vice);
		userRepository.save(carlos);
		userRepository.save(victor);
		
		Merchandising chapaNegra = new Merchandising("Chapa negra logo LCDD", chapa,(float) 5,50,5,"Es la mejor chapa del mundo.");
		chapaNegra.setHaveImage(true);
        merchRepository.save(chapaNegra);
        Merchandising lolPoster = new Merchandising("Poster LoL", poster,(float) 10,15,7,"Es la mejor poster.");
        lolPoster.setHaveImage(true);
        merchRepository.save(lolPoster);
        Merchandising figuraPoppy = new Merchandising("Figura Poppy", figura,(float) 15,5,20,"Debes comprarlo.");
        figuraPoppy.setHaveImage(true);
        merchRepository.save(figuraPoppy);
        Merchandising chapaBlanca = new Merchandising("Chapa blanca logo LCDD", chapa,(float) 800,2,50,"No te atreverías a comprarlo.");
        chapaBlanca.setHaveImage(true);
        merchRepository.save(chapaBlanca);
        Merchandising posterOnePiece = new Merchandising("Póster One Piece", poster,(float) 7,60,4,"WANTED. COMPRA.");
        posterOnePiece.setHaveImage(true);
        merchRepository.save(posterOnePiece);
        Merchandising tazaLogo = new Merchandising("Taza logo LCDD", taza,(float) 5,5,40,"Café para todos los estilos.");
        tazaLogo.setHaveImage(true);
        merchRepository.save(tazaLogo);
        Merchandising camisetaLogo = new Merchandising("Camiseta LCDD", camiseta,(float) 6,100,15,"Skin única LCDD.");
        camisetaLogo.setHaveImage(true);
        merchRepository.save(camisetaLogo);
		
		
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
