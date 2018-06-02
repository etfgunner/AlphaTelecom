package com.onlineCompetitionSystem.repository;


import com.onlineCompetitionSystem.model.Takmicenje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface TakmicenjeRepository extends CrudRepository<Takmicenje, Integer>{
	
}
