package fr.solutec.entities;

public class User {
	private Long id;
	private String mail;
	private String mdp;
	private String pseudo;
	private Boolean inscriptionEnd;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", mail=" + mail + ", mdp=" + mdp + ", pseudo=" + pseudo + ", inscriptionEnd="
				+ inscriptionEnd + "]";
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

	public User(String mail, String mdp, String pseudo, Boolean inscriptionEnd) {
		super();
		this.mail = mail;
		this.mdp = mdp;
		this.pseudo = pseudo;
		this.inscriptionEnd = inscriptionEnd;
	}
	
	

}
