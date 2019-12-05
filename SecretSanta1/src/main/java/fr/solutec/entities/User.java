package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mail;
	private String mdp;
	private String pseudo;
	private String nom;
	private String prenom;
	private Boolean inscriptionEnd;
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", mail=" + mail + ", pseudo=" + pseudo + ", nom=" + nom
				+ ", prenom=" + prenom + ", inscriptionEnd=" + inscriptionEnd + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public Boolean getInscriptionEnd() {
		return inscriptionEnd;
	}

	public void setInscriptionEnd(Boolean inscriptionEnd) {
		this.inscriptionEnd = inscriptionEnd;
	}

	public User() {
		super();
	}

	public User(String mail, String mdp, String pseudo, String nom, String prenom, Boolean inscriptionEnd) {
		super();
		this.mail = mail;
		this.mdp = mdp;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.inscriptionEnd = inscriptionEnd;
	}

	
	
	

}
