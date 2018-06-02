package com.onlineCompetitionSystem.repository;


import com.onlineCompetitionSystem.model.Usluga;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UslugaRepository extends CrudRepository<Usluga, Integer>{

	Iterable<Usluga> FindByStatusEquals(String status);
}
