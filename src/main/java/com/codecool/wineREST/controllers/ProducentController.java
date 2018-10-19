package com.codecool.wineREST.controllers;

import com.codecool.wineREST.entities.Producent;
import com.codecool.wineREST.exceptions.FkViolationException;
import com.codecool.wineREST.exceptions.ServerErrorException;
import com.codecool.wineREST.services.ProducentArchiveService;
import com.codecool.wineREST.services.ProducentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/producents")
public class ProducentController {
    private ProducentService producentService;
    private ProducentArchiveService producentArchiveService;

    @Autowired
    public ProducentController(ProducentService producentService, ProducentArchiveService producentArchiveService) {
        this.producentService = producentService;
        this.producentArchiveService = producentArchiveService;
    }

    @RequestMapping(path = "/{idProducent}", method = RequestMethod.GET)
    public Producent getById(@PathVariable(value = "idProducent") long idProducent) {
        Producent producent = this.producentService.findById(idProducent);
        if(producent == null) {
            throw new NoSuchElementException("There is no producent with id: " + idProducent);
        }

        return producent;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createProducent(@RequestBody Producent producent) {
        this.producentService.createProducent(producent.getName());
    }

    @RequestMapping(path = "/{idProducent}", method = RequestMethod.DELETE)
    public void archiveProducent(@PathVariable(value = "idProducent") long idProducent) throws NoSuchElementException,
            FkViolationException {
        Producent producent = this.producentService.findById(idProducent);
        if(producent == null) {
            throw new NoSuchElementException("There is no producent with id: " + idProducent);
        }
        try {
            this.producentService.deleteProducent(producent);
            this.producentArchiveService.archive(producent);
        } catch (DataIntegrityViolationException e) {
            throw new FkViolationException("This producent is attached to wine existing in the DB");
        }
    }

    @GetMapping()
    public Iterable<Producent> getAllProducents() {
        return producentService.getAll();
    }

    @RequestMapping(params = { "name"}, method=RequestMethod.GET)
    public Producent findByName(@RequestParam("name") String name) {
        System.out.println(name);
        return producentService.findByName(name);
    }

    @RequestMapping(path = "/err")
    public void return502() throws ServerErrorException {
        throw new ServerErrorException("Method for this endpoint has not been implemented yet");
    }
}
