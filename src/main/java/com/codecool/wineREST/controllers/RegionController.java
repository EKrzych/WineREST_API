package com.codecool.wineREST.controllers;

import com.codecool.wineREST.entities.Region;
import com.codecool.wineREST.repositories.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/regions")
public class RegionController {

    private RegionRepository regionRepository;

    @Autowired
    public RegionController(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public RegionController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    Iterable<Region> getAll() {
        return this.regionRepository.findAll();
    }

    @RequestMapping(params = {"name"}, method = RequestMethod.GET)
    public Region findByName(@RequestParam(value = "name") String name) {
        return this.regionRepository.findByName(name);
    }

    @RequestMapping(params = {"country"}, method = RequestMethod.GET)
    public List<Region> findByCountry(@RequestParam(value = "country") String country) {
        return this.regionRepository.findByCountry(country);
    }
}
