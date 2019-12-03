package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SSanta {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomSSanta;
	
	@ManyToOne
	private User createur;
	
	private Boolean enCours;

	
	

	public SSanta() {
		super();
	}

	public SSanta(Long id, String nomSSanta, User createur, Boolean enCours) {
		super();
		this.id = id;
		this.nomSSanta = nomSSanta;
		this.createur = createur;
		this.enCours = enCours;
	}

	public SSanta(String nomSSanta, User createur, Boolean enCours) {
		super();
		this.nomSSanta = nomSSanta;
		this.createur = createur;
		this.enCours = enCours;
	}

	public String getNomSSanta() {
		return nomSSanta;
	}

	public void setNomSSanta(String nomSSanta) {
		this.nomSSanta = nomSSanta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getCreateur() {
		return createur;
	}

	public void setCreateur(User createur) {
		this.createur = createur;
	}

	

	public Boolean getEnCours() {
		return enCours;
	}

	public void setEnCours(Boolean enCours) {
		this.enCours = enCours;
	}
	
	
	
}
