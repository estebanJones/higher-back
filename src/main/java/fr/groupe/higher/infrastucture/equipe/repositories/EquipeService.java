package fr.groupe.higher.infrastucture.equipe.repositories;

import org.springframework.stereotype.Service;

import fr.groupe.higher.infrastucture.equipe.persistence.repositories.EquipeDAO;

@Service
public class EquipeService {
	private EquipeDAO equipeDAO;
	
	public EquipeService(EquipeDAO equipeDAO) {
		this.equipeDAO = equipeDAO;
	}
	
	
}
