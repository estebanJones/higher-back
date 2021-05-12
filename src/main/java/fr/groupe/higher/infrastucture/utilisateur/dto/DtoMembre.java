package fr.groupe.higher.infrastucture.utilisateur.dto;

import fr.groupe.higher.infrastucture.utilisateur.model.Utilisateur;

public class DtoMembre {
    private Integer id;
	private String nom;

    public DtoMembre() {}

    public DtoMembre(Utilisateur util) {
        this.id = util.getId();
        this.nom = util.getUsername();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    


}
