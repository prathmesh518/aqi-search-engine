package com.aqi.aqi_backend;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;

@SpringBootApplication
@EnableCaching
public class AqiBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AqiBackendApplication.class, args);
	}

	@Bean
	public OpenAPI openAPI() {
		return new OpenAPI();
	}
}
