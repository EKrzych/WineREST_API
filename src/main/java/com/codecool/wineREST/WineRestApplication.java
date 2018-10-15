package com.codecool.wineREST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WineRestApplication {

	public static void main(String[] args) {

		SpringApplication.run(WineRestApplication.class, args);
	}
}
