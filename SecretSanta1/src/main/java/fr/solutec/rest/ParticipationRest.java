package fr.solutec.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.dao.ParticipationRepository;
import fr.solutec.dao.SSantaRepository;
import fr.solutec.dao.UserRepository;
import fr.solutec.entities.Participation;
import fr.solutec.entities.SSanta;
import fr.solutec.entities.User;

@RestController
@CrossOrigin("*")
public class ParticipationRest {
	private static final Random random = new Random();
	
	@Autowired
	private ParticipationRepository participationRepo;
	
	@Autowired
	private SSantaRepository sRepos;
	
	@Autowired
	private UserRepository uRespos;
	
	@RequestMapping(value = "/participations", method = RequestMethod.GET)
	public List<Participation> recupAll(Long  id) {
		return (List<Participation>) participationRepo.findAll();
	}

	
//	@RequestMapping(value = "/participation", method = RequestMethod.POST)
//	public User creerParticipation(@RequestBody User user, SSanta ssanta) {
//		return participationRepo.save(user,ssanta);
//	}
//	
	@RequestMapping(value = "/participantsanta/{id}/{participe}/{enCours}", method = RequestMethod.GET)
	public List<Participation> recupSantaAndParticipantByIdUserAndByParticipe(@PathVariable Long  id, @PathVariable boolean participe, @PathVariable boolean enCours) {
		List<Participation> p = new ArrayList<Participation>();
		p=participationRepo.findByParticipantIdAndPresentAndEvenementEnCours(id,participe,enCours);
		if (p.size()<=0) {
			return null;
		}
		else {
			return p;
		}
		
		
	}
	
	@RequestMapping(value = "/participation/{idUser}/{idSanta}", method = RequestMethod.GET)
	public Participation recupParticipationFromSantaAndUser(@PathVariable Long  idUser, @PathVariable Long idSanta) {
		return participationRepo.findByParticipantIdAndEvenementId(idUser,idSanta);
	}
	
	@RequestMapping(value = "/santa/{id}", method = RequestMethod.GET)
	public List<Participation> recupSantaByIdUser(@PathVariable Long  id) {
		return participationRepo.findEvenementByParticipantId(id);
	}
	
	@RequestMapping(value = "/santa/participants/{id}", method = RequestMethod.GET)
	public List<Participation> recupParticipants(@PathVariable Long id) {
		return participationRepo.findParticipantByEvenementId(id);
	}
	

	
	@RequestMapping(value = "/validParticipation", method = RequestMethod.PUT)
	public void confirmerParticipationByUser(@RequestBody Participation part) {
		//Participation p =new Participation();
		//p= participationRepo.findByParticipantAndEvenement(part.getParticipant(), part.getEvenement());  
		
		part.setPresent(true);
		participationRepo.save(part);
	}
	
	
	
	//@RequestMapping(value = "/home/invitation", method = RequestMethod.POST)
	//public Participation creerInvitation(@PathVariable Long id) {

	@RequestMapping(value = "/home/invitation/inv", method = RequestMethod.POST)
	public Participation creerInvitation(@PathVariable User user, @PathVariable SSanta evenement) {
		Participation p = new Participation();
		p.setEvenement(evenement);
		p.setParticipant(user);
		p.setPresent(false);
		participationRepo.save(p);
		
		return p;
		

	}
	
	@RequestMapping(value = "/participation/invitation/{id}", method = RequestMethod.POST)
	public Participation invitation(@RequestBody User u, @PathVariable Long id) {
		Optional<SSanta> sRecup = sRepos.findById(id);
		SSanta s = sRecup.get();
		
		User user = null;
		Optional<User> userR = uRespos.findByMail(u.getMail());
		
		if(userR.isPresent()) {
			 user = userR.get();
		}
		else {
			u.setInscriptionEnd(false);
			user = uRespos.save(u);
		}
		sendMail(u.getMail());
		
		
		Participation p = new Participation(user, s, false, null);
		
		return participationRepo.save(p);
	}

	
	private void sendMail(String mail) {
		Properties props = new Properties();
		final String expediteur = "secret.santa.dev17@gmail.com";
		final String password = "dev17test!";
		final String objet = "Bienvenue sur Secret Santa !";
		final String contenu = "Bonjour, vous avez été invité à participer à un événement secret santa !! Pour rejoindre vos amis et faire de nombreux heureux, connectez ou inscrivez vous sur http://localhost:4200/ !!";
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(expediteur,password);
			}
		});
		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(expediteur));
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(mail));
			message.setSubject(objet);
			message.setText(contenu);

			Transport.send(message);

			System.out.println("Mail envoyé");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	@RequestMapping(value = "/participation/valider", method = RequestMethod.POST)
	public Participation modifbooleanValidation(@RequestBody Participation p) {
		//Optional<Participation> pRecup = participationRepo.findById(p.getId());
		Participation parti = new Participation();
		parti=p;
		parti.setPresent(true);
		participationRepo.save(parti);
		
		return parti;
		
}
	@RequestMapping(value = "/santa/tirage/{id}", method = RequestMethod.GET)
	public List<Participation> tirage(@PathVariable Long id) {
		List<Participation> l = participationRepo.findParticipantByEvenementId(id);
		ArrayList<Long> a = new ArrayList<Long>();
		int x = l.size();
		Participation p = new Participation();
		Collections.shuffle(l, new Random());
		for (int i = 0; i < x; i++) {
			
			p=l.get(i);
			
			a.add(p.getParticipant().getId());
		}
		Collections.shuffle(a, new Random(1));
		for (int i = 0; i < x; i++) {
			
			p=l.get(i);
			
			p.setIdCadeau(a.get(i));
			participationRepo.save(p);
		}	
		System.out.println(l.toString());
		return l;
	}
	
	@RequestMapping(value = "/santa/cible/{iduser}/{idsanta}", method = RequestMethod.GET)
	public Optional<Participation> afficherCible(@PathVariable Long iduser,@PathVariable Long idsanta) {
		
		Participation parti = participationRepo.findByParticipantIdAndEvenementId(iduser, idsanta);
		Optional<Participation> parti2 = participationRepo.findById(parti.getIdCadeau());
		
		return parti2;
	}
		
	@RequestMapping(value = "/SupprimerParticipation/{iduser}/{idsanta}", method = RequestMethod.DELETE)
	public void SupprimerParticipantSanta(@PathVariable Long iduser, @PathVariable Long idsanta) {
			
			Participation parti = participationRepo.findByParticipantIdAndEvenementId(iduser, idsanta);
			participationRepo.deleteById(parti.getId());
	}
	
	
	
	
//	@RequestMapping(value = "/santa/hitorique/{id}", method = RequestMethod.GET)
//	public List<Participation> recupHistoriqueByIdUser(@PathVariable Long  id) {
//		List<Participation> p = new ArrayList<Participation>();
//		p = participationRepo.findEvenementByParticipantId(id);
//		return participationRepo.findHistorique(p);
//	}

	
	
	
}
