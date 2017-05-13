package org.sabDav.controller;

import java.net.MalformedURLException;
import java.net.URL;

import org.sabDav.model.MovieModel;
import org.sabDav.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlayMovieController {

	@Autowired
	private MovieService movieService;

	@RequestMapping(value="/play/{id}", method = RequestMethod.GET)
    public ModelAndView playMovie(Model model, @PathVariable int id) throws MalformedURLException {
		
		ModelAndView modelAndView = new ModelAndView();
		MovieModel movie = movieService.findById(id);
		modelAndView.addObject("searchMovie", new MovieModel());
		modelAndView.addObject("movie", movie);
		modelAndView.setViewName("/components/user/play");
		
		
		return modelAndView;	
	}//playMovie

	
}//class
