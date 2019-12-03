package fr.solutec.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Participation;

public interface ParticipationRepository extends CrudRepository<Participation, Long>{
	
	public List<Participation> findByParticipantId(Long id);
	
	public List<Participation> findEvenementByParticipantId(Long id);
	
	public List<Participation> findParticipantByEvenementId(Long id);

}
