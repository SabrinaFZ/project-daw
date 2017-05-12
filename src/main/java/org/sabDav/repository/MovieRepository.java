package org.sabDav.repository;


import java.util.List;

import org.sabDav.model.MovieModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("movieRepository")
public interface MovieRepository extends JpaRepository<MovieModel, Integer>{

	//Comprobacion de existencia y acceso a pelicula.
	public MovieModel findById(int id);
	public MovieModel findByTitle(String title);
	public MovieModel findByTitleIgnoreCase(String title);
	
	//Metodos para busqueda.
	public List<MovieModel> findByTitleContainingIgnoreCaseOrderByTitleAsc(String title);
	public List<MovieModel> findByTitleStartsWithOrderByTitleAsc(char letter);
	public List<MovieModel> findByYearOrderByTitleAsc(int year);
	public List<MovieModel> findByDirectorContainingIgnoreCaseOrderByTitleAsc(String director);
	public List<MovieModel> findByRatingGreaterThanEqualOrderByTitleAsc(int rating);
   
	
}//movieRepository
