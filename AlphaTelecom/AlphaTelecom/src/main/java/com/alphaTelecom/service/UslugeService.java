package com.alphaTelecom.service;

import com.alphaTelecom.model.Usluga;

public interface UslugeService {

	Iterable<Usluga> listAllUsluge();

	Usluga getUslugaById(Integer id);

	Usluga saveUsluga(Usluga usluga);

    void deleteUsluga(Integer id);
    
    Iterable<Usluga> findUslugeByStatus(String status);
}
