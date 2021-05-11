package fr.groupe.higher.infrastucture.equipe.dto;

public class DtoEquipeCreation {
	private String nom;
	private Integer createurId;
	
	public DtoEquipeCreation() {
		// TODO Auto-generated constructor stub
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getCreateurId() {
		return createurId;
	}

	public void setCreateurId(Integer createurId) {
		this.createurId = createurId;
	}
}
