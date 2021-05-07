package fr.groupe.higher.application.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.groupe.higher.infrastucture.utilisateur.dto.Nationalite;
import fr.groupe.higher.infrastucture.utilisateur.service.NationaliteService;

@RestController
@RequestMapping("/nationalites")
public class NationaliteController {
	private NationaliteService nationaliteService;
	
	public NationaliteController(NationaliteService nationaliteService) {
		this.nationaliteService = nationaliteService;
	}
	
	@GetMapping("/liste")
	public ResponseEntity<?> listeNationalites() {
		List<Nationalite> listing = this.nationaliteService.listeNationalites();
		
		return ResponseEntity.ok(listing);
	}
}
