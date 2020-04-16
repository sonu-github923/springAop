package com.example.SprringAop;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@RunWith(JUnitPlatform.class)
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class MockTesting {

	public MockTesting() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Mock
	studentServiceMock stdSerMock;
	
	
	@Autowired
	studentservice stdser;
	
//	public void setup()
//	{
//		MockitoAnnotations.initMocks(this);
//	}
	
	
	@Test
	public void Testcheck()
	{
		int count =8;
		System.out.println("this is studentcount mock test");
		when(stdSerMock.getstudentcount()).thenReturn(count);
		
		int exp = stdSerMock.getstudentcount();
		System.out.println("exp value="+exp);
		int act =  stdser.getstudentcount();
		System.out.println("act value="+act);
		Assertions.assertEquals(exp, act);
		
	}
	
	
	@Test
	public void TestbyId()
	{
		System.out.println("this is TestbyId mock test");
		String eml ="s@gmail.com";
		studententity studtst = new studententity(1,"sonu kumar",22,"s@gmail.com");
		List<studententity> sdd = new ArrayList<studententity>();
		sdd.add(studtst);
		when(stdSerMock.studentbyemail(eml)).thenReturn(sdd);
		List<studententity> ste = stdSerMock.studentbyemail("s@gmail.com");
		List<studententity> sta = stdser.studentbyemail("s@gmail.com");
		Assertions.assertEquals(ste.get(0).getAge(), sta.get(0).getAge());
	}
	
	
	 @Mock
     private List<String> mocklist;
     
     
	@Test
	public void checkverify()
	{
		
		String addstring ="sonu kumar";
		mocklist.add(addstring);
		mocklist.add("sristy sharma");
		verify(mocklist , times(1)).add("sonu kumar");
		verify(mocklist , never()).add("kumar");
		
	}
	
	
	@Test
	public void Testverfy()
	{
		studententity nh = new studententity(1,"sonu kumar" ,22,"s@gmail.com");
		studententity mk = new studententity(2,"ashu kumar" ,24,"as@gmail.com");
		
		List<studententity> vc = new ArrayList<studententity>();
		vc.add(nh);
		vc.add(mk);
		System.out.println("student sonu="+vc.get(0)+" "+vc.get(1));
		//when(stdSerMock.studentbyemail("s@gmail.com")).thenReturn(vc);
		when(stdSerMock.getstudent()).thenReturn(vc);
		
		stdSerMock.Tcheck("s@gmail.com");
		int id=1;
		verify(stdSerMock).deletestd(id);
			
		
		
	} 

}
