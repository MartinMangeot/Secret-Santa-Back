package fr.solutec.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

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

import fr.solutec.dao.UserRepository;
import fr.solutec.entities.Participation;
import fr.solutec.entities.Souhait;
import fr.solutec.entities.User;

@RestController
@CrossOrigin("*")
public class UserRest {
	
	@Autowired
	private UserRepository userRepo;
	
	
	@RequestMapping(value = "/finduser/{idUser}", method = RequestMethod.GET)
	public Optional<User> getByUserId(@PathVariable Long idUser){
		return  userRepo.findById(idUser);
	}
	
	@RequestMapping(value = "/invitationAutoComplete", method = RequestMethod.GET)
	public List<String> recupParticipants() {
		ArrayList<String> mails = new ArrayList<String>();
		List<User> l = (List<User>) userRepo.findAll();
		int x = l.size();
		String m = new String();
		for (int i = 0; i < x; i++) {
			
			m=l.get(i).getMail();
			
			mails.add(m);
		}
		return  mails;
	}
	
	
	@RequestMapping(value = "/home/invitation", method = RequestMethod.POST)
	public User invitationUser(@RequestBody User user ) {
		Optional<User> pe = userRepo.findByMail(user.getMail());
		User pf = new User();
		if (pe.isPresent()) {
			pf.setId(pe.get().getId());
			pf.setMail(pe.get().getMail());
			pf.setPseudo(pe.get().getPseudo());
			pf.setNom(pe.get().getNom());
			pf.setPrenom(pe.get().getPrenom());
			pf.setInscriptionEnd(true);
				return pf;
			}
		else {
			
			pf.setMail(pe.get().getMail());
			pf.setInscriptionEnd(false);
			sendMail(pf.getMail());
			userRepo.save(pf);
			return pf;	
			}						
		}
	
	private void sendMail(String mail) {
		Properties props = new Properties();
		final String expediteur = "secret.santa.dev17@gmail.com";
		final String password = "dev17test!";
		final String objet = "Bienvenue sur Secret Santa !";
		final String contenu = "Bonjour, vous avez été invité à participer à un événement secret santa !! Pour rejoindre vos amis et faire de nombreux heureux, inscrivez vous sur http://localhost:4200/ !!";
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
	
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public boolean inscriptionUser(@RequestBody User user) {
		Optional<User> pe = userRepo.findByMail(user.getMail());
		User pf = new User();
		if (pe.isPresent()) {
			pf.setInscriptionEnd(pe.get().getInscriptionEnd());
			if(pf.getInscriptionEnd()==false) {
				user.setId(pf.getId());
				userRepo.save(user);				
				return false;
			}else {
				return true;	
			}						
		}
		else {
			user.setInscriptionEnd(true);
			userRepo.save(user);
			return false;
		}		
	}
	
	
	@RequestMapping(value = "/connexion", method = RequestMethod.POST)
	public User connexion(@RequestBody User p) {
		Optional<User> pe = userRepo.findByMailAndMdp(p.getMail(), p.getMdp());
		User pf = new User();
		if (pe.isPresent()) {	
			pf.setId(pe.get().getId());
			pf.setMail(pe.get().getMail());
			pf.setPseudo(pe.get().getPseudo());
			pf.setNom(pe.get().getNom());
			pf.setPrenom(pe.get().getPrenom());
			pf.setInscriptionEnd(pe.get().getInscriptionEnd());
		}
		return pf;
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public User getUser(@PathVariable Long id) {
		Optional<User> pe = userRepo.findById(id);
		User pf = new User();
		if (pe.isPresent()) {	
			pf.setId(pe.get().getId());
			pf.setMail(pe.get().getMail());
			pf.setPseudo(pe.get().getPseudo());
			pf.setNom(pe.get().getNom());
			pf.setPrenom(pe.get().getPrenom());
			pf.setInscriptionEnd(pe.get().getInscriptionEnd());
		}
		return pf;
	}
	
	
	@RequestMapping(value = "/inscription", method = RequestMethod.POST)
	public boolean inscription(@RequestBody User user) {
		Optional<User> pe = userRepo.findByMail(user.getMail());
		if(pe.isPresent()) {
			if(pe.get().getInscriptionEnd()) {
				return true;
			}
			else {
				user.setId(pe.get().getId());
				userRepo.save(user);
				return false;
			}
		} 
		else {
			user.setInscriptionEnd(true);
			userRepo.save(user);
			return false;
		}			
	}
	
	
}
