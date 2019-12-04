package fr.solutec.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Participation;
import fr.solutec.entities.User;

public interface ParticipationRepository extends CrudRepository<Participation, Long>{
	
	public List<Participation> findByParticipantId(Long id);
	
	public List<Participation> findByParticipantIdAndParticipe(Long id, boolean participe);
	
	public List<Participation> findEvenementByParticipantId(Long id);
	
	public List<Participation> findParticipantByEvenementId(Long id);
	
	//public Participation findByUser(User user);

}
