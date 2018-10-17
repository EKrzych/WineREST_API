package com.codecool.wineREST.controllers;

import com.codecool.wineREST.entities.Producent;
import com.codecool.wineREST.exceptions.FkViolationException;
import com.codecool.wineREST.services.ProducentArchiveService;
import com.codecool.wineREST.services.ProducentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/producents")
public class ProducentController {

    private static final Logger LOGGER = LogManager.getLogger(ProducentController.class.getName());

    @Autowired
    ProducentService producentService;
    @Autowired
    ProducentArchiveService producentArchiveService;

    @RequestMapping(path = "/{idProducent}", method = RequestMethod.GET)
    public Producent getById(@PathVariable(value = "idProducent") long idProducent) {
        return this.producentService.findById(idProducent);
    }

    @RequestMapping(path = "/{idProducent}", method = RequestMethod.DELETE)
    public void archiveProducent(@PathVariable(value = "idProducent") long idProducent) throws FkViolationException {
        Producent producent = this.producentService.findById(idProducent);
        try {
            this.producentService.deleteProducent(producent);
            this.producentArchiveService.archive(producent);
        } catch (DataIntegrityViolationException e) {
            throw new FkViolationException("This producent is attached to wine existing in the DB");
        }
    }

    @GetMapping()
    public Iterable<Producent> getAllProducents() {
        LOGGER.debug("Debug Message Logged !!!");
        LOGGER.info("Info Message Logged !!!");
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
}
