package com.example;

public class Gretting {

	public Gretting() {
		// TODO Auto-generated constructor stub
	}
	
	public String grett(String ap) 
	{
		if (ap == null) {
			throw new IllegalArgumentException("Username cannot be blank");
			}

		return ap;
}
}
