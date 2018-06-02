package com.onlineCompetitionSystem.repository;


import com.onlineCompetitionSystem.model.Usluga;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UslugeRepository extends CrudRepository<Usluga, Integer>{

	Iterable<Usluga> findByStatusEquals(String status);
}
