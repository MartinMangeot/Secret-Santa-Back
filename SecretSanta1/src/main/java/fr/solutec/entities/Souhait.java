package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Souhait {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	@ManyToOne
	private User personne;
	
	public Souhait() {
	}

	public Souhait(Long id, String description, User personne) {
		super();
		this.id = id;
		this.description = description;
		this.personne = personne;
	}

	@Override
	public String toString() {
		return "Souhait [id=" + id + ", description=" + description + ", personne=" + personne + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getPersonne() {
		return personne;
	}

	public void setPersonne(User personne) {
		this.personne = personne;
	}

	public Souhait(String description, User personne) {
		super();
		this.description = description;
		this.personne = personne;
	}
	
	
	
	

}
