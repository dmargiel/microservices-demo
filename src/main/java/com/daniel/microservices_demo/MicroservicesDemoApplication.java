package com.daniel.microservices_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@SpringBootApplication
public class MicroservicesDemoApplication {

	@RequestMapping("/")
	public String home() {
		// Objec

		return "Cześć, Spring w Dockerze 3";
	}
	

	public static void main(String[] args) {
		SpringApplication.run(MicroservicesDemoApplication.class, args);
	}

}
