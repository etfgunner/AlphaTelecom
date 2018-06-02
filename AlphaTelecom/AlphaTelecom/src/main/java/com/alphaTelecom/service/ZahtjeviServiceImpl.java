package com.alphaTelecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alphaTelecom.model.Zahtjev;
import com.alphaTelecom.repository.ZahtjevRepository;

@Service("zahtjeviService")
public class ZahtjeviServiceImpl implements ZahtjeviService{
	
	private ZahtjevRepository zahtjevRepository;

    @Autowired
    public void setZahtjevRepository(ZahtjevRepository zahtjevRepository) {
        this.zahtjevRepository = zahtjevRepository;
    }

    @Override
    public Iterable<Zahtjev> listAllZahtjeve() {
        return zahtjevRepository.findAll();
    }
    
    @Override
    public Zahtjev saveZahtjev(Zahtjev zahtjev) {
        return zahtjevRepository.save(zahtjev);
    }

    @Override
    public Zahtjev getZahtjevById(Integer id) {
        return zahtjevRepository.findOne(id);
    }

    @Override
    public void deleteZahtjev(Integer id) {
    	zahtjevRepository.delete(id);
    }
    
    @Override
    public Iterable<Zahtjev> findZahtjevByStatus(String status) {
    	return zahtjevRepository.findByStatusEquals(status);
    }

}
