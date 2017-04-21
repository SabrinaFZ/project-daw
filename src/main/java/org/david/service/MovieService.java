package org.david.service;


import org.david.model.MovieModel;

public interface MovieService {

	public void saveMovie(MovieModel movie);

	public MovieModel findById(int id);
	public MovieModel findByName(String name);
	
	/* Administrar pelicula: Crear, Modificar, Borrar
	 * public void createMovie(MovieModel movie); 
	 * public void updateMovie(MovieModel movie);  
	 * public void deleteMovie(MovieModel movie);  
	 */
	
}//interface
