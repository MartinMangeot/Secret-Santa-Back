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
	
	private boolean enCours;
	private boolean tirageFait;

	
	

	public SSanta() {
		super();
	}

	
	public SSanta(String nomSSanta, User createur, boolean enCours, boolean tirageFait) {
		super();
		this.nomSSanta = nomSSanta;
		this.createur = createur;
		this.enCours = enCours;
		this.tirageFait = tirageFait;
	}


	public boolean isTirageFait() {
		return tirageFait;
	}

	public void setTirageFait(boolean tirageFait) {
		this.tirageFait = tirageFait;
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

	

	public boolean getEnCours() {
		return enCours;
	}

	public void setEnCours(boolean enCours) {
		this.enCours = enCours;
	}
	
	
	
}
