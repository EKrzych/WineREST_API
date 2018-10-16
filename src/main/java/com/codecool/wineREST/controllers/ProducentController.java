package com.codecool.wineREST.controllers;

import com.codecool.wineREST.entities.Producent;
import com.codecool.wineREST.services.ProducentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producents")
public class ProducentController {

    @Autowired
    ProducentService producentService;

    @GetMapping()
    public Iterable<Producent> getAllProducents() {
        return producentService.getAll();
    }

    @RequestMapping(params = { "name"}, method=RequestMethod.GET)
    public Producent findByName(@RequestParam("name") String name) {
        System.out.println(name);
        return producentService.findByName(name);
    }
}
