package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Participation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private User participant;
	@ManyToOne
	private SSanta evenement;

	private boolean present;
	
	private Long idCadeau;
	

	public Long getIdCadeau() {
		return idCadeau;
	}

	public void setIdCadeau(Long idCadeau) {
		this.idCadeau = idCadeau;
	}

	public Participation() {

	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
		return "Participation [id=" + id + ", participant=" + participant + ", evenement=" + evenement + ", present="
				+ present + ", idCadeau=" + idCadeau + "]";
	}

	public Participation(User participant, SSanta evenement, boolean present, Long idCadeau) {
		super();
		this.participant = participant;
		this.evenement = evenement;
		this.present = present;
		this.idCadeau = idCadeau;
	}
	

}
