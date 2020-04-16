package com.example.Model;

public class Movie {

	
	private String movieid;
	private String name;
	private String popularity;
	private String description;
	
	
	public String getPopularity() {
		return popularity;
	}


	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}


	public String getMovieid() {
		return movieid;
	}


	public void setMovieid(String movieid) {
		this.movieid = movieid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Movie() {
		// TODO Auto-generated constructor stub
	}


	public Movie(String movieid, String name, String popularity ,String description) {
		super();
		this.movieid = movieid;
		this.name = name;
		this.popularity  =popularity;
		this.description = description;
	}
	
	

}
