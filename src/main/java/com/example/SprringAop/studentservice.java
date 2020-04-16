package com.example.SprringAop;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



@Service
@Component("studentservice")
public class studentservice {

	
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
	
	public List<studententity> Tcheck(String email , studententity et)
	{
		studentservice sc = new studentservice();
		List<studententity> jh = sc.studentbyemail(email);
		for(studententity  zc: jh)
		{
			if(zc.getEmailid()== email)
			{
				int id = zc.getAge();
				sc.updatedetails(et, id);
				return sc.studentbyemail(email);
			}
		}
		return sc.studentbyemail(email);
	}
}
