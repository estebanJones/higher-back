package fr.groupe.higher.infrastucture.utilisateur.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.groupe.higher.infrastucture.utilisateur.dao.UtilisateurDAO;
import fr.groupe.higher.infrastucture.utilisateur.dto.RegisterDtoRequest;
import fr.groupe.higher.infrastucture.utilisateur.model.Utilisateur;

@Service
public class UtilisateurService {
	private UtilisateurDAO utilisateurDAO;
	
	public UtilisateurService(UtilisateurDAO utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}
	
	public Utilisateur creerUtilisateur(RegisterDtoRequest dtoRequest) {
		return new Utilisateur(dtoRequest.getEmail(), dtoRequest.getUsername(), dtoRequest.getPassword(), dtoRequest.getNationalite());
	}

	public Utilisateur persist(Utilisateur utilisateur) {
		return this.utilisateurDAO.save(utilisateur);
	}
	
	public Utilisateur getUtilisateurByEmail(String email) {
		Optional<Utilisateur> utilisateur = this.utilisateurDAO.findByEmail(email);
		return utilisateur.orElseThrow();
	}
	
	public Optional<Utilisateur> findByEmail(String email) {
		Optional<Utilisateur> utilisateur = this.utilisateurDAO.findByEmail(email);
		return utilisateur;
	}
	
}
