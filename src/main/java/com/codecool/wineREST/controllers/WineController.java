package com.codecool.wineREST.controllers;

import com.codecool.wineREST.entities.Region;
import com.codecool.wineREST.entities.User;
import com.codecool.wineREST.entities.Wine;
import com.codecool.wineREST.services.RegionService;
import com.codecool.wineREST.services.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wines")
public class WineController {
    @Autowired
    private WineService wineService;

    @Autowired
    private RegionService regionService;

    @GetMapping("")
    public Iterable<Wine> getAllWines() {
        return wineService.getAll();
    }

    @RequestMapping(params = {"name"}, method=RequestMethod.GET)
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

    @RequestMapping(params = {"type"}, method=RequestMethod.GET)
    public List<Wine> findByType(@RequestParam("type") String type) {
        return wineService.findByType(type);
    }

    @RequestMapping(params = { "variety"}, method=RequestMethod.GET)
    public List<Wine> findByVariety(@RequestParam("variety") String variety) {
        return wineService.findByVariety(variety);
    }

    @RequestMapping(value ="/best", method=RequestMethod.GET)
    public Iterable<Wine> getBestWine() {
        return wineService.getBestWine();
    }

    @RequestMapping(value = "/ratings", params = { "minRating"}, method=RequestMethod.GET)
    public List<Wine> findByMinRating(@RequestParam("minRating") String minRating) {
        return wineService.findByMinRating(Integer.valueOf(minRating));
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createWine(@RequestBody Wine wine) {
        this.wineService.createWine(wine.getName(), wine.getVariety(), wine.getStyle(), wine.getType(), wine.getProducent().getIdProducent(), wine.getRegion().getIdRegion(),wine.getYear());
    }

}
