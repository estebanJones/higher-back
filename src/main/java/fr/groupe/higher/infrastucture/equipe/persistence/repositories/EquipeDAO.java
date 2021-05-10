package fr.groupe.higher.infrastucture.equipe.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.groupe.higher.infrastucture.equipe.model.Equipe;

public interface EquipeDAO extends JpaRepository<Equipe, Integer>{
	
}
