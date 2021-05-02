package fr.groupe.higher.infrastucture.utilisateur.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.groupe.higher.infrastucture.utilisateur.model.Utilisateur;

public interface UtilisateurDAO extends JpaRepository<Utilisateur, Integer>{
	Optional<Utilisateur> findByEmail(String email);
}
