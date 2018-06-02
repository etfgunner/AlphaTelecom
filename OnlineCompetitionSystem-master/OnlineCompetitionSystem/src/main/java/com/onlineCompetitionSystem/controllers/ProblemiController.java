package com.onlineCompetitionSystem.controllers;

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

import com.onlineCompetitionSystem.model.Usluga;
import com.onlineCompetitionSystem.model.Problem;
import com.onlineCompetitionSystem.service.ProblemiService;
import com.onlineCompetitionSystem.service.UserService;

@Controller
public class ProblemiController {

	private ProblemiService problemService;
	private UserService userService;

    @Autowired
    public void setZahtjeviService (ProblemiService problemService) {
        this.problemService = problemService;
    }
    
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/korisnik/problemi", method = RequestMethod.GET)
    public String problemiIzlistaj(Model model){
        model.addAttribute("problemi", problemService.listAllProbleme());
        return "/korisnik/problemi";
    }
    
    @RequestMapping("problem/new")
    public String newProblem(Model model){
        model.addAttribute("problem", new Problem());
        return "problemform";
    }

    @RequestMapping(value = "problem", method = RequestMethod.POST)
    public String saveProblem(Problem problem){
    	//problem.setStatus("Neodobren");
    	problemService.saveProblem(problem);
        return "redirect:/korisnik/problemi";
    }
    
    //adminovo
    
  //izlistaj sve usluge koje nisu odobrene korisniku
    @RequestMapping(value = "/administrator/problemi", method = RequestMethod.GET)
    public String izlistajKorisnikoveProbleme(Model model){
 	   Iterable<Problem> problemi=problemService.listAllProbleme();
        model.addAttribute("problemi", problemi);
        return "/administrator/problemi";
    }
    
  //odobri uz id od usluge
    @RequestMapping("problem/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
    	//problemService.getProblemById(id).setStatus("Odobren");
    	problemService.saveProblem(problemService.getProblemById(id));
    		return "redirect:/administrator/problemi";
    }
}
