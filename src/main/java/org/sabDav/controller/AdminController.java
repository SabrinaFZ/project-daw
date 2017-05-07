package org.sabDav.controller;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.sabDav.model.MovieModel;
import org.sabDav.model.UserModel;
import org.sabDav.service.MovieService;
import org.sabDav.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@Autowired 
	private MovieService movieService;
	
	@RequestMapping(value={"/admin"}, method = RequestMethod.GET)
	public ModelAndView admin(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/admin");
		return modelAndView;
	}
	
	@RequestMapping(value={"/admin/users"}, method = RequestMethod.GET)
	public ModelAndView getAllUsers(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("users", userService.getUserRepository().findAll());
		modelAndView.setViewName("/components/admin/users");
		return modelAndView;
	}
	
	@RequestMapping(value={"/admin/users/{id}"}, method = RequestMethod.GET)
	public ModelAndView getUser(@PathVariable int id){
		ModelAndView modelAndView = new ModelAndView();
		UserModel user = userService.getUserRepository().findById(id);
		modelAndView.addObject("user", user);
		modelAndView.setViewName("/components/admin/userInfo");
		return modelAndView;
	}
	
	@RequestMapping(value={"/admin/users/{id}"}, method = RequestMethod.DELETE)
	public ModelAndView removeUser(@PathVariable int id){
		ModelAndView modelAndView = new ModelAndView();
		UserModel user = userService.getUserRepository().findById(id);
		userService.getUserRepository().delete(user);
		modelAndView.setViewName("/components/admin/users");
		modelAndView.addObject("users", userService.getUserRepository().findAll());
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/users/signup", method =  RequestMethod.GET)
	public ModelAndView signUp(){
		ModelAndView modelAndView = new ModelAndView();
		UserModel user = new UserModel();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("/components/login/signup");
		return modelAndView;
	}
	
	
	
	@RequestMapping(value="/admin/users/signup", method = RequestMethod.POST)
	public ModelAndView createUser(@Valid @ModelAttribute("user") UserModel user, BindingResult result, Model model){
		ModelAndView modelAndView = new ModelAndView();
		
		UserModel userExists = userService.findUserByUsername(user.getUsername());
		if(userExists != null){
			result.rejectValue("username", "error.user", "* There is already a user registered with the username provided");
		}
		if(result.hasErrors()){
			modelAndView.setViewName("/components/login/signup");
		}else{
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been created successfully");
			model.addAttribute("user", new UserModel());
			modelAndView.setViewName("/components/login/signup");
		}		
		return modelAndView;		
	}
	
	@RequestMapping(value={"/admin/movies"}, method = RequestMethod.GET)
	public ModelAndView getAllMovies(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("movies", movieService.getMovieRepository().findAll());
		modelAndView.setViewName("/components/admin/movies");
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/movies/formMovie", method =  RequestMethod.GET)
	public ModelAndView addMovie(){
		ModelAndView modelAndView = new ModelAndView();
		MovieModel movie =  new MovieModel();
		modelAndView.addObject("movie", movie);
		modelAndView.setViewName("/components/admin/formMovie");
		return modelAndView;
	}
	
	@RequestMapping(value={"/admin/movies/{id}"}, method = RequestMethod.GET)
	public ModelAndView getMovie(@PathVariable int id){
		ModelAndView modelAndView = new ModelAndView();
		MovieModel movie = movieService.findById(id);
		modelAndView.addObject("movie", movie);
		modelAndView.setViewName("/components/admin/movieInfo");
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/movies/formMovie", method = RequestMethod.POST)
	public ModelAndView createMovie(@Valid @ModelAttribute("movie") MovieModel movie, BindingResult result, Model model){
		ModelAndView modelAndView = new ModelAndView();
		
		MovieModel movieExists = movieService.findByTitle(movie.getTitle());
		if(movieExists != null){
			result.rejectValue("title", "error.movie", "* There is already a movie in the database with the title provided");
		}
		
		if(result.hasErrors()){
			modelAndView.setViewName("/components/admin/formMovie");
		}else{
			movieService.saveMovie(movie);
			modelAndView.addObject("successMessage", "Movie has been created successfully");
			model.addAttribute("movie", new MovieModel());
			modelAndView.setViewName("/components/admin/formMovie");
		}		
		return modelAndView;		
	}
	
	@RequestMapping(value={"/admin/movies/{id}"}, method = RequestMethod.DELETE)
	public ModelAndView removeMovie(@PathVariable int id){
		ModelAndView modelAndView = new ModelAndView();
		MovieModel movie = movieService.getMovieRepository().findById(id);
		movieService.getMovieRepository().delete(movie);
		modelAndView.setViewName("/components/admin/movies");
		modelAndView.addObject("movies", movieService.getMovieRepository().findAll());
		return modelAndView;
	}
	

}
