package fr.groupe.higher.infrastucture.utilisateur.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import fr.groupe.higher.infrastucture.equipe.model.Equipe;

@Entity
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 30, nullable = false)
	private String email;
	
	@Column(length = 30, nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column(length = 50, nullable = true)
	private String nationalite;
	
	@OneToOne
	@JoinColumn(name = "addresse_id", referencedColumnName = "id", nullable = true)
	private Adresse adresse;
	
	@OneToMany(mappedBy = "utilisateur", cascade = CascadeType.PERSIST)
	private List<RoleUtilisateur> roles = new ArrayList<>();
	
	@ManyToMany()
	@JoinTable(name = "utilisateur_equipe", joinColumns = @JoinColumn(name="id_utilisateur", referencedColumnName = "id"),
				inverseJoinColumns = @JoinColumn(name="id_equipe", referencedColumnName = "id")
			)
	private List<Equipe> equipes = new ArrayList<>();
	
	
	public Utilisateur(String email, String username, String password, String nationalite) {
		this.email = email;
		this.username = username;
		this.password = password;
		this.nationalite = nationalite;
	}

	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<RoleUtilisateur> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleUtilisateur> roles) {
		this.roles = roles;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}
}
