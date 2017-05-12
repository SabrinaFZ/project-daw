package org.sabDav.service;


import java.util.List;

import org.sabDav.model.MovieModel;
import org.sabDav.repository.MovieRepository;

public interface MovieService {

	public void saveMovie(MovieModel movie);

	public MovieModel findById(int id);
	public MovieModel findByTitle(String title);
	public MovieModel findByTitleIgnoreCase(String title);

	public MovieRepository getMovieRepository();
	
	public List<MovieModel> findByTitleContainingIgnoreCaseOrderByTitleAsc(String title);
	
	public List<MovieModel> findByTitleStartsWithOrderByTitleAsc(char letter);

	public List<MovieModel> findByYearOrderByTitleAsc(int year);

	public List<MovieModel> findByDirectorContainingIgnoreCaseOrderByTitleAsc(String title);

	public List<MovieModel> findByRatingGreaterThanEqualOrderByTitleAsc(int rating);

	
	/* Administrar pelicula: Crear, Modificar, Borrar
	 * public void createMovie(MovieModel movie); 
	 * public void updateMovie(MovieModel movie);  
	 * public void deleteMovie(MovieModel movie);  
	 */
	
}//interface
