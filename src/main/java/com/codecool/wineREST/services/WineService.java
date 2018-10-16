package com.codecool.wineREST.services;

import com.codecool.wineREST.entities.Producent;
import com.codecool.wineREST.entities.Region;

import com.codecool.wineREST.entities.Wine;
import com.codecool.wineREST.repositories.ProducentRepository;
import com.codecool.wineREST.repositories.RegionRepository;
import com.codecool.wineREST.repositories.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WineService {
    private WineRepository wineRepository;
    private ProducentRepository producentRepository;
    private RegionRepository regionRepository;

    @Autowired
    public WineService(WineRepository wineRepository, ProducentRepository producentRepository, RegionRepository regionRepository) {
        this.wineRepository = wineRepository;
        this.producentRepository = producentRepository;
        this.regionRepository = regionRepository;
    }


    public void createWine(String name, String variety, String style, String type, Long idProducent, Long idRegion, LocalDate year) {
        Producent producent = producentRepository.findById(idProducent).get();
        Region region = regionRepository.findById(idRegion).get();
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
        return wineRepository.findByStyle(style);
    }

    public List<Wine> findByType(String type) {
        return wineRepository.findByType(type);
    }

    public List<Wine> findByVariety(String variety) {
        return wineRepository.findByVariety(variety);
    }


}
