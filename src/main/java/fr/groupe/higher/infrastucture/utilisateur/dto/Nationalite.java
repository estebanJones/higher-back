package fr.groupe.higher.infrastucture.utilisateur.dto;


public class Nationalite {
	private String codePays;
	private String nomPays;
	
	public Nationalite(String codePays, String nomPays) {
		this.codePays = codePays;
		this.nomPays = nomPays;
	}

	public String getCodePays() {
		return codePays;
	}

	public void setCodePays(String codePays) {
		this.codePays = codePays;
	}

	public String getNomPays() {
		return nomPays;
	}

	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}
}
