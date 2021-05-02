package fr.groupe.higher.infrastucture.persistence.roles;

import org.springframework.stereotype.Repository;

import fr.groupe.higher.infrastucture.persistence.roles.RoleUtilisateurDAO;
import fr.groupe.higher.infrastucture.utilisateur.model.RoleUtilisateur;

@Repository
public class RoleUtilisateurRepository {
	private RoleUtilisateurDAO roleUtilisateurDAO;
	
	public RoleUtilisateurRepository(RoleUtilisateurDAO roleUtilisateurDAO) {
		this.roleUtilisateurDAO = roleUtilisateurDAO;
	}
	
	public RoleUtilisateur persist(RoleUtilisateur roleUtilisateur) {
		return this.roleUtilisateurDAO.save(roleUtilisateur);
	}
}
