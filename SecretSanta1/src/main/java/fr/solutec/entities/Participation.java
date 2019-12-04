package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Participation {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	long id;
	@ManyToOne
	User participant;
	@ManyToOne
	SSanta evenement;
	boolean accepte;
	
	
	public Participation(User participant, SSanta evenement, boolean accepte) {
		super();
		this.participant = participant;
		this.evenement = evenement;
		this.accepte = accepte;
	}


	public Participation() {
		
	}


	public Participation(long id, User participant, SSanta evenement, boolean accepte) {
		this.id = id;
		this.participant = participant;
		this.evenement = evenement;
		this.accepte = accepte;
	}
	
	
	public boolean isAccepte() {
		return accepte;
	}


	public void setAccepte(boolean accepte) {
		this.accepte = accepte;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public User getParticipant() {
		return participant;
	}


	public void setParticipant(User participant) {
		this.participant = participant;
	}


	public SSanta getEvenement() {
		return evenement;
	}


	public void setEvenement(SSanta evenement) {
		this.evenement = evenement;
	}


	@Override
	public String toString() {
		return "Participation [id=" + id + ", participant=" + participant + ", evenement=" + evenement + ", accepte="
				+ accepte + "]";
	}


	

	

	
	
	

}
