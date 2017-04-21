package org.david.controller;

import org.david.model.MovieModel;
import org.david.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchMovieController {

//	@Autowired
//	private MovieService movieService;
	
	@RequestMapping (value="/search", method = RequestMethod.POST)
	public ModelAndView searchMovie(@RequestParam String name) {
		
		//TODO Comprobar informacion de sesion (usuario logeado)
		
		ModelAndView modelAndView = new ModelAndView();
		
		//TODO
		
		modelAndView.setViewName("/components/movie/search");
		return modelAndView.addObject("result", name);
	}//searchMovie()

	@RequestMapping("/results")
	public ModelAndView showResults() {
		ModelAndView modelAndView = new ModelAndView();

		//TODO

		modelAndView.setViewName("/components/movie/results");
		return modelAndView;
	}//showResults
	
}//class
