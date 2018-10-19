package com.codecool.wineREST.controllers;

import com.codecool.wineREST.entities.User;
import com.codecool.wineREST.entities.Wine;
import com.codecool.wineREST.entities.WineRating;
import com.codecool.wineREST.entities.WineRatingPk;
import com.codecool.wineREST.repositories.UserRepository;
import com.codecool.wineREST.repositories.WineRatingRepository;
import com.codecool.wineREST.repositories.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.codecool.wineREST.web.RatingDTO;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/wines/{idWine}/ratings")
public class WineRatingController {

    private WineRepository wineRepository;
    private WineRatingRepository wineRatingRepository;
    private UserRepository userRepository;

    @Autowired
    public WineRatingController(WineRepository wineRepository, WineRatingRepository wineRatingRepository, UserRepository userRepository) {
        this.wineRepository = wineRepository;
        this.wineRatingRepository = wineRatingRepository;
        this.userRepository = userRepository;
    }

    public WineRatingController() {
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<WineRating> getAll(@PathVariable(value = "idWine") long idWine) {
        return this.wineRatingRepository.findByPkWineIdWine(idWine);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createWineRating(@PathVariable(value = "idWine") long idWine,
                                 @RequestBody @Validated RatingDTO ratingDTO) {
        Wine wine = verifyWine(idWine);
        User user = verifyUser(ratingDTO.getUsername());
        this.wineRatingRepository.save(new WineRating(new WineRatingPk(wine, user.getUsername()),
                ratingDTO.getRating(), ratingDTO.getComment()));

    }

    /**
     * Convert the WineRating entity to a RatingDTO
     *
     * @param wineRating
     * @return RatingDTO
     */
    private RatingDTO toDTO(WineRating wineRating) {
        return new RatingDTO(wineRating.getRating(), wineRating.getComment(), wineRating.getPk().getUsername());
    }

    /**
     * Verify and return the WineRating for a particular idWine and User
     * @param idWine
     * @param username
     * @return the found TourRating
     * @throws NoSuchElementException if no WineRating found
     */
    private WineRating verifyWineRating(long idWine, String username) throws NoSuchElementException {
        WineRating rating = this.wineRatingRepository.findByPkWineIdWineAndPkUsername(idWine, username);
        if (rating == null) {
            throw new NoSuchElementException("No ratings for wine: "
                    + idWine + " and customer: " + username);
        }
        return rating;
    }

    /**
     * Verify and return the Wine given idWine.
     *
     * @param idWine
     * @return the found Tour
     * @throws NoSuchElementException if no Tour found.
     */
    private Wine verifyWine(long idWine) throws NoSuchElementException {
        Wine wine = this.wineRepository.findById(idWine).get();
        if (wine == null) {
            throw new NoSuchElementException("Wine does not exist " + idWine);
        }
        return wine;
    }

    private User verifyUser(String username) throws NoSuchElementException {
        User user = this.userRepository.findByUsername(username);
        if (user == null) {
            throw new NoSuchElementException("User does not exist: " + username);
        }
        return user;
    }
}
