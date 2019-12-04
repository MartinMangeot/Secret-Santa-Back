package fr.solutec.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Souhait;

public interface SouhaitRepository extends CrudRepository<Souhait, Long>{
	
	public List<Souhait> findAllByPersonneId(Long id);
	
	@Query(value="SELECT s FROM Souhait s where s.personne.id = ?1 and s.santa.id = ?2 order by s.ordre")
	public List<Souhait> findAllByPersonneIdAndBySantaId(Long idUser, Long idSanta);

}
