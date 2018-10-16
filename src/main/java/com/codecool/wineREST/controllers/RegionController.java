package com.codecool.wineREST.controllers;

import com.codecool.wineREST.entities.Region;
import com.codecool.wineREST.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/regions")
public class RegionController {

    private RegionService regionService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    public RegionController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    Iterable<Region> getAll() {
        return this.regionService.getAll();
    }

    @RequestMapping(params = {"name"}, method = RequestMethod.GET)
    public Region findByName(@RequestParam(value = "name") String name) {
        return this.regionService.getByName(name);
    }

    @RequestMapping(params = {"country"}, method = RequestMethod.GET)
    public List<Region> findByCountry(@RequestParam(value = "country") String country) {
        return this.regionService.getByCountry(country);
    }
}
