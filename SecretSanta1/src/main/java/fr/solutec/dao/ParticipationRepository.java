package fr.solutec.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Participation;
import fr.solutec.entities.SSanta;
import fr.solutec.entities.User;

public interface ParticipationRepository extends CrudRepository<Participation, Long>{
	
	public List<Participation> findByParticipantId(Long id);
	
	public List<Participation> findByParticipantIdAndPresent(Long id, boolean participe);
	
	public List<Participation> findEvenementByParticipantId(Long id);
	
	public List<Participation> findParticipantByEvenementId(Long id);
	

	public Participation findByParticipantAndEvenement(User u, SSanta ev);
	
	public Participation findByParticipantIdAndEvenementId(Long idUser, Long idSanta);
	
	public Optional<Participation> findById(Long id);
	
	public void deleteById(Long id);



}
