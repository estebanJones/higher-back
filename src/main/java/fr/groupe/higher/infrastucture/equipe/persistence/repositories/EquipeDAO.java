package fr.groupe.higher.infrastucture.equipe.persistence.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import fr.groupe.higher.infrastucture.equipe.model.Equipe;

public interface EquipeDAO extends JpaRepository<Equipe, Integer>{
	
	@Query(value = "SELECT * FROM equipe " +
				   "INNER JOIN utilisateur_equipe " +
				   "ON utilisateur_equipe.id_equipe = equipe.id " +
				   "WHERE utilisateur_equipe.id_utilisateur = ?1"
				   , nativeQuery = true)
	List<Equipe> findByUtilisateur(Integer idUtilisateur);
	
	Optional<Equipe> findByNom(String nom);
}
