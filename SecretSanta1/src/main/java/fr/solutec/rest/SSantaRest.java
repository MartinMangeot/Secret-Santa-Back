package fr.solutec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.SSantaRepository;
import fr.solutec.entities.SSanta;

@RestController
@CrossOrigin("*")
public class SSantaRest {
	@Autowired
	private SSantaRepository ssantaRepo;
	
	
	@RequestMapping(value = "/createSSanta", method = RequestMethod.POST)
	public SSanta inscriptionSSanta(@RequestBody SSanta SSanta) {
		return ssantaRepo.save(SSanta);
	}
	
}
