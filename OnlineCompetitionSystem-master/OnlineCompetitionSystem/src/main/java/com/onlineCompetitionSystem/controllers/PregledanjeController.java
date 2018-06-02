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

import com.onlineCompetitionSystem.model.Pitanje;
import com.onlineCompetitionSystem.model.Pregledanje;
import com.onlineCompetitionSystem.service.PregledanjeService;
import com.onlineCompetitionSystem.service.PitanjeService;

@Controller
public class PregledanjeController {
	
	private PregledanjeService pregledanjeService;
	private PitanjeService pitanjeService;
	
    @Autowired
    public void setPregledanjeService(PregledanjeService pregledanjeService) {
        this.pregledanjeService = pregledanjeService;
    }
//trebace da iskoristim iz nje kasnije
   /* @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("pregledanja", pregledanjeService.listAllPregledanja());
        return "/admin/home";
    }*/
    /*
    @RequestMapping("pregledanje/new")
    public String newPregledanje(Model model){
        model.addAttribute("pregledanje", new Pregledanje());
        return "/takmicar/takmicenje";
    }
*/
    
    @RequestMapping(value = "/pregledanje/{id}", method = RequestMethod.POST)
    public String savePregledanje(@PathVariable Integer id, Pregledanje pregledanje){
    	pregledanje.setPitanje(pitanjeService.getPitanjeById(id));
    	pregledanjeService.savePregledanje(pregledanje);
        return "redirect:/takmicar/rezultati";
    }


}
