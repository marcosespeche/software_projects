package com.teams.teams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TeamsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TeamsApplication.class, args);

		System.out.println("Running teams microservice at port 8081");
	}

}
