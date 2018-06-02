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
import com.onlineCompetitionSystem.service.UserService;
import com.onlineCompetitionSystem.service.UslugeService;

@Controller
public class ZahtjeviController {

	private UslugeService uslugaService;
	private UserService userService;

    @Autowired
    public void setUslugeService(UslugeService uslugaService) {
        this.uslugaService = uslugaService;
    }
    
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/korisnik/home", method = RequestMethod.GET)
    public String uslugeIzlistaj(Model model){
        model.addAttribute("usluge", uslugaService.listAllUsluge());
        return "/korisnik/home";
    }
    
    @RequestMapping("usluga/new")
    public String newUsluga(Model model){
        model.addAttribute("usluga", new Usluga());
        return "uslugaform";
    }

    @RequestMapping(value = "usluga", method = RequestMethod.POST)
    public String saveUsluga(Usluga usluga){
    	usluga.setStatus("Neodobren");
    	uslugaService.saveUsluga(usluga);
        return "redirect:/administrator/home";
    }
}
