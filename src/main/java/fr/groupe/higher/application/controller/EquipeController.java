package fr.groupe.higher.application.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.groupe.higher.infrastucture.equipe.dto.DtoEquipe;
import fr.groupe.higher.infrastucture.equipe.dto.DtoEquipeCreation;
import fr.groupe.higher.infrastucture.equipe.model.Equipe;
import fr.groupe.higher.infrastucture.equipe.repositories.EquipeService;
import fr.groupe.higher.infrastucture.utilisateur.dto.DtoMembre;
import fr.groupe.higher.infrastucture.utilisateur.model.Utilisateur;
import fr.groupe.higher.infrastucture.utilisateur.service.UtilisateurService;

@RestController
@RequestMapping("/equipe")
public class EquipeController {
	private EquipeService equipeService;
	private UtilisateurService utilisateurService;
	
	public EquipeController(EquipeService equipeService, UtilisateurService utilisateurService) {
		this.equipeService = equipeService;
		this.utilisateurService = utilisateurService;
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<?> creerEquipe(@RequestBody DtoEquipeCreation dtoEquipeCreation, BindingResult resValid) {
		if(!resValid.hasErrors()) {
			// CONTROLER SI LE NOM DE LEQUIPE EXISTE DEJA SI OUI REFUSER LA CREATION SI NON CONTINUER
			try {
				this.equipeService.checkSiEquipeExiste(dtoEquipeCreation.getNom());
				Equipe equipe = this.equipeService.buildEquipe(dtoEquipeCreation);
				this.equipeService.saveEquipe(equipe);
			} catch(Exception e) {
				return ResponseEntity.ok(e.getMessage());
			}
			return ResponseEntity.ok("Votre equipe à été créée avec succès");
		} else {
			return ResponseEntity.badRequest().body("Une erreur est survenue lors de la validation du formulaire");
		}
	}
	
	@GetMapping("/liste/{idUtilisateur}")
	public ResponseEntity<?> listeEquipesParUtilisateur(@PathVariable Integer idUtilisateur) {
		List<Equipe> equipes = this.equipeService.findEquipeByUtilisateur(idUtilisateur);
		List<DtoEquipe> dtoEquipes = equipes.stream().map(equipeDB -> new DtoEquipe(equipeDB)).collect(Collectors.toList());
		return ResponseEntity.ok(dtoEquipes);
	}

	@GetMapping("/{idEquipe}/membres")
	public ResponseEntity<?> listeMembresParEquipe(@PathVariable Integer idEquipe) {
		List<Utilisateur> utilisateurs = this.utilisateurService.getUtilisateursByEquipe(idEquipe);
		List<DtoMembre> dtoMembres = utilisateurs.stream().map(utilisateur -> new DtoMembre(utilisateur)).collect(Collectors.toList());
		
		return ResponseEntity.ok(dtoMembres);
	}
}
