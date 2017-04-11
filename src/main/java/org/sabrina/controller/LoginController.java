package org.sabrina.controller;

import javax.validation.Valid;

import org.sabrina.model.UserModel;
import org.sabrina.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value="signup", method =  RequestMethod.GET)
	public ModelAndView signUp(){
		ModelAndView modelAndView = new ModelAndView();
		UserModel user = new UserModel();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("/components/login/signup");
		return modelAndView;
	}
	
	@RequestMapping(value="signup", method = RequestMethod.POST)
	public ModelAndView createUser(@Valid @ModelAttribute("user") UserModel user, BindingResult result, Model model){
		ModelAndView modelAndView = new ModelAndView();
		
		UserModel userExists = userService.findUserByEmail(user.getEmail());
		if(userExists != null){
			result.rejectValue("email", "error.user", "* There is already a user registered with the email provided");
		}
		if(result.hasErrors()){
			modelAndView.setViewName("/components/login/signup");
		}else{
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			model.addAttribute("user", new UserModel());
			modelAndView.setViewName("/components/login/signup");
		}		
		return modelAndView;		
	}
	
	
	
}
