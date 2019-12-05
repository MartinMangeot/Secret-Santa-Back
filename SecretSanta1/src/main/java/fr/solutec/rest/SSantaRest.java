package fr.solutec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.ParticipationRepository;
import fr.solutec.dao.SSantaRepository;
import fr.solutec.entities.Participation;
import fr.solutec.entities.SSanta;

@RestController
@CrossOrigin("*")
public class SSantaRest {
	@Autowired
	private SSantaRepository ssantaRepo;
	
	@Autowired
	private ParticipationRepository partiRepos;
	
	@RequestMapping(value = "/ssantas", method = RequestMethod.GET)
	public List<SSanta> getAll(){
		return (List<SSanta>) ssantaRepo.findAll();
	}
	
	
	@RequestMapping(value = "/createSSanta", method = RequestMethod.POST)
	public SSanta inscriptionSSanta(@RequestBody SSanta SSanta) {
		Participation p = new Participation();
		SSanta s = ssantaRepo.save(SSanta);
		p.setEvenement(s);
		p.setParticipant(s.getCreateur());
		p.setPresent(true);
		partiRepos.save(p);
		return s;
	}
	
	
	
}
