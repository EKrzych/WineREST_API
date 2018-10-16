package com.codecool.wineREST.services;

import com.codecool.wineREST.entities.Producent;
import com.codecool.wineREST.entities.Region;

import com.codecool.wineREST.entities.Wine;
import com.codecool.wineREST.repositories.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WineService {
    private WineRepository wineRepository;

    @Autowired
    public WineService(WineRepository wineRepository) {
        this.wineRepository = wineRepository;
    }

    public void createWine(Long idWine, String name, String variety, String style, String type, Producent producent, Region region, LocalDate year) {
        this.wineRepository.save(new Wine(name, variety, style, type, producent, region, year));
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
        return wineRepository.findByName(style);
    }

    public List<Wine> findByType(String type) {
        return wineRepository.findByName(type);
    }
    public List<Wine> findByVariety(String variety) {
        return wineRepository.findByName(variety);
    }


}
