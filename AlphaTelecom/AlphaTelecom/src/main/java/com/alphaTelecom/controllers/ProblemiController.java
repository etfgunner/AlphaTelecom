package com.alphaTelecom.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.alphaTelecom.model.Problem;
import com.alphaTelecom.model.Usluga;
import com.alphaTelecom.service.ProblemiService;
import com.alphaTelecom.service.UserService;

@Controller
public class ProblemiController {

	private ProblemiService problemService;
	private UserService userService;

	@Autowired
	public void setZahtjeviService(ProblemiService problemService) {
		this.problemService = problemService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/korisnik/problemi", method = RequestMethod.GET)
	public String problemiIzlistaj(Model model) {
		model.addAttribute("problemi", problemService.listAllProbleme());
		return "/korisnik/problemi";
	}

	@RequestMapping("problem/new")
	public String newProblem(Model model) {
		model.addAttribute("problem", new Problem());
		return "problemform";
	}

	@RequestMapping(value = "problem", method = RequestMethod.POST)
	public String saveProblem(Problem problem) {
		problem.setStatus("Na cekanju");
		problemService.saveProblem(problem);
		return "redirect:/korisnik/problemi";
	}

	// adminovo

	// izlistaj sve usluge koje nisu odobrene korisniku
	@RequestMapping(value = "/administrator/problemi", method = RequestMethod.GET)
	public String izlistajKorisnikoveProbleme(Model model) {
		Iterable<Problem> problemi = problemService.listAllProbleme();
		model.addAttribute("problemi", problemi);
		return "/administrator/problemi";
	}

	// stavi status da je proslijedjeno super adminu
	@RequestMapping("problem/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		problemService.getProblemById(id).setStatus("Proslijedjeno visim pozicijama na razmatranje.");
		problemService.saveProblem(problemService.getProblemById(id));
		return "redirect:/administrator/problemi";
	}
	
	// stavi status da je proslijedjeno super adminu
		@RequestMapping("problem/editPr/{id}")
		public String editPr(@PathVariable Integer id, Model model) {
			problemService.getProblemById(id).setStatus("Sazvan timski sastanak u svrhu rjesavanja problema.");
			problemService.saveProblem(problemService.getProblemById(id));
			return "redirect:/administrator/problemi";
		}
	
	
}
