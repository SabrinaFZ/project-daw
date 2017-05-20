package org.sabDav.model;

public class FormModel {
	
    private String title;
	private int year;
	private String director;
	private int rating;

	//Empty constructor
	public FormModel(){}

	/* Getters and Setters */	
	public String getTitle() {
		return title;
	}//getTitle

	public void setTitle(String title) {
		this.title = title;
	}//setTitle

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

	public int getRating() {
		return rating;
	}//getRating

	public void setRating(int rating) {
		this.rating = rating;
	}//setRating
     
}//FormModel
