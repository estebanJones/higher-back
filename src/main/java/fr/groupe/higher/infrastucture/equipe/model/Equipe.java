package fr.groupe.higher.infrastucture.equipe.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import  fr.groupe.higher.infrastucture.utilisateur.model.Utilisateur;

@Entity
public class Equipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	private Integer nbVictory;
	private Integer nbDefeat;
	private LocalDateTime created_at;
	
	@ManyToMany
	@JoinTable(name = "utilisateur_equipe", joinColumns = @JoinColumn(name="id_equipe", referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name="id_utilisateur", referencedColumnName = "id")
			)
	private List<Utilisateur> utilisateurs = new ArrayList<>();
	
	public Equipe() {
		// TODO Auto-generated constructor stub
	}

	public Equipe(String nom, Integer nbVictory, Integer nbDefeat, LocalDateTime created_at,
			List<Utilisateur> utilisateurs) {
		super();
		this.nom = nom;
		this.nbVictory = nbVictory;
		this.nbDefeat = nbDefeat;
		this.created_at = created_at;
		this.utilisateurs = utilisateurs;
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

	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
}
