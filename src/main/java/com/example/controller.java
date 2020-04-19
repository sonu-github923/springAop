package com.example;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ConfigurableWebApplicationContext;



@Controller
@RestController
@RequestMapping("/sonu")
public class controller {

	

	@Autowired
	studentservice ab;
	
	@Autowired 
	ConfigurableWebApplicationContext ctx;
	

	//studentservice st=(studentservice)ctx.getBean(studentservice.class);
	
	@RequestMapping(value="/studentdetail")
	//@Cacheable(value="studentdetail")
	public List<studententity> studentdetail() throws InterruptedException{
		//Thread.sleep(5000);
		studentservice st=(studentservice)ctx.getBean(studentservice.class);
		System.out.println("THIS IS REQUEST SCOPE of studentdetail "+st.hashCode());
		//System.out.println("THIS IS REQUEST SCOPE  "+st.hashCode());
		return ab.getstudent();
	}
	
	 
	
   @RequestMapping(value="/studentcount")
   //@Cacheable(value="studentcount")
   public String  studentcount() throws InterruptedException
   {
	   //Thread.sleep(5000);
	   studentservice st=(studentservice)ctx.getBean(studentservice.class);
	   System.out.println("THIS IS REQUEST SCOPE of studentcount "+st.hashCode());
	  return "no of student="+ab.getstudentcount();
   }
   
 
	@RequestMapping(value="/addstudent", method=RequestMethod.POST)
	public void addstudent(@RequestBody studententity std,HttpServletRequest request,HttpServletResponse response)
	{
		ab.addstudentdetail(std);
		response.setHeader("Location-", request.getRequestURL().append("/").append(std.getId()).toString());
	}
	@RequestMapping(value="/getstudentbyid/{id}",method=RequestMethod.GET)
	//@Cacheable(value="getstudentbyid")
	public Optional<studententity> getstudentbyid(@PathVariable("id") int id) //throws InterruptedException
	{
		//Thread.sleep(5000);
		studentservice st=(studentservice)ctx.getBean(studentservice.class);
		System.out.println("THIS IS REQUEST SCOPE of studentdetail "+st.hashCode());
		return ab.studentbyidd(id);
	}
	
	@RequestMapping(value ="/getstudentbyemail" , method=RequestMethod.POST)
	public List<studententity> getstudentbyname(@RequestBody studententity std)
	{
		studentservice st=(studentservice)ctx.getBean(studentservice.class);
		System.out.println("THIS IS REQUEST SCOPE of getstudentbyemail "+st.hashCode());
		return ab.studentbyemail(std.getEmailid());
	}
	
	@RequestMapping(value="/updatestudent/{id}", method=RequestMethod.PUT)
	public String updatestudent(@PathVariable("id") int id,@RequestBody studententity  bd,HttpServletRequest request,HttpServletResponse response)
	{
		if(id==bd.getId())
		{
		response.setHeader("Location-", request.getRequestURL().toString());
	   return ab.updatedetails(bd,id);
		}
		else
		{
			return "not updated";
		}
	   
	}
	
	@RequestMapping(value="/deletestudentbyid/{id}",method=RequestMethod.DELETE)
	public String deletestudentbyid(@PathVariable("id") int ID,studententity st)
	{
		String a=ab.deletestd(ID);
		return a;
		
	}
}
