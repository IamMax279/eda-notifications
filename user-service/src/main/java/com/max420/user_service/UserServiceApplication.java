package com.max420.user_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@EntityScan(basePackages = {"com.max420.user_service.models"})
@ComponentScan(basePackages = {
		"com.max420.user_service.controller",
		"com.max420.user_service.repository",
		"com.max420.user_service.services",
		"com.max420.user_service.config",
		"com.max420.user_service.producers"
})
@SpringBootApplication
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
