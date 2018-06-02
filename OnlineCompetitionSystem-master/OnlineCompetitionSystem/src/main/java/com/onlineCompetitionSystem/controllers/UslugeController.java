package com.onlineCompetitionSystem.controllers;

import org.springframework.stereotype.Controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
public class UslugeController {
	
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
    
  //dodijeli korisniku ovu uslugu
    @RequestMapping("usluga/dodijeli/{id}")
    public String dodijeliUslugu(@PathVariable Integer id, Model model){
 	   //Set<Usluga> usluge=new HashSet<Usluga>();
    	//if(uslugaService.getUslugaById(id).getStatus().equals("Odobren"))
    	userService.findUserByUsername("smuratovic").getUsluge().add(uslugaService.getUslugaById(id));
    	userService.saveUser(userService.findUserByUsername("smuratovic"));
        return "redirect:/korisnik/usluge";
    }
    
    //deaktiviraj ovu uslugu kod korisnika
    @RequestMapping("usluga/oduzmi/{id}")
    public String deaktUslugu(@PathVariable Integer id, Model model){
    	userService.findUserByUsername("smuratovic").getUsluge().remove(uslugaService.getUslugaById(id));
    	userService.saveUser(userService.findUserByUsername("smuratovic"));
        return "redirect:/korisnik/usluge";
    }
    
    //izlistaj aktivirane korisnikove usluge
    @RequestMapping(value = "/korisnik/usluge", method = RequestMethod.GET)
    public String mojeUslugeIzlistaj(Model model){
    	/*Set<Usluga> usluge=new HashSet<Usluga>();
    	for(Usluga usluga:userService.findUserByUsername("smuratovic").getUsluge()){
    		if(usluga.getStatus().equals("Odobren"))
    			usluge.add(usluga);
    	}*/
        model.addAttribute("usluge", userService.findUserByUsername("smuratovic").getUsluge());
        return "/korisnik/usluge";
    }
    

//adminove metode
    
    @RequestMapping(value = "/administrator/home", method = RequestMethod.GET)
    public String uslugeIzlistajAdminu(Model model){
        model.addAttribute("usluge", uslugaService.listAllUsluge());
        return "/administrator/home";
    }
    
    @RequestMapping("usluga/new")
    public String newUsluga(Model model){
        model.addAttribute("usluga", new Usluga());
        return "uslugaform";
    }

    @RequestMapping(value = "usluga", method = RequestMethod.POST)
    public String saveUsluga(Usluga usluga){
    	uslugaService.saveUsluga(usluga);
        return "redirect:/administrator/home";
    }

   @RequestMapping("usluga/delete/{id}")
    public String deleteUslugu(@PathVariable Integer id){
    	uslugaService.deleteUsluga(id);
        return "redirect:/administrator/home";
    }

   //izlistaj sve usluge koje nisu odobrene korisniku
   @RequestMapping(value = "/administrator/usluge", method = RequestMethod.GET)
   public String izlistajKorisnikoveUsluge(Model model){
	   /*Set<Usluga> usluge=userService.findUserByUsername("smuratovic").getUsluge();
	   usluge.clear();
	   Set<Usluga> usluge1=userService.findUserByUsername("smuratovic").getUsluge();
	   
	   for(Usluga usluga:usluge1){
   			usluge.add(uslugaService.getUslugaById(4));
   	}*/
       model.addAttribute("usluge", userService.findUserByUsername("smuratovic").getUsluge());
       return "/administrator/usluge";
   }
   

}
