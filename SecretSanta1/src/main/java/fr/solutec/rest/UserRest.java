package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value = "/home/invitation", method = RequestMethod.POST)
	public User invitationUser(@RequestBody User user ) {
		Optional<User> pe = userRepo.findByMail(user.getMail());
		User pf = new User();
		if (pe.isPresent()) {
			pf.setId(pe.get().getId());
			pf.setMail(pe.get().getMail());
			pf.setPseudo(pe.get().getPseudo());
			pf.setNom(pe.get().getNom());
			pf.setPrenom(pe.get().getPrenom());
			pf.setInscriptionEnd(true);
				return pf;
			}
		else {
			
			pf.setMail(pe.get().getMail());
			pf.setInscriptionEnd(false);
			userRepo.save(pf);
			return pf;	
			}						
		}
	
	
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
			pf.setNom(pe.get().getNom());
			pf.setPrenom(pe.get().getPrenom());
			pf.setInscriptionEnd(pe.get().getInscriptionEnd());
		}
		return pf;
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable Long id) {
		Optional<User> pe = userRepo.findById(id);
		User pf = new User();
		if (pe.isPresent()) {	
			pf.setId(pe.get().getId());
			pf.setMail(pe.get().getMail());
			pf.setPseudo(pe.get().getPseudo());
			pf.setNom(pe.get().getNom());
			pf.setPrenom(pe.get().getPrenom());
			pf.setInscriptionEnd(pe.get().getInscriptionEnd());
		}
		return pf;
	}
	
	
	@RequestMapping(value = "/inscription", method = RequestMethod.POST)
	public boolean inscription(@RequestBody User user) {
		Optional<User> pe = userRepo.findByMail(user.getMail());
		if(pe.isPresent()) {
			if(pe.get().getInscriptionEnd()) {
				return true;
			}
			else {
				user.setId(pe.get().getId());
				userRepo.save(user);
				return false;
			}
		} 
		else {
			user.setInscriptionEnd(true);
			userRepo.save(user);
			return false;
		}			
	}
	
	
}
