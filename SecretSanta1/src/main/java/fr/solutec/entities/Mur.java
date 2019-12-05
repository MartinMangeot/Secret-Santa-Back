package fr.solutec.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Mur {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Participation participation;
	
	
	private String message;
	
	@Lob
	private byte[] image;

	
	
	public Mur() {
		super();
	}

	public Mur(Participation participation, String message) {
		super();
		this.participation = participation;
		this.message = message;
	}

	public Mur(Participation participation, byte[] image) {
		super();
		this.participation = participation;
		this.image = image;
	}

	public Mur(Participation participation, String message, byte[] image) {
		super();
		this.participation = participation;
		this.message = message;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Participation getParticipation() {
		return participation;
	}

	public void setParticipation(Participation participation) {
		this.participation = participation;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	
	
	
	
	
	
}
