package com.codecool.wineREST.services;

import com.codecool.wineREST.entities.Region;
import com.codecool.wineREST.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    private RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public RegionService() {
    }

    public Iterable<Region> getAll() {
        return this.regionRepository.findAll();
    }

    public void createRegion(String name, String country) {
        this.regionRepository.save(new Region(name, country));
    }

    public void deleteRegion(Region region) {
        this.regionRepository.delete(region);
    }

    public Region getByName(String name) {
        return this.regionRepository.findByName(name);
    }

    public List<Region> getByCountry(String country) {
        return this.regionRepository.findByCountry(country);
    }

    public Region findById(long idRegion) {return this.regionRepository.findByIdRegion(idRegion);}
}
