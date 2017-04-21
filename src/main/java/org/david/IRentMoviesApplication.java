package org.david;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IRentMoviesApplication {
	
	public static final Logger logger = Logger.getLogger(IRentMoviesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(IRentMoviesApplication.class, args);
	}//main
	
}//class

