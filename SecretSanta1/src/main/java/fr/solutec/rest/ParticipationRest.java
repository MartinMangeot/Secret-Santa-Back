package fr.solutec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.ParticipationRepository;
import fr.solutec.entities.Participation;

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
	@RequestMapping(value = "/participantsanta/{id}", method = RequestMethod.GET)
	public List<Participation> recupSantaAndParticipantByIdUser(@PathVariable Long  id) {
		return participationRepo.findByParticipantId(id);
	}
	
	@RequestMapping(value = "/santa/{id}", method = RequestMethod.GET)
	public List<Participation> recupSantaByIdUser(@PathVariable Long  id) {
		
		for (Participation iterable_element : participationRepo.findEvenementByParticipantId(id)) {
			System.out.println(iterable_element);
		}
		return participationRepo.findEvenementByParticipantId(id);
	}
	
	

}
