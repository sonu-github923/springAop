package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="BAGICTABLE")
public class studententity {

	
	    @Id
	    @GeneratedValue
	   private int id;
	   private String name;
	   private int age;
	   private String emailid;
	public  int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public studententity(int id, String name, int age, String emailid) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.emailid = emailid;
	}
	public studententity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
