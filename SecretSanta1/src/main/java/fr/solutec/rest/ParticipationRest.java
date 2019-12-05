package fr.solutec.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;

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
	private static final Random random = new Random();
	
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
		
		return participationRepo.findByParticipantIdAndPresent(id,participe);
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
		
		Participation p = new Participation(user, s, false, null);
		
		return participationRepo.save(p);
	}


	@RequestMapping(value = "/santa/tirage/{id}", method = RequestMethod.GET)
	public List<Participation> tirage(@PathVariable Long id) {
		List<Participation> l = participationRepo.findParticipantByEvenementId(id);
		ArrayList<Long> a = new ArrayList<Long>();
		int x = l.size();
		Participation p = new Participation();
		Collections.shuffle(l, new Random());
		for (int i = 0; i < x; i++) {
			
			p=l.get(i);
			
			a.add(p.getId());
		}
		Collections.shuffle(a, new Random(1));
		for (int i = 0; i < x; i++) {
			
			p=l.get(i);
			
			p.setIdCadeau(a.get(i));
			participationRepo.save(p);
			
			//l.set(i, p);
		}	
		System.out.println(l.toString());
		return l;
	}
	
	

}
