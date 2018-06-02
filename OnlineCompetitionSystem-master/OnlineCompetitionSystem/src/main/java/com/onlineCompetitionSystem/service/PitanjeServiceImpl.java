package com.onlineCompetitionSystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.onlineCompetitionSystem.model.Pitanje;
import com.onlineCompetitionSystem.repository.PitanjeRepository;

import org.springframework.stereotype.Service;

@Service("pitanjeService")
public class PitanjeServiceImpl implements PitanjeService{
	
	private PitanjeRepository pitanjeRepository;

    @Autowired
    public void setPitanjeRepository(PitanjeRepository pitanjeRepository) {
        this.pitanjeRepository = pitanjeRepository;
    }

    @Override
    public Iterable<Pitanje> listAllPitanja() {
        return pitanjeRepository.findAll();
    }

    @Override
    public Iterable<Pitanje> getPitanjaByTakmicenjeId(Integer id) {
        return pitanjeRepository.findByTakmicenjeId(id);
    }
    
    @Override
    public Pitanje getPitanjeById(Integer id) {
        return pitanjeRepository.findOne(id);
    }

    @Override
    public Pitanje savePitanje(Pitanje pitanje) {
        return pitanjeRepository.save(pitanje);
    }

    @Override
    public void deletePitanje(Integer id) {
    	pitanjeRepository.delete(id);
    }

}
