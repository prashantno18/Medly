package com.medly.screen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@EntityScan(basePackages = "com.medly")
public class MedlyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedlyApplication.class, args);
	}

}
