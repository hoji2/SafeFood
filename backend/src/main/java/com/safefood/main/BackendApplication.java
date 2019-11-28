package com.safefood.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.safefood.support.Parser;


@SpringBootApplication
@ComponentScan("com.safefood.support")
public class BackendApplication {
	
	@Autowired
	private static Parser parser;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		parser.setParser();
	}
	


}
