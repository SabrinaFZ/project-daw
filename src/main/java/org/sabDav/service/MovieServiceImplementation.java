package org.sabDav.service;

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
	public MovieModel findByName(String name) {
		return movieRepository.findByName(name);
	}//findByName

	@Override
	public void saveMovie(MovieModel movie) {
		
		//TODO Comprobacion campos completos
		
		movieRepository.save(movie);
	}//saveMovie


	// TODO Otros metodos de busqueda de peliculas: year, director, valoration,
	// ...

	/* Administrar pelicula: Crear, Modificar, Borrar
	 * public void createMovie(MovieModel movie) { //TODO } 
	 * public void updateMovie(MovieModel movie) { //TODO }   
	 * public void deleteMovie(MovieModel movie) { //TODO }   
	 */
}// class
