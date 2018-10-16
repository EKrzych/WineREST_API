package com.codecool.wineREST.controllers;

import com.codecool.wineREST.entities.Wine;
import com.codecool.wineREST.entities.WineRating;
import com.codecool.wineREST.entities.WineRatingPk;
import com.codecool.wineREST.repositories.WineRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.codecool.wineREST.web.RatingDTO;

import java.util.NoSuchElementException;

@RestController
@RequestMapping(path = "/wines/{idWine}/ratings")
public class WineRatingController {

    private WineRepository wineRepository;
    private WineRatingRepository wineRatingRepository;

    @Autowired
    public WineRatingController(WineRepository wineRepository, WineRatingRepository wineRatingRepository) {
        this.wineRepository = wineRepository;
        this.wineRatingRepository = wineRatingRepository;
    }

    public WineRatingController() {
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createWineRating(@PathVariable(value = "idWine") long idWine,
                                 @RequestBody @Validated RatingDTO ratingDTO) {
        Wine wine = verifyWine(idWine);
        this.wineRatingRepository.save(new WineRating(new WineRatingPk(wine, ratingDTO.getUsername()),
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
     * @throws NoSuchElementException if no TourRating found
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

    /**
     * Exception handler if NoSuchElementException is thrown in this Controller
     *
     * @param ex
     * @return Error message String.
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(NoSuchElementException ex) {
        return ex.getMessage();

    }
}
