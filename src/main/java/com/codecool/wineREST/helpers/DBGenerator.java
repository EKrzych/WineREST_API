package com.codecool.wineREST.helpers;

import com.codecool.wineREST.entities.Region;
import com.codecool.wineREST.services.ProducentService;
import com.codecool.wineREST.services.RegionService;
import com.codecool.wineREST.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component
public class DBGenerator {
    @Autowired
    FileReaderCSV fileReaderCSV;
    @Autowired
    ProducentService producentService;
    @Autowired
    RegionService regionService;
    @Autowired
    UserService userService;

    public void populateDB() {
        populateProducers();
        populateRegions();
//        populateWine();
       populateUsers();
//        populateWineRating();
//        populateWineRatingPK();
    }

    private void populateUsers() {
        Path path = Paths.get("/Users/elzbietakrzych/Documents/codecool/ADVANCED/2018_10_15_TW/spring-boot-project-edobkowski/src/main/resources/Users.csv");
        List<String> users = fileReaderCSV.readData(path);
        for(String user : users) {
            String[] usersData = user.split(",");
            userService.createUser(usersData[0],usersData[1],usersData[2]);
        }
    }

    private void populateRegions() {
        Path path = Paths.get("/Users/elzbietakrzych/Documents/codecool/ADVANCED/2018_10_15_TW/spring-boot-project-edobkowski/src/main/resources/Regions.csv");
        List<String> regions = fileReaderCSV.readData(path);

        for(String region: regions) {
            String[] regionData = region.split(",");
            regionService.createRegion(regionData[0],regionData[1]);
        }
    }

    private void populateProducers() {
        Path path = Paths.get("/Users/elzbietakrzych/Documents/codecool/ADVANCED/2018_10_15_TW/spring-boot-project-edobkowski/src/main/resources/Producers.csv");
        List<String> producers = fileReaderCSV.readData(path);

        for(String producer: producers) {
            producentService.createProducent(producer);
        }
    }
}
