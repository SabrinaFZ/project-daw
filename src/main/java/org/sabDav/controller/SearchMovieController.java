package org.sabDav.controller;


import javax.validation.Valid;

import org.sabDav.model.FormModel;
import org.sabDav.model.MovieModel;
import org.sabDav.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchMovieController {

	@Autowired
	private MovieService movieService;

	@RequestMapping(value = "search", method = RequestMethod.GET)
    public ModelAndView searchMovieForm() {
		
		//TODO Comprobar si usuario esta logeado
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("searchMovie", new MovieModel());		
		modelAndView.setViewName("/components/user/search");
		return modelAndView;
    }//searchMovieForm

	@RequestMapping(value="search", method = RequestMethod.POST)
    public ModelAndView searchMovieSubmit(@Valid @ModelAttribute("searchMovie") MovieModel movie, BindingResult result, Model model){
		ModelAndView modelAndView = new ModelAndView();
		if(movie.getTitle() != ""){
			model.addAttribute("movies", movieService.getMovieRepository().findByTitleIgnoreCase(movie.getTitle()));		
		} else{
			modelAndView.addObject("movies", movieService.getMovieRepository().findAll());
		}		
		modelAndView.addObject("searchMovie", new MovieModel());
		modelAndView.setViewName("/components/user/search");
		return modelAndView;
    }//searchMovieSubmit


}//class
