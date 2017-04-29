package org.sabDav.controller;

import javax.validation.Valid;

import org.sabDav.configuration.SecurityConfiguration;
import org.sabDav.model.UserModel;
import org.sabDav.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value={"/", "login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/components/login/login");
		return modelAndView;
	}
	
	
	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public ModelAndView home(){
		System.out.println("paso2");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
	
}
