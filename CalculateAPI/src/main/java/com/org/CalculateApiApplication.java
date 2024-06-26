package com.org;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculateApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalculateApiApplication.class, args);
		System.out.println("Application is Started Sucessfully...");
	}

}
