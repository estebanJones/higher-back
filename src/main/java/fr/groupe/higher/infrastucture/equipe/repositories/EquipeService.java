package fr.groupe.higher.infrastucture.equipe.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.groupe.higher.infrastucture.equipe.dto.DtoEquipeCreation;
import fr.groupe.higher.infrastucture.equipe.model.Equipe;
import fr.groupe.higher.infrastucture.equipe.persistence.repositories.EquipeDAO;
import fr.groupe.higher.infrastucture.exceptions.RessourceNotFoundException;
import fr.groupe.higher.infrastucture.utilisateur.dao.UtilisateurDAO;
import fr.groupe.higher.infrastucture.utilisateur.model.Utilisateur;
import net.bytebuddy.implementation.bytecode.Throw;

@Service
public class EquipeService {
	private EquipeDAO equipeDAO;
	
	private UtilisateurDAO utilisateurDAO;
	
	public EquipeService(EquipeDAO equipeDAO, UtilisateurDAO utilisateurDAO) {
		this.equipeDAO = equipeDAO;
		this.utilisateurDAO = utilisateurDAO;
	}
	
	public Equipe buildEquipe(DtoEquipeCreation dtoEquipeCreation) throws RessourceNotFoundException {
		Equipe equipe = new Equipe(dtoEquipeCreation.getNom());
		Optional<Utilisateur> createur = this.utilisateurDAO.findById(dtoEquipeCreation.getCreateurId());
		if(createur.isPresent()) {
			this.setCapitaine(equipe, createur.get());
			this.setCreator(equipe, createur.get());
			equipe.addMembre(createur.get());
			return equipe;
		} else {
			throw new RessourceNotFoundException("Un problème est survenue avec la session utilisateur");
		}
	}
	
	public void checkSiEquipeExiste(String nomEquipe) throws RessourceNotFoundException {
		Optional<Equipe> equipe = this.equipeDAO.findByNom(nomEquipe);
		if(equipe.isPresent()) {
			throw new RessourceNotFoundException("L'equipe existe déjà avec le nom " + nomEquipe);			
		} 
	}
	
	public List<Equipe> findEquipeByUtilisateur(Integer idUtilisateur) {
		return this.equipeDAO.findByUtilisateur(idUtilisateur);
	}
	
	public Equipe saveEquipe(Equipe equipe) {
		return this.equipeDAO.save(equipe);
	}
	
	private void setCapitaine(Equipe equipe, Utilisateur utilisateur) {
		equipe.setCapitaine(utilisateur);
	}
	
	private void setCreator(Equipe equipe, Utilisateur utilisateur) {
		equipe.setCreator(utilisateur);
	}
	
	
	
	
}
