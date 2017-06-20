package org.sabDav;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class IRentMoviesApplication extends SpringBootServletInitializer{
	
	public static final Logger logger = Logger.getLogger(IRentMoviesApplication.class);
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(IRentMoviesApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(IRentMoviesApplication.class, args);
	}
	
}

