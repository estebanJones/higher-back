package fr.groupe.higher.application.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.groupe.higher.infrastucture.equipe.repositories.EquipeService;

@RestController
@RequestMapping("/equipe")
public class EquipeController {
	private EquipeService equipeService;
	
	public EquipeController(EquipeService equipeService) {
		this.equipeService = equipeService;
	}
	
	@GetMapping("/liste/{idUtilisateur}")
	public ResponseEntity<?> listeEquipesParUtilisateur(@PathVariable Integer idUtilisateur) {
		
		return ResponseEntity.ok("");
	}
	
	
}
