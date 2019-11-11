package com.ae.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AeMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AeMicroserviceApplication.class, args);
		System.out.println("Spring boot appling is running");
	}

}
