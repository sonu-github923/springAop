package com.example.SprringAop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
@Component("studentServiceMock")
public class studentServiceMock {

	public studentServiceMock() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	StudentRepo studentrepo;
	public List<studententity> getstudent()
	{
		List<studententity> allstudent=new ArrayList<studententity>();
		studentrepo.findAll().forEach(s ->allstudent.add(s));
		return allstudent;
	}
	
	//@Cacheable(value="studentcount")
	public int getstudentcount()
	{
		int p;
		p=(int)studentrepo.count();
		return p;
	}
	
	public void addstudentdetail(studententity std)
	{
		studentrepo.save(std);
	}
	
	
	public Optional<studententity> studentbyidd(int id)
	{
		return studentrepo.findById(id);
	}
	
	public List<studententity> studentbyemail(String email)
	{
		return studentrepo.findByemailid(email);
	}
	
	public String updatedetails(studententity dt, int id)
	{
		if(studentrepo.existsById(id))
		{
		 studentrepo.save(dt);
		 return "updated";
		}
		else
		{
		return "not found";	
		}
	}
	
	public String deletestd(int id)
	{
		if(studentrepo.existsById(id))
		{
		studentrepo.deleteById(id);
		return "deleted";
		}
		else
		{
			return "id id not exist";
		}
	}

	
	public List<studententity> Tcheck(String email)
	{
		studentServiceMock sc = new studentServiceMock();
		List<studententity> et = sc.getstudent();
		System.out.println("studnetentity = "+et);
		studententity wt = new studententity(1,"sonu kumar", 23 , "s@gmail.com"); 
		//List<studententity> jh = sc.studentbyemail(email);
		
		for(studententity  zc: et)
		{
			if(zc.getEmailid()== email)
			{
				
				//int id = zc.getId();
				//sc.updatedetails(wt, 1);
				sc.deletestd(1);
				return sc.getstudent();
			}
		}
		return sc.getstudent();
	}
}
