package com.example.BusinnessLogic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.InfraImpl.ExternalServicecall;
import com.example.Model.Movie;
import com.example.ResponseModel.CompanyR;
import com.example.converter.CSToUiconverter;
import com.example.converter.CsResponseSender;


@Component("MovieBl")
public class MovieBl {

	@Autowired
	private ExternalServicecall extcall;
	
	@Autowired
	private CsResponseSender csSender;
	
	CsResponseSender cv = new CsResponseSender();
	
	public Movie getMoviebyid(String movieid)
	{
		extcall.movieInfoById(movieid);
		return csSender.movieInfobyIdconverterUi();
	}
	
	public CompanyR getCompanybyId(String id)
	{
		extcall.companyInfoById(id);
		
		return csSender.companyInfobyIdconverterUi();
		
	}
	public MovieBl() {
		// TODO Auto-generated constructor stub
	}

}
