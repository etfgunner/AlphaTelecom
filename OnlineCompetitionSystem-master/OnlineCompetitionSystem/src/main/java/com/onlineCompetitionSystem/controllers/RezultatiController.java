package com.onlineCompetitionSystem.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.onlineCompetitionSystem.model.Rezultati;
import com.onlineCompetitionSystem.model.Takmicenje;
import com.onlineCompetitionSystem.model.User;
import com.onlineCompetitionSystem.service.RezultatiService;
import com.onlineCompetitionSystem.service.TakmicenjeService;
import com.onlineCompetitionSystem.service.UserService;

@Controller
public class RezultatiController {
	
	private RezultatiService rezultatiService;
	private UserService userService;
	private TakmicenjeService takmicenjeService;

    @Autowired
    public void setRezultatiService(RezultatiService rezultatiService) {
        this.rezultatiService = rezultatiService;
    }

    /*@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("rezultati", rezultatiService.listAllRezultati());
        return "/admin/home";
    }*/
    
/*
    @RequestMapping("rezultati/new/{rez}/{id}")
    public String newRezultati(@PathVariable(value="rez") Integer rez, @PathVariable(value="id") Integer id, Model model){
        Rezultati rezultati=new Rezultati();
        rezultati.setUser(userService.findUserByUsername("smuratovic"));
    	rezultati.setTakmicenje(takmicenjeService.getTakmicenjeById(id));
    	rezultati.setOstvareni_bodovi(rez);
    	model.addAttribute("rezultati", rezultati);
        return "rezultatiform";
    }
*/
    @PostMapping("rezultati/new/{rez}/{id}")
    public String saveRezultati(@PathVariable(value="rez") Integer rez, @PathVariable(value="id") Integer id,Rezultati rezultati){
    	rezultati.setUser(userService.findUserByUsername("smuratovic"));
    	rezultati.setTakmicenje(takmicenjeService.getTakmicenjeById(id));
    	rezultati.setOstvareni_bodovi(rez);
    	rezultatiService.saveRezultati(rezultati);
        return "redirect:/takmicar/rezultati";
    }



}
