package com.onlineCompetitionSystem.service;

import com.onlineCompetitionSystem.model.Pregledanje;

public interface PregledanjeService {
	
	Iterable<Pregledanje> listAllPregledanja();

	Pregledanje getPregledanjeById(Integer id);

	Pregledanje savePregledanje(Pregledanje pregledanje);

}
