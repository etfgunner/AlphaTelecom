package com.alphaTelecom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alphaTelecom.model.Problem;
import com.alphaTelecom.repository.ProblemRepository;

@Service("problemiService")
public class ProblemiServiceImpl implements ProblemiService {
	
	private ProblemRepository problemRepository;

    @Autowired
    public void setProblemRepository(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    @Override
    public Iterable<Problem> listAllProbleme() {
        return problemRepository.findAll();
    }
    
    @Override
    public Problem saveProblem(Problem problem) {
        return problemRepository.save(problem);
    }

    @Override
    public Problem getProblemById(Integer id) {
        return problemRepository.findOne(id);
    }

    @Override
    public void deleteProblem(Integer id) {
    	problemRepository.delete(id);
    }
    
    @Override
    public Iterable<Problem> findProblemByStatus(String status) {
    	return problemRepository.findByStatusEquals(status);
    }


}
