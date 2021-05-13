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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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
	
	@OneToOne
	private Utilisateur creator;
	
	@ManyToOne
	@JoinColumn(name="capitaine_id")
	private Utilisateur capitaine;
	
	@ManyToMany
	@JoinTable(name = "utilisateur_equipe", joinColumns = @JoinColumn(name="id_equipe", referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name="id_utilisateur", referencedColumnName = "id")
			)
	private List<Utilisateur> membres = new ArrayList<>();
	
	public Equipe() {
		// TODO Auto-generated constructor stub
	}

	public Equipe(String nom) {
		this.nom = nom;
		this.nbVictory = 0;
		this.nbDefeat = 0;
		this.created_at = LocalDateTime.now();
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

	public List<Utilisateur> getMembres() {
		return membres;
	}

	public void setMembres(List<Utilisateur> membres) {
		this.membres = membres;
	}
	
	public void addMembre(Utilisateur utilisateur) {
		this.membres.add(utilisateur);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Utilisateur getCapitaine() {
		return capitaine;
	}

	public void setCapitaine(Utilisateur capitaine) {
		this.capitaine = capitaine;
	}

	public Utilisateur getCreator() {
		return creator;
	}

	public void setCreator(Utilisateur creator) {
		this.creator = creator;
	}
	
	
}
