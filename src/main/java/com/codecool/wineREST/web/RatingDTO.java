package com.codecool.wineREST.web;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Data Transfer Object for Rating a Tour.
 *
 * Created by Mary Ellen Bowman
 */
public class RatingDTO {

    @Min(0)
    @Max(5)
    private Integer rating;

    @Size(max = 255)
    private String comment;

    @NotNull
    private String username;

    /**
     * Constructor to fully initialize the RatingDto
     *
     * @param rating
     * @param comment
     * @param username
     */
    public RatingDTO(Integer rating, String comment, String username) {
        this.rating = rating;
        this.comment = comment;
        this.username = username;
    }

    protected RatingDTO() {}

    public Integer getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }

    public String getUsername() {
        return username;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
