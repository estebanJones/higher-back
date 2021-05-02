package fr.groupe.higher.infrastucture.utilisateur.manager;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.groupe.higher.infrastucture.persistence.roles.RoleUtilisateurRepository;
import fr.groupe.higher.infrastucture.utilisateur.dto.RegisterDtoRequest;
import fr.groupe.higher.infrastucture.utilisateur.dto.RegisterDtoResponse;
import fr.groupe.higher.infrastucture.utilisateur.enums.ERole;
import fr.groupe.higher.infrastucture.utilisateur.model.RoleUtilisateur;
import fr.groupe.higher.infrastucture.utilisateur.model.Utilisateur;
import fr.groupe.higher.infrastucture.utilisateur.service.InscriptionVerificationService;
import fr.groupe.higher.infrastucture.utilisateur.service.UtilisateurService;

@Service
public class InscriptionManager {
	private UtilisateurService utilisateurService;
	private RoleUtilisateurRepository roleUtilisateurRepository;
	private PasswordEncoder passwordEncoder;
	private InscriptionVerificationService inscriptionVerificationService;
	
	public InscriptionManager(InscriptionVerificationService inscriptionVerificationService, PasswordEncoder passwordEncoder, UtilisateurService utilisateurService, RoleUtilisateurRepository roleUtilisateurRepository) {
		this.inscriptionVerificationService = inscriptionVerificationService;
		this.passwordEncoder = passwordEncoder;
		this.utilisateurService = utilisateurService;
		this.roleUtilisateurRepository = roleUtilisateurRepository;
		
	}
	
	public RegisterDtoResponse inscription(RegisterDtoRequest dtoRequest) {
		this.encodePassword(dtoRequest);
		Utilisateur utilisateur = this.utilisateurService.creerUtilisateur(dtoRequest);
		Utilisateur utilisateurDataBase = this.utilisateurService.persist(utilisateur);
		RoleUtilisateur roleUtilisateur = new RoleUtilisateur(utilisateurDataBase, ERole.ROLE_UTILISATEUR);
		RoleUtilisateur roleUtilisateurDataBase = this.roleUtilisateurRepository.persist(roleUtilisateur);
		return new RegisterDtoResponse("Inscription réussie !");
	}
	
	public boolean controleInscriptionProprietes(RegisterDtoRequest dtoRequest) {
		return this.inscriptionVerificationService.controleInscriptionProprietes(dtoRequest);
	}
	
	public void encodePassword(RegisterDtoRequest dtoRequest) {
		dtoRequest.setPassword(this.passwordEncoder.encode(dtoRequest.getPassword()));
	}
}
