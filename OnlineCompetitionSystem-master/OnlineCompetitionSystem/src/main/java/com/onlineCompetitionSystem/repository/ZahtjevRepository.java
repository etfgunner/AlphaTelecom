package com.onlineCompetitionSystem.repository;

import com.onlineCompetitionSystem.model.Usluga;
import com.onlineCompetitionSystem.model.Zahtjev;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ZahtjevRepository extends CrudRepository<Zahtjev, Integer>{
	
	Iterable<Zahtjev> findByStatusEquals(String status);

}
