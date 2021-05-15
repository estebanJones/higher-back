package fr.groupe.higher.infrastucture.equipe.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fr.groupe.higher.infrastucture.equipe.model.Equipe;
import fr.groupe.higher.infrastucture.utilisateur.dto.UtilisateurDto;

public class DtoEquipe {
	private Integer id;
	private Integer idCapitaine;
	private String nom;
	private Integer nbVictory;
	private Integer nbDefeat;
	private LocalDateTime created_at; 
	List<UtilisateurDto> utilisateurDtoMembres = new ArrayList<>();
	
	public DtoEquipe(Equipe equipe) {
		this.id = equipe.getId();
		this.idCapitaine = equipe.getCapitaine().getId();
		this.nom = equipe.getNom();
		this.nbVictory = equipe.getNbVictory();
		this.nbDefeat = equipe.getNbDefeat();
		this.created_at = equipe.getCreated_at();
		equipe.getMembres().stream().forEach(membre -> this.utilisateurDtoMembres.add(new UtilisateurDto(membre)));
	}

	public DtoEquipe() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public Integer getIdCapitaine() {
		return idCapitaine;
	}

	public void setIdCapitaine(Integer idCapitaine) {
		this.idCapitaine = idCapitaine;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getNbVictory() {
		return nbVictory;
	}

	public void setNbVictory(Integer nbVictory) {
		this.nbVictory = nbVictory;
	}

	public Integer getNbDefeat() {
		return nbDefeat;
	}

	public void setNbDefeat(Integer nbDefeat) {
		this.nbDefeat = nbDefeat;
	}

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public List<UtilisateurDto> getUtilisateurDtoMembres() {
		return utilisateurDtoMembres;
	}

	public void setUtilisateurDtoMembres(List<UtilisateurDto> utilisateurDtoMembres) {
		this.utilisateurDtoMembres = utilisateurDtoMembres;
	}
}
