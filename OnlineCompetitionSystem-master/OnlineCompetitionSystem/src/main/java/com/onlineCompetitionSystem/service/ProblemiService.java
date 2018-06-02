package com.onlineCompetitionSystem.service;

import com.onlineCompetitionSystem.model.Problem;

public interface ProblemiService {

	Iterable<Problem> listAllProbleme();

	Problem getProblemById(Integer id);

	Problem saveProblem(Problem problem);

    void deleteProblem(Integer id);
    
    Iterable<Problem> findProblemByStatus(String status);

}
