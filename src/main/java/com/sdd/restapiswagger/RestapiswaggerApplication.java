package com.sdd.restapiswagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class RestapiswaggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapiswaggerApplication.class, args);
	}

}
