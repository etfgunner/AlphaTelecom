package com.alphaTelecom.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.alphaTelecom.model.Problem;

public interface ProblemRepository extends CrudRepository<Problem, Integer>{

	Iterable<Problem> findByStatusEquals(String status);

}
