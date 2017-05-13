package org.sabDav.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SearchMovieController {

	@Autowired
	private MovieService movieService;

	@RequestMapping(value = "search", method = RequestMethod.GET)
    public ModelAndView searchMovieForm() {		
		ModelAndView modelAndView = new ModelAndView();
		FormModel form = new FormModel();
		modelAndView.addObject("form", form);		
		modelAndView.setViewName("/components/movie/search");
		return modelAndView;
    }//searchMovieForm

	@RequestMapping(value="search", method = RequestMethod.POST)
    public ModelAndView searchMovieSubmit(@RequestParam String input, Model model){		
		ModelAndView modelAndView = new ModelAndView();
		
		List<MovieModel> movies = movieService.findByTitleContainingIgnoreCaseOrderByTitleAsc(input);
		if(movies.isEmpty()){
			modelAndView.setViewName("/components/movie/notFound");
		} else {
			modelAndView.addObject("successMessage", "There is at least one movie with this name.");
			model.addAttribute("movies", movies);
			modelAndView.setViewName("/components/movie/result");	
		} //if
		return modelAndView;	
    }//searchMovieSubmit

	@RequestMapping(value = "search/title", method = RequestMethod.GET)
    public ModelAndView SearchByTitleMovieForm() {		
		ModelAndView modelAndView = new ModelAndView();
		FormModel form = new FormModel();
		modelAndView.addObject("form", form);		
		modelAndView.setViewName("/components/movie/searchByTitle");
		return modelAndView;
    }//SearchByTitleMovieForm

	@RequestMapping(value="search/title", method = RequestMethod.POST)
    public ModelAndView SearchByTitleSubmit(@Valid @ModelAttribute("form") FormModel form, BindingResult result, Model model){
		
		ModelAndView modelAndView = new ModelAndView();
		
		List<MovieModel> movies = movieService.findByTitleContainingIgnoreCaseOrderByTitleAsc(form.getTitle());
		if(movies.isEmpty()){
			modelAndView.setViewName("/components/movie/notFound");
		} else if (result.hasErrors()){
			modelAndView.setViewName("/components/movie/searchByTitle");
		} else {
			modelAndView.addObject("successMessage", "There is at least one movie with this name.");
			model.addAttribute("movies", movies);
			modelAndView.setViewName("/components/movie/result");
		} //if
		return modelAndView;		
    }//SearchByTitleSubmit
	
	@RequestMapping(value = "search/director", method = RequestMethod.GET)
    public ModelAndView SearchByDirectorMovieForm() {		
		ModelAndView modelAndView = new ModelAndView();
		FormModel form = new FormModel();
		modelAndView.addObject("form", form);		
		modelAndView.setViewName("/components/movie/searchByDirector");
		return modelAndView;
    }//SearchByDirectorMovieForm

	@RequestMapping(value="search/director", method = RequestMethod.POST)
    public ModelAndView SearchByDirectorSubmit(@Valid @ModelAttribute("form") FormModel form, BindingResult result, Model model){
		
		ModelAndView modelAndView = new ModelAndView();
		
		List<MovieModel> movies = movieService.findByDirectorContainingIgnoreCaseOrderByTitleAsc(form.getDirector());
		if(movies.isEmpty()){
			modelAndView.setViewName("/components/movie/notFound");
		} else if(result.hasErrors()){
			modelAndView.setViewName("/components/movie/searchByTitle");
		} else {
			modelAndView.addObject("successMessage", "There is at least one movie of this director.");
			model.addAttribute("movies", movies);
			modelAndView.setViewName("/components/movie/result");
		} //if
		return modelAndView;		
    }//SearchByDirectorSubmit
	
	@RequestMapping(value = "search/year", method = RequestMethod.GET)
    public ModelAndView SearchByYearMovieForm() {		
		ModelAndView modelAndView = new ModelAndView();
		FormModel form = new FormModel();
		modelAndView.addObject("form", form);		
		modelAndView.setViewName("/components/movie/searchByYear");
		return modelAndView;
    }//SearchByYearMovieForm

	@RequestMapping(value="search/year", method = RequestMethod.POST)
    public ModelAndView SearchByYearSubmit(@Valid @ModelAttribute("form") FormModel form, BindingResult result, Model model){
		
		ModelAndView modelAndView = new ModelAndView();
		
		List<MovieModel> movies = movieService.findByYearOrderByTitleAsc(form.getYear());
		if(movies.isEmpty()){
			modelAndView.setViewName("/components/movie/notFound");
		} else if(result.hasErrors()){
			modelAndView.setViewName("/components/movie/searchByTitle");
		} else {
			modelAndView.addObject("successMessage", "There is at least one movie of this year.");
			model.addAttribute("movies", movies);
			modelAndView.setViewName("/components/movie/result");
		} //if
		return modelAndView;		
    }//SearchByYearSubmit
	
	@RequestMapping(value = "search/rating", method = RequestMethod.GET)
    public ModelAndView SearchByRatingMovieForm() {		
		ModelAndView modelAndView = new ModelAndView();
		FormModel form = new FormModel();
		modelAndView.addObject("form", form);		
		modelAndView.setViewName("/components/movie/searchByRating");
		return modelAndView;
    }//SearchByRatingMovieForm

	@RequestMapping(value="search/rating", method = RequestMethod.POST)
    public ModelAndView SearchByRatingSubmit(@Valid @ModelAttribute("form") FormModel form, BindingResult result, Model model){
		
		ModelAndView modelAndView = new ModelAndView();
		
		List<MovieModel> movies = movieService.findByRatingGreaterThanEqualOrderByTitleAsc(form.getRating());
		if(movies.isEmpty()){
			modelAndView.setViewName("/components/movie/notFound");
		} else if(result.hasErrors()){
			modelAndView.setViewName("/components/movie/searchByRating");
		} else {
			modelAndView.addObject("successMessage", "There is at least one movie of this year.");
			model.addAttribute("movies", movies);
			modelAndView.setViewName("/components/movie/result");
		} //if
		return modelAndView;		
    }//SearchByYearSubmit
	

}//class
