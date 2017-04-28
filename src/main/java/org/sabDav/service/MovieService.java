package org.sabDav.service;


import org.sabDav.model.MovieModel;

public interface MovieService {

	public void saveMovie(MovieModel movie);

	public MovieModel findById(int id);
	public MovieModel findByTitle(String title);
	
	/* Administrar pelicula: Crear, Modificar, Borrar
	 * public void createMovie(MovieModel movie); 
	 * public void updateMovie(MovieModel movie);  
	 * public void deleteMovie(MovieModel movie);  
	 */
	
}//interface
