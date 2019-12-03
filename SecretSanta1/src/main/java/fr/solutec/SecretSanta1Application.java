package fr.solutec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.dao.SSantaRepository;
import fr.solutec.dao.UserRepository;
import fr.solutec.entities.SSanta;
import fr.solutec.entities.User;




@SpringBootApplication
public class SecretSanta1Application implements CommandLineRunner {
	
@Autowired
private UserRepository userRepo;
@Autowired
private SSantaRepository ssantaRepo;


	public static void main(String[] args) {
		SpringApplication.run(SecretSanta1Application.class, args);
			
		System.out.println("hello");	
		
		
	}


	@Override
	public void run(String... args) throws Exception {

		User u1 = new User( "test@test.test", "test", "test",true);
		User u2 = new User( "coco@coco.co", "coco", "coco",true);
		User u3 = new User( "jean@jean.co", "jean", "jean",true);
		User u4 = new User( "Wak@and.a", "wakanda", "wakanda",true);
		User u5 = new User( "jojo@jojo.jo", "jojo", "jojo",true);
		User u6 = new User( "martin@martin.ma", "martin", "martin",true);
		User u7 = new User( "Michael@Michael.mi", "Michael", "Michael",true);
		User u8 = new User( "pere@noel.no", "noel", "noel",true);
		User u9 = new User( "test2@test2.test2", "test2", "test2",true);
		User u10 = new User( "bob@bob.bob", "bob", "bob",true);
		
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
		
		SSanta s1 = new SSanta("Noel 1", u1, true);
		SSanta s2 = new SSanta("Noel 2", u1, true);
		SSanta s3 = new SSanta("Noel 3", u2, true);
		SSanta s4 = new SSanta("Noel 4", u3, true);
		SSanta s5 = new SSanta("Noel 4", u3, true);
		
		ssantaRepo.save(s1);
		ssantaRepo.save(s2);
		ssantaRepo.save(s3);
		ssantaRepo.save(s4);
		ssantaRepo.save(s5);
		
		
	}
	
	
	
	
	
	
	
	

}
