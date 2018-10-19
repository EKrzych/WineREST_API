package com.codecool.wineREST.services;

import com.codecool.wineREST.entities.Producent;
import com.codecool.wineREST.entities.Region;

import com.codecool.wineREST.entities.Wine;
import com.codecool.wineREST.entities.WineRating;
import com.codecool.wineREST.repositories.ProducentRepository;
import com.codecool.wineREST.repositories.RegionRepository;
import com.codecool.wineREST.repositories.WineRatingRepository;
import com.codecool.wineREST.repositories.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class WineService {
    private WineRepository wineRepository;
    private ProducentRepository producentRepository;
    private RegionRepository regionRepository;
    private WineRatingRepository wineRatingRepository;

    @Autowired
    public WineService(WineRepository wineRepository, ProducentRepository producentRepository, RegionRepository regionRepository, WineRatingRepository wineRatingRepository) {
        this.wineRepository = wineRepository;
        this.producentRepository = producentRepository;
        this.regionRepository = regionRepository;
        this.wineRatingRepository = wineRatingRepository;
    }

    public void createWine(String name, String variety, String style, String type, Long idProducent, Long idRegion, String year) {

        Producent producent = producentRepository.findById(idProducent).orElseThrow(NoSuchElementException::new);
        Region region = regionRepository.findById(idRegion).orElseThrow(NoSuchElementException::new);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy");
        LocalDate localDate = LocalDate.parse(year, formatter);

        this.wineRepository.save(new Wine(name, variety, style, type, producent, region, localDate));
    }

    public Iterable<Wine> getAll() {
        return this.wineRepository.findAll();
    }

    public List<Wine> findByName(String name) {
        return wineRepository.findByName(name);
    }

    public List<Wine> findByRegion(Region region) {
        return wineRepository.findByRegion(region);
    }

    public List<Wine> findByStyle(String style) {
        return wineRepository.findByStyle(style);
    }

    public List<Wine> findByType(String type) {
        return wineRepository.findByType(type);
    }

    public List<Wine> findByVariety(String variety) {
        return wineRepository.findByVariety(variety);
    }

    public  List<Wine> getBestWine() {
       Map<Wine, Long> wineListRatingSum = getWineListRatingSum();
       Map<Wine, Long> bestWinesWithRatingCount = new HashMap<>();

       Map.Entry<Wine, Long> maxEntry = null;
       for (Map.Entry<Wine, Long> entry : wineListRatingSum.entrySet()) {
           Long ratingsCount = (long) wineRatingRepository.findByPkWineIdWine(entry.getKey().getIdWine()).size();
           entry.setValue(entry.getValue() / ratingsCount);

           if (maxEntry == null) {
               maxEntry = entry;
               bestWinesWithRatingCount.put(maxEntry.getKey(), ratingsCount);
           } else if (entry.getValue() > maxEntry.getValue()) {
               maxEntry = entry;
               bestWinesWithRatingCount.clear();
               bestWinesWithRatingCount.put(maxEntry.getKey(), ratingsCount);
           } else if (entry.getValue().equals(maxEntry.getValue())) {
               bestWinesWithRatingCount.put(entry.getKey(), ratingsCount);
           }
       }
       List<Wine> bestWine = new ArrayList<>();

       Map.Entry<Wine, Long> maxEntryUsers = null;
       for (Map.Entry<Wine, Long> bestEntry : bestWinesWithRatingCount.entrySet()) {
           if (maxEntryUsers == null) {
               maxEntryUsers = bestEntry;
               bestWine.add(maxEntryUsers.getKey());
           } else if (bestEntry.getValue() > maxEntryUsers.getValue()) {
               maxEntryUsers = bestEntry;
               bestWine.clear();
               bestWine.add(maxEntryUsers.getKey());
           } else if (bestEntry.getValue().equals(maxEntryUsers.getValue())) {
               bestWine.add(maxEntryUsers.getKey());
           }

       }
       return bestWine;
   }

    public List<Wine> findByMinRating(Integer minRating) {
        Map<Wine, Long> wineListRatingSum = getWineListRatingSum();
        List<Wine> chosenWine = new ArrayList<>();

        for (Map.Entry<Wine, Long> entry : wineListRatingSum.entrySet()) {
            Long ratingsCount = (long) wineRatingRepository.findByPkWineIdWine(entry.getKey().getIdWine()).size();
            entry.setValue(entry.getValue() / ratingsCount);
            if (entry.getValue() >= minRating) {
                chosenWine.add(entry.getKey());
            }
        }
        return chosenWine;
    }

    private Map<Wine, Long> getWineListRatingSum() {
        Iterable<WineRating> ratingList = wineRatingRepository.findAll();
        Map<Wine, Long> wineListRatingSum = new HashMap<>();

        for (WineRating wineRating : ratingList) {
            Long ratingSum = wineListRatingSum.getOrDefault(wineRating.getPk().getWine(), 0L);
            wineListRatingSum.put(wineRating.getPk().getWine(), ratingSum+=wineRating.getRating());
        }
        return wineListRatingSum;
    }

    public Wine findById(long idWine) {
        return this.wineRepository.findByIdWine(idWine);
    }

    public void deleteWine(Wine wine) {
        this.wineRepository.delete(wine);
    }
}
