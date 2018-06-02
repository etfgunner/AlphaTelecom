package com.onlineCompetitionSystem.controllers;

import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.onlineCompetitionSystem.model.Pitanje;
import com.onlineCompetitionSystem.model.Takmicenje;
import com.onlineCompetitionSystem.model.Pregledanje;
import com.onlineCompetitionSystem.service.PitanjeService;
import com.onlineCompetitionSystem.service.TakmicenjeService;
import com.onlineCompetitionSystem.service.UserService;

@Controller
public class PitanjeController {
	
	private PitanjeService pitanjeService;
	private TakmicenjeService takmicenjeService;
	private UserService userService;

    @Autowired
    public void setPitanjeService(PitanjeService pitanjeService) {
        this.pitanjeService = pitanjeService;
    }

    @Autowired
    public void setTakmicenjeService(TakmicenjeService takmicenjeService) {
        this.takmicenjeService = takmicenjeService;
    }
    
    @Autowired
    public void setUserService(UserService userService) {
    	this.userService = userService;
    }
    
    //ispisuje sva pitanja od odredjenog takmicenja
    @RequestMapping(value = "/admin/dodajPitanja/{id}", method = RequestMethod.GET)
    public String list(@PathVariable Integer id, Model model){
        model.addAttribute("pitanja", pitanjeService.getPitanjaByTakmicenjeId(id));
        return "/admin/dodajPitanja";
    }
    
    @RequestMapping(value = "/takmicar/takmicenje/{id}", method = RequestMethod.GET)
    public String izlistaj(@PathVariable Integer id, Model model){
        model.addAttribute("pitanja", pitanjeService.getPitanjaByTakmicenjeId(id));
        model.addAttribute("takmicenje", takmicenjeService.getTakmicenjeById(id));
        Pregledanje pr=new Pregledanje();
        pr.setUser(userService.findUserByUsername("smuratovic"));
        //treba mi ovdje da podesim usera na trenutnog i treba da za svako pitanje unesem pregledanje a ne
        //jedno pregledanje za cijelo takmicenej malo sam se zajebala i treba mi da za pregledanje unesem pitanje 
        //pored ovog usera i onda treba da vidim koliko sam puno zakomplikovala situaciju obzirom da sam zbuckurisala
        //u takmicenje.html i saveanje i getanje i drugi dio ovog requesta je u pregledanjecontroleru sto nezz
        //bil uopste radilo ako je razdvojeno... et :O :(
        model.addAttribute("pregledanje", pr);
        return "/takmicar/takmicenje";
    }

    /*@RequestMapping("pitanje/{id}")
    public String showPitanje(@PathVariable Integer id, Model model){
        model.addAttribute("pitanje", pitanjeService.getPitanjeById(id));
        return "pitanjeshow";
    }*/
//uz id od pitanja
    @RequestMapping("pitanje/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("pitanje", pitanjeService.getPitanjeById(id));
        return "pitanjeform";
    }
//uz id od takmicenja na koje se klikne
    @RequestMapping("pitanje/new/{id}")
    public String newPitanje(@PathVariable Integer id, Model model){
    	Pitanje pitanjce= new Pitanje();
    	pitanjce.setTakmicenje(takmicenjeService.getTakmicenjeById(id));
        model.addAttribute("pitanje", pitanjce);
        return "pitanjeform";
    }

    @RequestMapping(value = "pitanje", method = RequestMethod.POST)
    public String savePitanje(Pitanje pitanje){
    	pitanjeService.savePitanje(pitanje);
        return "redirect:/admin/dodajPitanja/"+ pitanje.getTakmicenje().getId();
    }
//uz id od pitanja ali dole vracas id od takmicenja pitanja koje brises jer si gore tako definirala izlistavanje pitanja
    @RequestMapping("pitanje/delete/{id}")
    public String delete(@PathVariable Integer id){
    	int IdTakmicenjaPrijeNegoObrisesPitanje=pitanjeService.getPitanjeById(id).getTakmicenje().getId();
    	pitanjeService.deletePitanje(id);
        return "redirect:/admin/dodajPitanja/"+ IdTakmicenjaPrijeNegoObrisesPitanje;
    }

}
