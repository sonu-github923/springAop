package com.example.Model;

public class MovieSummary {

	private String id;
	private String title;
	private String popularity;
	private String overview;
	
	
	public String getPopularity() {
		return popularity;
	}


	public void setPopularity(String popularity) {
		this.popularity = popularity;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getOverview() {
		return overview;
	}


	public void setOverview(String overview) {
		this.overview = overview;
	}


	public MovieSummary(String id, String title, String popularity ,String overview) {
		super();
		this.id = id;
		this.title = title;
		this.popularity= popularity;
		this.overview = overview;
	}


	public MovieSummary() {
		// TODO Auto-generated constructor stub
	}

}
