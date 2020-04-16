package com.example.ResponseModel;

public class CompanyR {

	
	private String description;
	private String headquater;
	private String homepage;
	private String id;
	private String logo_path;
	private String origin_country;
	private String parent_country;
	
	
	public CompanyR(String description, String headquater, String homepage, String id, String logo_path,
			String origin_country, String parent_country) {
		super();
		this.description = description;
		this.headquater = headquater;
		this.homepage = homepage;
		this.id = id;
		this.logo_path = logo_path;
		this.origin_country = origin_country;
		this.parent_country = parent_country;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getHeadquater() {
		return headquater;
	}


	public void setHeadquater(String headquater) {
		this.headquater = headquater;
	}


	public String getHomepage() {
		return homepage;
	}


	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getLogo_path() {
		return logo_path;
	}


	public void setLogo_path(String logo_path) {
		this.logo_path = logo_path;
	}


	public String getOrigin_country() {
		return origin_country;
	}


	public void setOrigin_country(String origin_country) {
		this.origin_country = origin_country;
	}


	public String getParent_country() {
		return parent_country;
	}


	public void setParent_country(String parent_country) {
		this.parent_country = parent_country;
	}


	public CompanyR() {
		// TODO Auto-generated constructor stub
	}

}
