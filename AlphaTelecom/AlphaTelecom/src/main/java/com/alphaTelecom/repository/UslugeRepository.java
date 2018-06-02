package com.alphaTelecom.repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alphaTelecom.model.Usluga;

public interface UslugeRepository extends CrudRepository<Usluga, Integer>{

	Iterable<Usluga> findByStatusEquals(String status);
}
