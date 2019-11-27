package com.safefood.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import com.safefood.support.Parser;


@SpringBootApplication
@PropertySource("application.properties")
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		Parser tmp=new Parser();
		tmp.Parser();
		
	}

}
