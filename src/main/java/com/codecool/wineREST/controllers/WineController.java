package com.codecool.wineREST.controllers;

import com.codecool.wineREST.entities.Region;
import com.codecool.wineREST.entities.Wine;
import com.codecool.wineREST.repositories.RegionRepository;
import com.codecool.wineREST.services.RegionService;
import com.codecool.wineREST.services.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wines")
public class WineController {
    @Autowired
    WineService wineService;

    @Autowired
    RegionService regionService;

    @GetMapping("")
    public Iterable<Wine> getAllWines() {
        return wineService.getAll();
    }

    @RequestMapping(params = { "name"}, method=RequestMethod.GET)
    public List<Wine> findByName(@RequestParam("name") String name) {
        return wineService.findByName(name);
    }

    @RequestMapping(params = { "regionName"}, method=RequestMethod.GET)
    public List<Wine> findByRegion(@RequestParam("regionName") String regionName) {

        Region region = regionService.getByName(regionName);
        return wineService.findByRegion(region);
    }

    @RequestMapping(params = {"style"}, method=RequestMethod.GET)
    public List<Wine> findByStyle(@RequestParam("style") String style) {

        return wineService.findByStyle(style);
    }

    @RequestMapping(params = { "type"}, method=RequestMethod.GET)
    public List<Wine> findByType(@RequestParam("type") String type) {
        return wineService.findByType(type);
    }

    @RequestMapping(params = { "variety"}, method=RequestMethod.GET)
    public List<Wine> findByVariety(@RequestParam("variety") String variety) {
        return wineService.findByVariety(variety);
    }

    @GetMapping("/best")
    public Iterable<Wine> getBestWine() {
        return wineService.getBestWine();
    }

    @RequestMapping(params = { "minRating"}, method=RequestMethod.GET)
    public List<Wine> findByMinRating(@RequestParam("minRating") Integer minRating) {
        return wineService.findByMinRating(minRating);
    }

}
