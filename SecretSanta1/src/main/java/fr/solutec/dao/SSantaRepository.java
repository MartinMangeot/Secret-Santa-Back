package fr.solutec.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.SSanta;
import fr.solutec.entities.User;

public interface SSantaRepository extends CrudRepository<SSanta, Long>{
	
	public Optional<SSanta> findByCreateur(User createur);
	
	public User findCreateurById(Long id );
}
