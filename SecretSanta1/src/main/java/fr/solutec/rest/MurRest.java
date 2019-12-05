package fr.solutec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.MurRepository;
import fr.solutec.entities.Mur;

@RestController
@CrossOrigin("*")
public class MurRest {
	@Autowired
	MurRepository murRepo;
	


	@RequestMapping(value = "/mur/messages/{id}", method = RequestMethod.GET)
	public List<Mur> recupMessageDuMur(@PathVariable Long id) {
		return murRepo.findByParticipationEvenementId(id);		
	}
	
	@RequestMapping(value="/uploadMur", method= RequestMethod.POST)
	public Mur uploadImageGroup(@RequestBody Mur mur ) {
		
		return murRepo.save(mur);
	}

}
