package com.example.SprringAop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;



@RunWith(JUnitPlatform.class)
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@TestConfiguration 
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class FirstTest {
	
	
	public FirstTest() {
		// TODO Auto-generated constructor stub
	}

	
	
	
	private int sum = 1;
	 
    @Test
    void addingTwoReturnsThree() {
        sum += 2;
        Assertions.assertEquals(3, sum);
        System.out.println("testinstance check addtwo ="+sum);
    }
 
    @Test
    void addingThreeReturnsFour() {
        sum += 3;
        Assertions.assertEquals(4, sum);
        System.out.println("testinstance check addthree ="+sum);
    }
	
	@DisplayName("BeforeMethod")
	@BeforeEach
	public void BeforeMethod()
	{
		System.out.println("repitation of beforemethod");
	}
	
	
	@Test
	@DisplayName("Add operation test")
	@RepeatedTest(value = 1, name = "{displayName} - repetition {currentRepetition} of {totalRepetitions}")
	public void AddNumber( TestInfo  testinfo)
	{
	  System.out.println("addNumberMethod");
	  Assertions.assertEquals(2, 2);
	}
}
