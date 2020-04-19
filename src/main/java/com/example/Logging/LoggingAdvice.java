package com.example.Logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Aspect
@Component
public class LoggingAdvice {

	public LoggingAdvice() {
		// TODO Auto-generated constructor stub
	}
	
	Logger log =LoggerFactory.getLogger(LoggingAdvice.class);

	@Pointcut(value = "execution(* com.example.controller.*(..))")
	public void mypointcut()
	{
		
	}
	
	@Around("mypointcut()")
	public Object ApplicationLogger(ProceedingJoinPoint pip) throws Throwable
	{
		ObjectMapper objmap =new ObjectMapper();
		String methodname = pip.getSignature().getName();
		String classname = pip.getTarget().getClass().toString();
		Object[] array = pip.getArgs();
		log.info("method invoked " + classname +":" + methodname + ":" + "argument :" +objmap.writeValueAsString(array));
	    Object object = pip.proceed();	
	    log.info("After method excute "+ classname + methodname + "()" + "Response" + objmap.writeValueAsString(object));
		return object;
	}
}
