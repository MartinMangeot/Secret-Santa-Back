package fr.solutec.entities;

import java.util.Date;

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
	private SSanta event;
	
	private Date timeMessage;
	
	private String message;
	
	@Lob
	private byte[] image;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SSanta getEvent() {
		return event;
	}

	public void setEvent(SSanta event) {
		this.event = event;
	}

	public Date getTimeMessage() {
		return timeMessage;
	}

	public void setTimeMessage(Date timeMessage) {
		this.timeMessage = timeMessage;
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

	public Mur() {
		super();
	}

	public Mur(SSanta event, Date timeMessage, String message, byte[] image) {
		super();
		this.event = event;
		this.timeMessage = timeMessage;
		this.message = message;
		this.image = image;
	}

	public Mur(SSanta event, Date timeMessage, byte[] image) {
		super();
		this.event = event;
		this.timeMessage = timeMessage;
		this.image = image;
	}

	public Mur(SSanta event, Date timeMessage, String message) {
		super();
		this.event = event;
		this.timeMessage = timeMessage;
		this.message = message;
	}
	
	
	
}
