package com.onlineCompetitionSystem.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.onlineCompetitionSystem.model.Rezultati;
import com.onlineCompetitionSystem.model.Takmicenje;
import com.onlineCompetitionSystem.repository.RezultatiRepository;

import org.springframework.stereotype.Service;

@Service("rezultatiService")
public class RezultatiServiceImpl implements RezultatiService{
	
	private RezultatiRepository rezultatiRepository;

    @Autowired
    public void setRezultatiRepository(RezultatiRepository rezultatiRepository) {
        this.rezultatiRepository = rezultatiRepository;
    }

    @Override
    public Iterable<Rezultati> listAllRezultati() {
        return rezultatiRepository.findAll();
    }
    
    @Override
    public Rezultati saveRezultati(Rezultati rezultati) {
        return rezultatiRepository.save(rezultati);
    }

    @Override
    public Rezultati getRezultatiById(Integer id) {
        return rezultatiRepository.findOne(id);
    }


}
