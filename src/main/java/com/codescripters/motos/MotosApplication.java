package com.codescripters.motos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MotosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MotosApplication.class, args).getBean(MongoConfig.class);
	}

}
