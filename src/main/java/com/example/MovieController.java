package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.BusinnessLogic.MovieBl;
import com.example.Model.Movie;
import com.example.Model.MovieSummary;
import com.example.ResponseModel.CompanyR;

@RestController
@RequestMapping("/movie")
public class MovieController {

	@Autowired
	private MovieBl mvb;
	
	
	@RequestMapping(value="/movielist/{movieid}")
	public Movie getMovieInfo(@PathVariable("movieid") String movieid)
	{
		return mvb.getMoviebyid(movieid);
		
	}
	
	@RequestMapping(value="/companydetail/{id}")
	public CompanyR getcompanydetail(@PathVariable("id") String id)
	{
		return mvb.getCompanybyId(id);
	}


	public MovieController() {
		// TODO Auto-generated constructor stub
	}

}
