package fr.groupe.higher.infrastucture.utilisateur.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;

import fr.groupe.higher.infrastucture.utilisateur.dto.Nationalite;

@Service
public class NationaliteService {
	
	
	public List<Nationalite> listeNationalites() {
		String[] countryCodes = Locale.getISOCountries();
		List<Nationalite> listing = new ArrayList<>();
		
		for (String countryCode : countryCodes) {
		    Locale obj = new Locale("", countryCode);
		    listing.add(new Nationalite(obj.getCountry(), obj.getDisplayCountry()));
		}
		
		return listing;
	}
}
