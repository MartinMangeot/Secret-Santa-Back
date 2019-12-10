package fr.solutec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.dao.MurRepository;
import fr.solutec.dao.ParticipationRepository;
import fr.solutec.dao.SSantaRepository;
import fr.solutec.dao.SouhaitRepository;
import fr.solutec.dao.UserRepository;
import fr.solutec.entities.Mur;
import fr.solutec.entities.Participation;
import fr.solutec.entities.SSanta;
import fr.solutec.entities.Souhait;
import fr.solutec.entities.User;




@SpringBootApplication
public class SecretSanta1Application implements CommandLineRunner {
	
@Autowired
private UserRepository userRepo;
@Autowired
private SSantaRepository ssantaRepo;
@Autowired
private ParticipationRepository participationRepo;
@Autowired
private SouhaitRepository souhaitRepo;

@Autowired
private MurRepository murRepo;

	public static void main(String[] args) {
		SpringApplication.run(SecretSanta1Application.class, args);
			
		System.out.println("******************************************** lancement terminé avec success ********************************************");	
		
		
	}


	@Override
	public void run(String... args) throws Exception {
		System.out.println("******************************************** debut instruction run ********************************************");
		
		User u1 = new User( "michaelreptin@gmail.com", "mika", "mika","Reptin","Michaël",true);
		User u2 = new User( "martin.mangeot.6@gmail.com", "martin", "martinobrie","Mangeot","Martin",true);
		User u3 = new User( "corentin.rasle@gmail.com", "coco", "Coco","Rasle","Corentin",true);
		User u4 = new User( "francis.cabrel@gmail.com", "francis", "Francky Cabrel","Cabrel","Francis",true);
		User u5 = new User( "jojo@gmail.com", "jojo", "jojo","Banka","Joël",true);
		User u6 = new User( "emmanuel.macron@gmail.com", "emmanuel", "Manu","Macron","Emmanuel",true);
		
		userRepo.save(u1);
		userRepo.save(u2);
		userRepo.save(u3);
		userRepo.save(u4);
		userRepo.save(u5);
		userRepo.save(u6);
		
		SSanta s1 = new SSanta("Noël des dev17 !", u1, true,false);
		SSanta s2 = new SSanta("Famous Christmas", u4, true,false);
		
		ssantaRepo.save(s1);
		ssantaRepo.save(s2);
		

		Participation p1 = new Participation(u1,s1,true, null);
		Participation p2 = new Participation(u2,s1,true, null);
		Participation p3 = new Participation(u3,s1,true, null);
		Participation p4 = new Participation(u5,s1,true, null);
		
		Participation p5 = new Participation(u1,s2,true, null);
		Participation p6 = new Participation(u4,s2,true, null);
		Participation p7 = new Participation(u6,s2,true, null);
		
		participationRepo.save(p1);
		participationRepo.save(p2);
		participationRepo.save(p3);
		participationRepo.save(p4);
		participationRepo.save(p5);
		participationRepo.save(p6);
		participationRepo.save(p7);
		
		
		Souhait sh1 = new Souhait("Une voiture", u1, s1,1);
		Souhait sh2 = new Souhait("Une console", u1, s1,2);
		Souhait sh4 = new Souhait("Une télé", u2, s1,1);
		Souhait sh5 = new Souhait("Une toupie", u3, s1,1);
		Souhait sh3 = new Souhait("un pull de Noël", u5, s1,1);
		
		Souhait sh7 = new Souhait("Une tortue", u1, s2,1);
		Souhait sh8 = new Souhait("Une poupée", u4, s2,1);
		Souhait sh9 = new Souhait("Un téléphone", u6, s2,1);
	
		
		souhaitRepo.save(sh1);
		souhaitRepo.save(sh2);
		souhaitRepo.save(sh3);
		souhaitRepo.save(sh4);
		souhaitRepo.save(sh5);
		souhaitRepo.save(sh7);
		souhaitRepo.save(sh8);
		souhaitRepo.save(sh9);
		
		
		Mur mur1 = new Mur(p1,"Salut bienvenue à tous !");
		Mur mur3 = new Mur(p4,"Hâte de recevoir ma voiture");
		
		murRepo.save(mur1);
		murRepo.save(mur3);
		
		
	}
		
		
		

	
	

}
