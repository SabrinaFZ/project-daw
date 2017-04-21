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
		FormModel form = new FormModel();
		modelAndView.addObject("form", form);		
		modelAndView.setViewName("/components/movie/search");
		return modelAndView;
    }//searchMovieForm

	@RequestMapping(value="search", method = RequestMethod.POST)
    public ModelAndView searchMovieSubmit(@Valid @ModelAttribute("form") FormModel form, BindingResult result, Model model){
		
		ModelAndView modelAndView = new ModelAndView();
		
		MovieModel movie = movieService.findByName(form.getTitle());
		if(movie == null){
			result.rejectValue("title", "error.form", "* There is no movie with the title provided");
		}
		if(result.hasErrors()){
			modelAndView.setViewName("/components/movie/search");
		}else{
			//TODO Revisar: 'movie' como lista de peliculas?
			modelAndView.addObject("successMessage", "There is at least one movie with this name.");
			model.addAttribute("movie", movie);
			model.addAttribute("id", movie.getId());
			modelAndView.setViewName("/components/movie/result");
		}		
		return modelAndView;		
    }//searchMovieSubmit

}//class
