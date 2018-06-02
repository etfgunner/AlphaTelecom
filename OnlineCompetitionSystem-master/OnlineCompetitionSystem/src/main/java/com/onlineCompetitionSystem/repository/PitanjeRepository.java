package com.onlineCompetitionSystem.repository;


import com.onlineCompetitionSystem.model.Pitanje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface PitanjeRepository extends CrudRepository<Pitanje, Integer>{

	Iterable<Pitanje> findByTakmicenjeId(Integer id);
	
}
