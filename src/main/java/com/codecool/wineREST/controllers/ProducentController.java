package com.codecool.wineREST.controllers;

import com.codecool.wineREST.entities.Producent;
import com.codecool.wineREST.exceptions.FkViolationException;
import com.codecool.wineREST.services.ProducentArchiveService;
import com.codecool.wineREST.services.ProducentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/producents")
public class ProducentController {

    private Logger logger = LogManager.getLogger();
    @Autowired
    private ProducentService producentService;
    @Autowired
    private ProducentArchiveService producentArchiveService;

    @RequestMapping(path = "/{idProducent}", method = RequestMethod.GET)
    public Producent getById(@PathVariable(value = "idProducent") long idProducent) {
        return this.producentService.findById(idProducent);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createProducent(@RequestBody Producent producent) {
        this.producentService.createProducent(producent.getName());
        logger.info("Created new region");
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
            logger.error("Constraint violation: prodcent of id " + producent.getIdProducent() + " is attached to wine" +
                    " existing in the DB");
            logger.debug("This is a debug message");
            logger.info("This is an info message");
            logger.warn("This is a warn message");
            logger.error("This is an error message");
            logger.fatal("This is a fatal message");
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

    @ResponseStatus(HttpStatus.IM_USED)
    @ExceptionHandler(FkViolationException.class)
    public String return400(FkViolationException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex) {
        return ex.getMessage();

    }
}
