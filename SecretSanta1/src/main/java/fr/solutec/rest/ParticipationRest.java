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
import fr.solutec.entities.Participation;
import fr.solutec.entities.SSanta;
import fr.solutec.entities.User;

@RestController
@CrossOrigin("*")
public class ParticipationRest {
	
	@Autowired
	private ParticipationRepository participationRepo;
	
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
		
		return participationRepo.findByParticipantIdAndParticipe(id,participe);
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
		
		part.setParticipe(true);
		participationRepo.save(part);
	}
	//@RequestMapping(value = "/home/invitation", method = RequestMethod.POST)
	//public Participation creerInvitation(@PathVariable Long id) {
		
//	}


	
	
	

}
