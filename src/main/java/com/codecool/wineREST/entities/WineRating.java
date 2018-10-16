package com.codecool.wineREST.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class WineRating {

    @EmbeddedId
    private WineRatingPk pk;

    @Column(nullable = false)
    private Integer rating;

    @Column
    private String comment;

    public WineRating(WineRatingPk pk, Integer rating, String comment) {
        this.pk = pk;
        this.rating = rating;
        this.comment = comment;
    }

    public WineRating() {
    }

    public WineRatingPk getPk() {
        return pk;
    }

    public void setPk(WineRatingPk pk) {
        this.pk = pk;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "WineRating {" + "\n" +
                "pk: " + pk + "\n" +
                ", rating: " + rating + "\n" +
                ", comment: '" + comment + '\'' + "\n" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WineRating that = (WineRating) o;
        return Objects.equals(pk, that.pk) &&
                Objects.equals(rating, that.rating) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, rating, comment);
    }
}
