package com.onlineCompetitionSystem.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.onlineCompetitionSystem.model.User;
import com.onlineCompetitionSystem.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/", "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}

	/*@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	public ModelAndView ahome() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUsername(auth.getName());
		modelAndView.addObject("userName", user.getIme() + " " + user.getPrezime());
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}*/
	
	
	/*@RequestMapping(value = "/takmicar/home", method = RequestMethod.GET)
	public ModelAndView thome() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUsername(auth.getName());
		modelAndView.addObject("userName", user.getIme() + " " + user.getPrezime());
		modelAndView.setViewName("takmicar/home");
		return modelAndView;
	}*/
	
	//adminove podstranice:
	
	/*@RequestMapping(value = "/admin/napravi", method = RequestMethod.GET)
	public ModelAndView anapravi() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUsername(auth.getName());
		modelAndView.setViewName("admin/napravi");
		return modelAndView;
	}
	*/
	/*@RequestMapping(value = "/admin/dodajPitanja", method = RequestMethod.GET)
	public ModelAndView adodajPitanja() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUsername(auth.getName());
		modelAndView.setViewName("admin/dodajPitanja");
		return modelAndView;
	}*/
	
	@RequestMapping(value = "/admin/rezultati", method = RequestMethod.GET)
	public ModelAndView arezultati() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUsername(auth.getName());
		modelAndView.setViewName("admin/rezultati");
		return modelAndView;
	}
	
	
	//takmicarove podstranice:
	
	/*@RequestMapping(value = "/takmicar/takmicenje", method = RequestMethod.GET)
	public ModelAndView ttakmicenje() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUsername(auth.getName());
		modelAndView.setViewName("takmicar/takmicenje");
		return modelAndView;
	}*/

	@RequestMapping(value = "/takmicar/rezultati", method = RequestMethod.GET)
	public ModelAndView trezultati() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUsername(auth.getName());
		modelAndView.setViewName("takmicar/rezultati");
		return modelAndView;
	}
}