package fr.groupe.higher.application.controller;

import java.text.ParseException;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.groupe.higher.infrastucture.utilisateur.dto.RegisterDtoRequest;
import fr.groupe.higher.infrastucture.utilisateur.dto.RegisterDtoResponse;
import fr.groupe.higher.infrastucture.utilisateur.manager.InscriptionManager;
import fr.groupe.higher.infrastucture.utilisateur.service.InscriptionVerificationService;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class InscriptionController {
	private InscriptionManager inscriptionManager;
	private InscriptionVerificationService inscriptionVerificationService;
	
	public InscriptionController(InscriptionManager inscriptionManager, InscriptionVerificationService inscriptionVerificationService) {
		this.inscriptionManager = inscriptionManager;
		this.inscriptionVerificationService = inscriptionVerificationService;
	}

	@PostMapping("/inscription")
	public ResponseEntity<RegisterDtoResponse> register(@RequestBody RegisterDtoRequest dtoRequest, BindingResult resValid)
			throws ParseException {
		if (!resValid.hasErrors()) {
			if(this.inscriptionVerificationService.controleInscriptionProprietes(dtoRequest)) {
				RegisterDtoResponse dtoResponse = this.inscriptionManager.inscription(dtoRequest);
				return ResponseEntity.ok(dtoResponse);
			}
			return  ResponseEntity.badRequest().body(new RegisterDtoResponse("Veuillez verifier les règles de saisies"));
		}
		return ResponseEntity.badRequest().body(new RegisterDtoResponse("Une erreur est survenue")); 
	}
}
