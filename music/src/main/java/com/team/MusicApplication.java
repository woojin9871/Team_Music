package com.team;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

//@SpringBootApplication
//public class MusicApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(MusicApplication.class, args);
//	}
//
//}

@SpringBootApplication
public class MusicApplication extends SpringBootServletInitializer {
   @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MusicApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MusicApplication.class, args);
    }

	
	
}
