package fr.groupe.higher.application.controller;

import java.security.Principal;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.groupe.higher.infrastucture.utilisateur.dto.UtilisateurDto;
import fr.groupe.higher.infrastucture.utilisateur.model.Utilisateur;
import fr.groupe.higher.infrastucture.utilisateur.service.UtilisateurService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class AuthController {
	private UtilisateurService utilisateurService;
	public AuthController(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}
	
	@GetMapping("/me")
	public ResponseEntity<?> getConnectedUser(Principal principal) {
//		try {
//			Utilisateur utilisateur = this.utilisateurService.getUtilisateurByEmail(principal.getName());
//			UtilisateurDto utilisateurDto = new UtilisateurDto(utilisateur);
//			return ResponseEntity.ok().body(utilisateurDto);
//		} catch (Exception e) {
//			return ResponseEntity.badRequest().body("Veuillez vous reconnecter");
//		}
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return this.utilisateurService.findByEmail(email)
						                .map(UtilisateurDto::new)
						                .map(ResponseEntity::ok)
						                .orElse(ResponseEntity.badRequest().build());
	}
	
}
