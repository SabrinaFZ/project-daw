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
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PlayMovieController {

	@Autowired
	private MovieService movieService;

	@RequestMapping("/play/{id}")
    public ModelAndView playMovie(Model model, @PathVariable int id) throws MalformedURLException {
		
		ModelAndView modelAndView = new ModelAndView();
		MovieModel movie = movieService.findById(id);
		if(movie == null){
			modelAndView.setViewName("/components/movie/search");
		}else{
			URL url = new URL(movie.getUrl_movie());
			modelAndView.addObject("successMessage", "Playing movie.");
			model.addAttribute("movie", movie);
			model.addAttribute("url", url);
			modelAndView.setViewName("/components/movie/play");
		}		
		return modelAndView;	
	}//playMovie
	
}//class
