package com.onlineCompetitionSystem.service;

import com.onlineCompetitionSystem.model.Takmicenje;

public interface TakmicenjeService {
	
	Iterable<Takmicenje> listAllTakmicenja();

	Takmicenje getTakmicenjeById(Integer id);

	Takmicenje saveTakmicenje(Takmicenje takmicenje);

    void deleteTakmicenje(Integer id);
    
    

}
