package fr.solutec.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {



public Optional<User> findByMailAndMdp(String mail, String mdp);

public Optional<User> findByMail(String mail);

public Optional<User> findById(Long id);
}
