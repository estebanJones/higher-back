package fr.groupe.higher.infrastucture.utilisateur.role;

import fr.groupe.higher.infrastucture.utilisateur.model.RoleUtilisateur;

public class RoleDto {
	private Integer id;
	private String label;
	
	public RoleDto(RoleUtilisateur roleUtilisateur) {
		this.id = roleUtilisateur.getId();
		this.label = roleUtilisateur.getRole().toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}
