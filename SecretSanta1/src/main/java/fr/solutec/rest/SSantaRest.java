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
import fr.solutec.entities.Participation;
import fr.solutec.entities.SSanta;
import fr.solutec.entities.User;

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
	
	@RequestMapping(value = "/santaCreateur/{id}", method = RequestMethod.GET)
	public User getCreateurDuSanta(@PathVariable Long id){
		return  ssantaRepo.findCreateurById(id);
	}
	
	@RequestMapping(value = "/ssanta/{id}", method = RequestMethod.GET)
	public Optional<SSanta> recupSanta(@PathVariable Long id){
		return ssantaRepo.findById(id);
	}
	
	@RequestMapping(value = "/ssanta", method = RequestMethod.POST)
	public SSanta saveSanta(@RequestBody SSanta s){
		return ssantaRepo.save(s);
	}

//	@RequestMapping(value = "/ssanta/historique/{idUser}", method = RequestMethod.POST)
//	public SSanta recupSantaHistorique(@PathVariable Long id){
//		return ssantaRepo.findAllBy(s);
//	}
	
	
	
	
	
}
