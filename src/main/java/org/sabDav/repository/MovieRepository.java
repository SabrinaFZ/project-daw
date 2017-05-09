package org.sabDav.repository;


import org.sabDav.model.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("movieRepository")
public interface MovieRepository extends JpaRepository<MovieModel, Integer>{

	public MovieModel findById(int id);
	public MovieModel findByTitle(String title);
	//TODO Otros metodos de busqueda de peliculas: year, director, valoration, ...	
	public MovieModel findByTitleIgnoreCase(String title);
	
   
	
}//movieRepository
