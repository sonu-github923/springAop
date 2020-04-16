package com.example.Interface;

import com.example.Model.Movie;
import com.example.Model.MovieSummary;
import com.example.ResponseModel.CompanyR;

public interface MovieInterface {

	public Movie movieInfoById(String movieid); 
	
	public CompanyR companyInfoById(String id);
}
