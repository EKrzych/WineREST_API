package com.codecool.wineREST.controllers;

import com.codecool.wineREST.entities.Region;
import com.codecool.wineREST.exceptions.FkViolationException;
import com.codecool.wineREST.services.RegionArchiveService;
import com.codecool.wineREST.services.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping(path = "/regions")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @Autowired
    private RegionArchiveService regionArchiveService;

    @Autowired
    public RegionController(RegionService regionService) {
        this.regionService = regionService;
    }

    public RegionController() {
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createRegion(@RequestBody Region region) {
        this.regionService.createRegion(region.getName(), region.getCountry());
    }

    @RequestMapping(method = RequestMethod.GET)
    Iterable<Region> getAll() {
        return this.regionService.getAll();
    }

    @RequestMapping(params = {"name"}, method = RequestMethod.GET)
    public Region findByName(@RequestParam(value = "name") String name) {
        return this.regionService.getByName(name);
    }

    @RequestMapping(path = "/{idRegion}", method = RequestMethod.GET)
    public Region getById(@PathVariable(value = "idRegion") long idRegion) {
        return this.regionService.findById(idRegion);
    }

    @RequestMapping(path = "/{idRegion}", method = RequestMethod.DELETE)
    public void archiveRegion(@PathVariable(value = "idRegion") long idRegion) throws NoSuchElementException,
            FkViolationException {
        Region region = this.regionService.findById(idRegion);
        if(region == null) {
            throw new NoSuchElementException("There is no region with id: " + idRegion);
        }
        try {
            this.regionArchiveService.archive(region);
            this.regionService.deleteRegion(region);

        } catch (DataIntegrityViolationException e) {
            throw new FkViolationException("This region is attached to wine existing in the DB");
        }
    }

    @RequestMapping(params = {"country"}, method = RequestMethod.GET)
    public List<Region> findByCountry(@RequestParam(value = "country") String country) {
        return this.regionService.getByCountry(country);
    }
}
