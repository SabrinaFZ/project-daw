package org.sabDav.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sabDav.model.MovieModel;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	

	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("home");
		modelAndView.addObject("searchMovie", new MovieModel());
		return modelAndView;
	}
	
	
	@RequestMapping(value={"/logout"}, method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 ModelAndView modelAndView = new ModelAndView();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);	       
			modelAndView.setViewName("/components/login/login");
	    }
	    return modelAndView;
	}
	
}
