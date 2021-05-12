package fr.groupe.higher.infrastucture.utilisateur.service;

import java.util.List;
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
	
	public List<Utilisateur> getUtilisateursByEquipe(Integer idEquipe){
		Optional<List<Utilisateur>> membres = this.utilisateurDAO.findByEquipe(idEquipe);
		return membres.orElseThrow();
	}
	
}
