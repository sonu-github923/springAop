package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.ConfigurableWebApplicationContext;



@SpringBootApplication
@ComponentScan("com.example")
public class SprringAopApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SprringAopApplication.class, args);
		ConfigurableWebApplicationContext ctx=(ConfigurableWebApplicationContext) SpringApplication.run(SprringAopApplication.class, args);
		System.out.println("sonu kumar");
	}
	
	
	@Bean
	public RestTemplate getRestTemplate()
	{
		return new RestTemplate();
	}

}
