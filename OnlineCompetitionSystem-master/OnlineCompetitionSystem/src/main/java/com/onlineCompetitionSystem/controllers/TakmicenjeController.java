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
import com.onlineCompetitionSystem.model.Takmicenje;
import com.onlineCompetitionSystem.service.TakmicenjeService;

@Controller
public class TakmicenjeController {
	
	private TakmicenjeService takmicenjeService;

    @Autowired
    public void setTakmicenjeService(TakmicenjeService takmicenjeService) {
        this.takmicenjeService = takmicenjeService;
    }

    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("takmicenja", takmicenjeService.listAllTakmicenja());
        return "/admin/home";
    }
    
    
    @RequestMapping(value = "/takmicar/home", method = RequestMethod.GET)
    public String izlistaj(Model model){
        model.addAttribute("takmicenja", takmicenjeService.listAllTakmicenja());
        return "/takmicar/home";
    }

    /*@RequestMapping("takmicenje/edit/{id}")
    public String edit(@PathVariable Integer id, Model model){
        model.addAttribute("takmicenje", takmicenjeService.getTakmicenjeById(id));
        return "takmicenjeform";
    }*/
//adminove metode
    @RequestMapping("takmicenje/new")
    public String newTakmicenje(Model model){
        model.addAttribute("takmicenje", new Takmicenje());
        return "takmicenjeform";
    }

    @RequestMapping(value = "takmicenje", method = RequestMethod.POST)
    public String saveTakmicenje(Takmicenje takmicenje){
    	takmicenjeService.saveTakmicenje(takmicenje);
        return "redirect:/admin/home";
    }

    @RequestMapping("takmicenje/delete/{id}")
    public String delete(@PathVariable Integer id){
    	takmicenjeService.deleteTakmicenje(id);
        return "redirect:/admin/home";
    }


}
