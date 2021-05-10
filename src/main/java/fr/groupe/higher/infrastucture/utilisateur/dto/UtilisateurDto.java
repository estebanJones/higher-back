package fr.groupe.higher.infrastucture.utilisateur.dto;

import java.util.ArrayList;
import java.util.List;

import fr.groupe.higher.infrastucture.utilisateur.model.Utilisateur;
import fr.groupe.higher.infrastucture.utilisateur.role.RoleDto;

public class UtilisateurDto {
	private Integer id;
	private String email;
	private String username;
	private String nationalite;
	private List<RoleDto> roles = new ArrayList<>();

	public UtilisateurDto(Utilisateur utilisateur) {
		this.id = utilisateur.getId();
		this.email = utilisateur.getEmail();
		this.username = utilisateur.getUsername();
		this.nationalite = utilisateur.getNationalite();
		utilisateur.getRoles().forEach(role -> this.roles.add(new RoleDto(role)));
	}
	
	public UtilisateurDto() {
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

	public List<RoleDto> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleDto> roles) {
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
