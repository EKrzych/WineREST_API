package com.codecool.wineREST.repositories;

import com.codecool.wineREST.entities.Wine;
import com.codecool.wineREST.entities.WineRating;
import com.codecool.wineREST.entities.WineRatingPk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface WineRatingRepository extends CrudRepository<WineRating, WineRatingPk> {


    /**
     * Lookup all the WineRatings for a Wine.
     *
     * @param idWine is the Wine Identifier
     * @return a List of any found WineRatings
     */
    List<WineRating> findByPkWineIdWine(Long idWine);
    /**
     * Lookup all the WineRatings for a User.
     *
     * @param username is the User Identifier
     * @return a List of any found WineRatings
     */
    List<WineRating> findByPkUsername(String username);

    WineRating findByPkWineIdWineAndPkUsername(Long idWine, String username);
}
