package com.onlineCompetitionSystem.repository;

import com.onlineCompetitionSystem.model.Problem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface ProblemRepository extends CrudRepository<Problem, Integer>{

}
