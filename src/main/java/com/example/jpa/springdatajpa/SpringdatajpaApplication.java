package com.example.jpa.springdatajpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan({"com.service.bcd","com.example.jpa.springdatajpa"})
public class SpringdatajpaApplication {

	
	private final static Logger logger = LoggerFactory.getLogger(SpringdatajpaApplication.class);
	
	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringdatajpaApplication.class, args);
		logger.info("_____________________________________________");
		for(String s:applicationContext.getBeanDefinitionNames()) {
			logger.info(s);
		}
		logger.info("_____________________________________________");
	}

}
