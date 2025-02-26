package com.uygardeniz.personalbooklibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.uygardeniz.models")
@ComponentScan(basePackages = "com.uygardeniz")
@EnableJpaRepositories(basePackages = "com.uygardeniz.repository")
public class PersonalBookLibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalBookLibraryApplication.class, args);
	}

}
