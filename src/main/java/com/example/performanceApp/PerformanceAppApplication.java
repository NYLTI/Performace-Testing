package com.example.performanceApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories("com")
@ComponentScan("com")
public class PerformanceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(PerformanceAppApplication.class, args);
	}

}
