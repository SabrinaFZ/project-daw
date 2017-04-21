package org.david.repository;


import org.david.model.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("movieRepository")
public interface MovieRepository extends JpaRepository<MovieModel, Long>{

	public MovieModel findById(int id);
	public MovieModel findByName(String name);
	//TODO Otros metodos de busqueda de peliculas: year, director, valoration, ...
	
}//movieRepository
