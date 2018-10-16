package com.codecool.wineREST;

import com.codecool.wineREST.services.ProducentService;
import com.codecool.wineREST.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class WineRestApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private ProducentService producentService;

	public static void main(String[] args) {

		SpringApplication.run(WineRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userService.createUser("edobkowski", "Eryk", "Dobkowski");
		userService.getAll();

		producentService.createProducent("Polower");
		producentService.createProducent("Solo");



	}
}
