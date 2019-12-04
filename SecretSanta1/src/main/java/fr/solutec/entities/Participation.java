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
	
	boolean participe;
	


	public Participation() {
		
	}


	public Participation(User participant, SSanta evenement) {
		super();
		this.participant = participant;
		this.evenement = evenement;
	}


	public Participation(long id, User participant, SSanta evenement, boolean accepte) {
		this.id = id;
		this.participant = participant;
		this.evenement = evenement;
	}
	
	



	

	public Participation(User participant, SSanta evenement, boolean participe) {
		super();
		this.participant = participant;
		this.evenement = evenement;
		this.participe = participe;
	}


	public boolean isParticipe() {
		return participe;
	}


	public void setParticipe(boolean participe) {
		this.participe = participe;
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
		return "Participation [id=" + id + ", participant=" + participant + ", evenement=" + evenement  + "]";
	}


	

	

	
	
	

}
