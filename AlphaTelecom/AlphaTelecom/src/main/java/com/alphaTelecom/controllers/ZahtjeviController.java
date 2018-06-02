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

import com.alphaTelecom.model.Usluga;
import com.alphaTelecom.model.Zahtjev;
import com.alphaTelecom.service.UserService;
import com.alphaTelecom.service.ZahtjeviService;

@Controller
public class ZahtjeviController {

	private ZahtjeviService zahtjevService;
	private UserService userService;

	@Autowired
	public void setZahtjeviService(ZahtjeviService zahtjevService) {
		this.zahtjevService = zahtjevService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/korisnik/zahtjevi", method = RequestMethod.GET)
	public String zahtjeviIzlistaj(Model model) {
		model.addAttribute("zahtjevi", zahtjevService.listAllZahtjeve());
		return "/korisnik/zahtjevi";
	}

	@RequestMapping("zahtjev/new")
	public String newZahtjev(Model model) {
		model.addAttribute("zahtjev", new Zahtjev());
		return "zahtjevform";
	}

	@RequestMapping(value = "zahtjev", method = RequestMethod.POST)
	public String saveZahtjev(Zahtjev zahtjev) {
		zahtjev.setStatus("Neodobren");
		zahtjevService.saveZahtjev(zahtjev);
		return "redirect:/korisnik/zahtjevi";
	}

	// adminovo

	// izlistaj sve usluge koje nisu odobrene korisniku
	@RequestMapping(value = "/administrator/zahtjevi", method = RequestMethod.GET)
	public String izlistajKorisnikoveZahtjeve(Model model) {
		Iterable<Zahtjev> zahtjevi = zahtjevService.findZahtjevByStatus("Neodobren");
		model.addAttribute("zahtjevi", zahtjevi);
		return "/administrator/zahtjevi";
	}

	// odobri uz id od usluge
	@RequestMapping("zahtjev/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		zahtjevService.getZahtjevById(id).setStatus("Odobren");
		zahtjevService.saveZahtjev(zahtjevService.getZahtjevById(id));
		return "redirect:/administrator/zahtjevi";
	}
}
