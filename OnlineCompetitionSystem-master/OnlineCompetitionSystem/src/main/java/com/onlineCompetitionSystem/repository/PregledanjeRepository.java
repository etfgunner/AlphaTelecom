package com.onlineCompetitionSystem.repository;


import com.onlineCompetitionSystem.model.Pregledanje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface PregledanjeRepository extends CrudRepository<Pregledanje, Integer>{
	
}
