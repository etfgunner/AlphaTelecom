package com.onlineCompetitionSystem.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.onlineCompetitionSystem.model.Pitanje;
import com.onlineCompetitionSystem.model.Takmicenje;
import com.onlineCompetitionSystem.repository.TakmicenjeRepository;

import org.springframework.stereotype.Service;

@Service("takmicenjeService")
public class TakmicenjeServiceImpl implements TakmicenjeService{
	
	private TakmicenjeRepository takmicenjeRepository;

    @Autowired
    public void setTakmicenjeRepository(TakmicenjeRepository takmicenjeRepository) {
        this.takmicenjeRepository = takmicenjeRepository;
    }

    @Override
    public Iterable<Takmicenje> listAllTakmicenja() {
        return takmicenjeRepository.findAll();
    }
    
    @Override
    public Takmicenje saveTakmicenje(Takmicenje takmicenje) {
        return takmicenjeRepository.save(takmicenje);
    }

    @Override
    public Takmicenje getTakmicenjeById(Integer id) {
        return takmicenjeRepository.findOne(id);
    }

    @Override
    public void deleteTakmicenje(Integer id) {
    	takmicenjeRepository.delete(id);
    }

}
