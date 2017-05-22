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
	
	@RequestMapping(value = "search/options", method = RequestMethod.GET)
    public ModelAndView searchOptionsForm() {		
		ModelAndView modelAndView = new ModelAndView();	
		FormModel form = new FormModel();
		modelAndView.addObject("form", form);
		modelAndView.setViewName("/components/movie/search");
		return modelAndView;
    }//searchOptionsForm

	@RequestMapping(value="search/options", method = RequestMethod.POST)
	public ModelAndView searchOptionsSubmit(@Valid @ModelAttribute("form") FormModel form, BindingResult result, 
			 @RequestParam(value="searchType", required=true) String searchType, Model model){
		
		ModelAndView modelAndView = new ModelAndView();
		List<MovieModel> movies = null;
		
		switch(searchType) {
			case "title":
				movies = movieService.findByTitleContainingIgnoreCaseOrderByTitleAsc(form.getTitle());
	            break;
	        case "year":
	        	movies = movieService.findByYearOrderByTitleAsc(form.getYear());
	            break;
	        case "director":
	        	movies = movieService.findByDirectorContainingIgnoreCaseOrderByTitleAsc(form.getDirector());
	            break;
	        case "rating":
	        	movies = movieService.findByRatingGreaterThanEqualOrderByTitleAsc(form.getRating());
	            break;
	        default:
	        	modelAndView.setViewName("/components/movie/search");
	        	return modelAndView;
		}//switch
		
		if(movies.isEmpty()){
			modelAndView.setViewName("/components/movie/notFound");
		} else if(result.hasErrors()){
			modelAndView.setViewName("/components/movie/search");
		} else {
			modelAndView.addObject("successMessage", "There is at least one movie of this year.");
			model.addAttribute("movies", movies);
			modelAndView.setViewName("/components/movie/result");
		} //if
		
		return modelAndView;		
    }//searchOptionsSubmit
	
}//class
