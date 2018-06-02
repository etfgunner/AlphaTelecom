package com.onlineCompetitionSystem.service;

import org.springframework.stereotype.Service;

import com.onlineCompetitionSystem.model.Usluga;
import com.onlineCompetitionSystem.repository.UslugaRepository;

import org.springframework.beans.factory.annotation.Autowired;

@Service("uslugeService")
public class UslugeServiceImpl implements UslugeService{
	
	private UslugaRepository uslugaRepository;

    @Autowired
    public void setUslugaRepository(UslugaRepository uslugaRepository) {
        this.uslugaRepository = uslugaRepository;
    }

    @Override
    public Iterable<Usluga> listAllUsluge() {
        return uslugaRepository.findAll();
    }
    
    @Override
    public Usluga saveUsluga(Usluga usluga) {
        return uslugaRepository.save(usluga);
    }

    @Override
    public Usluga getUslugaById(Integer id) {
        return uslugaRepository.findOne(id);
    }

    @Override
    public void deleteUsluga(Integer id) {
    	uslugaRepository.delete(id);
    }
    
    @Override
    public Iterable<Usluga> FindUslugeByStatusLike(String status) {
    	return uslugaRepository.FindByStatusEquals(status);
    }
    

}
