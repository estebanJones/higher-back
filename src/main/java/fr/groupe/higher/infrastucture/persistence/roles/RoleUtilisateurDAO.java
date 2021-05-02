package fr.groupe.higher.infrastucture.persistence.roles;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.groupe.higher.infrastucture.utilisateur.model.RoleUtilisateur;

public interface RoleUtilisateurDAO extends JpaRepository<RoleUtilisateur, Integer>{
	
}
