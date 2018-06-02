package com.alphaTelecom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alphaTelecom.model.Usluga;
import com.alphaTelecom.model.Zahtjev;

public interface ZahtjevRepository extends CrudRepository<Zahtjev, Integer>{
	
	Iterable<Zahtjev> findByStatusEquals(String status);

}
