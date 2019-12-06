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
		
		User u1 = new User( "test@test.test", "test", "test","test","test",true);
		User u2 = new User( "coco@coco.co", "coco", "coco","Ras","Corentin",true);
		User u3 = new User( "jean@jean.co", "jean", "jean","Jeanjean","Jean",true);
		User u4 = new User( "Wak@and.a", "wakanda", "wakanda","Anda","Wak",true);
		User u5 = new User( "jojo@jojo.jo", "jojo", "jojo","Djodjo","Jojo",true);
		User u6 = new User( "martin@martin.ma", "martin", "martin","Man","Martin",true);
		User u7 = new User( "Michael@Michael.mi", "Michael", "Michael","Rep","Michael",true);
		User u8 = new User( "pere@noel.no", "noel", "noel","Noel","Pere",true);
		User u9 = new User( "test2@test2.test2", "test2", "test2","tes2","test2",true);
		User u10 = new User( "bob@bob.bob", "bob", "bob","bobby","bob",true);
		
		userRepo.save(u1);
		userRepo.save(u2);
		userRepo.save(u3);
		userRepo.save(u4);
		userRepo.save(u5);
		userRepo.save(u6);
		userRepo.save(u7);
		userRepo.save(u8);		
		userRepo.save(u9);
		userRepo.save(u10);	
		
		SSanta s1 = new SSanta("Noel 1", u1, true,false);
		SSanta s2 = new SSanta("Noel 2", u1, true,false);
		SSanta s3 = new SSanta("Noel 3", u2, true,false);
		SSanta s4 = new SSanta("Noel 4", u3, true,false);
		SSanta s5 = new SSanta("Noel 5", u3, true,false);
		SSanta s6 = new SSanta("Noel 6 terminé", u3, false,true);
		
		ssantaRepo.save(s1);
		ssantaRepo.save(s2);
		ssantaRepo.save(s3);
		ssantaRepo.save(s4);
		ssantaRepo.save(s5);
		ssantaRepo.save(s6);
		

		Participation p1 = new Participation(u1,s1,true, null);
		Participation p2 = new Participation(u2,s1,false, null);
		Participation p3 = new Participation(u3,s1,true, null);
		Participation p4 = new Participation(u4,s1,true, null);
		Participation p5 = new Participation(u5,s1,true, null);
		Participation p6 = new Participation(u1,s2,true, null);
		Participation p7 = new Participation(u1,s3,true, null);
		Participation p8 = new Participation(u2,s2,true, null);
		Participation p9 = new Participation(u3,s3,false, null);
		Participation p10 = new Participation(u6,s3,true, null);
		Participation p11 = new Participation(u6,s2,true, null);
		Participation p12 = new Participation(u7,s3,true, null);
		Participation p13 = new Participation(u2,s3,true, null);
		Participation p14 = new Participation(u2,s4,false, null);
		Participation p15 = new Participation(u2,s5,false, null);
		Participation p16 = new Participation(u1,s6,true, (long)2);
		Participation p17 = new Participation(u2,s6,true, (long)1);
		
		participationRepo.save(p1);
		participationRepo.save(p2);
		participationRepo.save(p3);
		participationRepo.save(p4);
		participationRepo.save(p5);
		participationRepo.save(p6);
		participationRepo.save(p7);
		participationRepo.save(p8);
		participationRepo.save(p9);
		participationRepo.save(p10);
		participationRepo.save(p11);
		participationRepo.save(p12);
		participationRepo.save(p13);
		participationRepo.save(p14);
		participationRepo.save(p15);
		participationRepo.save(p16);
		participationRepo.save(p17);
		
		
		Souhait sh1 = new Souhait("Une voiture", u1, s1,1);
		Souhait sh2 = new Souhait("Une console", u1, s1,2);
		Souhait sh3 = new Souhait("Une télé", u1, s1,3);
		Souhait sh4 = new Souhait("Un voyage", u2, s1,1);
		Souhait sh5 = new Souhait("Une voiture", u3, s1,2);
		Souhait sh6 = new Souhait("Une toupie", u3, s1,1);
		
		Souhait sh7 = new Souhait("Une voiture", u1, s2,1);
		Souhait sh8 = new Souhait("Une console", u2, s2,2);
		Souhait sh9 = new Souhait("Une télé", u2, s2,1);
		Souhait sh10 = new Souhait("Une voiture", u3, s2,1);
		Souhait sh11 = new Souhait("Une toupie", u4, s2,1);
		Souhait sh12 = new Souhait("Un voyage", u4, s2,2);
		
		Souhait sh13 = new Souhait("Une voiture", u1, s3,2);
		Souhait sh14 = new Souhait("Une voiture", u1, s3,1);
		Souhait sh15 = new Souhait("Une voiture", u1, s3,4);
		Souhait sh16 = new Souhait("Une voiture", u1, s3,6);
		Souhait sh17 = new Souhait("Une voiture", u1, s3,3);
		Souhait sh18 = new Souhait("Une voiture", u1, s3,5);
		
		Souhait sh19 = new Souhait("Une voiture", u1, s6,1);
		Souhait sh20 = new Souhait("Une console", u1, s6,2);
		Souhait sh21 = new Souhait("Une télé", u1, s6,3);
		Souhait sh22 = new Souhait("Un voyage", u2, s6,4);
		Souhait sh23 = new Souhait("Une voiture", u3, s6,5);
		Souhait sh24 = new Souhait("Une toupie", u3, s6,6);
		
		souhaitRepo.save(sh1);
		souhaitRepo.save(sh2);
		souhaitRepo.save(sh3);
		souhaitRepo.save(sh4);
		souhaitRepo.save(sh5);
		souhaitRepo.save(sh6);
		souhaitRepo.save(sh7);
		souhaitRepo.save(sh8);
		souhaitRepo.save(sh9);
		souhaitRepo.save(sh10);
		souhaitRepo.save(sh11);
		souhaitRepo.save(sh12);
		souhaitRepo.save(sh13);
		souhaitRepo.save(sh14);
		souhaitRepo.save(sh15);
		souhaitRepo.save(sh16);
		souhaitRepo.save(sh17);
		souhaitRepo.save(sh18);
		souhaitRepo.save(sh19);
		souhaitRepo.save(sh20);
		souhaitRepo.save(sh21);
		souhaitRepo.save(sh22);
		souhaitRepo.save(sh23);
		souhaitRepo.save(sh24);
		
		
		Mur mur1 = new Mur(p8,"message1 de user2");
		Mur mur2 = new Mur(p8,"message2 de user2");
		Mur mur3 = new Mur(p8,"message3 de user3");
		Mur mur4 = new Mur(p6,"message1 de user1");
		Mur mur5 = new Mur(p6,"message2 de user1");
		Mur mur6 = new Mur(p6,"message3 de user1");
		
		murRepo.save(mur1);
		murRepo.save(mur2);
		murRepo.save(mur3);
		murRepo.save(mur4);
		murRepo.save(mur5);
		murRepo.save(mur6);
		
		
	}
		
		
		

	
	

}
