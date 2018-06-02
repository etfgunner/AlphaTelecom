package com.onlineCompetitionSystem.service;

import com.onlineCompetitionSystem.model.Pitanje;

public interface PitanjeService {
	
	Iterable<Pitanje> listAllPitanja();
	
	Iterable<Pitanje> getPitanjaByTakmicenjeId(Integer id);

	Pitanje getPitanjeById(Integer id);

	Pitanje savePitanje(Pitanje pitanje);

    void deletePitanje(Integer id);
    
    

}
