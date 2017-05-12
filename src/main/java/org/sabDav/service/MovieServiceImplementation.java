package org.sabDav.service;

import java.util.List;

import org.sabDav.model.MovieModel;
import org.sabDav.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("movieService")
public class MovieServiceImplementation implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Override
	public MovieModel findById(int id) {
		return movieRepository.findById(id);
	}//findById
	
	@Override
	public MovieModel findByTitle(String title) {
		return movieRepository.findByTitle(title);
	}//findByTitle
	
	@Override
	public MovieModel findByTitleIgnoreCase(String title) {
		return movieRepository.findByTitleIgnoreCase(title);
	}//findByTitleIgnoreCase
	
	// TODO Otros metodos de busqueda de peliculas: year, director, valoration,
		// ...
	
	@Override
	public MovieRepository getMovieRepository() {
		return movieRepository;
	}//getMovieRepository

	@Override
	public void saveMovie(MovieModel movie) {
		movieRepository.save(movie);
	}//saveMovie

	@Override
	public List<MovieModel> findByTitleContainingIgnoreCaseOrderByTitleAsc(String title) {
		return movieRepository.findByTitleContainingIgnoreCaseOrderByTitleAsc(title);
	}//findByTitleContainingIgnoreCase

	@Override
	public List<MovieModel> findByYearOrderByTitleAsc(int year) {
		return movieRepository.findByYearOrderByTitleAsc(year);
	}//findByYearOrderByTitleAsc

	@Override
	public List<MovieModel> findByDirectorContainingIgnoreCaseOrderByTitleAsc(String title) {
		return movieRepository.findByDirectorContainingIgnoreCaseOrderByTitleAsc(title);
	}//findByDirectorContainingIgnoreCaseOrderByTitleAsc

	@Override
	public List<MovieModel> findByRatingGreaterThanEqualOrderByTitleAsc(int rating) {
		return movieRepository.findByRatingGreaterThanEqualOrderByTitleAsc(rating);
	}//findByRatingGreaterThanEqualOrderByTitleAsc

	@Override
	public List<MovieModel> findByTitleStartsWithOrderByTitleAsc(char letter) {
		return movieRepository.findByTitleStartsWithOrderByTitleAsc(letter);
	}//findByTitleStartsWith

	
	
	/* Administrar pelicula: Crear, Modificar, Borrar
	 * public void createMovie(MovieModel movie) { //TODO } 
	 * public void updateMovie(MovieModel movie) { //TODO }   
	 * public void deleteMovie(MovieModel movie) { //TODO }   
	 */
	
}// class
