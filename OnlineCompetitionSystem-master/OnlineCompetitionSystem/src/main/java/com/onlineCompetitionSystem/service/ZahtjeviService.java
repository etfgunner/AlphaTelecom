package com.onlineCompetitionSystem.service;

import com.onlineCompetitionSystem.model.Zahtjev;

public interface ZahtjeviService {

	Iterable<Zahtjev> listAllZahtjeve();

	Zahtjev getZahtjevById(Integer id);

	Zahtjev saveZahtjev(Zahtjev zahtjev);

    void deleteZahtjev(Integer id);
    
    Iterable<Zahtjev> findZahtjevByStatus(String status);
}
