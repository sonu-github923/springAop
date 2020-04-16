package com.example.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.Model.Movie;
import com.example.ResponseModel.CompanyR;

@Component
public class CsResponseSender {

	@Autowired
	private CSToUiconverter ui;
	
	public Movie movieInfobyIdconverterUi()
	{
		return  ui.movieInfobyIdReturn();
	}
	
	public CompanyR companyInfobyIdconverterUi()
	{
		return ui.companyInfobyIdReturn();
	}
	public CsResponseSender() {
		// TODO Auto-generated constructor stub
	}

}
