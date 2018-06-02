package com.onlineCompetitionSystem.service;

import com.onlineCompetitionSystem.model.Rezultati;

public interface RezultatiService {
	
	Iterable<Rezultati> listAllRezultati();

	Rezultati getRezultatiById(Integer id);

	Rezultati saveRezultati(Rezultati rezultati);


    
    

}
