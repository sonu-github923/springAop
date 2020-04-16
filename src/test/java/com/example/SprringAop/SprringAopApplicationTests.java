package com.example.SprringAop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;
import org.hibernate.validator.constraints.ModCheck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit.jupiter.SpringExtension;



@RunWith(JUnitPlatform.class)
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@TestConfiguration 
@ExtendWith(SpringExtension.class)
@Tag("development")
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class SprringAopApplicationTests {

    //@Autowired
	Gretting gt = new Gretting();
	
	Logger log = LoggerFactory.getLogger(SprringAopApplicationTests.class);
	
	@BeforeEach
	public void beforecheck(TestInfo testInfo)
	{
		System.out.println("check of TestInfo parameter ="+testInfo.getDisplayName());
		log.info("this is logger message in beorecheck method");
	
		
	}

    @Test
    @DisplayName("this is testcheck method")
	public void testcheck()
	{
		System.out.println("this is test method");
		String rt = gt.grett("junit");
		System.out.println(rt);
		Assertions.assertEquals(rt , "junit");
		Throwable evt =Assertions.assertThrows( IllegalArgumentException.class,()->{gt.grett(null);});
		Assertions.assertEquals("Username cannot be blank", evt.getMessage());
		System.out.println("Exception message = "+evt.getMessage());
	}
    
    @Test
    @DisplayName("this is testExceptionFail method")
    //@Disabled("this is not required")
    void testExpectedExceptionFail() {
   
    	String str = null;
    	Assertions.assertThrows(NullPointerException.class, () -> {str.length();
    	//Assertions.assertEquals("this is testExceptionFail method", );
    	log.getName();
      });
    }
    
    
    @Test
    @DisplayName("this is lambdaExpression method")
    public void lambdaExpression_assert()
    {
    	assertEquals(true,true);
    	int [] number = {1,2,3,4,5};
    
    	Assertions.assertAll("number", ()-> assertEquals(number[0],1),
    			                       ()-> assertEquals(number[1],2),
    			                       ()-> assertEquals(number[2],3),
    			                       () -> assertEquals(number[3],4),
    			                       () -> assertEquals(number[4],5)); 
    	
    	//assertEquals
    	Assertions.assertEquals("thakur","thakur");
    	Assertions.assertEquals(2, 2, "2 is equals to 2");
    	Assertions.assertFalse(2>4,"this is assertFalse method");
    	Assertions.assertNotNull(gt);
    	Assertions.assertArrayEquals(new int[] {1,2,3}, new int[] {1,2,3});
    	
    	
    	
    
    }
    
    @Test
    public void assert_assume()
    {
    	System.setProperty("DEV", "PRODUCtion");
    	Assumptions.assumeTrue("PRODUCtion".equals(System.getProperty("DEV")));
    	Assumptions.assumeFalse("PRODUCtion".equals(System.getProperty("cf")));
    	LocalDateTime dt = LocalDateTime.now();
    	//Assumptions.assumeTrue(dt.getDayOfYear() == 11);
    	System.out.println("date of system ="+dt);
    	Assumptions.assumingThat("A".equals("A"),
    	          () -> {
    	               assertEquals(10, 10);
    	               System.out.println("perform below assertions only on the test env");
    	               });
    	


    }
    
    @Test
    public void Assert_timeout()
    {
    	//Assertions.assertTimeout(Duration.ofSeconds(2), ()-> {Thread.sleep(1000)});
    	Assertions.assertTimeout(Duration.ofMillis(200), () -> {
             // Simulate task that takes more than 10 ms.
             Thread.sleep(100);
         });
    }

    public static String gretting()
    {
    	return "this is gretting method";
    }
    
    @Test
    void timeoutNotExceededWithResult() {
        // The following assertion succeeds, and returns the supplied object.
        String actualResult = Assertions.assertTimeout(Duration.ofMillis(200), () -> {
        	Thread.sleep(100);
            return "TCS";
        });
        assertEquals("TCS", actualResult);
        
        String actualResultt = Assertions.assertTimeout(Duration.ofMillis(1) ,SprringAopApplicationTests::gretting);
        Assertions.assertEquals("this is gretting method", actualResultt);
       
  
}
    
    
}