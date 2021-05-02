package fr.groupe.higher.infrastucture.utilisateur.service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import fr.groupe.higher.infrastucture.utilisateur.dao.UtilisateurDAO;
import fr.groupe.higher.infrastucture.utilisateur.dto.RegisterDtoRequest;
import fr.groupe.higher.infrastucture.utilisateur.model.Utilisateur;

@Service
public class InscriptionVerificationService {
	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	private UtilisateurDAO utilisateurDAO;
	public InscriptionVerificationService(UtilisateurDAO utilisateurDAO) {
		this.utilisateurDAO = utilisateurDAO;
	}
	
	public boolean controleInscriptionProprietes(RegisterDtoRequest dtoRequest) {
		return (this.checkIfDtoIsNotBlank(dtoRequest) && 
				this.checkEmailSyntaxe(dtoRequest) 	  &&
			    this.checkIfEmailExiste(dtoRequest))  ?  
					   true :  false;
	}
	
	private boolean checkIfEmailExiste(RegisterDtoRequest dtoRequest) {
		Optional<Utilisateur> utilisateur = this.utilisateurDAO.findByEmail(dtoRequest.getEmail());
		if(utilisateur.isPresent()) {
			return false;
		}
		return true;
	}
	
	private boolean checkEmailSyntaxe(RegisterDtoRequest dtoRequest) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(dtoRequest.getEmail());
        return matcher.find();
	}
	
	private boolean checkIfDtoIsNotBlank(RegisterDtoRequest dtoRequest) {
		if(!dtoRequest.getEmail().isBlank() && !dtoRequest.getPassword().isBlank()) {
			return true;
			
		}else {
			return false;
		}
	}
}
