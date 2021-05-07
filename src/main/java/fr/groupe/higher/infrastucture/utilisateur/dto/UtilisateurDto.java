package fr.groupe.higher.infrastucture.utilisateur.dto;

import java.util.ArrayList;
import java.util.List;

import fr.groupe.higher.infrastucture.utilisateur.model.Utilisateur;
import fr.groupe.higher.infrastucture.utilisateur.role.RoleDto;

public class UtilisateurDto {
	private Integer id;
	private String email;
	private List<RoleDto> roles = new ArrayList<>();

	public UtilisateurDto(Utilisateur utilisateur) {
		this.id = utilisateur.getId();
		this.email = utilisateur.getEmail();
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
}
