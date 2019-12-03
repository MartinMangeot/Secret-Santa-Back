package fr.solutec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.ParticipationRepository;
import fr.solutec.entities.SSanta;
import fr.solutec.entities.User;

@RestController
@CrossOrigin("*")
public class ParticipationRest {
	
	@Autowired
	private ParticipationRepository participationRepo;
	
//	@RequestMapping(value = "/participation", method = RequestMethod.POST)
//	public User creerParticipation(@RequestBody User user, SSanta ssanta) {
//		return participationRepo.save(user,ssanta);
//	}
//	
//	@RequestMapping(value = "/participations", method = RequestMethod.POST)
//	public List<SSanta> creerParticipation(@RequestBody User user, SSanta ssanta) {
//		return participationRepo.getByUser(user,ssanta);
//	}

}
