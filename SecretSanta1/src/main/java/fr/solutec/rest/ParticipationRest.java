package fr.solutec.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.ParticipationRepository;
import fr.solutec.dao.SSantaRepository;
import fr.solutec.dao.UserRepository;
import fr.solutec.entities.Participation;
import fr.solutec.entities.SSanta;
import fr.solutec.entities.User;

@RestController
@CrossOrigin("*")
public class ParticipationRest {
	
	@Autowired
	private ParticipationRepository participationRepo;
	
	@Autowired
	private SSantaRepository sRepos;
	
	@Autowired
	private UserRepository uRespos;
	
	@RequestMapping(value = "/participations", method = RequestMethod.GET)
	public List<Participation> recupAll(Long  id) {
		return (List<Participation>) participationRepo.findAll();
	}

	
//	@RequestMapping(value = "/participation", method = RequestMethod.POST)
//	public User creerParticipation(@RequestBody User user, SSanta ssanta) {
//		return participationRepo.save(user,ssanta);
//	}
//	
	@RequestMapping(value = "/participantsanta/{id}/{participe}", method = RequestMethod.GET)
	public List<Participation> recupSantaAndParticipantByIdUserAndByParticipe(@PathVariable Long  id, @PathVariable boolean participe) {
		//Participation p = new Participation();
				
		//p = participationRepo.findByParticipantIdAndPresent(id,participe);
		
		
		return participationRepo.findByParticipantIdAndPresent(id,participe);
	}
	
	@RequestMapping(value = "/participation/{idUser}/{idSanta}", method = RequestMethod.GET)
	public Participation recupParticipationFromSantaAndUser(@PathVariable Long  idUser, @PathVariable Long idSanta) {
		return participationRepo.findByParticipantIdAndEvenementId(idUser,idSanta);
	}
	
	@RequestMapping(value = "/santa/{id}", method = RequestMethod.GET)
	public List<Participation> recupSantaByIdUser(@PathVariable Long  id) {
		
		for (Participation iterable_element : participationRepo.findEvenementByParticipantId(id)) {
			System.out.println(iterable_element);
		}
		return participationRepo.findEvenementByParticipantId(id);
	}
	
	@RequestMapping(value = "/santa/participants/{id}", method = RequestMethod.GET)
	public List<Participation> recupParticipants(@PathVariable Long id) {
		return participationRepo.findParticipantByEvenementId(id);
	}
	

	
	@RequestMapping(value = "/validParticipation", method = RequestMethod.PUT)
	public void confirmerParticipationByUser(@RequestBody Participation part) {
		//Participation p =new Participation();
		//p= participationRepo.findByParticipantAndEvenement(part.getParticipant(), part.getEvenement());  
		
		part.setPresent(true);
		participationRepo.save(part);
	}
	
	
	
	//@RequestMapping(value = "/home/invitation", method = RequestMethod.POST)
	//public Participation creerInvitation(@PathVariable Long id) {

	@RequestMapping(value = "/home/invitation/inv", method = RequestMethod.POST)
	public Participation creerInvitation(@PathVariable User user, @PathVariable SSanta evenement) {
		Participation p = new Participation();
		p.setEvenement(evenement);
		p.setParticipant(user);
		p.setPresent(false);
		participationRepo.save(p);
		
		return p;
		

	}
	
	@RequestMapping(value = "/participation/invitation/{id}", method = RequestMethod.POST)
	public Participation invitation(@RequestBody User u, @PathVariable Long id) {
		Optional<SSanta> sRecup = sRepos.findById(id);
		SSanta s = sRecup.get();
		
		User user = null;
		Optional<User> userR = uRespos.findByMail(u.getMail());
		
		if(userR.isPresent()) {
			 user = userR.get();
		}
		else {
			u.setInscriptionEnd(false);
			user = uRespos.save(u);
		}
		
		Participation p = new Participation(user, s, false);
		
		return participationRepo.save(p);
	}

	@RequestMapping(value = "/participation/valider", method = RequestMethod.POST)
	public Participation modifbooleanValidation(@RequestBody Participation p) {
		//Optional<Participation> pRecup = participationRepo.findById(p.getId());
		Participation parti = new Participation();
		parti=p;
		parti.setPresent(true);
		participationRepo.save(parti);
		
		return parti;
		

	}
	
	
	

}
