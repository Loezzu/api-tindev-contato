package com.tindev.apicontato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ApiContatoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiContatoApplication.class, args);
	}

}
