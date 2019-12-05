package fr.solutec.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Mur;

public interface MurRepository extends CrudRepository<Mur, Long> {
	
	public Optional<Mur> findByid(Long id);
	
	public List<Mur> findByParticipationEvenementId(Long id);
	
	

}
