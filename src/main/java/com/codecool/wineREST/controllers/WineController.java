package com.codecool.wineREST.controllers;

import com.codecool.wineREST.entities.Region;
import com.codecool.wineREST.entities.Wine;
import com.codecool.wineREST.repositories.RegionRepository;
import com.codecool.wineREST.services.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WineController {
    @Autowired
    WineService wineService;
    RegionRepository regionRepository;

    @GetMapping("/wines")
    public Iterable<Wine> getAllWines() {
        return wineService.getAll();
    }

    @RequestMapping(value="/wines/", params = { "name"}, method=RequestMethod.GET)
    public List<Wine> findByName(@RequestParam("name") String name) {
        return wineService.findByName(name);
    }

    @RequestMapping(value="/wines", params = { "name"}, method=RequestMethod.GET)
    public List<Wine> findByRegion(@RequestParam("name") String name) {

        Region region = regionRepository.findByName(name);
        return wineService.findByRegion(region);
    }

    @RequestMapping(value="/wines", params = { "style"}, method=RequestMethod.GET)
    public List<Wine> findByStyle(@RequestParam("style") String style) {
        return wineService.findByStyle(style);
    }

    @RequestMapping(value="/wines", params = { "type"}, method=RequestMethod.GET)
    public List<Wine> findByType(@RequestParam("type") String type) {
        return wineService.findByType(type);
    }

    @RequestMapping(value="/wines", params = { "variety"}, method=RequestMethod.GET)
    public List<Wine> findByVariety(@RequestParam("variety") String variety) {
        return wineService.findByStyle(variety);
    }
}
