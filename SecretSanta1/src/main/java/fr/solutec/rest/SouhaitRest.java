package fr.solutec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.SouhaitRepository;
import fr.solutec.entities.Souhait;

@RestController
@CrossOrigin("*")
public class SouhaitRest {
	@Autowired
	private SouhaitRepository souhaitRepo;
	
	@RequestMapping(value = "/souhaits", method = RequestMethod.GET)
	public List<Souhait> getAll(){
		return (List<Souhait>) souhaitRepo.findAll();
	}
	
	@RequestMapping(value = "/user/santa/souhaits/{idUser}/{idEvent}", method = RequestMethod.GET)
	public List<Souhait> getAllByUserID(@PathVariable Long idUser, @PathVariable Long idEvent){
		return (List<Souhait>) souhaitRepo.findAllByPersonneIdAndBySantaId(idUser,idEvent);
	}
	
	@RequestMapping(value = "/souhait", method = RequestMethod.POST)
	public Souhait save(@RequestBody Souhait s){
		return souhaitRepo.save(s);
	}
	
	@RequestMapping(value = "/souhait/{id}", method = RequestMethod.DELETE)
	public boolean delete(@PathVariable Long id){
		souhaitRepo.deleteById(id);
		return true;
	}
	
	@RequestMapping(value = "/souhait/{idUser}/{idSanta}/{ordre}", method = RequestMethod.GET)
	public Souhait recupSouhaitByIdUserAndIdSantaAndOrdre(@PathVariable Long idUser, @PathVariable Long idSanta, @PathVariable int ordre){
		return souhaitRepo.findByIdUserAndIdSantaAndOrdre(idUser,idSanta,ordre);
	}
	

}
