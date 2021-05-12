package fr.groupe.higher.infrastucture.utilisateur.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.groupe.higher.infrastucture.utilisateur.model.Utilisateur;

public interface UtilisateurDAO extends JpaRepository<Utilisateur, Integer>{
	@Query(value = "SELECT * FROM utilisateur " +
				   "INNER JOIN utilisateur_equipe " +
				   "ON utilisateur_equipe.id_utilisateur = utilisateur.id " +  
				   "INNER JOIN equipe " +
				   "ON utilisateur_equipe.id_equipe = equipe.id " +
				   "WHERE equipe.id = :#{#idEquipe}"
				   , nativeQuery = true)
	Optional<List<Utilisateur>> findByEquipe(@Param("idEquipe")Integer idEquipe);
	Optional<Utilisateur> findByEmail(String email);
	
}
