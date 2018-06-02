package com.onlineCompetitionSystem.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.onlineCompetitionSystem.model.Pitanje;
import com.onlineCompetitionSystem.model.Pregledanje;
import com.onlineCompetitionSystem.repository.PregledanjeRepository;

import org.springframework.stereotype.Service;

@Service("pregledanjeeService")
public class PregledanjeServiceImpl implements PregledanjeService{
	
	private PregledanjeRepository pregledanjeRepository;

    @Autowired
    public void setPregledanjeRepository(PregledanjeRepository pregledanjeRepository) {
        this.pregledanjeRepository = pregledanjeRepository;
    }

    @Override
    public Iterable<Pregledanje> listAllPregledanja() {
        return pregledanjeRepository.findAll();
    }
    
    @Override
    public Pregledanje savePregledanje(Pregledanje pregledanje) {
        return pregledanjeRepository.save(pregledanje);
    }

    @Override
    public Pregledanje getPregledanjeById(Integer id) {
        return pregledanjeRepository.findOne(id);
    }


}
