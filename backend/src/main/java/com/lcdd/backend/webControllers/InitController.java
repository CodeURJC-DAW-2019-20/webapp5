package com.lcdd.backend.webControllers;

import java.util.Calendar;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.lcdd.backend.pojo.Event;
import com.lcdd.backend.pojo.EventRegister;
import com.lcdd.backend.pojo.Game;
import com.lcdd.backend.pojo.MerchType;
import com.lcdd.backend.pojo.Merchandising;
import com.lcdd.backend.pojo.Purchase;
import com.lcdd.backend.pojo.Role;
import com.lcdd.backend.pojo.User;
import com.lcdd.backend.services.UserService;
import com.lcdd.backend.services.EventService;
import com.lcdd.backend.services.GameService;
import com.lcdd.backend.services.MerchTypeService;
import com.lcdd.backend.services.MerchandisingService;
import com.lcdd.backend.services.PurchaseService;
import com.lcdd.backend.services.RoleService;
import com.lcdd.backend.services.UserRegisterEventService;

@Controller
public class InitController {
	@Autowired
	private GameService gameService;
	
	@Autowired
	private MerchTypeService merchTypeService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private MerchandisingService merchService;
	
	@Autowired
	private PurchaseService purchaseService;
	
	@Autowired
	private UserRegisterEventService eventRegService;
	
	@PostConstruct
	public void init() {
		
		//Game
		Game lol = new Game("League of Legends", "LoL");
		Game magic = new Game("Magic: The Gathering Arena", "MTG Arena");
		Game tft = new Game("Teamfight Tactics", "TFT");
		Game lor = new Game("Legends of Runaterra", "LoR");
		Game hs = new Game("HeartStone", "HS");
		gameService.save(lol);
		gameService.save(magic);
		gameService.save(tft);
		gameService.save(lor);
		gameService.save(hs);
		
		//Role
		Role presi= new Role("President");
		Role vice= new Role("Vice-president");
		Role vocal = new Role("Vocal");
		Role secretary = new Role("Secretary");
		Role treasurer = new Role("Treasurer");
		roleService.save(presi);
		roleService.save(vice);
		roleService.save(vocal);
		roleService.save(secretary);
		roleService.save(treasurer);
		
		//MerchType
		MerchType chapa = new MerchType("Chapas");
		MerchType poster = new MerchType("Posters");
		MerchType camiseta = new MerchType("Camisetas");
		MerchType figura = new MerchType("Figuras");
		MerchType taza = new MerchType("Tazas");
		MerchType others = new MerchType("Otros");
		merchTypeService.save(chapa);
		merchTypeService.save(poster);
		merchTypeService.save(camiseta);
		merchTypeService.save(figura);
		merchTypeService.save(taza);
		merchTypeService.save(others);
		
		//Event
		Event eventLol = new Event("Evento de lol 1",lol,"URJC Móstoles, S10 Lab 2","03-03-2019", "15:00","Es un torneo de LoL presencial",true,"Un abrazo",5,(long)10,20);
		eventLol.setHaveImage(true);
		eventService.save(eventLol);
        Event eventMagic = new Event("Evento de magic",magic,"URJC Móstoles, S10 Lab 2","03-03-2019", "15:00","Es un meeting de magic no presencial",false,"",8,(long)1,1);
        eventMagic.setHaveImage(true);
        eventService.save(eventMagic);
        Event eventLol2 = new Event("Evento de lol 2",lol,"URJC Móstoles, S10 Lab 2","03-03-2019", "15:00","Es un torneo de LoL presencial",false,"",2,(long)4,2);
        eventLol2.setHaveImage(true);
        eventService.save(eventLol2);
        Event eventTft = new Event("Evento de Teamfight Tactics",tft,"URJC Móstoles, S10 Lab 2","03-03-2019", "15:00","Es un torneo de Teamfight Tactics presencial",true,"Un aplauso",1,(long)1,1);
        eventTft.setHaveImage(true);
        eventService.save(eventTft);
        Event eventHs = new Event("Evento de HeartStone",hs,"URJC Móstoles, S10 Lab 2","03-03-2019", "15:00","Es un torneo de HeartStone presencial",true,"Las gracias",5,(long)5,2);
        eventHs.setHaveImage(true);
        eventService.save(eventHs);
		
		//User
		User carlos = new User("email", "cPabe", "carlos", "pabe", "pass" , secretary, "ROLE_USER");
		User dani = new User("email", "daniel", "dani", "moreno","pass", treasurer, "ROLE_USER", "ROLE_ADMIN");
		User oscar = new User("email", "oscar", "osk", "rivas","pass", vocal, "ROLE_USER");
		User alfonso = new User("email", "alfonso", "angra", "lopz","pass", presi, "ROLE_USER", "ROLE_ADMIN");
		User grani = new User("email", "miguel", "byGranizo", "jimenez","pass", vocal, "ROLE_USER");
		userService.save(carlos);
		userService.save(dani);
		userService.save(oscar);
		userService.save(alfonso);
		userService.save(grani);
		
		//Merchandising
		Merchandising chapaNegra = new Merchandising("Chapa negra logo LCDD", chapa,(float) 5,50,5,"Es la mejor chapa del mundo.");
		chapaNegra.setHaveImage(true);
		merchService.save(chapaNegra);
        Merchandising lolPoster = new Merchandising("Poster LoL", poster,(float) 10,15,7,"Es la mejor poster.");
        lolPoster.setHaveImage(true);
        merchService.save(lolPoster);
        Merchandising figuraPoppy = new Merchandising("Figura Poppy", figura,(float) 15,5,20,"Debes comprarlo.");
        figuraPoppy.setHaveImage(true);
        merchService.save(figuraPoppy);
        Merchandising chapaBlanca = new Merchandising("Chapa blanca logo LCDD", chapa,(float) 800,2,50,"No te atreverías a comprarlo.");
        chapaBlanca.setHaveImage(true);
        merchService.save(chapaBlanca);
        Merchandising posterOnePiece = new Merchandising("Póster One Piece", poster,(float) 7,60,4,"WANTED. COMPRA.");
        posterOnePiece.setHaveImage(true);
        merchService.save(posterOnePiece);
        Merchandising tazaLogo = new Merchandising("Taza logo LCDD", taza,(float) 5,5,40,"Café para todos los estilos.");
        tazaLogo.setHaveImage(true);
        merchService.save(tazaLogo);
        Merchandising camisetaLogo = new Merchandising("Camiseta LCDD", camiseta,(float) 6,100,15,"Skin única LCDD.");
        camisetaLogo.setHaveImage(true);
        merchService.save(camisetaLogo);
		
		//Purchases
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -11);
		purchaseService.save(new Purchase(carlos, calendar.getTime(),chapaNegra));
		calendar.add(Calendar.MONTH, +5);
		purchaseService.save(new Purchase(dani, calendar.getTime(),posterOnePiece));
		calendar.add(Calendar.MONTH, +8);
		purchaseService.save(new Purchase(carlos, calendar.getTime(),figuraPoppy));
		calendar.add(Calendar.MONTH, +1);
		purchaseService.save(new Purchase(oscar, calendar.getTime(),chapaNegra));
		calendar.add(Calendar.MONTH, -16);
		purchaseService.save(new Purchase(alfonso, calendar.getTime(),chapaNegra));
		calendar.add(Calendar.MONTH, +14);
		purchaseService.save(new Purchase(alfonso, calendar.getTime(),posterOnePiece));
		calendar.add(Calendar.MONTH, +9);
		purchaseService.save(new Purchase(carlos, calendar.getTime(),figuraPoppy));
		calendar.add(Calendar.MONTH, +3);
		purchaseService.save(new Purchase(grani, calendar.getTime(),chapaNegra));
		
		//EventRegister
		EventRegister reg1 = new EventRegister(carlos,eventHs,"TeamPabe",2);
		eventRegService.save(reg1);
		EventRegister reg2 = new EventRegister(carlos,eventLol,"TeamPabe",5);
		eventRegService.save(reg2);
		EventRegister reg3 = new EventRegister(carlos,eventTft,"TeamPabe",1);
		eventRegService.save(reg3);
		EventRegister reg4 = new EventRegister(dani,eventMagic,"TeamDani",2);
		eventRegService.save(reg4);
		EventRegister reg5 = new EventRegister(dani,eventLol2,"TeamDani",5);
		eventRegService.save(reg5);
		EventRegister reg6 = new EventRegister(oscar,eventTft,"TeamLlury",1);
		eventRegService.save(reg6);
		EventRegister reg7 = new EventRegister(alfonso,eventLol,"TeamAngra",2);
		eventRegService.save(reg7);
		EventRegister reg8 = new EventRegister(alfonso,eventLol2,"TeamAngra",5);
		eventRegService.save(reg8);
		EventRegister reg9 = new EventRegister(grani,eventTft,"TeamGranizo",1);
		eventRegService.save(reg9);
	}
}
