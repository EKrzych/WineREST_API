package com.codecool.wineREST;

import com.codecool.wineREST.services.ProducentService;
import com.codecool.wineREST.services.RegionService;
import com.codecool.wineREST.services.UserService;
import com.codecool.wineREST.services.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDate;

@SpringBootApplication
@EnableJpaAuditing
public class WineRestApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private ProducentService producentService;

	@Autowired
    private WineService wineService;

    @Autowired
    private RegionService regionService;

	public static void main(String[] args) {

		SpringApplication.run(WineRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userService.createUser("edobkowski", "Eryk", "Dobkowski");
		userService.getAll();

		producentService.createProducent("Polower");
		producentService.createProducent("Solo");

        regionService.createRegion("Abbruzzo", "Italy");
        regionService.createRegion("BBBBBB", "France");

		wineService.createWine("BeautyBlue", "Chardonney", "White", "Dry", (long)1, (long)3, LocalDate.now());

        wineService.createWine("RedCredit", "CCCCCC", "Red", "Dry", (long)1, (long)4, LocalDate.now());



	}
}
