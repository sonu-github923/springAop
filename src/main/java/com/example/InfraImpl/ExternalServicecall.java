package com.example.InfraImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.Interface.MovieInterface;
import com.example.Model.Company;
import com.example.Model.Movie;
import com.example.Model.MovieSummary;
import com.example.ResponseModel.CompanyR;
import com.example.converter.CSToUiconverter;


@Component
public class ExternalServicecall implements  MovieInterface{
	
	@Value("${api.key}")
	private String apiKey;
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CSToUiconverter uiTocs;
	
	@Override
	public Movie movieInfoById(String movieid) {
		MovieSummary moviesummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieid + "?api_key=" +  apiKey +"&language=pt-BR", MovieSummary.class);
	    Movie mv = uiTocs.movieInfobyIdconverter(moviesummary);
		return mv;
	}

	@Override
	public CompanyR companyInfoById(String id) {
		Company comp = restTemplate.getForObject("https://api.themoviedb.org/3/company/"+ id +"?api_key=" + apiKey, Company.class);
		CompanyR CompR = uiTocs.companyInforbyIdconverter(comp);
		return CompR;
	}
	
	
	
	

}
