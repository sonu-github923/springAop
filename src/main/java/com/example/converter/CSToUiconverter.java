package com.example.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.InfraImpl.ExternalServicecall;
import com.example.Model.Company;
import com.example.Model.Movie;
import com.example.Model.MovieSummary;
import com.example.ResponseModel.CompanyR;


@Component
public class CSToUiconverter {

	@Autowired
	private ExternalServicecall extsercall;
	Movie mv = new Movie();
	CompanyR comp = new CompanyR();
	
	public Movie movieInfobyIdconverter(MovieSummary Msummary)
	{
		
		
		mv.setMovieid(Msummary.getId());
		mv.setName(Msummary.getTitle());
		mv.setDescription(Msummary.getOverview());
		mv.setPopularity(Msummary.getPopularity());
		return mv;
	}
	
	public Movie movieInfobyIdReturn() {
		return mv;
	}
	
	public CompanyR companyInforbyIdconverter(Company compr)
	{
		comp.setDescription(compr.getDescription());
		comp.setHeadquater(compr.getHeadquater());
		comp.setHomepage(compr.getHomepage());
		comp.setId(compr.getId());
		comp.setLogo_path(compr.getLogo_path());
		comp.setOrigin_country(compr.getOrigin_country());
		comp.setParent_country(compr.getParent_country());
		
		return comp;
	}
	
	public CompanyR companyInfobyIdReturn()
	{
		return comp;
	}
	public CSToUiconverter() {
		// TODO Auto-generated constructor stub
	}

}
