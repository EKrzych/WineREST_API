package com.codecool.wineREST.helpers;

import com.codecool.wineREST.entities.WineRating;
import com.codecool.wineREST.entities.WineRatingPk;
import com.codecool.wineREST.repositories.WineRatingRepository;
import com.codecool.wineREST.services.ProducentService;
import com.codecool.wineREST.services.RegionService;
import com.codecool.wineREST.services.UserService;
import com.codecool.wineREST.services.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    @Autowired
    WineService wineService;
    @Autowired
    WineRatingRepository wineRatingRepository;

    public void populateDB() {
        populateProducers();
        populateRegions();
        populateWine();
        populateUsers();
        populateWineRating();
    }


    private void populateWineRating() {
        Path path = Paths.get("/Users/elzbietakrzych/Documents/codecool/ADVANCED/2018_10_15_TW/spring-boot-project-edobkowski/src/main/resources/Ratings.csv");

        List<String> ratings = fileReaderCSV.readData(path);
        List<String> users = getUserslogin();
        Random r = new Random();
        for(String rating : ratings) {
            String[] ratingData = rating.split(",");
            WineRatingPk pk = new WineRatingPk(wineService.findById(Long.valueOf(ratingData[2])), users.get(r.nextInt(users.size()-1)));
            wineRatingRepository.save(new WineRating(pk, Integer.valueOf(ratingData[1]), ratingData[0]));
        }
    }

    private List<String> getUserslogin() {
        List<String> userList = new ArrayList<>();
        Path path = Paths.get("/Users/elzbietakrzych/Documents/codecool/ADVANCED/2018_10_15_TW/spring-boot-project-edobkowski/src/main/resources/Users.csv");
        List<String> users = fileReaderCSV.readData(path);
        for(String user : users) {
            String[] usersData = user.split(",");
            userList.add(usersData[0]);
        }
        return userList;
    }

    private void populateWine() {
        Path path = Paths.get("/Users/elzbietakrzych/Documents/codecool/ADVANCED/2018_10_15_TW/spring-boot-project-edobkowski/src/main/resources/Wines.csv");
        List<String> wines = fileReaderCSV.readData(path);
        for(String wine : wines) {
            String[] wineData = wine.split(",");
            wineService.createWine(wineData[0], wineData[1],wineData[2],wineData[3],Long.valueOf(wineData[4]),Long.valueOf(wineData[5]),wineData[6]);
        }
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
