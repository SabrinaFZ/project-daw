package org.david.model;

import javax.persistence.*;
import org.hibernate.validator.constraints.*;

@Entity
@Table(name="movie")
public class MovieModel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="movie_id")
	private int id;	
	@Column(name="name")
	@NotEmpty(message="*Please provide the name of the movie.*")
	private String name;
	@Column(name="url_movie")
	@NotEmpty(message="*Please provide the URL of the movie.*")
	private String url_movie;
	@Column(name="description")
	@NotEmpty(message="*Please provide the sinopsis of the movie.*")
	private String description;
	@Column(name="year")
	@NotEmpty(message="*Please provide the release year of the movie.*")
	private int year;
	@Column(name="director")
	@NotEmpty(message="*Please provide the director of the movie.*")
	private String director;
	@Column(name="cast")
	@NotEmpty(message="*Please provide the cast actors of the movie.*")
	private String cast;	
	@Column(name="url_cover")
	@NotEmpty(message="*Please provide the URL of the cover image.*")
	private String url_cover;
	@Column(name="rating")
	@NotEmpty(message="*Please provide the valoration of the movie.*")
	private double rating;
	
	//Empty constructor
	public MovieModel(){}

	/* Getters and Setters */	
	
	public int getId() {
		return id;
	}//getId

	public void setId(int id) {
		this.id = id;
	}//setId

	public String getName() {
		return name;
	}//getName

	public void setName(String name) {
		this.name = name;
	}//setName

	public String getUrl_movie() {
		return url_movie;
	}//getUrl_movie

	public void setUrl_movie(String url_movie) {
		this.url_movie = url_movie;
	}//setUrl_movie

	public String getDescription() {
		return description;
	}//getDescription

	public void setDescription(String description) {
		this.description = description;
	}//setDescription

	public int getYear() {
		return year;
	}//getYear

	public void setYear(int year) {
		this.year = year;
	}//setYear

	public String getDirector() {
		return director;
	}//getDirector

	public void setDirector(String director) {
		this.director = director;
	}//setDirector

	public String getCast() {
		return cast;
	}//getCast

	public void setCast(String cast) {
		this.cast = cast;
	}//setCast

	public String getUrl_cover() {
		return url_cover;
	}//getUrl_cover

	public void setUrl_cover(String url_cover) {
		this.url_cover = url_cover;
	}//setUrl_cover

	public double getRating() {
		return rating;
	}//getRating

	public void setRating(double rating) {
		this.rating = rating;
	}//setRating
	
}//class
