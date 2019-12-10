package fr.solutec.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Participation;
import fr.solutec.entities.SSanta;
import fr.solutec.entities.User;

public interface ParticipationRepository extends CrudRepository<Participation, Long>{
	
	public List<Participation> findByParticipantId(Long id);
	
	public List<Participation> findByParticipantIdAndPresentAndEvenementEnCours(Long id, boolean participe,boolean enCours);
	
	public List<Participation> findEvenementByParticipantId(Long id);
	
	//@Query(value="SELECT participations FROM p where p.evenement.id = ?1 and p.present = ?2")
	public List<Participation> findParticipantByEvenementIdAndPresent(Long id, boolean present);
	
	public List<Participation> findParticipantByEvenementId(Long id);
	
	public Participation findByEvenementId(Long id);
	

	

	public Participation findByParticipantAndEvenement(User u, SSanta ev);
	
	public Participation findByParticipantIdAndEvenementId(Long idUser, Long idSanta);
	
	public Participation findByParticipantMailAndEvenementId(String mailUser, Long idSanta);
	
	public Optional<Participation> findById(Long id);
	
	public void deleteById(Long id);
	
//	@Query(value="SELECT participations FROM p where s.personne.id = ?1 and s.santa.id = ?2 and s.ordre = ?3")
//	public List<Participation> findHistorique(List<Participation> p);
	



}
