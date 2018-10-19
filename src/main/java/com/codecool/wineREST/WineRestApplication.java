package com.codecool.wineREST;

import com.codecool.wineREST.helpers.DBGenerator;
import com.codecool.wineREST.services.ProducentService;
import com.codecool.wineREST.services.RegionService;
import com.codecool.wineREST.services.UserService;
import com.codecool.wineREST.services.WineService;
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

	@Autowired
    private WineService wineService;

    @Autowired
    private RegionService regionService;

    @Autowired
	private DBGenerator dbGenerator;

	public static void main(String[] args) {

		SpringApplication.run(WineRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		dbGenerator.populateDB();
	}
}
