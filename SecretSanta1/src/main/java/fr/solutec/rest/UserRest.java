package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.UserRepository;
import fr.solutec.entities.User;

@RestController
@CrossOrigin("*")
public class UserRest {
	
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public boolean inscriptionUser(@RequestBody User user) {
		Optional<User> pe = userRepo.findByMail(user.getMail());
		User pf = new User();
		if (pe.isPresent()) {
			pf.setInscriptionEnd(pe.get().getInscriptionEnd());
			if(pf.getInscriptionEnd()==false) {
				user.setId(pf.getId());
				userRepo.save(user);
				
				return false;
			}else {
				return true;	
			}						
		}
		else {
			user.setInscriptionEnd(true);
			userRepo.save(user);
			return false;
		}
			
	}
	
	@RequestMapping(value = "/connexion", method = RequestMethod.POST)
	public User connexion(@RequestBody User p) {
		Optional<User> pe = userRepo.findByMailAndMdp(p.getMail(), p.getMdp());
		User pf = new User();
		if (pe.isPresent()) {	
			pf.setId(pe.get().getId());
			pf.setMail(pe.get().getMail());
			pf.setPseudo(pe.get().getPseudo());
		}
		return pf;
	}
	
	
	
}
