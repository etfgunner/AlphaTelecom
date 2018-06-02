package com.alphaTelecom.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.alphaTelecom.model.User;
import com.alphaTelecom.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@RequestMapping(value = { "/", "/homepage" }, method = RequestMethod.GET)
	public ModelAndView homepage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("homepage");
		return modelAndView;
	}

	@RequestMapping(value = { "/administrator/home" }, method = RequestMethod.GET)
	public ModelAndView adminPanel() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/administrator/home");
		return modelAndView;
	}
	
	@RequestMapping(value = { "/ponude" }, method = RequestMethod.GET)
	public ModelAndView ponuda() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("ponude");
		return modelAndView;
	}
	
	

}